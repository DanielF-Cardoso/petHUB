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
            return DriverManager.getConnection("jdbc:mysql://190.115.196.66/s3_privado", "u3_0rKFINXhUG", "pHb9CedFIX=FzZI+X=1mv3oS");
        } catch (Exception erro) {
            throw new RuntimeException(erro);
        }
        
    }
    
}
