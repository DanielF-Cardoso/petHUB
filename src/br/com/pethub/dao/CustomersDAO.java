/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pethub.dao;

import br.com.pethub.jdbc.ConnectionFactory;
import br.com.pethub.model.Customers;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daniel
 */
public class CustomersDAO {

    private Connection con;

    public CustomersDAO(){
        this.con = new ConnectionFactory().getConnection();
    }

    public void addCustomer(Customers obj){
    
        try {

            //Criar o comando sql

            String sql = "insert into tb_customers (name, rg, cpf, email, landline, phone, cep, address, number," +
                    "complement, district, city, state)" +
                    "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getLandline());
            stmt.setString(6, obj.getPhone());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getAddress());
            stmt.setInt(9, obj.getNumber());
            stmt.setString(10, obj.getComplement());
            stmt.setString(11, obj.getDistrict());
            stmt.setString(12, obj.getCity());
            stmt.setString(13, obj.getState());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
        
    }
    
    public void editCustomer(Customers obj){
    
            try {

            //Criar o comando sql

            String sql = "update into tb_customers (name, rg, cpf, email, landline, phone, cep, address, number," +
                    "complement, district, city, state)" +
                    "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getLandline());
            stmt.setString(6, obj.getPhone());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getAddress());
            stmt.setInt(9, obj.getNumber());
            stmt.setString(10, obj.getComplement());
            stmt.setString(11, obj.getDistrict());
            stmt.setString(12, obj.getCity());
            stmt.setString(13, obj.getState());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
        
    }
    
    public void deleteCustomer(Customers obj){
    
                try {

            //Criar o comando sql

            String sql = "delete form tb_customers where id = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!");
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    
    }
    
    public List<Customers>  listCustomers(){
        try {

            List<Customers> listCustomer = new ArrayList<>();

            String sql = "select * from tb_customers";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(); //retorna um conjunto de dados

            while(rs.next()){
                Customers obj = new Customers();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setLandline(rs.getString("landline"));
                obj.setPhone(rs.getString("phone"));
                obj.setCep(rs.getString("cep"));
                obj.setAddress(rs.getString("address"));
                obj.setNumber(rs.getInt("number"));
                obj.setComplement(rs.getString("complement"));
                obj.setDistrict(rs.getString("district"));
                obj.setCity(rs.getString("city"));
                obj.setState(rs.getString("state"));

                listCustomer.add(obj);
            }

            return listCustomer;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }
    
}
