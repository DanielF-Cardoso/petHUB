package br.com.pethub.utils;

import org.mindrot.jbcrypt.BCrypt;

public class EncryptPassword {

    public String encryptPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

}
