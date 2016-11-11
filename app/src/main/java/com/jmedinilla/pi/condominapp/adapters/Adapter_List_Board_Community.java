package com.jmedinilla.pi.condominapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jmedinilla.pi.condominapp.ModelApplication;
import com.jmedinilla.pi.condominapp.R;
import com.jmedinilla.pi.condominapp.models.Model_Entry;

import java.util.ArrayList;
import java.util.List;

/**
 * Class created by JMedinilla on 2016-11-06
 * <p>
 * Adapter for the list in the boards screen
 */
public class Adapter_List_Board_Community extends RecyclerView.Adapter<Adapter_List_Board_Community.EntryViewHolder> {

    private List<Model_Entry> entries;
    private Context ctxt;

    public Adapter_List_Board_Community(Context context) {
        this.ctxt = context;
        this.entries = new ArrayList<>(((ModelApplication) ctxt.getApplicationContext()).getSecondEntries());
    }

    @Override
    public EntryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_board, parent, false);
        return new EntryViewHolder(item);
    }

    @Override
    public void onBindViewHolder(EntryViewHolder holder, int position) {
        String month = (String) android.text.format.DateFormat.format("MMM", entries.get(position).getEn_date());
        String year = (String) android.text.format.DateFormat.format("yyyy", entries.get(position).getEn_date());
        String day = (String) android.text.format.DateFormat.format("dd", entries.get(position).getEn_date());

        holder.entryTitle.setText(entries.get(position).getEn_title());
        holder.entryDate.setText(day + " " + month + " " + year);
        holder.entryDesc.setText(entries.get(position).getEn_content());
    }

    @Override
    public int getItemCount() {
        return entries.size();
    }

    static class EntryViewHolder extends RecyclerView.ViewHolder {
        TextView entryTitle;
        TextView entryDate;
        TextView entryDesc;

        EntryViewHolder(View item) {
            super(item);

            entryTitle = (TextView) item.findViewById(R.id.rowBoa_txtTitle);
            entryDate = (TextView) item.findViewById(R.id.rowBoa_txtDate);
            entryDesc = (TextView) item.findViewById(R.id.rowBoa_txtDescription);
        }
    }

    public void getAllEntries(List<Model_Entry> entries) {
        this.entries.clear();
        this.entries.addAll(entries);
        notifyDataSetChanged();
    }

    public void entryAddedNotify() {
        this.entries = new ArrayList<>(((ModelApplication) ctxt.getApplicationContext()).getSecondEntries());
        notifyDataSetChanged();
    }
}
