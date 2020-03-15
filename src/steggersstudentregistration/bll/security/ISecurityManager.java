package steggersstudentregistration.bll.security;

public interface ISecurityManager {

    String hashPassword(String password) throws SecurityException;

}
