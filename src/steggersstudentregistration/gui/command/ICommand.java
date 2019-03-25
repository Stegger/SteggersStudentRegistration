/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steggersstudentregistration.gui.command;

/**
 *
 * @author pgn
 */
public interface ICommand
{
    void execute() throws Exception;
    
    void undo() throws Exception;
}
