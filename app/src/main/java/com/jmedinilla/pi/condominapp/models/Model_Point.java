package com.jmedinilla.pi.condominapp.models;

import java.util.Comparator;
import java.util.UUID;

/**
 * Class created by JMedinilla on 2016-10-29
 * <p>
 * BD point of a meeting
 */
public class Model_Point {
    private String po_id;
    private int po_meeting;
    private String po_title;
    private String po_content;

    public Model_Point(int po_meeting, String po_title, String po_content) {
        this.po_id = UUID.randomUUID().toString();
        this.po_meeting = po_meeting;
        this.po_title = po_title;
        this.po_content = po_content;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        //The object can't be null
        if (obj != null) {
            //The object has to be a Meeting
            if (obj instanceof Model_Point) {
                Model_Point another = (Model_Point) obj;
                //If the Title is equal, it's the same point
                if (this.po_title.toUpperCase().equals(another.po_title.toUpperCase())) {
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Point: " + po_title;
    }

    /**
     * Point getters and setters
     */
    //ID
    public String getPo_id() {
        return po_id;
    }

    public void setPo_id(String po_id) {
        this.po_id = po_id;
    }

    //MEETING
    public int getPo_meeting() {
        return po_meeting;
    }

    public void setPo_meeting(int po_meeting) {
        this.po_meeting = po_meeting;
    }

    //TITLE
    public String getPo_title() {
        return po_title;
    }

    public void setPo_title(String po_title) {
        this.po_title = po_title;
    }

    //CONTENT
    public String getPo_content() {
        return po_content;
    }

    public void setPo_content(String po_content) {
        this.po_content = po_content;
    }

    /**
     * Point comparators
     */
    //TITLE
    public static final Comparator<Model_Point> COMPARATOR_POINT_TITLE_ASC = new Comparator<Model_Point>() {
        @Override
        public int compare(Model_Point o1, Model_Point o2) {
            return o1.getPo_title().toUpperCase().compareTo(o2.getPo_title().toUpperCase());
        }
    };
    public static final Comparator<Model_Point> COMPARATOR_POINT_TITLE_DES = new Comparator<Model_Point>() {
        @Override
        public int compare(Model_Point o1, Model_Point o2) {
            return o2.getPo_title().toUpperCase().compareTo(o1.getPo_title().toUpperCase());
        }
    };
}
