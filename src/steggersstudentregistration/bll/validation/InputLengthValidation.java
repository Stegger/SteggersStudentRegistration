/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steggersstudentregistration.bll.validation;

/**
 * @author pgn
 */
public class InputLengthValidation extends AbstractValidation {

    public static final int MINIMUM_PASSWORD_LENGTH = 8;
    public static final int MAXIMUM_USER_NAME_LENGTH = 50;

    private final int length;
    private final boolean isMinimum;
    private final String minOrAtLeast;

    public InputLengthValidation(int length, boolean isMinimum) {
        this.isMinimum = isMinimum;
        this.length = length;
        this.minOrAtLeast = isMinimum ? "minimum" : "at least";
    }

    @Override
    public boolean validateInput(String input) {
        if ((isMinimum && (input.length() < length)) ^ (!isMinimum && (input.length() > length))) {
            validationMessage = "Password must be " + minOrAtLeast + " " + length + " chars long.";
            return false;
        } else {
            validationMessage = "";
            return true;
        }
    }

}