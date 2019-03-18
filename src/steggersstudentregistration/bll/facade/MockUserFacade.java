/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steggersstudentregistration.bll.facade;

/**
 *
 * @author pgn
 */
public class MockUserFacade implements IStundentRegistrationFacade
{

    private static IStundentRegistrationFacade INSTANCE;

    private MockUserFacade()
    {
        //Does nothing.
    }

    public static synchronized IStundentRegistrationFacade getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new MockUserFacade();
        }
        return INSTANCE;
    }

}
