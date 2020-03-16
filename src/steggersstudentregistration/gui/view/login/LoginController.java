/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steggersstudentregistration.gui.view.login;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import steggersstudentregistration.gui.command.ICommandInvoker;
import steggersstudentregistration.gui.model.UserModel;
import steggersstudentregistration.gui.utillities.SceneSwitcher;
import steggersstudentregistration.gui.view.createUser.CreateUserController;
import steggersstudentregistration.gui.view.main.MainViewController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author pgn
 */
public class LoginController extends ICommandInvoker implements Initializable {

    @FXML
    private TextField txtUserName;
    @FXML
    private CheckBox checkRememberMe;
    @FXML
    private PasswordField txtPassword;

    private UserModel userModel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void handleLogIn(ActionEvent event) throws IOException {
        String userName = txtUserName.getText().trim();
        String password = txtPassword.getText();
        if (userModel.logIn(userName, password)) {
            SceneSwitcher ss = new SceneSwitcher();
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            MainViewController mainController = ss.putSceneInStageNGetController("/steggersstudentregistration/gui/view/main/MainView.fxml", stage);
            mainController.setUserModel(this.userModel);
        }
    }

    @FXML
    private void handleQuit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void handleRememberMe(ActionEvent event) {
        //TODO Store credentials to a file.
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    @FXML
    public void handleNewUser(ActionEvent event) throws IOException {
        SceneSwitcher ss = new SceneSwitcher();
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        CreateUserController createUserController = ss.putSceneInStageNGetController("/steggersstudentregistration/gui/view/createUser/CreateUserView.fxml", stage);
        createUserController.setUserModel(this.userModel);
    }
}
