
package br.com.pethub.dao;

import br.com.pethub.jdbc.ConnectionFactory;
import br.com.pethub.model.Suppliers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;


public class SuppliersDAO {
    
     private Connection con;

    public SuppliersDAO(){
        this.con = new ConnectionFactory().getConnection();
    }

    
     public void addSuppliers(Suppliers obj){
    
        try {

            String sql = "insert into tb_suppliers (name, cnpj, email, landline, phone, cep, address, number," +
                    "complement, district, city, state)" +
                    "values (?,?,?,?,?,?,?,?,?,?,?, ?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getCnpj());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getLandline());
            stmt.setString(5, obj.getPhone());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getAddress());
            stmt.setInt(8, obj.getNumber());
            stmt.setString(9, obj.getComplement());
            stmt.setString(10, obj.getDistrict());
            stmt.setString(11, obj.getCity());
            stmt.setString(12, obj.getState());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso!");
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
        
    }
     
     public void editSuppliers(Suppliers obj){
    
            try {


            String sql = "update tb_suppliers set name = ?, cnpj = ?, email = ?, landline = ?, phone = ?, cep = ?, address = ?, number = ?," +
                    "complement = ?, district = ?, city = ?, state = ? where id = ?";


            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getCnpj());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getLandline());
            stmt.setString(5, obj.getPhone());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getAddress());
            stmt.setInt(8, obj.getNumber());
            stmt.setString(9, obj.getComplement());
            stmt.setString(10, obj.getDistrict());
            stmt.setString(11, obj.getCity());
            stmt.setString(12, obj.getState());
            stmt.setInt(13, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Fornecedor editado com sucesso!");
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
        
    }
     
     public void deleteSuppliers(Suppliers obj){
    
                try {

            String sql = "delete from tb_suppliers where id = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Fornecedor excluido com sucesso!");
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não é possível apagar esse fornecedor pois existem produtos relacionados a ele no sistema!");
        }
    
    }
     
     public List<Suppliers>  listSuppliers(){
        try {

            List<Suppliers> listSuppliers = new ArrayList<>();

            String sql = "select * from tb_suppliers";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Suppliers obj = new Suppliers();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setCnpj(rs.getString("cnpj"));  
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

                listSuppliers.add(obj);
            }

            return listSuppliers;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }
     
      public List<Suppliers>  searchSuppliers(String name){
        try {

            List<Suppliers> listSuppliers = new ArrayList<>();

            String sql = "select * from tb_suppliers where name like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Suppliers obj = new Suppliers();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setCnpj(rs.getString("cnpj"));
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

                listSuppliers.add(obj);
            }

            return listSuppliers;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }    
    
      public Suppliers consultSuppliers(String name){
        try {

            String sql = "select * from tb_suppliers where name = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            Suppliers obj = new Suppliers();
            
            if(rs.next()){
                
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setCnpj(rs.getString("cnpj"));
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
            }

            return obj;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }    
}
