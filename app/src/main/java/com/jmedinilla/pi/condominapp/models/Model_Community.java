package com.jmedinilla.pi.condominapp.models;

import android.support.annotation.NonNull;
import java.util.Comparator;

/**
 * Class created by JMedinilla on 2016-10-29
 *
 * BD community
 */
public class Model_Community implements Comparable<Model_Community> {
    private int co_id;
    private String co_locality;
    private String co_municipality;
    private String co_address;
    private String co_number;
    private String co_block;
    private String co_postal;
    private int co_apartments;
    private String co_admin_name;
    private String co_admin_address;
    private String co_admin_phone;
    private String co_admin_mail;
    private String co_president_name;
    private String co_president_phone;

    public Model_Community(int co_id, String co_locality, String co_municipality,
                           String co_address, String co_number, String co_block,
                           String co_postal, int co_apartments, String co_admin_name,
                           String co_admin_address, String co_admin_phone, String co_admin_mail,
                           String co_president_name, String co_president_phone) {
        this.co_id = co_id;
        this.co_locality = co_locality;
        this.co_municipality = co_municipality;
        this.co_address = co_address;
        this.co_number = co_number;
        this.co_block = co_block;
        this.co_postal = co_postal;
        this.co_apartments = co_apartments;
        this.co_admin_name = co_admin_name;
        this.co_admin_address = co_admin_address;
        this.co_admin_phone = co_admin_phone;
        this.co_admin_mail = co_admin_mail;
        this.co_president_name = co_president_name;
        this.co_president_phone = co_president_phone;
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        //The object can't be null
        if (o != null) {
            //The object has to be a Community
            if (o instanceof Model_Community) {
                Model_Community another = (Model_Community)o;
                //If the Postal, Address, Number and Block are equals, it's the same community
                if (this.co_postal.equals(another.co_postal) && this.co_address.equals(another.co_address)
                        && this.co_number.equals(another.co_number) && this.co_block.equals(another.co_block)) {
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Community: " + co_postal + " (postal), " + co_address + " n" + co_number + " (address), " + co_admin_name + " (admin)";
    }

    /**
     * Community comparable method
     * @param another Community to compare
     * @return Wich one is higher
     */
    @Override
    public int compareTo(@NonNull Model_Community another) {
        if (this.getCo_postal().compareTo(another.getCo_postal()) == 0) {
            if (this.getCo_address().compareTo(another.getCo_address()) == 0) {
                if (this.getCo_number().compareTo(another.getCo_number()) == 0) {
                    return this.getCo_block().compareTo(another.getCo_block());
                }
                else {
                    return this.getCo_number().compareTo(another.getCo_number());
                }
            }
            else {
                return this.getCo_address().compareTo(another.getCo_address());
            }
        }
        else {
            return this.getCo_postal().compareTo(another.getCo_postal());
        }
    }

    /**
     * Community getters and setters
     */
    //ID
    public int getCo_id() {
        return co_id;
    }
    public void setCo_id(int co_id) {
        this.co_id = co_id;
    }
    //LOCALITY
    public String getCo_locality() {
        return co_locality;
    }
    public void setCo_locality(String co_locality) {
        this.co_locality = co_locality;
    }
    //MUNICIPALITY
    public String getCo_municipality() {
        return co_municipality;
    }
    public void setCo_municipality(String co_municipality) {
        this.co_municipality = co_municipality;
    }
    //ADDRESS
    public String getCo_address() {
        return co_address;
    }
    public void setCo_address(String co_address) {
        this.co_address = co_address;
    }
    //NUMBER
    public String getCo_number() {
        return co_number;
    }
    public void setCo_number(String co_number) {
        this.co_number = co_number;
    }
    //BLOCK
    public String getCo_block() {
        return co_block;
    }
    public void setCo_block(String co_block) {
        this.co_block = co_block;
    }
    //POSTAL
    public String getCo_postal() {
        return co_postal;
    }
    public void setCo_postal(String co_postal) {
        this.co_postal = co_postal;
    }
    //APARTMENTS
    public int getCo_apartments() {
        return co_apartments;
    }
    public void setCo_apartments(int co_apartments) {
        this.co_apartments = co_apartments;
    }
    //ADMIN NAME
    public String getCo_admin_name() {
        return co_admin_name;
    }
    public void setCo_admin_name(String co_admin_name) {
        this.co_admin_name = co_admin_name;
    }
    //ADMIN ADDRESS
    public String getCo_admin_address() {
        return co_admin_address;
    }
    public void setCo_admin_address(String co_admin_address) {
        this.co_admin_address = co_admin_address;
    }
    //ADMIN PHONE
    public String getCo_admin_phone() {
        return co_admin_phone;
    }
    public void setCo_admin_phone(String co_admin_phone) {
        this.co_admin_phone = co_admin_phone;
    }
    //ADMIN MAIL
    public String getCo_admin_mail() {
        return co_admin_mail;
    }
    public void setCo_admin_mail(String co_admin_mail) {
        this.co_admin_mail = co_admin_mail;
    }
    //PRESIDENT NAME
    public String getCo_president_name() {
        return co_president_name;
    }
    public void setCo_president_name(String co_president_name) {
        this.co_president_name = co_president_name;
    }
    //PRESIDENT PHONE
    public String getCo_president_phone() {
        return co_president_phone;
    }
    public void setCo_president_phone(String co_president_phone) {
        this.co_president_phone = co_president_phone;
    }

    /**
     * Community comparators
     */
    //ID
    public static final Comparator<Model_Community> COMPARATOR_COMMUNITY_ID_ASC = new Comparator<Model_Community>() {
        @Override
        public int compare(Model_Community o1, Model_Community o2) {
            return o1.getCo_id() - o2.getCo_id();
        }
    };
    public static final Comparator<Model_Community> COMPARATOR_COMMUNITY_ID_DES = new Comparator<Model_Community>() {
        @Override
        public int compare(Model_Community o1, Model_Community o2) {
            return o2.getCo_id() - o1.getCo_id();
        }
    };
    //LOCALITY
    public static final Comparator<Model_Community> COMPARATOR_COMMUNITY_LOCALITY_ASC = new Comparator<Model_Community>() {
        @Override
        public int compare(Model_Community o1, Model_Community o2) {
            return o1.getCo_locality().toUpperCase().compareTo(o2.getCo_locality().toUpperCase());
        }
    };
    public static final Comparator<Model_Community> COMPARATOR_COMMUNITY_LOCALITY_DES = new Comparator<Model_Community>() {
        @Override
        public int compare(Model_Community o1, Model_Community o2) {
            return o2.getCo_locality().toUpperCase().compareTo(o1.getCo_locality().toUpperCase());
        }
    };
    //MUNICIPALITY
    public static final Comparator<Model_Community> COMPARATOR_COMMUNITY_MUNICIPALITY_ASC = new Comparator<Model_Community>() {
        @Override
        public int compare(Model_Community o1, Model_Community o2) {
            return o1.getCo_municipality().toUpperCase().compareTo(o2.getCo_municipality().toUpperCase());
        }
    };
    public static final Comparator<Model_Community> COMPARATOR_COMMUNITY_MUNICIPALITY_DES = new Comparator<Model_Community>() {
        @Override
        public int compare(Model_Community o1, Model_Community o2) {
            return o2.getCo_municipality().toUpperCase().compareTo(o1.getCo_municipality().toUpperCase());
        }
    };
    //ADDRESS
    public static final Comparator<Model_Community> COMPARATOR_COMMUNITY_ADDRESS_ASC = new Comparator<Model_Community>() {
        @Override
        public int compare(Model_Community o1, Model_Community o2) {
            return o1.getCo_address().toUpperCase().compareTo(o2.getCo_address().toUpperCase());
        }
    };
    public static final Comparator<Model_Community> COMPARATOR_COMMUNITY_ADDRESS_DES = new Comparator<Model_Community>() {
        @Override
        public int compare(Model_Community o1, Model_Community o2) {
            return o2.getCo_address().toUpperCase().compareTo(o1.getCo_address().toUpperCase());
        }
    };
    //NUMBER
    public static final Comparator<Model_Community> COMPARATOR_COMMUNITY_NUMBER_ASC = new Comparator<Model_Community>() {
        @Override
        public int compare(Model_Community o1, Model_Community o2) {
            return o1.getCo_number().toUpperCase().compareTo(o2.getCo_number().toUpperCase());
        }
    };
    public static final Comparator<Model_Community> COMPARATOR_COMMUNITY_NUMBER_DES = new Comparator<Model_Community>() {
        @Override
        public int compare(Model_Community o1, Model_Community o2) {
            return o2.getCo_number().toUpperCase().compareTo(o1.getCo_number().toUpperCase());
        }
    };
    //BLOCK
    public static final Comparator<Model_Community> COMPARATOR_COMMUNITY_BLOCK_ASC = new Comparator<Model_Community>() {
        @Override
        public int compare(Model_Community o1, Model_Community o2) {
            return o1.getCo_block().toUpperCase().compareTo(o2.getCo_block().toUpperCase());
        }
    };
    public static final Comparator<Model_Community> COMPARATOR_COMMUNITY_BLOCK_DES = new Comparator<Model_Community>() {
        @Override
        public int compare(Model_Community o1, Model_Community o2) {
            return o2.getCo_block().toUpperCase().compareTo(o1.getCo_block().toUpperCase());
        }
    };
    //POSTAL
    public static final Comparator<Model_Community> COMPARATOR_COMMUNITY_POSTAL_ASC = new Comparator<Model_Community>() {
        @Override
        public int compare(Model_Community o1, Model_Community o2) {
            return o1.getCo_postal().toUpperCase().compareTo(o2.getCo_postal().toUpperCase());
        }
    };
    public static final Comparator<Model_Community> COMPARATOR_COMMUNITY_POSTAL_DES = new Comparator<Model_Community>() {
        @Override
        public int compare(Model_Community o1, Model_Community o2) {
            return o2.getCo_postal().toUpperCase().compareTo(o1.getCo_postal().toUpperCase());
        }
    };
    //APARTMENTS
    public static final Comparator<Model_Community> COMPARATOR_COMMUNITY_APARTMENTS_ASC = new Comparator<Model_Community>() {
        @Override
        public int compare(Model_Community o1, Model_Community o2) {
            return o1.getCo_apartments() - o2.getCo_apartments();
        }
    };
    public static final Comparator<Model_Community> COMPARATOR_COMMUNITY_APARTMENTS_DES = new Comparator<Model_Community>() {
        @Override
        public int compare(Model_Community o1, Model_Community o2) {
            return o2.getCo_apartments() - o1.getCo_apartments();
        }
    };
    //ADMIN NAME
    public static final Comparator<Model_Community> COMPARATOR_COMMUNITY_ADMINNAME_ASC = new Comparator<Model_Community>() {
        @Override
        public int compare(Model_Community o1, Model_Community o2) {
            return o1.getCo_admin_name().toUpperCase().compareTo(o2.getCo_admin_name().toUpperCase());
        }
    };
    public static final Comparator<Model_Community> COMPARATOR_COMMUNITY_ADMINNAME_DES = new Comparator<Model_Community>() {
        @Override
        public int compare(Model_Community o1, Model_Community o2) {
            return o2.getCo_admin_name().toUpperCase().compareTo(o1.getCo_admin_name().toUpperCase());
        }
    };
    //ADMIN ADDRESS
    public static final Comparator<Model_Community> COMPARATOR_COMMUNITY_ADMINADDRESS_ASC = new Comparator<Model_Community>() {
        @Override
        public int compare(Model_Community o1, Model_Community o2) {
            return o1.getCo_admin_address().toUpperCase().compareTo(o2.getCo_admin_address().toUpperCase());
        }
    };
    public static final Comparator<Model_Community> COMPARATOR_COMMUNITY_ADMINADDRESS_DES = new Comparator<Model_Community>() {
        @Override
        public int compare(Model_Community o1, Model_Community o2) {
            return o2.getCo_admin_address().toUpperCase().compareTo(o1.getCo_admin_address().toUpperCase());
        }
    };
    //ADMIN PHONE
    public static final Comparator<Model_Community> COMPARATOR_COMMUNITY_ADMINPHONE_ASC = new Comparator<Model_Community>() {
        @Override
        public int compare(Model_Community o1, Model_Community o2) {
            return o1.getCo_admin_phone().toUpperCase().compareTo(o2.getCo_admin_phone().toUpperCase());
        }
    };
    public static final Comparator<Model_Community> COMPARATOR_COMMUNITY_ADMINPHONE_DES = new Comparator<Model_Community>() {
        @Override
        public int compare(Model_Community o1, Model_Community o2) {
            return o2.getCo_admin_phone().toUpperCase().compareTo(o1.getCo_admin_phone().toUpperCase());
        }
    };
    //ADMIN MAIL
    public static final Comparator<Model_Community> COMPARATOR_COMMUNITY_ADMINMAIL_ASC = new Comparator<Model_Community>() {
        @Override
        public int compare(Model_Community o1, Model_Community o2) {
            return o1.getCo_admin_mail().toUpperCase().compareTo(o2.getCo_admin_mail().toUpperCase());
        }
    };
    public static final Comparator<Model_Community> COMPARATOR_COMMUNITY_ADMINMAIL_DES = new Comparator<Model_Community>() {
        @Override
        public int compare(Model_Community o1, Model_Community o2) {
            return o2.getCo_admin_mail().toUpperCase().compareTo(o1.getCo_admin_mail().toUpperCase());
        }
    };
    //PRESIDENT NAME
    public static final Comparator<Model_Community> COMPARATOR_COMMUNITY_PRESIDENTNAME_ASC = new Comparator<Model_Community>() {
        @Override
        public int compare(Model_Community o1, Model_Community o2) {
            return o1.getCo_president_name().toUpperCase().compareTo(o2.getCo_president_name().toUpperCase());
        }
    };
    public static final Comparator<Model_Community> COMPARATOR_COMMUNITY_PRESIDENTNAME_DES = new Comparator<Model_Community>() {
        @Override
        public int compare(Model_Community o1, Model_Community o2) {
            return o2.getCo_president_name().toUpperCase().compareTo(o1.getCo_president_name().toUpperCase());
        }
    };
    //PRESIDENT PHONE
    public static final Comparator<Model_Community> COMPARATOR_COMMUNITY_PRESIDENTPHONE_ASC = new Comparator<Model_Community>() {
        @Override
        public int compare(Model_Community o1, Model_Community o2) {
            return o1.getCo_president_phone().toUpperCase().compareTo(o2.getCo_president_phone().toUpperCase());
        }
    };
    public static final Comparator<Model_Community> COMPARATOR_COMMUNITY_PRESIDENTPHONE_DES = new Comparator<Model_Community>() {
        @Override
        public int compare(Model_Community o1, Model_Community o2) {
            return o2.getCo_president_phone().toUpperCase().compareTo(o1.getCo_president_phone().toUpperCase());
        }
    };
}
