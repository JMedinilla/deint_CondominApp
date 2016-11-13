package com.jmedinilla.pi.condominapp.forms;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageView;

import com.jmedinilla.pi.condominapp.ModelApplication;
import com.jmedinilla.pi.condominapp.R;
import com.jmedinilla.pi.condominapp.models.Model_Meeting;
import com.jmedinilla.pi.condominapp.preferences.Preferences_Profile;

import java.util.Calendar;
import java.util.Date;

/**
 * Class created by JMedinilla on 2016-11-06
 * <p>
 * Form for meetings
 */
public class Form_Meetings extends AppCompatActivity {

    private ImageView formMeeting_btnAdd;
    private CalendarView formMeeting_calendar;
    private Preferences_Profile preferences_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_meetings);

        preferences_profile = new Preferences_Profile(Form_Meetings.this);

        formMeeting_btnAdd = (ImageView) findViewById(R.id.formBoard_btnAdd);
        formMeeting_calendar = (CalendarView) findViewById(R.id.formMeeting_calendar);
        formMeeting_calendar.setFirstDayOfWeek(Calendar.MONDAY);

        formMeeting_btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date date = new Date(formMeeting_calendar.getDate());

                Model_Meeting meeting = new Model_Meeting(preferences_profile.getUserCommunity(), date);

                if (!((ModelApplication) getApplication()).getMeetings().contains(meeting)) {
                    ((ModelApplication) getApplication()).saveMeeting(meeting);
                    finish();
                } else
                    Snackbar.make(findViewById(R.id.form_meetings), "already exists", Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}
