
package br.com.pethub.dao;

import br.com.pethub.jdbc.ConnectionFactory;
import br.com.pethub.model.Pets;
import br.com.pethub.model.Customers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class PetsDAO {
    
    private Connection con;

    public PetsDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    
    public void addPets(Pets obj) {

        try {

            //Criar o comando sql
            String sql = "insert into tb_pets (pet_name, gender, birth, pet_weight, species, breed, for_id)"
                    + "values (?,?,?,?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getPet_name());
            stmt.setString(2, obj.getGender());
            stmt.setString(3, obj.getBirth());
            stmt.setDouble(4, obj.getPet_weight());
            stmt.setString(5, obj.getSpecies());
            stmt.setString(6, obj.getBreed());
            
            stmt.setInt(7, obj.getCustumers().getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Animal cadastrado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }
    
    
    
     public void editPets(Pets obj) {

        try {

            //Criar o comando sql
            String sql = "update tb_pets set pets_name=?, gender=?, birth=?, pet_weight=?, species=?, breed=?, for_id=? where id=?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getPet_name());
            stmt.setString(2, obj.getGender());
            stmt.setString(3, obj.getBirth());
            stmt.setDouble(4, obj.getPet_weight());
            stmt.setString(5, obj.getSpecies());
            stmt.setString(6, obj.getBreed());

            stmt.setInt(7, obj.getCustumers().getId());

            stmt.setInt(8, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Animal alterado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }
     
     
     public void deletePets(Pets obj) {

        try {

            //Criar o comando sql
            String sql = "delete from tb_pets where id = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Animal excluido com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }
     
     
     
     public List<Pets> listPets() {
        try {

            List<Pets> listPets = new ArrayList<>();

            String sql = "select p.id, p.pet_name, p.gender, p.birth, p.pet_weight, p.species, p.breed, f.name from tb_pets as p "
                    + "inner join tb_customers as f on (p.for_id = f.id)";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(); //retorna um conjunto de dados

            while (rs.next()) {

                Pets obj = new Pets();
                Customers f = new Customers();

                obj.setId(rs.getInt("p.id"));
                obj.setPet_name(rs.getString("p.pet_name"));
                obj.setGender(rs.getString("p.gender"));
                obj.setBirth(rs.getString("p.birth"));
                obj.setPet_weight(rs.getDouble("p.pet_weight"));
                obj.setSpecies(rs.getString("p.species"));
                obj.setBreed(rs.getString("p.breed"));

                f.setName(rs.getString("f.name"));

                obj.setCustumers(f);

                listPets.add(obj);
            }

            return listPets;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }
     
     
     public List<Pets> searchPets(String name) {
        try {

            List<Pets> listPets = new ArrayList<>();

            String sql = "select p.id, p.pet_name, p.gender, p.birth, p.pet_weight, p.species, p.breed, f.name from tb_pets as p "
                    + "inner join tb_customers as f on (p.for_id = f.id) where p.product like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);

            ResultSet rs = stmt.executeQuery(); //retorna um conjunto de dados

            while (rs.next()) {

                Pets obj = new Pets();
                Customers f = new Customers();

                obj.setId(rs.getInt("p.id"));
                obj.setPet_name(rs.getString("p.pet_name"));
                obj.setGender(rs.getString("p.gender"));
                obj.setBirth(rs.getString("p.birth"));
                obj.setPet_weight(rs.getDouble("p.pet_weight"));
                obj.setSpecies(rs.getString("p.Species"));
                obj.setBreed(rs.getString("p.breed"));

                f.setName(rs.getString("f.name"));

                obj.setCustumers(f);

                listPets.add(obj);
            }

            return listPets;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }

}
