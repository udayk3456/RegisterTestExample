package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
/*@IdClass(User.IdClass.class)*/
@Table(name="RegisterTestExampleUser")
public class User{
	@Id
	@GeneratedValue(generator="user")
	@GenericGenerator(name="user",strategy="increment")
	private Integer Id;
	private String email;
	private String familyName;
	private String givenName;
	private String userName;
	private String picture;
	private boolean emailVerified;
	
	/*@Embedded
	private TestModel test;*/
	/*@Lob
	@Column(name = "picture", columnDefinition="BLOB")
	private byte[] picture;
	*/
	
	public String getEmail() {
		return email;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getGivenName() {
		return givenName;
	}
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public boolean isEmailVerified() {
		return emailVerified;
	}
	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}
	@Override
	public String toString() {
		return "User [Id=" + Id + ", email=" + email + ", familyName=" + familyName + ", givenName=" + givenName
				+ ", userName=" + userName + ", picture=" + picture + ", emailVerified=" + emailVerified + "]";
	}
	
	
	
    /*static class IdClass implements Serializable {
        private Integer id;
        private String email;
    }*/
	
	
	
	
}
