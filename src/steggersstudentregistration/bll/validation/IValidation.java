/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steggersstudentregistration.bll.validation;

/**
 * @author pgn
 */
public interface IValidation {

    boolean validateInput(String input);

    String getValidationMessage();

}
