package com.jmedinilla.pi.condominapp.models;

import android.support.annotation.NonNull;

import java.sql.Blob;
import java.util.Comparator;
import java.util.Date;

/**
 * Class created by JMedinilla on 2016-10-29
 * <p>
 * BD incident
 */
public class Model_Incident implements Comparable<Model_Incident> {
    private int in_id;
    private Model_User in_user;
    private Date in_date;
    private String in_title;
    private String in_description;
    private Blob in_photo;

    public Model_Incident(int in_id, Model_User in_user, Date in_date,
                          String in_title, String in_description, Blob in_photo) {
        this.in_id = in_id;
        this.in_user = in_user;
        this.in_date = in_date;
        this.in_title = in_title;
        this.in_description = in_description;
        this.in_photo = in_photo;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        //The object can't be null
        if (obj != null) {
            //The object has to be an Incident
            if (obj instanceof Model_Incident) {
                Model_Incident another = (Model_Incident) obj;
                //If the Title is equal, it's the same incident
                if (this.in_title.toUpperCase().equals(another.in_title.toUpperCase())) {
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Incident: " + in_title + " (" + in_date.toString() + ")";
    }

    /**
     * Incident comparable method
     *
     * @param another Incident to compare
     * @return Wich one is higher
     */
    @Override
    public int compareTo(@NonNull Model_Incident another) {
        if (this.getIn_title().toUpperCase().compareTo(another.getIn_title().toUpperCase()) == 0) {
            if (this.getIn_date().compareTo(another.getIn_date()) == 0) {
                return this.getIn_description().toUpperCase().compareTo(another.getIn_description().toUpperCase());
            } else {
                return this.getIn_date().compareTo(another.getIn_date());
            }
        } else {
            return this.getIn_title().toUpperCase().compareTo(another.getIn_title().toUpperCase());
        }
    }

    /**
     * Incident getters and setters
     */
    //ID
    public int getIn_id() {
        return in_id;
    }

    public void setIn_id(int in_id) {
        this.in_id = in_id;
    }

    //USER
    public Model_User getIn_user() {
        return in_user;
    }

    public void setIn_user(Model_User in_user) {
        this.in_user = in_user;
    }

    //DATE
    public Date getIn_date() {
        return in_date;
    }

    public void setIn_date(Date in_date) {
        this.in_date = in_date;
    }

    //TITLE
    public String getIn_title() {
        return in_title;
    }

    public void setIn_title(String in_title) {
        this.in_title = in_title;
    }

    //DESCRIPTION
    public String getIn_description() {
        return in_description;
    }

    public void setIn_description(String in_description) {
        this.in_description = in_description;
    }

    //PHOTO
    public Blob getIn_photo() {
        return in_photo;
    }

    public void setIn_photo(Blob in_photo) {
        this.in_photo = in_photo;
    }

    /**
     * Entry comparators
     */
    //TITLE
    public static final Comparator<Model_Incident> COMPARATOR_INCIDENT_TITLE_ASC = new Comparator<Model_Incident>() {
        @Override
        public int compare(Model_Incident o1, Model_Incident o2) {
            return o1.getIn_title().toUpperCase().compareTo(o2.getIn_title().toUpperCase());
        }
    };
    public static final Comparator<Model_Incident> COMPARATOR_INCIDENT_TITLE_DES = new Comparator<Model_Incident>() {
        @Override
        public int compare(Model_Incident o1, Model_Incident o2) {
            return o2.getIn_title().toUpperCase().compareTo(o1.getIn_title().toUpperCase());
        }
    };
    //DATE
    public static final Comparator<Model_Incident> COMPARATOR_INCIDENT_DATE_ASC = new Comparator<Model_Incident>() {
        @Override
        public int compare(Model_Incident o1, Model_Incident o2) {
            return o1.getIn_date().compareTo(o2.getIn_date());
        }
    };
    public static final Comparator<Model_Incident> COMPARATOR_INCIDENT_DATE_DES = new Comparator<Model_Incident>() {
        @Override
        public int compare(Model_Incident o1, Model_Incident o2) {
            return o2.getIn_date().compareTo(o1.getIn_date());
        }
    };
}
