package steggersstudentregistration.gui.view.createUser;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import steggersstudentregistration.bll.validation.IValidation;
import steggersstudentregistration.bll.validation.ValidationFactory;
import steggersstudentregistration.gui.model.UserModel;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateUserController implements Initializable {


    @FXML
    public TextField txtUserName;
    @FXML
    public TextField txtEmail;
    @FXML
    public PasswordField txtPassword;
    @FXML
    public Label lblUsernameErr;
    @FXML
    public Label lblEmailErr;
    @FXML
    public Label lblPasswordErr;

    private UserModel userModel;

    private IValidation emailValidator;
    private IValidation userNameValidator;
    private IValidation passwordValidator;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            emailValidator = ValidationFactory.CreateInputValidation(ValidationFactory.ValidationTypes.EMAIL);
            passwordValidator = ValidationFactory.CreateInputValidation(ValidationFactory.ValidationTypes.PASSWORD);


            //TODO Bind validators to fields
            bindValidation(txtEmail, lblEmailErr, emailValidator);
            bindValidation(txtPassword, lblPasswordErr, passwordValidator);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void bindValidation(TextField txtField, Label errorMsg, IValidation validation) {
        txtField.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!validation.validateInput(newValue)) {
                    errorMsg.textProperty().setValue(validation.getValidationMessage());
                } else {
                    errorMsg.textProperty().setValue("");
                }
            }

        });
    }

    @FXML
    public void handleCreateUser(ActionEvent actionEvent) {
        //TODO Do final validation before submitting new user to model
    }

    @FXML
    public void handleQuit(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}