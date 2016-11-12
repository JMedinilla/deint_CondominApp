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
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
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
    private static final int TYPE_INCIDENT_AUTHOR = 42;
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

        Model_User tmpUser_1 = new Model_User("xdftrcgykdtgykjcftydtydykjdhkdxfhgkdgfhkmjdghkh", 123, "2", "B", "656565656", "correo@correo.com", "Javier Medinilla", Model_User.NEIGHBOUR);
        Model_User tmpUser_2 = new Model_User("dykdcghymcdgrjeddhkjdghkhftuyodghedcghrlfyuldft", 213, "1", "A", "767676767", "mail@mail.es", "Amador Fernandez", Model_User.PRESIDENT);
        GregorianCalendar calendar_1 = new GregorianCalendar(2016, 4, 4);
        GregorianCalendar calendar_2 = new GregorianCalendar(2015, 5, 16);
        GregorianCalendar calendar_3 = new GregorianCalendar(2016, 1, 10);
        GregorianCalendar calendar_4 = new GregorianCalendar(2016, 7, 2);
        GregorianCalendar calendar_5 = new GregorianCalendar(2016, 9, 24);
        GregorianCalendar calendar_6 = new GregorianCalendar(2016, 11, 8);
        GregorianCalendar calendar_7 = new GregorianCalendar(2016, 7, 2);
        GregorianCalendar calendar_8 = new GregorianCalendar(2016, 8, 24);
        GregorianCalendar calendar_9 = new GregorianCalendar(2016, 9, 8);
        GregorianCalendar calendar_10 = new GregorianCalendar(2016, 9, 27);
        GregorianCalendar calendar_11 = new GregorianCalendar(2016, 10, 13);
        GregorianCalendar calendar_12 = new GregorianCalendar(2016, 10, 23);

        saveDocument(new Model_Document(0, "Estatutos", "Estatutos de la comunidad actualizados", "asdfasdfasdfasdfasdfasdfasdf"));
        saveDocument(new Model_Document(1, "Normativa ruidos", "Normativa del ayuntamiento sobre ruidos", "asdfasdfasdfasdfasdfasdfasdf"));
        saveDocument(new Model_Document(2, "Acta junta 16/5/15", "Acta de la junta celebrada el 16 de junio de 2015", "asdfasdfasdfasdfasdfasdfasdf"));
        saveDocument(new Model_Document(3, "Acta junta 10/1/16", "Acta de la junta celebrada el 10 de enero de 2016", "asdfasdfasdfasdfasdfasdfasdf"));
        saveFirstEntry(new Model_Entry(tmpUser_2, "Ruidos nocturnos", "Recuerdo a los vecinos que el ayuntamiento prohíbe el ruído a partir de las 22:00", new Date(calendar_1.getTimeInMillis()), Model_Entry.FIRST));
        saveFirstEntry(new Model_Entry(tmpUser_2, "Ascensor estropeado", "El ascensor está estropeado desde el martes pasado, el revisor vendrá el mes que viene", new Date(calendar_11.getTimeInMillis()), Model_Entry.FIRST));
        saveSecondEntry(new Model_Entry(tmpUser_1, "Pantalón perdido", "Soy del 1A y tengo un pantalón vaquero que se ha caído al patio", new Date(calendar_2.getTimeInMillis()), Model_Entry.SECOND));
        saveSecondEntry(new Model_Entry(tmpUser_1, "Ruidos por la noche", "Estoy harto ya de acostarme y no poder dormir porque alguien tiene la música puesta hasta las 2 de la mañana", new Date(calendar_12.getTimeInMillis()), Model_Entry.SECOND));
        saveIncident(new Model_Incident(tmpUser_1, new Date(calendar_5.getTimeInMillis()), "Bombilla fundida", "La bombilla del rellano del 3º está fundida", "asdfasdfasdfasdfasdfasdfasdf"));
        saveIncident(new Model_Incident(tmpUser_1, new Date(calendar_6.getTimeInMillis()), "Azulejo roto", "Dentro del portal hay un azulejo roto en las escaleras", "asdfasdfasdfasdfasdfasdfasdf"));
        saveIncident(new Model_Incident(tmpUser_2, new Date(calendar_7.getTimeInMillis()), "Escalón roto", "El azulejo de un escalón del 2º al 3er piso está roto", "asdfasdfasdfasdfasdfasdfasdf"));
        saveMeeting(new Model_Meeting(0, new Date(calendar_3.getTimeInMillis())));
        saveMeeting(new Model_Meeting(0, new Date(calendar_4.getTimeInMillis())));
        saveNote(new Model_Note(0, new Date(calendar_8.getTimeInMillis()), "Corte de agua", "El martes 21 hay un corte de agua desde las 4:00 hasta las 8:00"));
        saveNote(new Model_Note(0, new Date(calendar_9.getTimeInMillis()), "Revisión ascensor", "El día 14 de diciembre viene el revisor a ver el ascensor"));
        saveNote(new Model_Note(0, new Date(calendar_10.getTimeInMillis()), "Revisión extintores", "El 15 de enero toca revisión de los extintores de la comunidad"));
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
        switch (type) {
            case TYPE_COMMUNITY_ID:
                if (asc) { Collections.sort(communityList, Model_Community.COMPARATOR_COMMUNITY_ID_ASC); }
                else { Collections.sort(communityList, Model_Community.COMPARATOR_COMMUNITY_ID_DES); }
                break;
            case TYPE_COMMUNITY_LOCALITY:
                if (asc) { Collections.sort(communityList, Model_Community.COMPARATOR_COMMUNITY_LOCALITY_ASC); }
                else { Collections.sort(communityList, Model_Community.COMPARATOR_COMMUNITY_LOCALITY_DES); }
                break;
            case TYPE_COMMUNITY_MUNICIPALITY:
                if (asc) { Collections.sort(communityList, Model_Community.COMPARATOR_COMMUNITY_MUNICIPALITY_ASC); }
                else { Collections.sort(communityList, Model_Community.COMPARATOR_COMMUNITY_MUNICIPALITY_DES); }
                break;
            case TYPE_COMMUNITY_POSTAL:
                if (asc) { Collections.sort(communityList, Model_Community.COMPARATOR_COMMUNITY_POSTAL_ASC); }
                else { Collections.sort(communityList, Model_Community.COMPARATOR_COMMUNITY_POSTAL_DES); }
                break;
            case TYPE_COMMUNITY_APARTMENTS:
                if (asc) { Collections.sort(communityList, Model_Community.COMPARATOR_COMMUNITY_APARTMENTS_ASC); }
                else { Collections.sort(communityList, Model_Community.COMPARATOR_COMMUNITY_APARTMENTS_DES); }
                break;
        }
        return communityList;
    }

    public List<Model_Document> getDocuments(boolean asc, int type) {
        switch (type) {
            case TYPE_DOCUMENT_TITLE:
                if (asc) { Collections.sort(documentList, Model_Document.COMPARATOR_DOCUMENT_TITLE_ASC); }
                else { Collections.sort(documentList, Model_Document.COMPARATOR_DOCUMENT_TITLE_DES); }
                break;
        }
        return documentList;
    }

    public List<Model_Entry> getFirstEntries(boolean asc, int type) {
        switch (type) {
            case TYPE_ENTRY_TITLE:
                if (asc) { Collections.sort(entryFirstList, Model_Entry.COMPARATOR_ENTRY_TITLE_ASC); }
                else { Collections.sort(entryFirstList, Model_Entry.COMPARATOR_ENTRY_TITLE_DES); }
                break;
            case TYPE_ENTRY_DATE:
                if (asc) { Collections.sort(entryFirstList, Model_Entry.COMPARATOR_ENTRY_DATE_ASC); }
                else { Collections.sort(entryFirstList, Model_Entry.COMPARATOR_ENTRY_DATE_DES); }
                break;
        }
        return entryFirstList;
    }

    public List<Model_Entry> getSecondEntries(boolean asc, int type) {
        switch (type) {
            case TYPE_ENTRY_TITLE:
                if (asc) { Collections.sort(entrySecondList, Model_Entry.COMPARATOR_ENTRY_TITLE_ASC); }
                else { Collections.sort(entrySecondList, Model_Entry.COMPARATOR_ENTRY_TITLE_DES); }
                break;
            case TYPE_ENTRY_DATE:
                if (asc) { Collections.sort(entrySecondList, Model_Entry.COMPARATOR_ENTRY_DATE_ASC); }
                else { Collections.sort(entrySecondList, Model_Entry.COMPARATOR_ENTRY_DATE_DES); }
                break;
        }
        return entrySecondList;
    }

    public List<Model_Incident> getIncidents(boolean asc, int type) {
        switch (type) {
            case TYPE_INCIDENT_TITLE:
                if (asc) { Collections.sort(incidentList, Model_Incident.COMPARATOR_INCIDENT_TITLE_ASC); }
                else { Collections.sort(incidentList, Model_Incident.COMPARATOR_INCIDENT_TITLE_DES); }
                break;
            case TYPE_INCIDENT_DATE:
                if (asc) { Collections.sort(incidentList, Model_Incident.COMPARATOR_INCIDENT_DATE_ASC); }
                else { Collections.sort(incidentList, Model_Incident.COMPARATOR_INCIDENT_DATE_DES); }
                break;
            case TYPE_INCIDENT_AUTHOR:
                if (asc) { Collections.sort(incidentList, Model_Incident.COMPARATOR_INCIDENT_AUTHOR_ASC); }
                else { Collections.sort(incidentList, Model_Incident.COMPARATOR_INCIDENT_AUTHOR_DES); }
                break;
        }
        return incidentList;
    }

    public List<Model_Meeting> getMeetings(boolean asc, int type) {
        switch (type) {
            case TYPE_MEETING_DATE:
                if (asc) { Collections.sort(meetingList, Model_Meeting.COMPARATOR_MEETING_DATE_ASC); }
                else { Collections.sort(meetingList, Model_Meeting.COMPARATOR_MEETING_DATE_DES); }
                break;
        }
        return meetingList;
    }

    public List<Model_Note> getNotes(boolean asc, int type) {
        switch (type) {
            case TYPE_NOTE_TITLE:
                if (asc) { Collections.sort(noteList, Model_Note.COMPARATOR_NOTE_TITLE_ASC); }
                else { Collections.sort(noteList, Model_Note.COMPARATOR_NOTE_TITLE_DES); }
                break;
            case TYPE_NOTE_DATE:
                if (asc) { Collections.sort(noteList, Model_Note.COMPARATOR_NOTE_DATE_ASC); }
                else { Collections.sort(noteList, Model_Note.COMPARATOR_NOTE_DATE_DES); }
                break;
        }
        return noteList;
    }

    public List<Model_Point> getPoints(boolean asc, int type) {
        switch (type) {
            case TYPE_POINT_TITLE:
                if (asc) { Collections.sort(pointList, Model_Point.COMPARATOR_POINT_TITLE_ASC); }
                else { Collections.sort(pointList, Model_Point.COMPARATOR_POINT_TITLE_DES); }
                break;
        }
        return pointList;
    }

    public List<Model_User> getUsers(boolean asc, int type) {
        switch (type) {
            case TYPE_USER_NAME:
                if (asc) { Collections.sort(userList, Model_User.COMPARATOR_USER_NAME_ASC); }
                else { Collections.sort(userList, Model_User.COMPARATOR_USER_NAME_DES); }
                break;
            case TYPE_USER_PHONE:
                if (asc) { Collections.sort(userList, Model_User.COMPARATOR_USER_PHONE_ASC); }
                else { Collections.sort(userList, Model_User.COMPARATOR_USER_PHONE_DES); }
                break;
        }
        return userList;
    }
}
