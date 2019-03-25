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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import steggersstudentregistration.be.Student;
import steggersstudentregistration.bll.facade.IStundentRegistrationFacade;
import steggersstudentregistration.gui.command.AddStudentCommand;
import steggersstudentregistration.gui.command.ICommandInvoker;
import steggersstudentregistration.gui.model.MainModel;

/**
 *
 * @author pgn
 */
public class MainViewController extends ICommandInvoker implements Initializable
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
        try
        {
            undo();
        } catch (Exception ex)
        {
            displayError(ex, "You could not undo the last action!", "It's irreversible!");
        }
    }

    @FXML
    private void handleRedo(ActionEvent event)
    {
        try
        {
            redo();
        } catch (Exception ex)
        {
            displayError(ex, "Could not redo action.", "Something that you previously could do can't be done again. Sucks...");
        }
    }

    @FXML
    private void handleAddStudent(ActionEvent event)
    {
        try
        {
            String studentName = txtStudent.getText().trim();
            AddStudentCommand addStudentCmd = new AddStudentCommand(mainModel, studentName);
            submit(addStudentCmd);
        } catch (Exception ex)
        {
            displayError(ex, "Could not add student", "An error occured while trying to add a student. Please try again.");
        }
    }

    /**
     * Displays errormessages to the user.
     *
     * @param ex The Exception
     */
    private void displayError(Exception ex, String title, String header)
    {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(ex.getMessage());
        alert.showAndWait();
    }

}