package com.simprailway.model;




public class Passenger {
    private int passengerId;
    private String name;
    private int age;
    private String gender;
    private String contactNumber;
    private String email;

    

    public int getPassengerId() {
		return passengerId;
	}



	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getContactNumber() {
		return contactNumber;
	}



	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	@Override
    public String toString() {
        return String.format("Passenger [passengerId=%d, name=%s, age=%d, gender=%s, contactNumber=%s, email=%s]",
                passengerId, name, age, gender, contactNumber, email);
    }
	public Passenger() {
		
	}
}
