/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steggersstudentregistration.bll.user;

import java.util.HashMap;

/**
 * @author pgn
 */
public class UserFacadeFactory {

    /**
     * The Sinlgeton static variable.
     */
    private static UserFacadeFactory INSTANCE;
    /**
     * Map of registered facades.
     */
    private final HashMap<UserFacadeTypes, IUserFacade> REGISTERED_FACADES;

    /**
     * Private constructor.
     */
    private UserFacadeFactory() {
        REGISTERED_FACADES = new HashMap();
        REGISTERED_FACADES.put(UserFacadeTypes.MOCK, new MockUserManager());
        REGISTERED_FACADES.put(UserFacadeTypes.PRODUCTION, new UserManager());
    }

    /**
     * Singleton getter method.
     *
     * @return The singleton instance of the factory.
     */
    public static synchronized UserFacadeFactory instance() {
        if (INSTANCE == null) {
            INSTANCE = new UserFacadeFactory();
        }
        return INSTANCE;
    }

    /**
     * Register a facade for the factory.
     *
     * @param type The type of the facade
     * @param facade The facade instance.
     */
    public void registerFacade(UserFacadeTypes type, IUserFacade facade) {
        REGISTERED_FACADES.put(type, facade);
    }

    /**
     * Creates/gets a registered facade.
     *
     * @param type The type of facade you want.
     * @return The facade object
     */
    public IUserFacade getFacade(UserFacadeTypes type) {
        return REGISTERED_FACADES.get(type);
    }

    /**
     * The types of facades to support.
     */
    public enum UserFacadeTypes {
        MOCK, PRODUCTION
    }

}