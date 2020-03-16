/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steggersstudentregistration.bll.validation;


/**
 * @author pgn
 */
public class ValidationFactory {

    /**
     * Enum representing the different kinds of Validators this factory can create.
     */
    public enum ValidationTypes {
        EMAIL, PASSWORD, USER_NAME
    }

    /**
     * Creates an input validation that matches the given input.
     *
     * @param type The type of input to validate.
     * @return A validation object to validate the given type of input.
     * @throws Exception
     */
    public static IValidation CreateInputValidation(ValidationTypes type) throws Exception {
        switch (type) {
            case EMAIL:
                return new EmailValidation();
            case PASSWORD:
                return CreateAndInputValidation(new InputLengthValidation(InputLengthValidation.MINIMUM_PASSWORD_LENGTH, true), new PasswordContainsSpecialChars(), new PasswordNotTopTenValidation());
            case USER_NAME:
                return CreateAndInputValidation(new InputLengthValidation(InputLengthValidation.MAXIMUM_USER_NAME_LENGTH, false), new UserNameValidation());
            default:
                throw new Exception("Unknown validation type submitted to ValidationFactory");
        }
    }

    /**
     * Creates an InputValidation that checks multiple validations in one.
     *
     * @param validations A multiple length parameter of input validation
     *                    validations.
     * @return A validation object to validate a given input type for multiple
     * conditions.
     * @throws Exception
     */
    public static IValidation CreateAndInputValidation(IValidation... validations) throws Exception {
        if (validations.length == 1) {
            return validations[0];
        }
        if (validations.length == 2) {
            return new AndValidation(validations[0], validations[1]);
        }
        if (validations.length > 2) {
            IValidation valid = new AndValidation(validations[0], validations[1]);
            for (int i = 2; i < validations.length; i++) {
                valid = new AndValidation(validations[i], valid);
            }
            return valid;
        }
        throw new Exception("Can't create Validations without any IValidation's. Method CreateAndInputValidation requires at least one IValidation");
    }


}
