/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steggersstudentregistration.bll.validation;

/**
 * @author pgn
 */
public class AndValidation extends AbstractValidation {

    private final IValidation a;
    private final IValidation b;

    public AndValidation(IValidation a, IValidation b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean validateInput(String input) {
        validationMessage = "";
        boolean isValid = true;
        if (!a.validateInput(input)) {
            validationMessage = a.getValidationMessage();
            isValid = false;
        }
        if (!b.validateInput(input)) {
            isValid = false;
            if (!validationMessage.isEmpty()) {
                validationMessage += System.getProperty("line.separator");
            }
            validationMessage += b.getValidationMessage();
        }
        return isValid;
    }

}
