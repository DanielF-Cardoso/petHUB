package br.com.pethub.dao;

import br.com.pethub.jdbc.ConnectionFactory;
import br.com.pethub.model.Customers;
import br.com.pethub.model.Sales;
import java.io.InputStream;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author danie
 */
public class SalesDAO {

    private Connection con;

    public SalesDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void addSales(Sales obj) {

        try {

            String sql = "insert into tb_sales (client_id, sale_date, total_sale, note)"
                    + "values (?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getCustomer().getId());
            stmt.setString(2, obj.getSale_date());
            stmt.setDouble(3, obj.getTotal_sale());
            stmt.setString(4, obj.getNote());

            stmt.execute();
            stmt.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }

    public int returnLastSale() {
        int idSale = 0;
        try {
            String sql = "select max(id) id from tb_sales";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Sales sales = new Sales();
                sales.setId(rs.getInt("id"));
                idSale = sales.getId();
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
        return idSale;
    }

    public List<Sales> listSales(LocalDate date_start, LocalDate date_end) {
        try {

            List<Sales> listSale = new ArrayList<>();

            String sql = "select s.id, date_format(s.sale_date, '%d/%m/%y') as date_formatted, c.name, s.total_sale, s.note from tb_sales as s "
                    + "inner join tb_customers c on (s.client_id = c.id) "
                    + "where s.sale_date between ? and ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, date_start.toString());
            stmt.setString(2, date_end.toString());

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                Sales sale = new Sales();
                Customers customer = new Customers();

                sale.setId(rs.getInt("s.id"));
                sale.setSale_date(rs.getString("date_formatted"));
                customer.setName(rs.getString("c.name"));
                sale.setTotal_sale(rs.getDouble("s.total_sale"));
                sale.setNote(rs.getString("s.note"));

                sale.setCustomer(customer);

                listSale.add(sale);
            }

            return listSale;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }

    public double returnTotalSalesDay(LocalDate sale_date) {

        try {
            double totalSale = 0;

            String sql = "select sum(total_sale) as total from tb_sales where sale_date = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, sale_date.toString());

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                totalSale = rs.getDouble("total");
            }
            return totalSale;

        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }

    public void deleteSalesByCustomerId(int customerId) {
        try {
            ItemSaleDAO itemSaleDAO = new ItemSaleDAO();
            itemSaleDAO.deleteItemsSaleByCustomerId(customerId);

            String sql = "delete from tb_sales where client_id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, customerId);

            stmt.execute();
            stmt.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar vendas: " + erro);
        }
    }

    public void lastSaleReport() {
        try {
            String sql = "SELECT s.id, DATE_FORMAT(s.sale_date, '%d/%m/%y') AS date_formatted, c.*, p.*, i.*, s.total_sale, s.note "
                    + "FROM tb_sales AS s "
                    + "INNER JOIN tb_customers c ON (s.client_id = c.id) "
                    + "INNER JOIN tb_itemssales i ON (s.id = i.sale_id) "
                    + "INNER JOIN tb_products p ON (i.product_id = p.id) "
                    + "WHERE s.id = (SELECT MAX(id) FROM tb_sales)";

            InputStream inputStream = getClass().getResourceAsStream("/br/com/pethub/reports/lastSaleReport.jrxml");
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
