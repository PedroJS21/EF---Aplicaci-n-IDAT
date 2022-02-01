package com.example.app.ui.home;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.app.R;

public class AnnounceCardViewHolder extends RecyclerView.ViewHolder {
    public NetworkImageView announceImage;
    public TextView announceTitle;
    public TextView announceContent;

    public AnnounceCardViewHolder(@NonNull View itemView) {
        super(itemView);
        announceImage = itemView.findViewById(R.id.announce_image);
        announceTitle = itemView.findViewById(R.id.announce_title);
        announceContent = itemView.findViewById(R.id.announce_content);
    }
}
