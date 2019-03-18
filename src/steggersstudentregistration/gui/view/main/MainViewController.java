/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steggersstudentregistration.gui.view.main;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.Stack;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import steggersstudentregistration.be.Student;
import steggersstudentregistration.bll.facade.IStundentRegistrationFacade;
import steggersstudentregistration.gui.command.AddStudentCommand;
import steggersstudentregistration.gui.command.ICommand;
import steggersstudentregistration.gui.command.ICommandInvoker;
import steggersstudentregistration.gui.model.AbsenceModel;
import steggersstudentregistration.gui.model.MainModel;

/**
 *
 * @author pgn
 */
public class MainViewController implements Initializable, ICommandInvoker
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
    private Stack<ICommand> executedCommands;

    /**
     * List of commands that was previously executed but has then been undone.
     */
    private Stack<ICommand> undoneCommands;

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
        executedCommands = new Stack<ICommand>();
        undoneCommands = new Stack<ICommand>();
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
        
        AbsenceModel absenceModel = new AbsenceModel(facade)
        
    }

    @FXML
    private void handleUndo(ActionEvent event)
    {
        ICommand cmd = executedCommands.pop();
        cmd.undo();
        undoneCommands.add(cmd);
    }

    @FXML
    private void handleRedo(ActionEvent event)
    {
        ICommand cmd = undoneCommands.pop();
        cmd.execute();
        executedCommands.add(cmd);
    }

    @Override
    public void submit(ICommand command)
    {
        command.execute();
        executedCommands.add(command);
        undoneCommands.clear();
    }

    @FXML
    private void handleAddStudent(ActionEvent event)
    {
        String studentName = txtStudent.getText().trim();
        AddStudentCommand addStudentCmd = new AddStudentCommand(mainModel, studentName);
        submit(addStudentCmd);
    }

}
