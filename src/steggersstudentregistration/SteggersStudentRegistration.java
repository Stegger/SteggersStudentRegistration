/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steggersstudentregistration;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import steggersstudentregistration.bll.facade.StudentRegistrationFacadeImpl;
import steggersstudentregistration.bll.user.UserFacadeFactory;
import steggersstudentregistration.gui.model.UserModel;
import steggersstudentregistration.gui.view.login.LoginController;

/**
 *
 * @author pgn
 */
public class SteggersStudentRegistration extends Application
{

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gui/view/login/LoginView.fxml"));

        Parent root = loader.load();
        LoginController controller = loader.getController();

        //Dependency injection
        //Call a factory method for an object implementing the facade: DONE
        //The actual implementation of a facade is now hidden!
        StudentRegistrationFacadeImpl facade = new StudentRegistrationFacadeImpl(UserFacadeFactory.instance().getFacade(UserFacadeFactory.UserFacadeTypes.MOCK));
        UserModel userModel = new UserModel(facade);
        controller.setUserModel(userModel);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

}
