/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steggersstudentregistration.gui.view.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import steggersstudentregistration.be.User;
import steggersstudentregistration.gui.command.ICommandInvoker;
import steggersstudentregistration.gui.model.MainModel;
import steggersstudentregistration.gui.model.UserModel;
import steggersstudentregistration.gui.utillities.SceneSwitcher;
import steggersstudentregistration.gui.view.registerPresence.RegisterController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author pgn
 */
public class MainViewController extends ICommandInvoker implements Initializable {

    /**
     * The model holding the state for this controller.
     */
    private MainModel mainModel;

    @FXML
    public BorderPane mainBorderPane;
    /**
     * The user model that holds the currently logged in user.
     */
    private UserModel userModel;
    @FXML
    private MenuItem menuClose;
    @FXML
    private MenuItem menuUndo;
    @FXML
    private MenuItem menuRedo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void handleUndo(ActionEvent event) {
        try {
            undo();
        } catch (Exception ex) {
            displayError(ex, "You could not undo the last action!", "It's irreversible!");
        }
    }

    @FXML
    private void handleRedo(ActionEvent event) {
        try {
            redo();
        } catch (Exception ex) {
            displayError(ex, "Could not redo action.", "Something that you previously could do can't be done again. Sucks...");
        }
    }

    /**
     * Displays errormessages to the user.
     *
     * @param ex The Exception
     */
    private void displayError(Exception ex, String title, String header) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(ex.getMessage());
        alert.showAndWait();
    }

    public void setUserModel(UserModel userModel) throws IOException {
        this.userModel = userModel;
        if (mainModel == null) {
            mainModel = new MainModel(userModel.getStudentRegistrationFacade());
        }
        if (this.userModel.getLoggedInUser().getRole() == User.Role.Teacher) {
            //TODO Inject Teacher view
        } else if (this.userModel.getLoggedInUser().getRole() == User.Role.Student) {
            SceneSwitcher ss = new SceneSwitcher();
            SceneSwitcher.SceneControllerBag scb = ss.getSceneControllerBag("/steggersstudentregistration/gui/view/registerPresence/RegisterView.fxml");
            mainBorderPane.centerProperty().set(scb.getRoot());
            RegisterController registerController = (RegisterController) scb.getController();
            registerController.setUserModel(userModel);
        }
    }

}