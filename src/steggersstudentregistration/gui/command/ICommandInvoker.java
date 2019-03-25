/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steggersstudentregistration.gui.command;

import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import steggersstudentregistration.gui.view.main.MainViewController;

/**
 *
 * @author pgn
 */
public abstract class ICommandInvoker
{

    /**
     * List of commands that has been executed.
     */
    private final Stack<ICommand> executedCommands;

    /**
     * List of commands that was previously executed but has then been undone.
     */
    private final Stack<ICommand> undoneCommands;

    public ICommandInvoker()
    {
        executedCommands = new Stack<>();
        undoneCommands = new Stack<>();
    }

    /**
     * Submit a command for immediate execution and add it to the stack of
     * executed commands.
     *
     * @param command
     */
    public void submit(ICommand command) throws Exception
    {
        command.execute();
        executedCommands.add(command);
        undoneCommands.clear();
    }

    public void undo() throws Exception
    {
        ICommand cmd = executedCommands.pop();
        cmd.undo();
        undoneCommands.add(cmd);
    }

    public void redo() throws Exception
    {
        ICommand cmd = undoneCommands.pop();
        cmd.execute();
        executedCommands.add(cmd);
    }

}
