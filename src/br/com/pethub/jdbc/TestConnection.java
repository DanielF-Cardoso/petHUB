/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pethub.jdbc;

import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class TestConnection {
    
    public static void main(String[] args) {
        try {
            
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null, "Conexão feita com sucesso!");
            
        } catch(Exception erro){
             JOptionPane.showMessageDialog(null, "Um erro aconteceu: " + erro);           
        }
    }
    
}
