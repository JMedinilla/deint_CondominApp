package com.jmedinilla.pi.condominapp.interfaces;

import java.util.Date;

/**
 * Interface created by JMedinilla on 2016-11-06
 */
public interface IDiary {

    /**
     * Interface that implements the method for the view
     * The method recieves an error message for the View from the Presenter
     */
    interface View {
        void setDiaryError(String message, int idView);
    }

    /**
     * Interface that implements the method for the presenter
     * The method validates the data in the components
     */
    interface Presenter {
        boolean validateDiary(Date no_date, String no_title, String no_content);
    }
}
