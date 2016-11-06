package com.jmedinilla.pi.condominapp.models;

import android.support.annotation.NonNull;

import java.util.Comparator;
import java.util.UUID;

/**
 * Class created by JMedinilla on 2016-10-29
 * <p>
 * BD document
 */
public class Model_Document implements Comparable<Model_Document> {
    private String do_id;
    private int do_community;
    private String do_title;
    private String do_description;
    private String do_link;

    public Model_Document(int do_community,
                          String do_title, String do_description, String do_link) {
        this.do_id = UUID.randomUUID().toString();
        this.do_community = do_community;
        this.do_title = do_title;
        this.do_description = do_description;
        this.do_link = do_link;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        //The object can't be null
        if (obj != null) {
            //The object has to be a Document
            if (obj instanceof Model_Document) {
                Model_Document another = (Model_Document) obj;
                //If the Title and Link are equals, it's the same document
                if (this.do_title.toUpperCase().equals(another.do_title.toUpperCase())
                        && this.do_link.toUpperCase().equals(another.do_link.toUpperCase())) {
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Document: " + do_title + " -> " + do_link;
    }

    /**
     * Document comparable method
     *
     * @param another Document to compare
     * @return Wich one is higher
     */
    @Override
    public int compareTo(@NonNull Model_Document another) {
        if (this.getDo_title().toUpperCase().compareTo(another.getDo_title().toUpperCase()) == 0) {
            if (this.getDo_link().toUpperCase().compareTo(another.getDo_link().toUpperCase()) == 0) {
                return this.getDo_description().toUpperCase().compareTo(another.getDo_description().toUpperCase());
            } else {
                return this.getDo_link().toUpperCase().compareTo(another.getDo_link().toUpperCase());
            }
        } else {
            return this.getDo_title().toUpperCase().compareTo(another.getDo_title().toUpperCase());
        }
    }

    /**
     * Document getters and setters
     */
    //ID
    public String getDo_id() {
        return do_id;
    }

    public void setDo_id(String do_id) {
        this.do_id = do_id;
    }

    //COMMUNITY
    public int getDo_community() {
        return do_community;
    }

    public void setDo_community(int do_community) {
        this.do_community = do_community;
    }

    //TITLE
    public String getDo_title() {
        return do_title;
    }

    public void setDo_title(String do_title) {
        this.do_title = do_title;
    }

    //DESCRIPTION
    public String getDo_description() {
        return do_description;
    }

    public void setDo_description(String do_description) {
        this.do_description = do_description;
    }

    //LINK
    public String getDo_link() {
        return do_link;
    }

    public void setDo_link(String do_link) {
        this.do_link = do_link;
    }

    /**
     * Document comparators
     */
    //TITLE
    public static final Comparator<Model_Document> COMPARATOR_DOCUMENT_TITLE_ASC = new Comparator<Model_Document>() {
        @Override
        public int compare(Model_Document o1, Model_Document o2) {
            return o1.getDo_title().toUpperCase().compareTo(o2.getDo_title().toUpperCase());
        }
    };
    public static final Comparator<Model_Document> COMPARATOR_DOCUMENT_TITLE_DES = new Comparator<Model_Document>() {
        @Override
        public int compare(Model_Document o1, Model_Document o2) {
            return o2.getDo_title().toUpperCase().compareTo(o1.getDo_title().toUpperCase());
        }
    };
}
