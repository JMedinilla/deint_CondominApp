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
public class Adapter_List_Incidents extends RecyclerView.Adapter<Adapter_List_Incidents.IncidentViewHolder> {

    private List<Model_Incident> incidents;
    private Context ctxt;

    public Adapter_List_Incidents(Context context) {
        this.ctxt = context;
        this.incidents = new ArrayList<>(((ModelApplication) ctxt.getApplicationContext()).getIncidents());
    }

    @Override
    public IncidentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_incidents_left, null);
        return new IncidentViewHolder(item);
    }

    @Override
    public void onBindViewHolder(IncidentViewHolder holder, int position) {
        String month = (String) android.text.format.DateFormat.format("MMM", incidents.get(position).getIn_date());
        String year = (String) android.text.format.DateFormat.format("yyyy", incidents.get(position).getIn_date());
        String day = (String) android.text.format.DateFormat.format("dd", incidents.get(position).getIn_date());

        //holder.incidentImg.setImage
        holder.incidentTitle.setText(incidents.get(position).getIn_title());
        holder.incidentDate.setText(day + " " + month + " " + year);
        holder.incidentAuthor.setText(incidents.get(position).getIn_user().getUs_name());
    }

    @Override
    public int getItemCount() {
        return incidents.size();
    }

    static class IncidentViewHolder extends RecyclerView.ViewHolder {
        ImageView incidentImg;
        TextView incidentTitle;
        TextView incidentDate;
        TextView incidentAuthor;

        IncidentViewHolder(View item) {
            super(item);
            incidentImg = (ImageView) item.findViewById(R.id.rowIncLeft_imgLogo);
            incidentTitle = (TextView) item.findViewById(R.id.rowIncLeft_txtTitle);
            incidentDate = (TextView) item.findViewById(R.id.rowIncLeft_txtDate);
            incidentAuthor = (TextView) item.findViewById(R.id.rowIncLeft_txtAuthor);
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
