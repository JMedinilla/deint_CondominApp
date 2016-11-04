package com.jmedinilla.pi.condominapp.models;

import java.util.Comparator;
import java.util.Date;

/**
 * Class created by JMedinilla on 2016-10-29
 *
 * BD entry for a board
 */
public class Model_Entry implements Comparable<Model_Entry> {
    private int en_id;
    private Model_User en_user;
    private String en_title;
    private String en_content;
    private Date en_date;
    private int en_category;

    public Model_Entry(int en_id, Model_User en_user, String en_title,
                       String en_content, Date en_date, int en_category) {
        this.en_id = en_id;
        this.en_user = en_user;
        this.en_title = en_title;
        this.en_content = en_content;
        this.en_date = en_date;
        this.en_category = en_category;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        //The object can't be null
        if (obj != null) {
            //The object has to be an Entry
            if (obj instanceof Model_Entry) {
                Model_Entry another = (Model_Entry)obj;
                //If the Title and Content are equals, it's the same entry
                if (this.en_title.equals(another.en_title) && this.en_content.equals(another.en_content)) {
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Entry: " + en_title + " (" + en_date.toString() + ")";
    }

    /**
     * Entry comparable method
     * @param another Entry to compare
     * @return Wich one is higher
     */
    @Override
    public int compareTo(Model_Entry another) {
        if (this.getEn_date().compareTo(another.getEn_date()) == 0) {
            if (this.getEn_title().compareTo(another.getEn_title()) == 0) {
                return this.getEn_content().compareTo(another.getEn_content());
            }
            else {
                return this.getEn_title().compareTo(another.getEn_title());
            }
        }
        else {
            return this.getEn_date().compareTo(another.getEn_date());
        }
    }

    /**
     * Entry getters and setters
     */
    //ID
    public int getEn_id() {
        return en_id;
    }
    public void setEn_id(int en_id) {
        this.en_id = en_id;
    }
    //USER
    public Model_User getEn_user() {
        return en_user;
    }
    public void setEn_user(Model_User en_user) {
        this.en_user = en_user;
    }
    //TITLE
    public String getEn_title() {
        return en_title;
    }
    public void setEn_title(String en_title) {
        this.en_title = en_title;
    }
    //CONTENT
    public String getEn_content() {
        return en_content;
    }
    public void setEn_content(String en_content) {
        this.en_content = en_content;
    }
    //DATE
    public Date getEn_date() {
        return en_date;
    }
    public void setEn_date(Date en_date) {
        this.en_date = en_date;
    }
    //CATEGORY
    public int getEn_category() {
        return en_category;
    }
    public void setEn_category(int en_category) {
        this.en_category = en_category;
    }

    /**
     * Entry comparators
     */
    //ID
    public static final Comparator<Model_Entry> COMPARATOR_ENTRY_ID_ASC = new Comparator<Model_Entry>() {
        @Override
        public int compare(Model_Entry o1, Model_Entry o2) {
            return o1.getEn_id() - o2.getEn_id();
        }
    };
    public static final Comparator<Model_Entry> COMPARATOR_ENTRY_ID_DES = new Comparator<Model_Entry>() {
        @Override
        public int compare(Model_Entry o1, Model_Entry o2) {
            return o2.getEn_id() - o1.getEn_id();
        }
    };
    //TITLE
    public static final Comparator<Model_Entry> COMPARATOR_ENTRY_TITLE_ASC = new Comparator<Model_Entry>() {
        @Override
        public int compare(Model_Entry o1, Model_Entry o2) {
            return o1.getEn_title().toUpperCase().compareTo(o2.getEn_title().toUpperCase());
        }
    };
    public static final Comparator<Model_Entry> COMPARATOR_ENTRY_TITLE_DES = new Comparator<Model_Entry>() {
        @Override
        public int compare(Model_Entry o1, Model_Entry o2) {
            return o2.getEn_title().toUpperCase().compareTo(o1.getEn_title().toUpperCase());
        }
    };
    //CONTENT
    public static final Comparator<Model_Entry> COMPARATOR_ENTRY_CONTENT_ASC = new Comparator<Model_Entry>() {
        @Override
        public int compare(Model_Entry o1, Model_Entry o2) {
            return o1.getEn_content().toUpperCase().compareTo(o2.getEn_content().toUpperCase());
        }
    };
    public static final Comparator<Model_Entry> COMPARATOR_ENTRY_CONTENT_DES = new Comparator<Model_Entry>() {
        @Override
        public int compare(Model_Entry o1, Model_Entry o2) {
            return o2.getEn_content().toUpperCase().compareTo(o1.getEn_content().toUpperCase());
        }
    };
    //DATE
    public static final Comparator<Model_Entry> COMPARATOR_ENTRY_DATE_ASC = new Comparator<Model_Entry>() {
        @Override
        public int compare(Model_Entry o1, Model_Entry o2) {
            return o1.getEn_date().compareTo(o2.getEn_date());
        }
    };
    public static final Comparator<Model_Entry> COMPARATOR_ENTRY_DATE_DES = new Comparator<Model_Entry>() {
        @Override
        public int compare(Model_Entry o1, Model_Entry o2) {
            return o2.getEn_date().compareTo(o1.getEn_date());
        }
    };
    //CATEGORY
    public static final Comparator<Model_Entry> COMPARATOR_ENTRY_CATEGORY_ASC = new Comparator<Model_Entry>() {
        @Override
        public int compare(Model_Entry o1, Model_Entry o2) {
            return o1.getEn_category() - o2.getEn_category();
        }
    };
    public static final Comparator<Model_Entry> COMPARATOR_ENTRY_CATEGORY_DES = new Comparator<Model_Entry>() {
        @Override
        public int compare(Model_Entry o1, Model_Entry o2) {
            return o2.getEn_category() - o1.getEn_category();
        }
    };
}
