/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


/**
 *
 * @author Ahmed Diab, Fengnan Zhang.
 */
public class DbConnection {

    String userName, password;
    String dataBaseName;
    
    /**
     * constructor.
     * @param dataBase
     * @param user
     * @param password 
     */
    public DbConnection(String dataBase,String user,String password){
        this.dataBaseName = dataBase;
        this.password = password;
        this.userName = user;
        
    }
    
    /**
     * set username.
     * @param userName 
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    /**
     * set password.
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * set database name.
     * @param dataBaseName 
     */
    public void setDataBaseName(String dataBaseName) {
        this.dataBaseName = dataBaseName;
    }
    
    /**
     * connect to the database.
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public Connection openConnection() throws ClassNotFoundException, SQLException {

        Properties properties = new Properties();
        properties.put("user", userName);
        properties.put("password", password);
        String url = "jdbc:mysql://localhost/" + dataBaseName;

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection(url, properties);
        return c;
    }
}
