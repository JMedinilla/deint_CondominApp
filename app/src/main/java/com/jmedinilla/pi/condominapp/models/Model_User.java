package com.jmedinilla.pi.condominapp.models;

import android.support.annotation.NonNull;

import java.util.Comparator;
import java.util.UUID;

/**
 * Class created by JMedinilla on 2016-10-29
 * <p>
 * BD user
 */
public class Model_User {
    public static final int ADMINISTRATOR = 100;
    public static final int PRESIDENT = 200;
    public static final int NEIGHBOUR = 300;

    private String us_id;
    private int us_community;
    private String us_floor;
    private String us_door;
    private String us_phone;
    private String us_mail;
    private String us_name;
    private int us_category;

    public Model_User(String id, int us_community, String us_floor,
                      String us_door, String us_phone, String us_mail,
                      String us_name, int us_category) {
        this.us_id = id;
        this.us_community = us_community;
        this.us_floor = us_floor;
        this.us_door = us_door;
        this.us_phone = us_phone;
        this.us_mail = us_mail;
        this.us_name = us_name;
        this.us_category = us_category;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        //The object can't be null
        if (obj != null) {
            //The object has to be an User
            if (obj instanceof Model_User) {
                Model_User another = (Model_User) obj;
                //If the Phone is equal, it's the same user
                if (this.getUs_phone().equals(another.getUs_phone())) {
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "User: " + us_name + " (" + us_phone + ") -> " + us_floor + us_door;
    }

    /**
     * User getters and setters
     */
    //ID
    public String getUs_id() {
        return us_id;
    }

    public void setUs_id(String us_id) {
        this.us_id = us_id;
    }

    //COMMUNITY
    public int getUs_community() {
        return us_community;
    }

    public void setUs_community(int us_community) {
        this.us_community = us_community;
    }

    //FLOOR
    public String getUs_floor() {
        return us_floor;
    }

    public void setUs_floor(String us_floor) {
        this.us_floor = us_floor;
    }

    //DOOR
    public String getUs_door() {
        return us_door;
    }

    public void setUs_door(String us_door) {
        this.us_door = us_door;
    }

    //PHONE
    public String getUs_phone() {
        return us_phone;
    }

    public void setUs_phone(String us_phone) {
        this.us_phone = us_phone;
    }

    //MAIL
    public String getUs_mail() {
        return us_mail;
    }

    public void setUs_mail(String us_mail) {
        this.us_mail = us_mail;
    }

    //NAME
    public String getUs_name() {
        return us_name;
    }

    public void setUs_name(String us_name) {
        this.us_name = us_name;
    }

    //CATEGORY
    public int getUs_category() {
        return us_category;
    }

    public void setUs_category(int us_category) {
        this.us_category = us_category;
    }

    /**
     * User comparators
     */
    //NAME
    public static final Comparator<Model_User> COMPARATOR_USER_NAME_ASC = new Comparator<Model_User>() {
        @Override
        public int compare(Model_User o1, Model_User o2) {
            return o1.getUs_name().toUpperCase().compareTo(o2.getUs_name().toUpperCase());
        }
    };
    public static final Comparator<Model_User> COMPARATOR_USER_NAME_DES = new Comparator<Model_User>() {
        @Override
        public int compare(Model_User o1, Model_User o2) {
            return o2.getUs_name().toUpperCase().compareTo(o1.getUs_name().toUpperCase());
        }
    };
    //PHONE
    public static final Comparator<Model_User> COMPARATOR_USER_PHONE_ASC = new Comparator<Model_User>() {
        @Override
        public int compare(Model_User o1, Model_User o2) {
            return o1.getUs_phone().compareTo(o2.getUs_phone());
        }
    };
    public static final Comparator<Model_User> COMPARATOR_USER_PHONE_DES = new Comparator<Model_User>() {
        @Override
        public int compare(Model_User o1, Model_User o2) {
            return o2.getUs_phone().compareTo(o1.getUs_phone());
        }
    };
}
