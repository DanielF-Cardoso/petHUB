/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pethub.utils;

/**
 *
 * @author Daniel Fernandes
 */
import br.com.parg.viacep.*;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * This class provides a utility method to fetch and fill address details based on a given CEP (Postal Code in Brazil).
 * It uses the ViaCEP service to fetch the address details.
 */
public class CEPUtils {

    /**
     * This method fetches the address details for a given CEP and fills the details in the provided fields.
     * @param cepField The text field containing the CEP.
     * @param addressField The text field to be filled with the fetched address.
     * @param districtField The text field to be filled with the fetched district.
     * @param cityField The text field to be filled with the fetched city.
     * @param ufField The combo box to be filled with the fetched state.
     */
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
                Toolkit.getDefaultToolkit().beep();
            }
    }
}