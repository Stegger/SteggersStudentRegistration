/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steggersstudentregistration.bll.facade;

import java.util.HashMap;

/**
 *
 * @author pgn
 */
public class StudentRegistrationFacadeFactory
{

    /**
     * The types of facades to support.
     */
    public enum StudentRegistrationFacadeTypes
    {
        MOCK, PRODUCTION;
    }

    /**
     * The Sinlgeton static variable.
     */
    private static StudentRegistrationFacadeFactory INSTANCE;

    /**
     * Map of registered facades.
     */
    private final HashMap<StudentRegistrationFacadeTypes, IStundentRegistrationFacade> REGISTERED_FACADES = new HashMap();

    /**
     * Singleton getter method.
     *
     * @return The singleton instance of the factory.
     */
    public static synchronized StudentRegistrationFacadeFactory instance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new StudentRegistrationFacadeFactory();
        }
        return INSTANCE;
    }

    /**
     * Private constructor.
     */
    private StudentRegistrationFacadeFactory()
    {
        
    }

    /**
     * Register a facade for the factory.
     *
     * @param type The type of the facade
     * @param facade The facade instance.
     */
    public void registerFacade(StudentRegistrationFacadeTypes type, IStundentRegistrationFacade facade)
    {
        REGISTERED_FACADES.put(type, facade);
    }

    /**
     * Creates/gets a registered facade.
     *
     * @param type The type of facade you want.
     * @return The facade object
     */
    public IStundentRegistrationFacade createFacade(StudentRegistrationFacadeTypes type)
    {
        return REGISTERED_FACADES.get(type);
    }

}
