/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.sql.Connection;
import java.rmi.RemoteException;
import rmi.rmi_interface;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author devhr
 */
public class server  extends UnicastRemoteObject implements rmi_interface{
    public server() throws RemoteException{
        super();
    }
    
    public static void main(String[] args)throws RemoteException{
        Registry reg = LocateRegistry.createRegistry(1099);
        server ser = new server();
        reg.rebind("db",ser);
        System.out.println("Server is Active!");
        
    }

    @Override
    public String insert(String firstname, String lastname, String Password) throws RemoteException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/user","root","");
            PreparedStatement ps = c.prepareStatement("insert into user_data(fistname,lastname,password) values (?,?,?)");
  
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setString(3, Password);
            
            ps.executeUpdate();
            return "User Data Added!";
            
        }
        catch(ClassNotFoundException | SQLException ex){
            return ex.toString();
        }
    }
    
}
