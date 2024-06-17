/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pethub.utils;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Daniel Fernandes
 */

/**
 * This class provides a utility method to clean the text fields in a given set of containers.
 */
public class CleanFields {
    /**
     * This method cleans all the text fields in the given containers.
     * It sets the text of each text field to null.
     * @param containers The containers whose text fields are to be cleaned.
     */
        public void cleanFields(JPanel... containers) {
        for (JPanel container : containers) {
            Component components[] = container.getComponents();
            for (Component component : components) {
                if (component instanceof JTextField) {
                    ((JTextField) component).setText(null);
                }
            }
        }
    }
    
}
