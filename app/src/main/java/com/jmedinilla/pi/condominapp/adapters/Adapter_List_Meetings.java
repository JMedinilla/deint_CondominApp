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
public class Adapter_List_Meetings extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Model_Meeting> meetings;
    private Context ctxt;

    public Adapter_List_Meetings(Context context) {
        this.ctxt = context;
        this.meetings = new ArrayList<>(((ModelApplication) ctxt.getApplicationContext()).getMeetings());
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2 * 2;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLeft = null;
        View itemRight = null;

        switch (viewType) {
            case 0:
                itemLeft = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_meetings_left, null);
                break;
            case 2:
                itemRight = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_meetings_right, null);
                break;
        }

        if (viewType == 0) {
            return new MeetingViewHolderLeft(itemLeft);
        } else {
            return new MeetingViewHolderRight(itemRight);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String month = (String) DateFormat.format("MMM", meetings.get(position).getMe_date());
        String year = (String) DateFormat.format("yyyy", meetings.get(position).getMe_date());
        String day = (String) DateFormat.format("dd", meetings.get(position).getMe_date());

        if (position % 2 == 0) {
            MeetingViewHolderLeft holderLeft = (MeetingViewHolderLeft) holder;
            ((MeetingViewHolderLeft) holder).meetingDateLeft.setText(day + " " + month + " " + year);
        } else {
            MeetingViewHolderRight holderRight = (MeetingViewHolderRight) holder;
            ((MeetingViewHolderRight) holder).meetingDateRight.setText(day + " " + month + " " + year);
        }
    }

    @Override
    public int getItemCount() {
        return meetings.size();
    }

    private static class MeetingViewHolderLeft extends RecyclerView.ViewHolder {
        TextView meetingDateLeft;

        MeetingViewHolderLeft(View item) {
            super(item);

            meetingDateLeft = (TextView) item.findViewById(R.id.rowMeeLeft_txtDate);
        }
    }

    private static class MeetingViewHolderRight extends RecyclerView.ViewHolder {
        TextView meetingDateRight;

        MeetingViewHolderRight(View item) {
            super(item);

            meetingDateRight = (TextView) item.findViewById(R.id.rowMeeRight_txtDate);
        }
    }

    public void getAllMeetings(List<Model_Meeting> meetings) {
        this.meetings.clear();
        this.meetings.addAll(meetings);
        notifyDataSetChanged();
    }

    public void meetingAddedNotify() {
        this.meetings = new ArrayList<>(((ModelApplication) ctxt.getApplicationContext()).getMeetings());
        notifyDataSetChanged();
    }
}
