package com.jmedinilla.pi.condominapp.interfaces;

/**
 * Interface created by JMedinilla on 2016-10-29
 */
public interface ILogin {

    /**
     * Interface that implements the method for the view
     * The method recieves an error message for the View from the Presenter
     */
    interface View {
        void setLoginError(String message, int idView);
    }

    /**
     * Interface that implements the method for the presenter
     * The method validates the data in the components
     */
    interface Presenter {
        boolean validateLogin(String key);
    }
}
