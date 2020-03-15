package steggersstudentregistration.gui.model;

import steggersstudentregistration.bll.facade.IStudentRegistrationFacade;

public abstract class BaseModel {

    protected IStudentRegistrationFacade facade;

    public BaseModel(IStudentRegistrationFacade facade) {
        this.facade = facade;
    }

    public IStudentRegistrationFacade getStudentRegistrationFacade() {
        return facade;
    }

}
