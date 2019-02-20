package com.uniovi.entities;

import javax.persistence.*;
import java.util.Set; //A collection that contains no duplicate elements

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue
	private long id;
	@Column(unique = true)
	private String dni;
	private String name;
	private String lastName;
	private String role;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Mark> marks;

	private String password;
	@Transient // propiedad que no se almacena e la tabla.
	private String passwordConfirm;

	public User(String dni, String name, String lastName) {
		super();
		this.dni = dni;
		this.name = name;
		this.lastName = lastName;
	}

	public User() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public void setMarks(Set<Mark> marks) {
		this.marks = marks;
	}

	public Set<Mark> getMarks() {
		return marks;
	}

	public String getFullName() {
		return this.name + " " + this.lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public boolean tieneNotas() {
		return marks.size() != 0;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", dni=" + dni + ", name=" + name + ", lastName=" + lastName + ", role=" + role
				+ ", marks=" + marks + ", password=" + password + ", passwordConfirm=" + passwordConfirm + ", getId()="
				+ getId() + ", getDni()=" + getDni() + ", getName()=" + getName() + ", getLastName()=" + getLastName()
				+ ", getMarks()=" + getMarks() + ", getFullName()=" + getFullName() + ", getPassword()=" + getPassword()
				+ ", getPasswordConfirm()=" + getPasswordConfirm() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}