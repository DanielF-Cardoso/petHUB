/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pethub.jdbc;

import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Fernandes
 */

/**
 * This class is used to test the database connection.
 * It creates a new instance of the ConnectionFactory class and attempts to establish a connection.
 * If the connection is successful, a success message is displayed.
 * If an error occurs during the connection process, the error message is displayed.
 */
public class TestConnection {

    /**
     * The main method of the TestConnection class.
     * It is the entry point for the application.
     * @param args An array of command-line arguments for the application.
     */
    public static void main(String[] args) {
        try {
            
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null, "Conexão feita com sucesso!");
            
        } catch(Exception erro){
             JOptionPane.showMessageDialog(null, "Um erro aconteceu: " + erro);           
        }
    }
    
}
