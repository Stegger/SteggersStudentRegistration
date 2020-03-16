/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steggersstudentregistration.bll.validation;

/**
 * @author pgn
 */
public abstract class AbstractValidation implements IValidation {

    protected String validationMessage;

    public AbstractValidation() {
        validationMessage = "";
    }

    @Override
    public String getValidationMessage() {
        return validationMessage;
    }

}