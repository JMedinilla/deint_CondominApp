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
public class Adapter_List_Documents extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Model_Document> documents;
    private Context ctxt;

    public Adapter_List_Documents(Context context) {
        this.ctxt = context;
        this.documents = new ArrayList<>(((ModelApplication) ctxt.getApplicationContext()).getDocuments());
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
                itemLeft = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_documents_left, null);
                break;
            case 2:
                itemRight = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_documents_right, null);
                break;
        }

        if (viewType == 0) {
            return new DocumentViewHolderLeft(itemLeft);
        } else {
            return new DocumentViewHolderRight(itemRight);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position % 2 == 0) {
            DocumentViewHolderLeft holderLeft = (DocumentViewHolderLeft) holder;
            holderLeft.documentTitleLeft.setText(documents.get(position).getDo_title());
            holderLeft.documentDescLeft.setText(documents.get(position).getDo_description());
        } else {
            DocumentViewHolderRight holderRight = (DocumentViewHolderRight) holder;
            holderRight.documentTitleRight.setText(documents.get(position).getDo_title());
            holderRight.documentDescRight.setText(documents.get(position).getDo_description());
        }
    }

    @Override
    public int getItemCount() {
        return documents.size();
    }

    private static class DocumentViewHolderLeft extends RecyclerView.ViewHolder {
        TextView documentTitleLeft;
        TextView documentDescLeft;

        DocumentViewHolderLeft(View item) {
            super(item);

            documentTitleLeft = (TextView) item.findViewById(R.id.rowDocLeft_txtTitle);
            documentDescLeft = (TextView) item.findViewById(R.id.rowDocLeft_txtDescription);
        }
    }

    private static class DocumentViewHolderRight extends RecyclerView.ViewHolder {
        TextView documentTitleRight;
        TextView documentDescRight;

        DocumentViewHolderRight(View item) {
            super(item);

            documentTitleRight = (TextView) item.findViewById(R.id.rowDocRight_txtTitle);
            documentDescRight = (TextView) item.findViewById(R.id.rowDocRight_txtDescription);
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
