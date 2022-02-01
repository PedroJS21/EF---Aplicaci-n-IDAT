package com.example.app.network;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.R;
import com.example.app.network.AnnounceEntry;
import com.example.app.network.ImageRequester;
import com.example.app.ui.home.AnnounceCardViewHolder;

import java.util.List;

public class AnnounceCardRecyclerAdapter extends RecyclerView.Adapter<AnnounceCardViewHolder> {
    private List<AnnounceEntry> announceList;
    private ImageRequester imageRequester;

    public AnnounceCardRecyclerAdapter(List<AnnounceEntry> announceList) {
        this.announceList = announceList;
        imageRequester = ImageRequester.getInstance();
    }

    @NonNull
    @Override
    public AnnounceCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType ){
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_home_card, parent, false);
        return new AnnounceCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull AnnounceCardViewHolder holder, int position) {
        if(announceList != null & position < announceList.size()) {
            AnnounceEntry announce = announceList.get(position);
            holder.announceTitle.setText(announce.title);
            holder.announceContent.setText(announce.content);
            imageRequester.setImageFromUrl(holder.announceImage, announce.url);
        }
    }

    @Override
    public  int getItemCount() {
        return announceList.size();
    }
}
