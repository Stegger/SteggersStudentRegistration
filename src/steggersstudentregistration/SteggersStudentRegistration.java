/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steggersstudentregistration;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import steggersstudentregistration.bll.facade.StudentRegistrationFacadeFactory;
import steggersstudentregistration.gui.view.main.MainViewController;

/**
 *
 * @author pgn
 */
public class SteggersStudentRegistration extends Application
{

    static
    {
        try
        {
            Class.forName("steggersstudentregistration.bll.facade.MockUserFacade");
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(SteggersStudentRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gui/view/main/MainView.fxml"));
        
        Parent root = loader.load();
        MainViewController controller = loader.getController();

        //Dependency injection
        //Call a factory method for an object implementing the facade: DONE
        //The actual implementation of a facade is now hidden! 
        controller.setStudentRegistrationFacade(StudentRegistrationFacadeFactory.instance().createFacade(StudentRegistrationFacadeFactory.StudentRegistrationFacadeTypes.MOCK));
        
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
