/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steggersstudentregistration.bll.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author pgn
 */
public class PasswordContainsSpecialChars extends AbstractValidation {

    @Override
    public boolean validateInput(String input) {
        Pattern p = Pattern.compile("[^A-Za-z0-9]");
        Matcher m = p.matcher(input);
        if (m.find()) {
            validationMessage = "";
            return true;
        } else {
            validationMessage = "Password must contain special characters";
            return false;
        }
    }

}
