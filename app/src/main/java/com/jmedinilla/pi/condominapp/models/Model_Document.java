package com.jmedinilla.pi.condominapp.models;

import android.support.annotation.NonNull;
import java.util.Comparator;

/**
 * Class created by JMedinilla on 2016-10-29
 *
 * BD document
 */
public class Model_Document implements Comparable<Model_Document> {
    private int do_id;
    private int do_community;
    private String do_title;
    private String do_description;
    private String do_link;

    public Model_Document(int do_id, int do_community,
                          String do_title, String do_description, String do_link) {
        this.do_id = do_id;
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
                Model_Document another = (Model_Document)obj;
                //If the Title and Link are equals, it's the same document
                if (this.do_title.equals(another.do_title) && this.do_link.equals(another.do_link)) {
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
     * @param another Document to compare
     * @return Wich one is higher
     */
    @Override
    public int compareTo(@NonNull Model_Document another) {
        if (this.getDo_title().compareTo(another.getDo_title()) == 0) {
            if (this.getDo_link().compareTo(another.getDo_link()) == 0) {
                return this.getDo_description().compareTo(another.getDo_description());
            }
            else {
                return this.getDo_link().compareTo(another.getDo_link());
            }
        }
        else {
            return this.getDo_title().compareTo(another.getDo_title());
        }
    }

    /**
     * Document getters and setters
     */
    //ID
    public int getDo_id() {
        return do_id;
    }
    public void setDo_id(int do_id) {
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
    //ID
    public static final Comparator<Model_Document> COMPARATOR_DOCUMENT_ID_ASC = new Comparator<Model_Document>() {
        @Override
        public int compare(Model_Document o1, Model_Document o2) {
            return o1.getDo_id() - o2.getDo_id();
        }
    };
    public static final Comparator<Model_Document> COMPARATOR_DOCUMENT_ID_DES = new Comparator<Model_Document>() {
        @Override
        public int compare(Model_Document o1, Model_Document o2) {
            return o2.getDo_id() - o1.getDo_id();
        }
    };
    //COMMUNITY
    public static final Comparator<Model_Document> COMPARATOR_DOCUMENT_COMMUNITY_ASC = new Comparator<Model_Document>() {
        @Override
        public int compare(Model_Document o1, Model_Document o2) {
            return o1.getDo_id() - o2.getDo_id();
        }
    };
    public static final Comparator<Model_Document> COMPARATOR_DOCUMENT_COMMUNITY_DES = new Comparator<Model_Document>() {
        @Override
        public int compare(Model_Document o1, Model_Document o2) {
            return o2.getDo_community() - o1.getDo_community();
        }
    };
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
    //DESCRIPTION
    public static final Comparator<Model_Document> COMPARATOR_DOCUMENT_DESCRIPTION_ASC = new Comparator<Model_Document>() {
        @Override
        public int compare(Model_Document o1, Model_Document o2) {
            return o1.getDo_description().toUpperCase().compareTo(o2.getDo_description().toUpperCase());
        }
    };
    public static final Comparator<Model_Document> COMPARATOR_DOCUMENT_DESCRIPTION_DES = new Comparator<Model_Document>() {
        @Override
        public int compare(Model_Document o1, Model_Document o2) {
            return o2.getDo_description().toUpperCase().compareTo(o1.getDo_description().toUpperCase());
        }
    };
    //LINK
    public static final Comparator<Model_Document> COMPARATOR_DOCUMENT_LINK_ASC = new Comparator<Model_Document>() {
        @Override
        public int compare(Model_Document o1, Model_Document o2) {
            return o1.getDo_link().toUpperCase().compareTo(o2.getDo_link().toUpperCase());
        }
    };
    public static final Comparator<Model_Document> COMPARATOR_DOCUMENT_LINK_DES = new Comparator<Model_Document>() {
        @Override
        public int compare(Model_Document o1, Model_Document o2) {
            return o2.getDo_link().toUpperCase().compareTo(o1.getDo_link().toUpperCase());
        }
    };
}
