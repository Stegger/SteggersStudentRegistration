/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steggersstudentregistration.gui.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import steggersstudentregistration.be.User;
import steggersstudentregistration.bll.facade.IStundentRegistrationFacade;

/**
 *
 * @author pgn
 */
public class UserModel
{

    private IStundentRegistrationFacade facade;

    private final ObjectProperty<User> loggedInUser = new SimpleObjectProperty<>();

    public User getLoggedInUser()
    {
        return loggedInUser.get();
    }

    public ObjectProperty loggedInUserProperty()
    {
        return loggedInUser;
    }

    public boolean logIn(String userName, String password)
    {
        User user = facade.logIn(userName, password);
        loggedInUser.set(user);
        return true;
    }

    public void setFacade(IStundentRegistrationFacade facade)
    {
        this.facade = facade;
    }

}