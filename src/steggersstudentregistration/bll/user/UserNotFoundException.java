package steggersstudentregistration.bll.user;

public class UserNotFoundException extends RuntimeException {

    UserNotFoundException(String message) {
        super(message);
    }

}