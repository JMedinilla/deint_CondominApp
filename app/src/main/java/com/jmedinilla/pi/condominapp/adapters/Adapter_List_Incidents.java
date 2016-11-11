package com.jmedinilla.pi.condominapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jmedinilla.pi.condominapp.ModelApplication;
import com.jmedinilla.pi.condominapp.R;
import com.jmedinilla.pi.condominapp.models.Model_Incident;

import java.util.ArrayList;
import java.util.List;

/**
 * Class created by JMedinilla on 2016-10-29
 * <p>
 * Adapter for the list in the incidents screen
 */
public class Adapter_List_Incidents extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Model_Incident> incidents;
    private Context ctxt;

    public Adapter_List_Incidents(Context context) {
        this.ctxt = context;
        this.incidents = new ArrayList<>(((ModelApplication) ctxt.getApplicationContext()).getIncidents());
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
                itemLeft = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_incidents_left, null);
                break;
            case 2:
                itemRight = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_incidents_right, null);
                break;
        }

        if (viewType == 0) {
            return new IncidentViewHolderLeft(itemLeft);
        } else {
            return new IncidentViewHolderRight(itemRight);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String month = (String) android.text.format.DateFormat.format("MMM", incidents.get(position).getIn_date());
        String year = (String) android.text.format.DateFormat.format("yyyy", incidents.get(position).getIn_date());
        String day = (String) android.text.format.DateFormat.format("dd", incidents.get(position).getIn_date());

        if (position % 2 == 0) {
            IncidentViewHolderLeft holderLeft = (IncidentViewHolderLeft) holder;
            //image
            holderLeft.incidentTitleLeft.setText(incidents.get(position).getIn_title());
            holderLeft.incidentDateLeft.setText(day + " " + month + " " + year);
            holderLeft.incidentAuthorLeft.setText(incidents.get(position).getIn_user().getUs_name());
        } else {
            IncidentViewHolderRight holderRight = (IncidentViewHolderRight) holder;
            //image
            holderRight.incidentTitleRight.setText(incidents.get(position).getIn_title());
            holderRight.incidentDateRight.setText(day + " " + month + " " + year);
            holderRight.incidentAuthorRight.setText(incidents.get(position).getIn_user().getUs_name());
        }
    }

    @Override
    public int getItemCount() {
        return incidents.size();
    }

    private static class IncidentViewHolderLeft extends RecyclerView.ViewHolder {
        ImageView incidentImgLeft;
        TextView incidentTitleLeft;
        TextView incidentDateLeft;
        TextView incidentAuthorLeft;

        IncidentViewHolderLeft(View item) {
            super(item);
            incidentImgLeft = (ImageView) item.findViewById(R.id.rowIncLeft_imgLogo);
            incidentTitleLeft = (TextView) item.findViewById(R.id.rowIncLeft_txtTitle);
            incidentDateLeft = (TextView) item.findViewById(R.id.rowIncLeft_txtDate);
            incidentAuthorLeft = (TextView) item.findViewById(R.id.rowIncLeft_txtAuthor);
        }
    }

    private static class IncidentViewHolderRight extends RecyclerView.ViewHolder {
        ImageView incidentImgRight;
        TextView incidentTitleRight;
        TextView incidentDateRight;
        TextView incidentAuthorRight;

        IncidentViewHolderRight(View item) {
            super(item);
            incidentImgRight = (ImageView) item.findViewById(R.id.rowIncRight_imgLogo);
            incidentTitleRight = (TextView) item.findViewById(R.id.rowIncRight_txtTitle);
            incidentDateRight = (TextView) item.findViewById(R.id.rowIncRight_txtDate);
            incidentAuthorRight = (TextView) item.findViewById(R.id.rowIncRight_txtAuthor);
        }
    }

    public void getAllIncidents(List<Model_Incident> incidents) {
        this.incidents.clear();
        this.incidents.addAll(incidents);
        notifyDataSetChanged();
    }

    public void incidentAddedNotify() {
        this.incidents = new ArrayList<>(((ModelApplication) ctxt.getApplicationContext()).getIncidents());
        notifyDataSetChanged();
    }
}
