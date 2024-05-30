/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pethub.utils;

/**
 *
 * @author danie
 */
import br.com.parg.viacep.*;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CEPUtils {
    public static void buscarCEP(JTextField cepField, JTextField addressField, JTextField districtField, JTextField cityField, JComboBox ufField) {
            ViaCEP viaCep = new ViaCEP();

            try {
                viaCep.buscar(cepField.getText());
                addressField.setText(viaCep.getLogradouro());
                districtField.setText(viaCep.getBairro());
                cityField.setText(viaCep.getLocalidade());
                ufField.setSelectedItem(viaCep.getUf());
            } catch (ViaCEPException ex) {
                JOptionPane.showMessageDialog(null, "CEP inválido", "Erro", JOptionPane.ERROR_MESSAGE);
                Toolkit.getDefaultToolkit().beep(); // Reproduz o som de erro do sistema
            }
    }
}