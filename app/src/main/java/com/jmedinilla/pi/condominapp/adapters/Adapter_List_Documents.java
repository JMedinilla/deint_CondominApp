package com.jmedinilla.pi.condominapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jmedinilla.pi.condominapp.ModelApplication;
import com.jmedinilla.pi.condominapp.R;
import com.jmedinilla.pi.condominapp.models.Model_Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Class created by JMedinilla on 2016-10-29
 * <p>
 * Adapter for the list in the documents screen
 */
public class Adapter_List_Documents extends RecyclerView.Adapter<Adapter_List_Documents.DocumentViewHolder> {

    private List<Model_Document> documents;
    private Context ctxt;

    public Adapter_List_Documents(Context context) {
        this.ctxt = context;
        this.documents = new ArrayList<>(((ModelApplication) ctxt.getApplicationContext()).getDocuments());
    }

    @Override
    public DocumentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_documents_left, null);
        return new DocumentViewHolder(item);
    }

    @Override
    public void onBindViewHolder(DocumentViewHolder holder, int position) {
        holder.documentTitle.setText(documents.get(position).getDo_title());
        holder.documentDesc.setText(documents.get(position).getDo_description());
    }

    @Override
    public int getItemCount() {
        return documents.size();
    }

    static class DocumentViewHolder extends RecyclerView.ViewHolder {
        TextView documentTitle;
        TextView documentDesc;

        DocumentViewHolder(View item) {
            super(item);

            documentTitle = (TextView) item.findViewById(R.id.rowDocLeft_txtTitle);
            documentDesc = (TextView) item.findViewById(R.id.rowDocLeft_txtDescription);
        }
    }

    public void getAllDocuments(List<Model_Document> documents) {
        this.documents.clear();
        this.documents.addAll(documents);
        notifyDataSetChanged();
    }

    public void documentAddedNotify() {
        this.documents = new ArrayList<>(((ModelApplication) ctxt.getApplicationContext()).getDocuments());
        notifyDataSetChanged();
    }
}
