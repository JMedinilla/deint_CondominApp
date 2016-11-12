package com.jmedinilla.pi.condominapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jmedinilla.pi.condominapp.ModelApplication;
import com.jmedinilla.pi.condominapp.R;
import com.jmedinilla.pi.condominapp.models.Model_Note;

import java.util.ArrayList;
import java.util.List;

/**
 * Class created by JMedinilla on 2016-10-29
 * <p>
 * Adapter for the list in the diary screen
 */
public class Adapter_List_Diary extends RecyclerView.Adapter<Adapter_List_Diary.NoteViewHolder> {

    private static final int TYPE_NOTE_DATE = 60;
    private static final int TYPE_NOTE_TITLE = 61;
    private static boolean ASC_TITLE = true;
    private static boolean ASC_DATE = true;

    private List<Model_Note> notes;
    private Context ctxt;

    public Adapter_List_Diary(Context context) {
        this.ctxt = context;
        this.notes = new ArrayList<>(((ModelApplication) ctxt.getApplicationContext()).getNotes());
    }

    public void sortDiary(int type) {
        boolean ASC = false;

        if (type == TYPE_NOTE_DATE) { ASC = ASC_TITLE; ASC_TITLE = !ASC_TITLE; }
        else if (type == TYPE_NOTE_TITLE) { ASC = ASC_DATE; ASC_DATE = !ASC_DATE; }

        getAllNotes(((ModelApplication)ctxt.getApplicationContext()).getNotes(ASC, type));
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_diary, parent, false);
        return new NoteViewHolder(item);
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        String month = (String) android.text.format.DateFormat.format("MMM", notes.get(position).getNo_date());
        String year = (String) android.text.format.DateFormat.format("yyyy", notes.get(position).getNo_date());
        String day = (String) android.text.format.DateFormat.format("dd", notes.get(position).getNo_date());

        holder.noteTitle.setText(notes.get(position).getNo_title());
        holder.noteDate.setText(day + " " + month + " " + year);
        holder.noteDesc.setText(notes.get(position).getNo_content());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    static class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView noteTitle;
        TextView noteDate;
        TextView noteDesc;

        NoteViewHolder(View item) {
            super(item);

            noteTitle = (TextView) item.findViewById(R.id.rowDia_txtTitle);
            noteDate = (TextView) item.findViewById(R.id.rowDia_txtDate);
            noteDesc = (TextView) item.findViewById(R.id.rowDia_txtDescription);
        }
    }

    private void getAllNotes(List<Model_Note> notesP) {
        this.notes.clear();
        this.notes.addAll(notesP);
        notifyDataSetChanged();
    }

    public void noteAddedNotify() {
        this.notes = new ArrayList<>(((ModelApplication) ctxt.getApplicationContext()).getNotes());
        notifyDataSetChanged();
    }
}
