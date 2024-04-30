/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pethub.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author danie
 */
public class ConnectionFactory {
    
    public Connection getConnection(){
        
        try {
            return DriverManager.getConnection("jdbc:mysql://node21.elgaehost.com.br/s2361_petHUB", "u2361_zoJwJxiM18", "USKL@bAXb^Ry@ae+tcf5o!Qg");
        } catch (Exception erro) {
            throw new RuntimeException(erro);
        }
        
    }
    
}
