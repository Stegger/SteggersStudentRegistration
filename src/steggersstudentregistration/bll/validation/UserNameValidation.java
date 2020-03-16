/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steggersstudentregistration.bll.validation;

/**
 * @author pgn
 */
public class UserNameValidation extends AbstractValidation {

    private final String[] BAD_USER_NAME_PARTIALS =
            {
                    "corona", "virus"
            };

    @Override
    public boolean validateInput(String input) {
        boolean isValid = true;
        isValid = !input.isEmpty();
        int c = 0;
        while (isValid && c < BAD_USER_NAME_PARTIALS.length) {
            isValid = !input.toLowerCase().contains(BAD_USER_NAME_PARTIALS[c++].toLowerCase());
        }
        validationMessage = isValid ? "" : "User name is not valid";
        return isValid;
    }

}
