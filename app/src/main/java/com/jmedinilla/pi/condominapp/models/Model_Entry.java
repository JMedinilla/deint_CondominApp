package com.jmedinilla.pi.condominapp.models;

import java.util.Date;

/**
 * Class created by JMedinilla on 2016-10-29
 *
 * BD entry for a board
 */
public class Model_Entry {
    private int en_id;
    private Model_User en_user;
    private String en_title;
    private String en_content;
    private Date en_date;
    private String en_category;
}
