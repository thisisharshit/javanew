package com.harshit;

import java.sql.Statement;

import javax.swing.text.TabExpander;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
	public static final String DB_NAME="testjava.db";
	public static final String CONNECTION_STRING="jdbc:sqlite:C:\\EclipseWorkspaces\\csse120\\TestDB\\"+DB_NAME;
	public static final String TABLE_CONTACTS="contacts";
	public static final String COLUMN_NAME="name";
	public static final String COLUMN_PHONE="phone";
	public static final String COLUMN_EMAIL="email";
	public static void main(String[] args) {
		try {
			Connection conn=DriverManager.getConnection(CONNECTION_STRING);
//			Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\EclipseWorkspaces\\csse120\\TestDB\\testjava.db");
//			conn.setAutoCommit(false);
			Statement statement=conn.createStatement();
			statement.execute("drop table if exists "+TABLE_CONTACTS);
			statement.execute("create table if not exists contacts(name text ,phone integer,email text)");
			
			statement.execute("insert into contacts(name,phone,email) values('joe',123455,'joe@gmail.com')");
			statement.execute("insert into contacts(name,phone,email) values('jane',4829484,'jane@gmail.com')");
			statement.execute("insert into contacts(name,phone,email) values('fido',9038,'dog@gmail.com')");
			
			statement.execute("update contacts set phone=52459823 where name='jane'");
			
			statement.execute("delete from contacts where name='fido'");
			
/*			statement.execute("select * from contacts");
			ResultSet results=statement.getResultSet();
			while(results.next()) {
				System.out.println(results.getString("name")+" "+results.getInt("phone")+" "+results.getString("email"));
			}
			results.close();
*/
			ResultSet results=statement.executeQuery("select * from contacts");
			while(results.next()) {
				System.out.println(results.getString("name")+" "+results.getInt("phone")+" "+results.getString("email"));
			}
			results.close();
			
			
			
			
			statement.close();
			conn.close();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("something went wrong: "+e.getMessage());
		}
	}
}
