/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steggersstudentregistration.gui.model;

import steggersstudentregistration.bll.facade.IStundentRegistrationFacade;
import steggersstudentregistration.gui.command.ICommandInvoker;

/**
 *
 * @author pgn
 */
public class AbsenceModel
{
    private IStundentRegistrationFacade facade;
    
    public AbsenceModel(IStundentRegistrationFacade facade)
    {
        this.facade = facade;
    }
    
    
    
}
