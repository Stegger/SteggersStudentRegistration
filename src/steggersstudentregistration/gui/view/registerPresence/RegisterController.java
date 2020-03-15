package steggersstudentregistration.gui.view.registerPresence;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import steggersstudentregistration.gui.command.ICommandInvoker;
import steggersstudentregistration.gui.model.PresenceModel;
import steggersstudentregistration.gui.model.UserModel;

public class RegisterController extends ICommandInvoker {

    @FXML
    public Button btnNotHere;
    @FXML
    public Button btnHere;
    @FXML
    public ListView lstLessons;
    private PresenceModel presenceModel;
    private UserModel userModel;

    public void handlePresence(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnHere) {
            //TODO Handle student IS presence
        } else if (actionEvent.getSource() == btnNotHere) {
            //TODO Handle student !IS presence
        }
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
        if (presenceModel == null)
            presenceModel = new PresenceModel(userModel.getStudentRegistrationFacade());
    }
}