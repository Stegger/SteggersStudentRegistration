/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steggersstudentregistration.gui.command;

import steggersstudentregistration.be.Student;
import steggersstudentregistration.gui.model.MainModel;

/**
 *
 * @author pgn
 */
public class AddStudentCommand implements ICommand
{

    private final MainModel mainModel;
    private final String name;
    private Student student;

    public AddStudentCommand(MainModel mainModel, String name)
    {
        this.mainModel = mainModel;
        this.name = name;
    }
    
    @Override
    public void execute()
    {
        student = mainModel.addStudent(name);
    }

    @Override
    public void undo()
    {
        mainModel.removeStudent(student);
    }
    
}
