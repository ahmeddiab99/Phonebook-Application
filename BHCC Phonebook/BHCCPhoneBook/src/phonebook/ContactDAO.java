/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


/**
 *
 * @author Ahmed Diab, Fengnan Zhang.
 */
public class ContactDAO {
	   //private static DataSource dataSource;

    String databaseName;
    String username;
    String password;

    /**
     * Constructor.
     * @param databaseName
     * @param username
     * @param password 
     */
    public ContactDAO(String databaseName, String username, String password) {
        this.databaseName = databaseName;
        this.username = username;
        this.password = password;
    }
    
    /**
     * method that gets all the contacts from the database.
     * @return
     * @throws Exception 
     */
    public DoublyLinkedList<Contact> getContacts() throws Exception {
        DoublyLinkedList<Contact> contacts = new DoublyLinkedList<>();
        //initialization 
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            // getting the connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/" + databaseName, username, password);
            // creating statements
            String sql = "select * from contacts order by name";
            st = con.createStatement();
            // execute query
            rs = st.executeQuery(sql);
            // processing  the resultSet
            while (rs.next()) {
                //retrieving data from the dataBase
                int id = rs.getInt("CONTACT_ID");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String state = rs.getString("state");
                String phone = rs.getString("phone");
                // creating a new contact object
                Contact contact = new Contact(id, name, address, city, state, phone);
                // adding the contact to the list
                contacts.add(contact);
            }
        } finally {
            // Closing  the connection
            close(con, st, rs);
        }

        return contacts;
    }
    
    /**
     * method that add contact to the database.
     * @param contact
     * @throws Exception 
     */
    public void addContact(Contact contact) throws Exception {
        Connection con = null;
        PreparedStatement st = null;
        try {
            //con = dataSource.getConnection();

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/" + databaseName, username, password);
            //creating the statement
            String sql = "insert into contacts"
                    + "(CONTACT_ID,name,address,city,state,phone)"
                    + "values(?,?,?,?,?,?)";
            st = con.prepareStatement(sql);
            
            // inserting contact data into the database.
            st.setInt(1, contact.getId());
            st.setString(2, contact.getName());
            st.setString(3, contact.getAddress());
            st.setString(4, contact.getCity());
            st.setString(5, contact.getState());
            st.setString(6, contact.getPhoneNumber());
            st.execute();
        } finally {
            // Closing  the connection.
            close(con, st, null);
        }

    }
    
    /**
     * method that retrieves a specific contact from the database.
     * @param contactId
     * @return
     * @throws Exception 
     */
    public Contact getContact(String contactId) throws Exception {
        Contact c = null;
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        int cId;
        try {
            //converting contactId to cId integer 
            cId = Integer.parseInt(contactId);
            //get connection to the database
            //con = dataSource.getConnection();
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/" + databaseName, username, password);
            //create sql to get the contact from the database
            String sql = "select * from contacts where contact_ID=?";
            //create prepared statement
            st = con.prepareStatement(sql);
            //set parameters
            st.setInt(1, cId);
            //execute statement
            rs = st.executeQuery();
            //retrieve data from the resultSet
            if (rs.next()) {
                String name = rs.getString("name");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String state = rs.getString("state");
                String phone = rs.getString("phone");
                c = new Contact();
                c.setName(name);
                c.setAddress(address);
                c.setCity(city);
                c.setState(state);
                c.setPhoneNumber(phone);
            } else {
                throw new Exception("could not find the contact with ID:" + contactId + " !");
            }

        } finally {
            close(con, st, rs);
        }

        return c;

    }
    /**
     * method that deletes a specific contact from the database.
     * @param contactId
     * @throws Exception 
     */
    public void deleteContact(int contactId) throws Exception {
        int cId;
        Contact c = null;
        Connection con = null;
        PreparedStatement st = null;

        try {
            //converting contactId to cId integer 
            //cId = Integer.parseInt(contactId);
            //get connection to the database
            //con = dataSource.getConnection();
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/" + databaseName, username, password);
            //create sql to get the contact from the database
            String sql = "delete  from contacts where contact_ID=?";
            //create prepared statement
            st = con.prepareStatement(sql);
            //set parameters
            st.setInt(1, contactId);
            //execute statement
            st.execute();

        } finally {
            close(con, st, null);
        }

    }
    /**
     * method that updates a specific contact in the database.
     * @param c
     * @throws Exception 
     */
    public void updateContact(Contact c) throws Exception {
        Connection con = null;
        PreparedStatement st = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/" + databaseName, username, password);
            String sql = "update contacts "
                    + "set name=?,address=?,city=?,state=?,phone=? where CONTACT_ID=?";
            st = con.prepareStatement(sql);

            st.setString(1, c.getName());
            st.setString(2, c.getAddress());
            st.setString(3, c.getCity());
            st.setString(4, c.getState());
            st.setString(5, c.getPhoneNumber());
            st.setInt(6, c.getId());
            st.execute();

        } finally {
            close(con, st, null);
        }
    }
    
    
    /**
     * method that close the connection.
     * @param con
     * @param st
     * @param rs
     * @throws Exception 
     */
    private static void close(Connection con, Statement st, ResultSet rs) throws Exception {
        try {
            if (con != null) {
                con.close();
            }
            if (st != null) {
                st.close();
            }
            if (rs != null) {
                rs.close();
            }

        } catch (Exception ex) {
            throw new Exception();
        }

    }

}
