package com.jmedinilla.pi.condominapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jmedinilla.pi.condominapp.ModelApplication;
import com.jmedinilla.pi.condominapp.R;
import com.jmedinilla.pi.condominapp.models.Model_Meeting;

import java.util.ArrayList;
import java.util.List;

/**
 * Class created by JMedinilla on 2016-10-29
 * <p>
 * Adapter for the list in the meetings screen
 */
public class Adapter_List_Meetings extends RecyclerView.Adapter<Adapter_List_Meetings.MeetingViewHolder> {

    private static final int TYPE_MEETING_DATE = 50;
    private static boolean ASC_DATE = true;

    private List<Model_Meeting> meetings;
    private Context ctxt;

    public Adapter_List_Meetings(Context context) {
        this.ctxt = context;
        this.meetings = new ArrayList<>(((ModelApplication) ctxt.getApplicationContext()).getMeetings());
    }

    public void sortMeeting(int type) {
        boolean ASC = false;

        if (type == TYPE_MEETING_DATE) { ASC = ASC_DATE; ASC_DATE = !ASC_DATE; }

        getAllMeetings(((ModelApplication)ctxt.getApplicationContext()).getMeetings(ASC, type));
    }

    @Override
    public Adapter_List_Meetings.MeetingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_meetings, parent, false);
        return new MeetingViewHolder(item);
    }

    @Override
    public void onBindViewHolder(Adapter_List_Meetings.MeetingViewHolder holder, int position) {
        String month = (String) DateFormat.format("MMM", meetings.get(position).getMe_date());
        String year = (String) DateFormat.format("yyyy", meetings.get(position).getMe_date());
        String day = (String) DateFormat.format("dd", meetings.get(position).getMe_date());

        holder.meetingDate.setText(day + " " + month + " " + year);
    }

    @Override
    public int getItemCount() {
        return meetings.size();
    }

    static class MeetingViewHolder extends RecyclerView.ViewHolder {
        TextView meetingDate;

        MeetingViewHolder(View item) {
            super(item);

            meetingDate = (TextView) item.findViewById(R.id.rowMee_txtDate);
        }
    }

    private void getAllMeetings(List<Model_Meeting> meetingsP) {
        this.meetings.clear();
        this.meetings.addAll(meetingsP);
        notifyDataSetChanged();
    }

    public void meetingAddedNotify() {
        this.meetings = new ArrayList<>(((ModelApplication) ctxt.getApplicationContext()).getMeetings());
        notifyDataSetChanged();
    }
}
