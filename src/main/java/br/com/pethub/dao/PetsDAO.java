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

            String sql = "update tb_pets set pet_name=?, gender=?, birth=?, pet_weight=?, species=?, breed=?, for_id=? where id=?";

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

            VaccineDAO vaccineDAO = new VaccineDAO();
            vaccineDAO.deleteVaccinesByPetId(obj.getId());

            ServicesDAO servicesDAO = new ServicesDAO();
            servicesDAO.deleteScheduleByPetId(obj.getId());

            String sql = "delete from tb_pets where id = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Animal e registros relacionados excluídos com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }

    public List<Pets> listPets() {
        try {
            List<Pets> listPets = new ArrayList<>();

            String sql = "select p.id, p.pet_name, p.gender, date_format(p.birth, '%d/%m/%Y') as date_formatted, p.pet_weight, p.species, p.breed, f.name from tb_pets as p "
                    + "inner join tb_customers as f on (p.for_id = f.id)";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Pets obj = new Pets();
                Customers f = new Customers();

                obj.setId(rs.getInt("p.id"));
                obj.setPet_name(rs.getString("p.pet_name"));
                obj.setGender(rs.getString("p.gender"));
                obj.setBirth(rs.getString("date_formatted"));
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
                    + "inner join tb_customers as f on (p.for_id = f.id) where p.pet_name like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);

            ResultSet rs = stmt.executeQuery();

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

    public List<Pets> getPetsByCustomer(Customers customer) {
        try {
            List<Pets> listPets = new ArrayList<>();

            String sql = "SELECT * FROM tb_pets WHERE for_id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, customer.getId());

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Pets obj = new Pets();

                obj.setId(rs.getInt("id"));
                obj.setPet_name(rs.getString("pet_name"));
                obj.setGender(rs.getString("gender"));
                obj.setBirth(rs.getString("birth"));
                obj.setPet_weight(rs.getDouble("pet_weight"));
                obj.setSpecies(rs.getString("species"));
                obj.setBreed(rs.getString("breed"));

                obj.setCustumers(customer);

                listPets.add(obj);
            }

            return listPets;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }

    public Pets getPetByName(String name) {
        try {
            String sql = "SELECT * FROM tb_pets WHERE pet_name = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Pets obj = new Pets();
                Customers f = new Customers();

                obj.setId(rs.getInt("id"));
                obj.setPet_name(rs.getString("pet_name"));
                obj.setGender(rs.getString("gender"));
                obj.setBirth(rs.getString("birth"));
                obj.setPet_weight(rs.getDouble("pet_weight"));
                obj.setSpecies(rs.getString("species"));
                obj.setBreed(rs.getString("breed"));

                f.setId(rs.getInt("for_id"));
                obj.setCustumers(f);

                return obj;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
        return null;
    }

    public void deletePetsByCustomerId(int customerId) {
        try {
            VaccineDAO vaccineDAO = new VaccineDAO();
            vaccineDAO.deleteVaccinesByCustomerId(customerId);

            String sql = "delete from tb_pets where for_id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, customerId);

            stmt.execute();
            stmt.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar pets: " + erro);
        }
    }

}
