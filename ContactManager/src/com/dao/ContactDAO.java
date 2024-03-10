package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.ContactManager;
import com.utility.DBUtility;

public class ContactDAO {
	
	
	public int saveContact(ContactManager contact)
	{
		Connection con=DBUtility.getDBConnection();		
		String sql="insert into Contact values(?,?)";		
		PreparedStatement ps=null;
		int val=0;
		try
		{
			ps=con.prepareStatement(sql);
			
			ps.setString(1,contact.getContact_Name());
			ps.setString(2,contact.getContact_Number());
			val=ps.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("Exception Occured In Save Student"+e);
		}
		return val;	 
		
	}
	
	

	public int deleteContact(ContactManager contact)
	{
		Connection con=DBUtility.getDBConnection();		
		String sql="delete from Contact where Contact_Name=?";		
		PreparedStatement ps=null;
		int val=0;
		try
		{
			ps=con.prepareStatement(sql);			
			ps.setString(1,contact.getContact_Name());
						val=ps.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("Exception Occured In Delete Student"+e);
		}
		return val;	 
		
	}
	public int updateContact(ContactManager contact)
	{
		Connection con=DBUtility.getDBConnection();		
		String sql="update Contact set Contact_Number=? where Contact_Name=?";		
		PreparedStatement ps=null;
		int val=0;
		try
		{
			ps=con.prepareStatement(sql);	
			ps.setString(1,contact.getContact_Number());	
			ps.setString(2,contact.getContact_Name());
			val=ps.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("Exception Occured In Delete Student"+e);
		}
		return val;	 
		
	}
	
	
	public List<ContactManager> getAllContacts()
	{
		Connection con=DBUtility.getDBConnection();		
	    String sql="select * from Contact";		
	    PreparedStatement ps=null;
	    List<ContactManager> list=new ArrayList<ContactManager>();    
	    
	    try
	    {
	    	ps=con.prepareStatement(sql);
	    	ResultSet rs=ps.executeQuery();
	    	while(rs.next())
	    	{
	    		ContactManager contacts=new  ContactManager();
	    		contacts.setContact_Name(rs.getString(1));
	    		contacts.setContact_Number(rs.getNString(2));
	    		
	    		list.add(contacts);
	    	}
	    	
	    }
	    catch(Exception e)
	    {
	    	System.out.println("Exceptin in getAllContacts"+e);
	    }
	    return list;
		
	}
	
	
	
}
