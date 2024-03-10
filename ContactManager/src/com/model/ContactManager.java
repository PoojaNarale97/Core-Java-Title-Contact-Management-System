package com.model;

public class ContactManager {
	
	private String contact_Name;
	private String Contact_Number;
	
	public ContactManager() {
		// TODO Auto-generated constructor stub
	}

	public ContactManager(String contact_Name, String contact_Number) {
		super();
		this.contact_Name = contact_Name;
		Contact_Number = contact_Number;
	}

	public String getContact_Name() {
		return contact_Name;
	}

	public void setContact_Name(String contact_Name) {
		this.contact_Name = contact_Name;
	}

	public String getContact_Number() {
		return Contact_Number;
	}

	public void setContact_Number(String contact_Number) {
		Contact_Number = contact_Number;
	}

	@Override
	public String toString() {
		return "ContactManager [contact_Name=" + contact_Name + ", Contact_Number=" + Contact_Number + "]";
	}
	

}
