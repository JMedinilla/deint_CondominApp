package com.jmedinilla.pi.condominapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jmedinilla.pi.condominapp.ModelApplication;
import com.jmedinilla.pi.condominapp.R;
import com.jmedinilla.pi.condominapp.models.Model_Meeting;

/**
 * Class created by JMedinilla on 2016-11-12
 * <p>
 * Adapter for the list in the meetings screen
 */
public class Adapter_List_Meetings_ListView extends ArrayAdapter<Model_Meeting> {
    public Adapter_List_Meetings_ListView(Context context) {
        super(context, R.layout.activity_main_list_meetings, ((ModelApplication)context.getApplicationContext()).getMeetings());
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        MeetingHolder holder;
        LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null)
            holder = new MeetingHolder();
        else
            holder = (MeetingHolder)view.getTag();

        view = layoutInflater.inflate(R.layout.row_meetings, parent, false);
        holder.txtDate = (TextView) view.findViewById(R.id.rowMee_txtDate);

        view.setTag(holder);

        Model_Meeting meet = getItem(position);
        if (meet != null) {
            String month = (String) DateFormat.format("MMM", meet.getMe_date());
            String year = (String) DateFormat.format("yyyy", meet.getMe_date());
            String day = (String) DateFormat.format("dd", meet.getMe_date());

            holder.txtDate.setText(day + " " + month + " " + year);
        }

        return view;
    }

    private class MeetingHolder {
        TextView txtDate;
    }
}
