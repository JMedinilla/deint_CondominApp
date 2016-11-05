package com.jmedinilla.pi.condominapp.models;

import android.support.annotation.NonNull;

import java.util.Comparator;
import java.util.Date;

/**
 * Class created by JMedinilla on 2016-10-29
 * <p>
 * BD note for the community diary
 */
public class Model_Note implements Comparable<Model_Note> {
    private int no_id;
    private int no_community;
    private Date no_date;
    private String no_title;
    private String no_content;

    public Model_Note(int no_id, int no_community, Date no_date,
                      String no_title, String no_content) {
        this.no_id = no_id;
        this.no_community = no_community;
        this.no_date = no_date;
        this.no_title = no_title;
        this.no_content = no_content;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        //The object can't be null
        if (obj != null) {
            //The object has to be a Note
            if (obj instanceof Model_Note) {
                Model_Note another = (Model_Note) obj;
                //If the Date and Title are equals, it's the same note
                if (this.getNo_date().equals(another.getNo_date())
                        && this.getNo_title().toUpperCase().equals(another.getNo_title().toUpperCase())) {
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Note: " + no_title + " (" + no_date.toString() + ")";
    }

    /**
     * Note comparable method
     *
     * @param another Note to compare
     * @return Wich one is higher
     */
    @Override
    public int compareTo(@NonNull Model_Note another) {
        return this.getNo_title().toUpperCase().compareTo(another.getNo_title().toUpperCase());
    }

    /**
     * Note getters and setters
     */
    //ID
    public int getNo_id() {
        return no_id;
    }

    public void setNo_id(int no_id) {
        this.no_id = no_id;
    }

    //COMMUNITY
    public int getNo_community() {
        return no_community;
    }

    public void setNo_community(int no_community) {
        this.no_community = no_community;
    }

    //DATE
    public Date getNo_date() {
        return no_date;
    }

    public void setNo_date(Date no_date) {
        this.no_date = no_date;
    }

    //TITLE
    public String getNo_title() {
        return no_title;
    }

    public void setNo_title(String no_title) {
        this.no_title = no_title;
    }

    //CONTENT
    public String getNo_content() {
        return no_content;
    }

    public void setNo_content(String no_content) {
        this.no_content = no_content;
    }

    /**
     * Note comparators
     */
    //DATE
    public static final Comparator<Model_Note> COMPARATOR_NOTE_DATE_ASC = new Comparator<Model_Note>() {
        @Override
        public int compare(Model_Note o1, Model_Note o2) {
            return o1.getNo_date().compareTo(o2.getNo_date());
        }
    };
    public static final Comparator<Model_Note> COMPARATOR_NOTE_DATE_DES = new Comparator<Model_Note>() {
        @Override
        public int compare(Model_Note o1, Model_Note o2) {
            return o2.getNo_date().compareTo(o1.getNo_date());
        }
    };
    //TITLE
    public static final Comparator<Model_Note> COMPARATOR_NOTE_TITLE_ASC = new Comparator<Model_Note>() {
        @Override
        public int compare(Model_Note o1, Model_Note o2) {
            return o1.getNo_title().toUpperCase().compareTo(o2.getNo_title().toUpperCase());
        }
    };
    public static final Comparator<Model_Note> COMPARATOR_NOTE_TITLE_DES = new Comparator<Model_Note>() {
        @Override
        public int compare(Model_Note o1, Model_Note o2) {
            return o2.getNo_title().toUpperCase().compareTo(o1.getNo_title().toUpperCase());
        }
    };
}
