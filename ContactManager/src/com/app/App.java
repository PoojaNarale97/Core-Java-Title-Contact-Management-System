package com.app;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.model.ContactManager;
import com.dao.ContactDAO;

public class App {

public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int op,conti;
		ContactDAO dao=new ContactDAO();
		
		do
		{
			System.out.println("1.Add Contact");
			System.out.println("2.Delete Contact");
			System.out.println("3.Update Contact");
			System.out.println("4.View All Contact");
			
			System.out.println("Enter Your Choice:");
			op=sc.nextInt();
			sc.nextLine();
			
			switch (op) {
			
			case 1:
				System.out.println("Enter Contact Name:");
				String contact_Name=sc.nextLine();
				
				System.out.println("Enter Contact Number:");
				String contact_Number=sc.nextLine();
				
				ContactManager addContact=new ContactManager(contact_Name,contact_Number);
				
				int addRecords=dao.saveContact(addContact);
				
				if(addRecords>0)
				{
					System.out.println("Contact Saved Successfully");
				}
				else
				{
					System.out.println("Contact Failed to Save");
				}
									
				break;
			case 2:
				
				System.out.println("Enter Contact Name");
				String dcontact_Name=sc.nextLine();
				
				ContactManager dContact=new ContactManager();
				
				dContact.setContact_Name(dcontact_Name);
				
				int deleteRecords=dao.deleteContact(dContact);
				if(deleteRecords>0)
				{
					System.out.println("Contact Delete Successfully");
				}
				else
				{
					System.out.println("Contact Failed to Delete");
				}
			break;
			
          case 3:
				
				System.out.println("Enter Contact Name");
				String uContact_Name=sc.nextLine();
				
				System.out.println("Enter Contact Number:");
				String uContact_Number=sc.nextLine();
				
				ContactManager upContact=new ContactManager(uContact_Name,uContact_Number);
				
				int updateRecords=dao.updateContact(upContact);
				
				if(updateRecords>0)
				{
					System.out.println("Contact Update Successfully");
				}
				else
				{
					System.out.println("Contact Failed to Update.......");
				}
									
			break;
          case 4:          
        	    List<ContactManager> allContacts = dao.getAllContacts();    	    
        	    
        	    
        	    if(allContacts.isEmpty())
        	    {
        	    	System.out.println("No Contacts Available");
        	    }
        	    else
        	    {
        	    	
        	    	System.out.println("Contact_Name    Contact_Number");
        	    	System.out.println("----------------------------------");
        	    	Iterator<ContactManager> itr =allContacts.iterator();
        	    	while(itr.hasNext())
            	    {
            	    	ContactManager contacts1=itr.next();
            	    	
            	    	System.out.print(" "+contacts1.getContact_Name());
            	    	System.out.println("           "+contacts1.getContact_Number());
            	    }
            	    
        	    }
        	   
        	    
        	    break;

				
			default:
				break;
			}
			System.out.println("Do You Want to Continue PRESS 1");
			conti=sc.nextInt();
			
		}while(conti==1);
		
		
		
		
		
	}


}
