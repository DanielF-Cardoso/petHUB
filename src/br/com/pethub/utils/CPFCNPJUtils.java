/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pethub.utils;

/**
 *
 * @author danie
 */
public class CPFCNPJUtils {

    public boolean isCPFValid(String cpf) {
        if (cpf == null || cpf.length() != 11 || cpf.chars().allMatch(x -> x == cpf.charAt(0))) {
            return false;
        }

        String digits = cpf.substring(0, 9);
        String verifiers = cpf.substring(9);

        return verifiers.equals(getVerificationDigits(digits));
    }

    private String getVerificationDigits(String digits) {
        int firstDigit = getVerificationDigit(digits, 10);
        int secondDigit = getVerificationDigit(digits + firstDigit, 11);

        return String.valueOf(firstDigit) + secondDigit;
    }

    private int getVerificationDigit(String digits, int weight) {
        int sum = 0;
        for (int i = 0; i < digits.length(); i++) {
            sum += Integer.parseInt(digits.substring(i, i + 1)) * weight--;
        }

        int remainder = sum % 11;
        return (remainder < 2) ? 0 : 11 - remainder;
    }

    public boolean isCNPJValid(String cnpj) {
        if (cnpj == null || cnpj.length() != 14 || cnpj.chars().allMatch(x -> x == cnpj.charAt(0))) {
            return false;
        }

        String digits = cnpj.substring(0, 12);
        String verifiers = cnpj.substring(12);

        return verifiers.equals(getVerificationDigitsCNPJ(digits));
    }

    private String getVerificationDigitsCNPJ(String digits) {
        int firstDigit = getVerificationDigitCNPJ(digits, 5);
        int secondDigit = getVerificationDigitCNPJ(digits + firstDigit, 6);

        return String.valueOf(firstDigit) + secondDigit;
    }

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
