package com.jmedinilla.pi.condominapp.models;

import java.sql.Blob;
import java.util.Date;

/**
 * Class created by JMedinilla on 2016-10-29
 *
 * BD incident
 */
public class Model_Incident {
    private int in_id;
    private Model_User in_user;
    private Date in_date;
    private String in_description;
    private Blob in_photo;
}
