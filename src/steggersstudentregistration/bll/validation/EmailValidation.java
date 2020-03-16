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
public class EmailValidation extends AbstractValidation {

    @Override
    public boolean validateInput(String input) {
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            validationMessage = "";
            return true;
        } else {
            validationMessage = "Email is invalid";
            return false;
        }
    }

}