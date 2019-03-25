/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steggersstudentregistration.gui.login;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import steggersstudentregistration.gui.command.ICommandInvoker;

/**
 * FXML Controller class
 *
 * @author pgn
 */
public class LoginController extends ICommandInvoker implements Initializable
{

    @FXML
    private TextField txtUserName;
    @FXML
    private CheckBox checkRememberMe;
    @FXML
    private PasswordField txtPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    

    @FXML
    private void handleLogIn(ActionEvent event)
    {
    }

    @FXML
    private void handleQuit(ActionEvent event)
    {
    }

    @FXML
    private void handleRememberMe(ActionEvent event)
    {
    }
    
}
