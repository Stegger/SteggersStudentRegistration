/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steggersstudentregistration.gui.view.main;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import steggersstudentregistration.be.Student;
import steggersstudentregistration.bll.facade.IStundentRegistrationFacade;
import steggersstudentregistration.gui.command.ICommand;
import steggersstudentregistration.gui.model.MainModel;

/**
 *
 * @author pgn
 */
public class MainViewController implements Initializable
{

    /**
     * The facade exposing the functionality of the BLL but hides it's
     * complexity.
     */
    private IStundentRegistrationFacade facade;

    /**
     * The model holding the state for this controller.
     */
    private MainModel mainModel;

    /**
     * List of commands that has been executed.
     */
    private List<ICommand> executedCommands;

    /**
     * List of commands that was previously executed but has then been undone.
     */
    private List<ICommand> undoneCommands;

    @FXML
    private MenuItem menuClose;
    @FXML
    private MenuItem menuUndo;
    @FXML
    private MenuItem menuRedo;
    @FXML
    private ListView<Student> lstStudents;
    @FXML
    private TextField txtStudent;

    /**
     * Constructs the Main View Controller.
     */
    public MainViewController()
    {
        executedCommands = new LinkedList<>();
        undoneCommands = new LinkedList<>();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        mainModel = new MainModel();
        lstStudents.setItems(mainModel.getStudents());
    }

    /**
     * Dependency injection method for the facade create at startup.
     *
     * @param facade
     */
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
    private void handleUndo(ActionEvent event)
    {
        
    }

    @FXML
    private void handleRedo(ActionEvent event)
    {
        
    }

    public void submitCommand(ICommand command)
    {
        
    }

    @FXML
    private void handleAddStudent(ActionEvent event)
    {
        String studentName = txtStudent.getText().trim();
    }

}
