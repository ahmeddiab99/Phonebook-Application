/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;

import java.sql.*;

/**
 *
 * @author Ahmed Diab, Fengnan Zhang.
 */
public class DataManager {

    private DbConnection dataConnect;
    private Connection con;
    // creating a statement for the connection

    public DataManager(String dataBase, String user, String pass) throws ClassNotFoundException, SQLException {
        dataConnect = new DbConnection(dataBase, user, pass);
        con = dataConnect.openConnection();
    }

    public void setConnection(String dataBase, String user, String pass) throws ClassNotFoundException, SQLException {
        dataConnect = new DbConnection(dataBase, user, pass);
        con = dataConnect.openConnection();
    }

    public DoublyLinkedList<Contact> retrieveAll() throws SQLException {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from contacts"); // creating a resultSet to contain the data retrieved using the statement
        DoublyLinkedList<Contact> contactList = new DoublyLinkedList<>();
        while (rs.next()) {
            Contact c1 = new Contact(); // creating a new contact object
            c1.setId(rs.getInt(1));
            c1.setName(rs.getString(2));
            c1.setPhoneNumber(rs.getString(6));
            contactList.add(c1);
        }
        return contactList;
    }

    public void deleteAll(DoublyLinkedList<Contact> list) throws SQLException {
        Statement st = con.createStatement();
        for (Contact c : list) {
            st.executeUpdate("DELETE FROM contacts WHERE contact_ID=\'" + c.getId() + "\';");
        }
    }

    public void deleteContact(Contact c) throws SQLException {
        Statement st = con.createStatement();
        st.executeUpdate("DELETE FROM contacts WHERE contact_ID=\'" + c.getId() + "\';");
    }

    public void insertContact(Contact c) throws SQLException {
        Statement st = con.createStatement();
        st.executeUpdate("INSERT INTO `phone_book`.`contacts` "
                + "(`name`, `address`, `city`, `state`, `phone`) VALUES"
                + " ('" + c.getName() + "', '" + c.getAddress() + "', '" + c.getCity() + "', '" + c.getState() + "', '" + c.getPhoneNumber() + "');");
    }
    public void updateContact(Contact c) throws SQLException{
         Statement st = con.createStatement();
         st.executeUpdate("UPDATE contacts SET name = '"+c.getName()+"', address = '"+c.getAddress()+"',city = '" + c.getCity()+"'"+
                            ",state = '"+c.getState()+"', phone = '"+c.getPhoneNumber()+"'  WHERE contact_id = "+ c.getId()+" ;");
         System.out.println(st.toString());
   
         
    }

}


