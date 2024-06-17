package br.com.pethub.utils;

import org.mindrot.jbcrypt.BCrypt;

/**
 * This class is responsible for encrypting passwords.
 * It uses the BCrypt fuction for password encryption.
 */
public class EncryptPassword {
    /**
     * This method is used to encrypt a password.
     * @param password The password to be encrypted.
     * @return The encrypted password.
     */
    public String encryptPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

}
