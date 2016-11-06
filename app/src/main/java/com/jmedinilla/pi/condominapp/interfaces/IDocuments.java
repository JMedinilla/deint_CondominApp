package com.jmedinilla.pi.condominapp.interfaces;

/**
 * Interface created by JMedinilla on 2016-11-06
 */
public interface IDocuments {

    /**
     * Interface that implements the method for the view
     * The method recieves an error message for the View from the Presenter
     */
    interface View {
        void setDocumentsError(String message, int idView);
    }

    /**
     * Interface that implements the method for the presenter
     * The method validates the data in the components
     */
    interface Presenter {
        boolean validateDocuments(String do_title, String do_description, String do_link);
    }
}
