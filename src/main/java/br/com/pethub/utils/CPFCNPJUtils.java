/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pethub.utils;

/**
 *
 * @author Daniel Fernandes
 */

/**
 * This class provides utility methods for validating CPF and CNPJ numbers.
 * CPF (Cadastro de Pessoas Físicas) is the Brazilian individual taxpayer registry identification.
 * CNPJ (Cadastro Nacional da Pessoa Jurídica) is the Brazilian national registry of legal entities.
 */
public class CPFCNPJUtils {

    /**
     * This method validates a CPF number.
     * @param cpf The CPF number to be validated.
     * @return true if the CPF number is valid, false otherwise.
     */
    public boolean isCPFValid(String cpf) {
        if (cpf == null || cpf.length() != 11 || cpf.chars().allMatch(x -> x == cpf.charAt(0))) {
            return false;
        }

        String digits = cpf.substring(0, 9);
        String verifiers = cpf.substring(9);

        return verifiers.equals(getVerificationDigits(digits));
    }

    /**
     * This method calculates the verification digits for a CPF number.
     * @param digits The digits of the CPF number.
     * @return The verification digits.
     */
    private String getVerificationDigits(String digits) {
        int firstDigit = getVerificationDigit(digits, 10);
        int secondDigit = getVerificationDigit(digits + firstDigit, 11);

        return String.valueOf(firstDigit) + secondDigit;
    }

    /**
     * This method calculates a verification digit.
     * @param digits The digits for which the verification digit is to be calculated.
     * @param weight The weight to be used in the calculation.
     * @return The verification digit.
     */
    private int getVerificationDigit(String digits, int weight) {
        int sum = 0;
        for (int i = 0; i < digits.length(); i++) {
            sum += Integer.parseInt(digits.substring(i, i + 1)) * weight--;
        }

        int remainder = sum % 11;
        return (remainder < 2) ? 0 : 11 - remainder;
    }

    /**
     * This method validates a CNPJ number.
     * @param cnpj The CNPJ number to be validated.
     * @return true if the CNPJ number is valid, false otherwise.
     */
    public boolean isCNPJValid(String cnpj) {
        if (cnpj == null || cnpj.length() != 14 || cnpj.chars().allMatch(x -> x == cnpj.charAt(0))) {
            return false;
        }

        String digits = cnpj.substring(0, 12);
        String verifiers = cnpj.substring(12);

        return verifiers.equals(getVerificationDigitsCNPJ(digits));
    }

    /**
     * This method calculates the verification digits for a CNPJ number.
     * @param digits The digits of the CNPJ number.
     * @return The verification digits.
     */
    private String getVerificationDigitsCNPJ(String digits) {
        int firstDigit = getVerificationDigitCNPJ(digits, 5);
        int secondDigit = getVerificationDigitCNPJ(digits + firstDigit, 6);

        return String.valueOf(firstDigit) + secondDigit;
    }

    /**
     * This method calculates a verification digit for a CNPJ number.
     * @param digits The digits for which the verification digit is to be calculated.
     * @param weight The weight to be used in the calculation.
     * @return The verification digit.
     */
    private int getVerificationDigitCNPJ(String digits, int weight) {
        int sum = 0;
        for (int i = 0; i < digits.length(); i++) {
            sum += Integer.parseInt(digits.substring(i, i + 1)) * weight--;
            if (weight < 2) {
                weight = 9;
            }
        }

        int remainder = sum % 11;
        return (remainder < 2) ? 0 : 11 - remainder;
    }

}
