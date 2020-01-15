package org.javacream.training.apache.camel.datatypes;

public class Person {

	private long id;
	private String lastname;
	private String firstname;
	private String gender;
	private Integer height;
	public long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + ", gender=" + gender
				+ ", height=" + height + "]";
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}

}
