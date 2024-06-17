package br.com.pethub.dao;

import br.com.pethub.jdbc.ConnectionFactory;
import br.com.pethub.model.Products;
import br.com.pethub.model.Suppliers;
import java.io.InputStream;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;

/**
 * This class is responsible for managing the data access for the Products in the application.
 * It provides methods to add, edit, delete, list, and search products in the database.
 * It also provides methods to search products by code, update stock, return stock, and generate a products report.
 */
public class ProductsDAO {

    private Connection con;

    /**
     * The constructor method of the ProductsDAO class.
     */
    public ProductsDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    /**
     * This method is used to add a new product to the database.
     * @param obj The product to be added.
     */
    public void addProducts(Products obj) {

        try {

            String sql = "insert into tb_products (product, price, stock_qty, for_id)"
                    + "values (?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getProduct());
            stmt.setDouble(2, obj.getPrice());
            stmt.setInt(3, obj.getStock_qty());
            stmt.setInt(4, obj.getSuppliers().getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }

    /**
     * This method is used to edit the details of an existing product in the database.
     * @param obj The product with the updated details.
     */
    public void editProducts(Products obj) {

        try {

            String sql = "update tb_products set product=?, price=?, stock_qty=?, for_id=? where id=?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getProduct());
            stmt.setDouble(2, obj.getPrice());
            stmt.setInt(3, obj.getStock_qty());

            stmt.setInt(4, obj.getSuppliers().getId());

            stmt.setInt(5, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }

    /**
     * This method is used to delete a product from the database.
     * @param obj The product to be deleted.
     */
    public void deleteProducts(Products obj) {

        try {

            String sql = "delete from tb_products where id = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto excluido com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não é possível deletar esse produto pois existem vendas relacionadas a ele no sistema!");
        }

    }

    /**
     * This method is used to retrieve a list of all products from the database.
     * @return A list of all products.
     */
    public List<Products> listProducts() {
        try {

            List<Products> listProducts = new ArrayList<>();

            String sql = "select p.id, p.product, p.price, p.stock_qty, f.name from tb_products as p "
                    + "inner join tb_suppliers as f on (p.for_id = f.id)";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Products obj = new Products();
                Suppliers f = new Suppliers();

                obj.setId(rs.getInt("p.id"));
                obj.setProduct(rs.getString("p.product"));
                obj.setPrice(rs.getDouble("p.price"));
                obj.setStock_qty(rs.getInt("p.stock_qty"));

                f.setName(rs.getString("f.name"));

                obj.setSuppliers(f);

                listProducts.add(obj);
            }

            return listProducts;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }

    /**
     * This method is used to search for products by name.
     * @param name The name of the product to search for.
     * @return A list of products that match the provided name.
     */
    public List<Products> searchProducts(String name) {
        try {

            List<Products> listProducts = new ArrayList<>();

            String sql = "select p.id, p.product, p.price, p.stock_qty, f.name from tb_products as p "
                    + "inner join tb_suppliers as f on (p.for_id = f.id) where p.product like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Products obj = new Products();
                Suppliers f = new Suppliers();

                obj.setId(rs.getInt("p.id"));
                obj.setProduct(rs.getString("p.product"));
                obj.setPrice(rs.getDouble("p.price"));
                obj.setStock_qty(rs.getInt("p.stock_qty"));

                f.setName(rs.getString("f.name"));

                obj.setSuppliers(f);

                listProducts.add(obj);
            }

            return listProducts;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }

    /**
     * This method is used to search for a product by code.
     * @param id The code of the product to search for.
     * @return The product that matches the provided code, or null if no match is found.
     */
    public Products searchProductsByCode(int id) {
        try {
            String sql = "select p.id, p.product, p.price, p.stock_qty, f.name from tb_products as p "
                    + "inner join tb_suppliers as f on (p.for_id = f.id) where p.id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Products obj = new Products();
                Suppliers f = new Suppliers();

                obj.setId(rs.getInt("p.id"));
                obj.setProduct(rs.getString("p.product"));
                obj.setPrice(rs.getDouble("p.price"));
                obj.setStock_qty(rs.getInt("p.stock_qty"));

                f.setName(rs.getString("f.name"));

                obj.setSuppliers(f);

                return obj;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar produto: " + e.getMessage());
        }
        return null;
    }

    /**
     * This method is used to update the stock of a product.
     * @param id The id of the product to update the stock for.
     * @param stock_new The new stock quantity.
     */
    public void updateStock(int id, int stock_new) {
        try {
            String sql = "update tb_products set stock_qty= ? where id= ?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, stock_new);
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();

        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Erro: " + error);
        }
    }

    /**
     * This method is used to return the stock of a product.
     * @param id The id of the product to return the stock for.
     * @return The stock quantity of the product.
     */
    public int returnStock(int id) {
        try {
            int stock_qty = 0;

            String sql = "select stock_qty from tb_products where id= ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Products products = new Products();

                stock_qty = (rs.getInt("stock_qty"));
            }

            return stock_qty;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method is used to generate a products report.
     */
    public void productsReport() {
        try {
            String sql = "select p.id, p.product, p.price, p.stock_qty, f.name from tb_products as p "
                    + "inner join tb_suppliers as f on (p.for_id = f.id)";

            InputStream inputStream = getClass().getResourceAsStream("/br/com/pethub/reports/productsReport.jrxml");
            JasperDesign jd = JRXmlLoader.load(inputStream);

            JRDesignQuery query = new JRDesignQuery();
            query.setText(sql);
            jd.setQuery(query);

            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con);

            JasperViewer.viewReport(jp, false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }

}
