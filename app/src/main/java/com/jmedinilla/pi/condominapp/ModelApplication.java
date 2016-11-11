package com.jmedinilla.pi.condominapp;

import android.app.Application;

import com.jmedinilla.pi.condominapp.models.Model_Community;
import com.jmedinilla.pi.condominapp.models.Model_Document;
import com.jmedinilla.pi.condominapp.models.Model_Entry;
import com.jmedinilla.pi.condominapp.models.Model_Incident;
import com.jmedinilla.pi.condominapp.models.Model_Meeting;
import com.jmedinilla.pi.condominapp.models.Model_Note;
import com.jmedinilla.pi.condominapp.models.Model_Point;
import com.jmedinilla.pi.condominapp.models.Model_User;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Class created by JMedinilla on 2016-11-11
 */
public class ModelApplication extends Application {
    private static final int TYPE_COMMUNITY_ID = 10;
    private static final int TYPE_COMMUNITY_LOCALITY = 11;
    private static final int TYPE_COMMUNITY_MUNICIPALITY = 12;
    private static final int TYPE_COMMUNITY_POSTAL = 13;
    private static final int TYPE_COMMUNITY_APARTMENTS = 14;
    private static final int TYPE_DOCUMENT_TITLE = 20;
    private static final int TYPE_ENTRY_TITLE = 30;
    private static final int TYPE_ENTRY_DATE = 31;
    private static final int TYPE_INCIDENT_TITLE = 40;
    private static final int TYPE_INCIDENT_DATE = 41;
    private static final int TYPE_MEETING_DATE = 50;
    private static final int TYPE_NOTE_DATE = 60;
    private static final int TYPE_NOTE_TITLE = 61;
    private static final int TYPE_POINT_TITLE = 70;
    private static final int TYPE_USER_NAME = 80;
    private static final int TYPE_USER_PHONE = 81;

    private ArrayList<Model_Community> communityList;
    private ArrayList<Model_Document> documentList;
    private ArrayList<Model_Entry> entryFirstList;
    private ArrayList<Model_Entry> entrySecondList;
    private ArrayList<Model_Incident> incidentList;
    private ArrayList<Model_Meeting> meetingList;
    private ArrayList<Model_Note> noteList;
    private ArrayList<Model_Point> pointList;
    private ArrayList<Model_User> userList;

    @Override
    public void onCreate() {
        super.onCreate();
        communityList = new ArrayList<>();
        documentList = new ArrayList<>();
        entryFirstList = new ArrayList<>();
        entrySecondList = new ArrayList<>();
        incidentList = new ArrayList<>();
        meetingList = new ArrayList<>();
        noteList = new ArrayList<>();
        pointList = new ArrayList<>();
        userList = new ArrayList<>();

        Model_User tmpUser = new Model_User(0, "floor", "door", "phone", "mail", "name", Model_User.NEIGHBOUR);
        Calendar calendar = Calendar.getInstance();


        saveDocument(new Model_Document(0, "title", "desc", "link"));
        saveDocument(new Model_Document(0, "title", "desc", "link"));
        saveDocument(new Model_Document(0, "title", "desc", "link"));
        saveFirstEntry(new Model_Entry(tmpUser, "Ruidos nocturnos", "Recuerdo a los vecinos que el ayuntamiento prohíbe el ruído a partir de las 22:00", new Date(calendar.getTimeInMillis()), Model_Entry.FIRST));
        saveSecondEntry(new Model_Entry(tmpUser, "Pantalón perdido", "Soy del 1A y tengo un pantalón vaquero que se ha caído al patio", new Date(calendar.getTimeInMillis()), Model_Entry.SECOND));
        saveIncident(new Model_Incident(tmpUser, new Date(calendar.getTimeInMillis()), "title", "desc", "link"));
        saveIncident(new Model_Incident(tmpUser, new Date(calendar.getTimeInMillis()), "title", "desc", "link"));
        saveIncident(new Model_Incident(tmpUser, new Date(calendar.getTimeInMillis()), "title", "desc", "link"));
        saveMeeting(new Model_Meeting(0, new Date(calendar.getTimeInMillis())));
        saveMeeting(new Model_Meeting(0, new Date(calendar.getTimeInMillis())));
        saveMeeting(new Model_Meeting(0, new Date(calendar.getTimeInMillis())));
        saveNote(new Model_Note(0, new Date(calendar.getTimeInMillis()), "Corte de agua", "El martes 21 hay un corte de agua desde las 4:00 hasta las 8:00"));
        saveNote(new Model_Note(0, new Date(calendar.getTimeInMillis()), "Revisión ascensor", "El día 14 de diciembre viene el revisor a ver el ascensor"));
    }

    public void saveCommunity(Model_Community community) {
        communityList.add(community);
    }

    public void saveDocument(Model_Document document) {
        documentList.add(document);
    }

    public void saveFirstEntry(Model_Entry entry) {
        entryFirstList.add(entry);
    }

    public void saveSecondEntry(Model_Entry entry) {
        entrySecondList.add(entry);
    }

    public void saveIncident(Model_Incident incident) {
        incidentList.add(incident);
    }

    public void saveMeeting(Model_Meeting meeting) {
        meetingList.add(meeting);
    }

    public void saveNote(Model_Note note) {
        noteList.add(note);
    }

    public void savePoint(Model_Point point) {
        pointList.add(point);
    }

    public void saveUser(Model_User user) {
        userList.add(user);
    }

    public List<Model_Community> getCommunities() {
        return communityList;
    }

    public List<Model_Document> getDocuments() {
        return documentList;
    }

    public List<Model_Entry> getFirstEntries() {
        return entryFirstList;
    }

