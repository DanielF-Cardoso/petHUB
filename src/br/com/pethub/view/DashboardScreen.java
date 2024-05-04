/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.pethub.view;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author daniel
 */
public class DashboardScreen extends javax.swing.JFrame {

    public String userLogin;

    /**
     * Creates new form Frmmenu
     */
    public DashboardScreen() {
        initComponents();

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/br/com/pethub/images/icones/icone_pethub.png")));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/br/com/pethub/images/fundo_pethubv1.png"));
        Image image = icon.getImage();
        painel_desktop = new javax.swing.JDesktopPane(){

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = customizeJMenuBar(new javax.swing.JMenuBar());
        customerMenu = new javax.swing.JMenu();
        addCustomerMenu = new javax.swing.JMenuItem();
        searchCustomerMenu = new javax.swing.JMenuItem();
        addAnimalMenu = new javax.swing.JMenuItem();
        searchAnimalMenu = new javax.swing.JMenuItem();
        employeeMenu = new javax.swing.JMenu();
        addEmployeeMenu = new javax.swing.JMenuItem();
        searchEmployeeMenu = new javax.swing.JMenuItem();
        supplierMenu = new javax.swing.JMenu();
        addSupplierMenu = new javax.swing.JMenuItem();
        searchSupplierMenu = new javax.swing.JMenuItem();
        productsMenu = new javax.swing.JMenu();
        stockManagementMenu = new javax.swing.JMenuItem();
        addProductsMenu = new javax.swing.JMenuItem();
        searchProductMenu = new javax.swing.JMenuItem();
        vaccineMenu = new javax.swing.JMenu();
        vaccineControllerMenu = new javax.swing.JMenuItem();
        searchVaccineMenu = new javax.swing.JMenuItem();
        salesMenu = new javax.swing.JMenu();
        pdvMenu = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        historySalesMenu = new javax.swing.JMenuItem();
        settingsMenu = new javax.swing.JMenu();
        changeUserMenu = new javax.swing.JMenuItem();
        exitMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PetHUB | Painel Administrativo");
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(28, 74, 137));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuário Logado:");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Daniel Fernandes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addContainerGap(863, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        painel_desktop.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout painel_desktopLayout = new javax.swing.GroupLayout(painel_desktop);
        painel_desktop.setLayout(painel_desktopLayout);
        painel_desktopLayout.setHorizontalGroup(
            painel_desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        painel_desktopLayout.setVerticalGroup(
            painel_desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_desktopLayout.createSequentialGroup()
                .addGap(0, 423, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorder(null);

        customerMenu.setForeground(new java.awt.Color(255, 255, 255));
        customerMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pethub/images/icones/Icone_cliente.png"))); // NOI18N
        customerMenu.setText("Clientes");

        addCustomerMenu.setForeground(new java.awt.Color(28, 74, 137));
        addCustomerMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pethub/images/icones/icone_adicionar.png"))); // NOI18N
        addCustomerMenu.setText("Cadastro de Cliente");
        addCustomerMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCustomerMenuActionPerformed(evt);
            }
        });
        customerMenu.add(addCustomerMenu);

        searchCustomerMenu.setForeground(new java.awt.Color(28, 74, 137));
        searchCustomerMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pethub/images/icones/icone_buscar.png"))); // NOI18N
        searchCustomerMenu.setText("Consulta de Cliente");
        searchCustomerMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCustomerMenuActionPerformed(evt);
            }
        });
        customerMenu.add(searchCustomerMenu);

        addAnimalMenu.setForeground(new java.awt.Color(28, 74, 137));
        addAnimalMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pethub/images/icones/icone_adicionar.png"))); // NOI18N
        addAnimalMenu.setText("Cadastro de Animal");
        addAnimalMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAnimalMenuActionPerformed(evt);
            }
        });
        customerMenu.add(addAnimalMenu);

        searchAnimalMenu.setForeground(new java.awt.Color(28, 74, 137));
        searchAnimalMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pethub/images/icones/icone_buscar.png"))); // NOI18N
        searchAnimalMenu.setText("Consulta de Animal");
        searchAnimalMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchAnimalMenuActionPerformed(evt);
            }
        });
        customerMenu.add(searchAnimalMenu);

        jMenuBar1.add(customerMenu);

        employeeMenu.setForeground(new java.awt.Color(255, 255, 255));
        employeeMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pethub/images/icones/Icone_funcionario.png"))); // NOI18N
        employeeMenu.setText("Funcionarios");

        addEmployeeMenu.setForeground(new java.awt.Color(28, 74, 137));
        addEmployeeMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pethub/images/icones/icone_adicionar.png"))); // NOI18N
        addEmployeeMenu.setText("Cadastro de  Funcionários");
        addEmployeeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeMenuActionPerformed(evt);
            }
        });
        employeeMenu.add(addEmployeeMenu);

        searchEmployeeMenu.setForeground(new java.awt.Color(28, 74, 137));
        searchEmployeeMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pethub/images/icones/icone_buscar.png"))); // NOI18N
        searchEmployeeMenu.setText("Consulta de Funcionários");
        searchEmployeeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchEmployeeMenuActionPerformed(evt);
            }
        });
        employeeMenu.add(searchEmployeeMenu);

        jMenuBar1.add(employeeMenu);

        supplierMenu.setForeground(new java.awt.Color(255, 255, 255));
        supplierMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pethub/images/icones/icone_fornecedores.png"))); // NOI18N
        supplierMenu.setText("Fornecedores");

        addSupplierMenu.setForeground(new java.awt.Color(28, 74, 137));
        addSupplierMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pethub/images/icones/icone_adicionar.png"))); // NOI18N
        addSupplierMenu.setText("Cadastro de Fornecedores");
        addSupplierMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSupplierMenuActionPerformed(evt);
            }
        });
        supplierMenu.add(addSupplierMenu);

        searchSupplierMenu.setForeground(new java.awt.Color(28, 74, 137));
        searchSupplierMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pethub/images/icones/icone_buscar.png"))); // NOI18N
        searchSupplierMenu.setText("Consulta de Fornecedores");
        searchSupplierMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchSupplierMenuActionPerformed(evt);
            }
        });
        supplierMenu.add(searchSupplierMenu);

        jMenuBar1.add(supplierMenu);

        productsMenu.setForeground(new java.awt.Color(255, 255, 255));
        productsMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pethub/images/icones/icone_produtos.png"))); // NOI18N
        productsMenu.setText("Produtos");

        stockManagementMenu.setForeground(new java.awt.Color(28, 74, 137));
        stockManagementMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pethub/images/icones/icone_adicionar.png"))); // NOI18N
        stockManagementMenu.setText("Controle de Estoque");
        stockManagementMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockManagementMenuActionPerformed(evt);
            }
        });
        productsMenu.add(stockManagementMenu);

        addProductsMenu.setForeground(new java.awt.Color(28, 74, 137));
        addProductsMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pethub/images/icones/icone_adicionar.png"))); // NOI18N
        addProductsMenu.setText("Cadastro de Produtos");
        addProductsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductsMenuActionPerformed(evt);
            }
        });
        productsMenu.add(addProductsMenu);

        searchProductMenu.setForeground(new java.awt.Color(28, 74, 137));
        searchProductMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pethub/images/icones/icone_buscar.png"))); // NOI18N
        searchProductMenu.setText("Consulta de Produtos");
        searchProductMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchProductMenuActionPerformed(evt);
            }
        });
        productsMenu.add(searchProductMenu);

        jMenuBar1.add(productsMenu);

        vaccineMenu.setForeground(new java.awt.Color(255, 255, 255));
        vaccineMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pethub/images/icones/icone_vacina.png"))); // NOI18N
        vaccineMenu.setText("Vacinas");

        vaccineControllerMenu.setForeground(new java.awt.Color(28, 74, 137));
        vaccineControllerMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pethub/images/icones/icone_adicionar.png"))); // NOI18N
        vaccineControllerMenu.setText("Controle de Vacinas");
        vaccineControllerMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vaccineControllerMenuActionPerformed(evt);
            }
        });
        vaccineMenu.add(vaccineControllerMenu);

        searchVaccineMenu.setForeground(new java.awt.Color(28, 74, 137));
        searchVaccineMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pethub/images/icones/icone_buscar.png"))); // NOI18N
        searchVaccineMenu.setText("Consulta de Vacinas");
        searchVaccineMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchVaccineMenuActionPerformed(evt);
            }
        });
        vaccineMenu.add(searchVaccineMenu);

        jMenuBar1.add(vaccineMenu);

        salesMenu.setForeground(new java.awt.Color(255, 255, 255));
        salesMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pethub/images/icones/icone_vendas.png"))); // NOI18N
        salesMenu.setText("Vendas");

        pdvMenu.setForeground(new java.awt.Color(28, 74, 137));
        pdvMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pethub/images/icones/icone_pdv.png"))); // NOI18N
        pdvMenu.setText("Abrir PDV");
        pdvMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdvMenuActionPerformed(evt);
            }
        });
        salesMenu.add(pdvMenu);

        jMenuItem7.setForeground(new java.awt.Color(28, 74, 137));
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pethub/images/icones/icone_historico.png"))); // NOI18N
        jMenuItem7.setText("Posição do dia");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        salesMenu.add(jMenuItem7);

        historySalesMenu.setForeground(new java.awt.Color(28, 74, 137));
        historySalesMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pethub/images/icones/icone_historico.png"))); // NOI18N
        historySalesMenu.setText("Histórico de Vendas");
        historySalesMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historySalesMenuActionPerformed(evt);
            }
        });
        salesMenu.add(historySalesMenu);

        jMenuBar1.add(salesMenu);

        settingsMenu.setForeground(new java.awt.Color(255, 255, 255));
        settingsMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pethub/images/icones/icone_configuracoes.png"))); // NOI18N
        settingsMenu.setText("Configurações");

        changeUserMenu.setForeground(new java.awt.Color(28, 74, 137));
        changeUserMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pethub/images/icones/icone_trocarusuario.png"))); // NOI18N
        changeUserMenu.setText("Trocar de Usuário");
        settingsMenu.add(changeUserMenu);

        jMenuBar1.add(settingsMenu);

        exitMenu.setForeground(new java.awt.Color(255, 255, 255));
        exitMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pethub/images/icones/icone_sair.png"))); // NOI18N
        exitMenu.setText("Sair");
        exitMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(exitMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel_desktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel_desktop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addCustomerMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCustomerMenuActionPerformed
        // TODO add your handling code here:

        CustomerScreen customer = new CustomerScreen();
        customer.jTabbedPane1.setSelectedIndex(0);
        customer.setVisible(true);

    }//GEN-LAST:event_addCustomerMenuActionPerformed

    private void addEmployeeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeMenuActionPerformed
        // TODO add your handling code here:

        EmployeeScreen employee = new EmployeeScreen();
        employee.jTabbedPane1.setSelectedIndex(0);
        employee.setVisible(true);

    }//GEN-LAST:event_addEmployeeMenuActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        this.setExtendedState(this.MAXIMIZED_BOTH);
        jLabel3.setText(userLogin);
        this.setVisible(true);
    }//GEN-LAST:event_formWindowActivated

    private void addAnimalMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAnimalMenuActionPerformed
        // TODO add your handling code here:

        PetScreen pet = new PetScreen();
        pet.jTabbedPane1.setSelectedIndex(0);
        pet.setVisible(true);

    }//GEN-LAST:event_addAnimalMenuActionPerformed

    private void vaccineControllerMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vaccineControllerMenuActionPerformed
        // TODO add your handling code here:
        
        VaccineScreen vaccine = new VaccineScreen();
        vaccine.jTabbedPane1.setSelectedIndex(0);
        vaccine.setVisible(true);
        
    }//GEN-LAST:event_vaccineControllerMenuActionPerformed

    private void searchProductMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchProductMenuActionPerformed
        // TODO add your handling code here:

        ProductsScreen products = new ProductsScreen();
        products.jTabbedPane1.setSelectedIndex(1);
        products.setVisible(true);

    }//GEN-LAST:event_searchProductMenuActionPerformed

    private void searchCustomerMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCustomerMenuActionPerformed
        // TODO add your handling code here:
        CustomerScreen customer = new CustomerScreen();
        customer.jTabbedPane1.setSelectedIndex(1);
        customer.setVisible(true);
    }//GEN-LAST:event_searchCustomerMenuActionPerformed

    private void searchAnimalMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchAnimalMenuActionPerformed
        // TODO add your handling code here:

        PetScreen pet = new PetScreen();
        pet.jTabbedPane1.setSelectedIndex(1);
        pet.setVisible(true);

    }//GEN-LAST:event_searchAnimalMenuActionPerformed

    private void searchEmployeeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchEmployeeMenuActionPerformed
        // TODO add your handling code here:

        EmployeeScreen employee = new EmployeeScreen();
        employee.jTabbedPane1.setSelectedIndex(0);
        employee.setVisible(true);

    }//GEN-LAST:event_searchEmployeeMenuActionPerformed

    private void searchSupplierMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchSupplierMenuActionPerformed
        // TODO add your handling code here:

        SupplierScreen supplier = new SupplierScreen();
        supplier.jTabbedPane1.setSelectedIndex(1);
        supplier.setVisible(true);

    }//GEN-LAST:event_searchSupplierMenuActionPerformed

    private void addSupplierMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSupplierMenuActionPerformed
        // TODO add your handling code here:

        SupplierScreen supplier = new SupplierScreen();
        supplier.jTabbedPane1.setSelectedIndex(0);
        supplier.setVisible(true);

    }//GEN-LAST:event_addSupplierMenuActionPerformed

    private void addProductsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductsMenuActionPerformed
        // TODO add your handling code here:
        
        ProductsScreen products = new ProductsScreen();
        products.jTabbedPane1.setSelectedIndex(0);
        products.setVisible(true);
        
    }//GEN-LAST:event_addProductsMenuActionPerformed

    private void stockManagementMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockManagementMenuActionPerformed
        // TODO add your handling code here:
        
        StockManagementScreen stock = new StockManagementScreen();
        stock.setVisible(true);
        
    }//GEN-LAST:event_stockManagementMenuActionPerformed

    private void searchVaccineMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchVaccineMenuActionPerformed
        // TODO add your handling code here:
        
                VaccineScreen vaccine = new VaccineScreen();
        vaccine.jTabbedPane1.setSelectedIndex(1);
        vaccine.setVisible(true);
        
    }//GEN-LAST:event_searchVaccineMenuActionPerformed

    private void pdvMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdvMenuActionPerformed
        // TODO add your handling code here:
        
        PdvScreen pdv = new PdvScreen();
        pdv.setVisible(true);
        
    }//GEN-LAST:event_pdvMenuActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void historySalesMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historySalesMenuActionPerformed
        // TODO add your handling code here:
        
        HistorySalesScreen history = new HistorySalesScreen();
        history.setVisible(true);
        
    }//GEN-LAST:event_historySalesMenuActionPerformed

    private void exitMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMenuMouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_exitMenuMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DashboardScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardScreen().setVisible(true);
            }
        });
    }

    public JMenuBar customizeJMenuBar(JMenuBar menuBar) {
        return new JMenuBar() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(28, 74, 137));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addAnimalMenu;
    private javax.swing.JMenuItem addCustomerMenu;
    private javax.swing.JMenuItem addEmployeeMenu;
    private javax.swing.JMenuItem addProductsMenu;
    private javax.swing.JMenuItem addSupplierMenu;
    private javax.swing.JMenuItem changeUserMenu;
    private javax.swing.JMenu customerMenu;
    private javax.swing.JMenu employeeMenu;
    private javax.swing.JMenu exitMenu;
    private javax.swing.JMenuItem historySalesMenu;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JDesktopPane painel_desktop;
    private javax.swing.JMenuItem pdvMenu;
    private javax.swing.JMenu productsMenu;
    private javax.swing.JMenu salesMenu;
    private javax.swing.JMenuItem searchAnimalMenu;
    private javax.swing.JMenuItem searchCustomerMenu;
    private javax.swing.JMenuItem searchEmployeeMenu;
    private javax.swing.JMenuItem searchProductMenu;
    private javax.swing.JMenuItem searchSupplierMenu;
    private javax.swing.JMenuItem searchVaccineMenu;
    private javax.swing.JMenu settingsMenu;
    private javax.swing.JMenuItem stockManagementMenu;
    private javax.swing.JMenu supplierMenu;
    private javax.swing.JMenuItem vaccineControllerMenu;
    private javax.swing.JMenu vaccineMenu;
    // End of variables declaration//GEN-END:variables
}
