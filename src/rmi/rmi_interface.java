/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rmi;

import java.rmi.Remote;

import java.rmi.RemoteException;

/**
 *
 * @author devhr
 */
public interface rmi_interface extends Remote{
    
    public String insert(String firstname, String lastname, String Password) throws RemoteException;
}
