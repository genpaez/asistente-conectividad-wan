package com.oesia.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {      

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;    // Cifrado

    @Autowired
    private DataSource dataSource;    // Referencia en archivo application-properties

    @Value("${spring.queries.users-query}") // Referencia en archivo application-properties Query
    private String usersQuery;

    @Value("${spring.queries.roles-query}") // Referencia en archivo application-properties Query
    private String rolesQuery;

    @Override
    protected void configure(AuthenticationManagerBuilder auth)  // Sobre escribe método configure e inicializa valores para permisos de usuarios
            throws Exception {
        auth.
                jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {   // Se definen los permisos

        http
        	    .csrf().disable()
                .authorizeRequests()
                	.antMatchers("/").permitAll()
                	.antMatchers("/error").permitAll()
                	.antMatchers("/index/").denyAll()
                	.antMatchers("/index").hasAuthority("USUARIO")
                	.antMatchers("/registration").hasAuthority("ADMIN")
                	.antMatchers("/configuracion").hasAuthority("ADMIN").anyRequest()
                	.authenticated()
                	
                .and()
                	.csrf().disable()
                	.formLogin()
                	.loginPage("/login").permitAll()
                	.loginPage("/login").failureUrl("/login?error=true")
                	.defaultSuccessUrl("/default")
                	.usernameParameter("email")
                	.passwordParameter("password")
                
                .and().logout()
                	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                	.logoutSuccessUrl("/").and().exceptionHandling()
                	.accessDeniedPage("/access-denied");
                            
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/js/main.js", "/images/**");
    }

}
