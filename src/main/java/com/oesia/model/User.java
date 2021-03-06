package com.oesia.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_id")
    private int id;
    @Column(name = "email")
    @Email(message = "*Por favor ingrese un email válido")
    @NotEmpty(message = "*Por favor ingrese un email")
    private String email;
	@Column(name = "password")
    @Length(min = 7, message = "*El password debe tener a menos 7 caracteres")
    @NotEmpty(message = "*Por favor ingrese el password")
    private String password;
    @Column(name = "name")
    @NotEmpty(message = "*Por favor ingrese su nombre")
    private String name;
    @Column(name = "last_name")
    @NotEmpty(message = "*Por favor ingrese su apellido")
    private String lastName;
    @Column(name = "active")
    private int active;
    @ManyToMany (cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id")) 
    private Set<Role> roles; 

    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