    public List<Model_Entry> getSecondEntries() {
        return entrySecondList;
    }

    public List<Model_Incident> getIncidents() {
        return incidentList;
    }

    public List<Model_Meeting> getMeetings() {
        return meetingList;
    }

    public List<Model_Note> getNotes() {
        return noteList;
    }

    public List<Model_Point> getPoints() {
        return pointList;
    }

    public List<Model_User> getUsers() {
        return userList;
    }

    public List<Model_Community> getCommunities(boolean asc, int type) {
        if (asc) {
            switch (type) {
                case TYPE_COMMUNITY_ID:
                    Collections.sort(communityList, Model_Community.COMPARATOR_COMMUNITY_ID_ASC);
                    break;
                case TYPE_COMMUNITY_LOCALITY:
                    Collections.sort(communityList, Model_Community.COMPARATOR_COMMUNITY_ID_ASC);
                    break;
                case TYPE_COMMUNITY_MUNICIPALITY:
                    Collections.sort(communityList, Model_Community.COMPARATOR_COMMUNITY_ID_ASC);
                    break;
                case TYPE_COMMUNITY_POSTAL:
                    Collections.sort(communityList, Model_Community.COMPARATOR_COMMUNITY_ID_ASC);
                    break;
                case TYPE_COMMUNITY_APARTMENTS:
                    Collections.sort(communityList, Model_Community.COMPARATOR_COMMUNITY_ID_ASC);
                    break;
            }
        } else {
            Collections.sort(communityList, Collections.<Model_Community>reverseOrder());
        }
        return communityList;
    }

    public List<Model_Document> getDocuments(boolean asc, int type) {
        if (asc) {
            switch (type) {
                case TYPE_DOCUMENT_TITLE:
                    Collections.sort(documentList, Model_Document.COMPARATOR_DOCUMENT_TITLE_ASC);
                    break;
            }
        } else {
            Collections.sort(documentList, Collections.<Model_Document>reverseOrder());
        }
        return documentList;
    }

    public List<Model_Entry> getFirstEntries(boolean asc, int type) {
        if (asc) {
            switch (type) {
                case TYPE_ENTRY_TITLE:
                    Collections.sort(entryFirstList, Model_Entry.COMPARATOR_ENTRY_TITLE_ASC);
                    break;
                case TYPE_ENTRY_DATE:
                    Collections.sort(entryFirstList, Model_Entry.COMPARATOR_ENTRY_DATE_ASC);
                    break;
            }
        } else {
            Collections.sort(entryFirstList, Collections.<Model_Entry>reverseOrder());
        }
        return entryFirstList;
    }

    public List<Model_Entry> getSecondEntries(boolean asc, int type) {
        if (asc) {
            switch (type) {
                case TYPE_ENTRY_TITLE:
                    Collections.sort(entrySecondList, Model_Entry.COMPARATOR_ENTRY_TITLE_ASC);
                    break;
                case TYPE_ENTRY_DATE:
                    Collections.sort(entrySecondList, Model_Entry.COMPARATOR_ENTRY_DATE_ASC);
                    break;
            }
        } else {
            Collections.sort(entrySecondList, Collections.<Model_Entry>reverseOrder());
        }
        return entrySecondList;
    }

    public List<Model_Incident> getIncidents(boolean asc, int type) {
        if (asc) {
            switch (type) {
                case TYPE_INCIDENT_TITLE:
                    Collections.sort(incidentList, Model_Incident.COMPARATOR_INCIDENT_TITLE_ASC);
                    break;
                case TYPE_INCIDENT_DATE:
                    Collections.sort(incidentList, Model_Incident.COMPARATOR_INCIDENT_DATE_ASC);
                    break;
            }
        } else {
            Collections.sort(incidentList, Collections.<Model_Incident>reverseOrder());
        }
        return incidentList;
    }

    public List<Model_Meeting> getMeetings(boolean asc, int type) {
        if (asc) {
            switch (type) {
                case TYPE_MEETING_DATE:
                    Collections.sort(meetingList, Model_Meeting.COMPARATOR_MEETING_DATE_ASC);
                    break;
            }
        } else {
            Collections.sort(meetingList, Collections.<Model_Meeting>reverseOrder());
        }
        return meetingList;
    }

    public List<Model_Note> getNotes(boolean asc, int type) {
        if (asc) {
            switch (type) {
                case TYPE_NOTE_TITLE:
                    Collections.sort(noteList, Model_Note.COMPARATOR_NOTE_TITLE_ASC);
                    break;
                case TYPE_NOTE_DATE:
                    Collections.sort(noteList, Model_Note.COMPARATOR_NOTE_DATE_ASC);
                    break;
            }
        } else {
            Collections.sort(noteList, Collections.<Model_Note>reverseOrder());
        }
        return noteList;
    }

    public List<Model_Point> getPoints(boolean asc, int type) {
        if (asc) {
            switch (type) {
                case TYPE_POINT_TITLE:
                    Collections.sort(pointList, Model_Point.COMPARATOR_POINT_TITLE_ASC);
                    break;
            }
        } else {
            Collections.sort(pointList, Collections.<Model_Point>reverseOrder());
        }
        return pointList;
    }

    public List<Model_User> getUsers(boolean asc, int type) {
        if (asc) {
            switch (type) {
                case TYPE_USER_NAME:
                    Collections.sort(userList, Model_User.COMPARATOR_USER_NAME_ASC);
                    break;
                case TYPE_USER_PHONE:
                    Collections.sort(userList, Model_User.COMPARATOR_USER_PHONE_ASC);
                    break;
            }
        } else {
            Collections.sort(userList, Collections.<Model_User>reverseOrder());
        }
        return userList;
    }
}
