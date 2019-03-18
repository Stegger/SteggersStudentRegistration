/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steggersstudentregistration.gui.view.main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import steggersstudentregistration.bll.facade.IStundentRegistrationFacade;
import steggersstudentregistration.gui.model.MainModel;

/**
 *
 * @author pgn
 */
public class MainViewController implements Initializable
{

    @FXML
    private Label label;

    private IStundentRegistrationFacade facade;
    private MainModel mainModel;

    public void setStudentRegistrationFacade(IStundentRegistrationFacade facade)
    {
        this.facade = facade;
        if (mainModel == null)
        {
            mainModel = new MainModel();
        }
        mainModel.setStudentRegistrationFacade(facade);
    }

    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }

}
