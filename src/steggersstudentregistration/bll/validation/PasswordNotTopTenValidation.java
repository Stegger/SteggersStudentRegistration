/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steggersstudentregistration.bll.validation;

/**
 * @author pgn
 */
public class PasswordNotTopTenValidation extends AbstractValidation {

    private static final String[] TOP_25_USED_PASSWORDS =
            {
                    "123456",
                    "123456789",
                    "qwerty",
                    "12345678",
                    "111111",
                    "1234567890",
                    "1234567",
                    "password",
                    "123123",
                    "987654321",
                    "qwertyuiop",
                    "mynoob",
                    "123321",
                    "666666",
                    "18atcskd2w",
                    "7777777",
                    "1q2w3e4r",
                    "654321",
                    "555555",
                    "3rjs1la7qe",
                    "google",
                    "1q2w3e4r5t",
                    "123qwe",
                    "zxcvbnm",
                    "1q2w3e"
            };

    @Override
    public boolean validateInput(String input) {
        for (String password : TOP_25_USED_PASSWORDS) {
            if (input.equalsIgnoreCase(password.trim())) {
                validationMessage = "The password is among the 25 most common passwords!";
                return false;
            }
        }
        validationMessage = "";
        return true;
    }

}
