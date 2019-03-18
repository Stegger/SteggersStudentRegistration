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
import steggersstudentregistration.bll.facade.MockUserFacade;
import steggersstudentregistration.gui.view.main.MainViewController;

/**
 *
 * @author pgn
 */
public class SteggersStudentRegistration extends Application
{
    
    @Override
    public void start(Stage stage) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/main/MainView.fxml"));
        
        
        Parent root = loader.load();
        MainViewController controller = loader.getController();
        
        //Dependency injection
        controller.setStudentRegistrationFacade(MockUserFacade.getInstance());
        
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
