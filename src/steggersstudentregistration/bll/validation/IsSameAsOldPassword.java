package steggersstudentregistration.bll.validation;

public class IsSameAsOldPassword extends AbstractValidation {

    private final String oldPassword;

    public IsSameAsOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    @Override
    public boolean validateInput(String input) {
        if (input.equalsIgnoreCase(oldPassword)) {
            validationMessage = "New password is the same as the old one.";
            return false;
        }
        return true;
    }


}
