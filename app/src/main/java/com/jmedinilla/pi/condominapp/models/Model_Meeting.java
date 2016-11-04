package com.jmedinilla.pi.condominapp.models;

import java.util.Comparator;
import java.util.Date;

/**
 * Class created by JMedinilla on 2016-10-29
 *
 * BD meeting
 */
public class Model_Meeting implements Comparable<Model_Meeting> {
    private int me_id;
    private int me_community;
    private Date me_date;

    public Model_Meeting(int me_id, int me_community, Date me_date) {
        this.me_id = me_id;
        this.me_community = me_community;
        this.me_date = me_date;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        //The object can't be null
        if (obj != null) {
            //The object has to be a Meeting
            if (obj instanceof Model_Meeting) {
                Model_Meeting another = (Model_Meeting)obj;
                //If the Date is equal, it's the same meeting
                if (this.me_date.equals(another.me_date)) {
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Meeting (" + me_date.toString() + ")";
    }

    /**
     * Meeting comparable method
     * @param another Meeting to compare
     * @return Which one is higher
     */
    @Override
    public int compareTo(Model_Meeting another) {
        return this.getMe_date().compareTo(another.getMe_date());
    }

    /**
     * Meeting getters and setters
     */
    //ID
    public int getMe_id() {
        return me_id;
    }
    public void setMe_id(int me_id) {
        this.me_id = me_id;
    }
    //COMMUNITY
    public int getMe_community() {
        return me_community;
    }
    public void setMe_community(int me_community) {
        this.me_community = me_community;
    }
    //DATE
    public Date getMe_date() {
        return me_date;
    }
    public void setMe_date(Date me_date) {
        this.me_date = me_date;
    }

    /**
     * Meeting comparators
     */
    //DATE
    public static final Comparator<Model_Meeting> COMPARATOR_MEETING_DATE_ASC = new Comparator<Model_Meeting>() {
        @Override
        public int compare(Model_Meeting o1, Model_Meeting o2) {
            return o1.getMe_date().compareTo(o2.getMe_date());
        }
    };
    public static final Comparator<Model_Meeting> COMPARATOR_MEETING_DATE_DES = new Comparator<Model_Meeting>() {
        @Override
        public int compare(Model_Meeting o1, Model_Meeting o2) {
            return o2.getMe_date().compareTo(o1.getMe_date());
        }
    };
}
