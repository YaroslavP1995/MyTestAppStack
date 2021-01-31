package com.example.mytestappstack.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mytestappstack.R;
import com.example.mytestappstack.model.content.Photo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventItemAdapter extends RecyclerView.Adapter<EventItemAdapter.EventHolder> {

    private List<Photo> eventsList;
    private List<String> photoUrl;
    private Context context;
    private RecyclerClickListener recyclerClickListener;

    public EventItemAdapter(List<Photo> eventsList, List<String> photoUrl, Context context, RecyclerClickListener recyclerClickListener) {
        this.eventsList = eventsList;
        this.photoUrl = photoUrl;
        this.context = context;
        this.recyclerClickListener = recyclerClickListener;
    }

    @NonNull
    @Override
    public EventHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item_layout, parent, false);
        return new EventHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventHolder holder, int position) {
        String url = photoUrl.get(position);

        Glide.with(context)
                .load(url)
                .into(holder.imageView);


        holder.llListItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerClickListener.onItemClicked(position, eventsList.get(position).getId(), url);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (photoUrl == null)
            return 0;
        return photoUrl.size();
    }

    static class EventHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_view)
        ImageView imageView;
        @BindView(R.id.ll_list_item)
        LinearLayout llListItem;

        EventHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    public interface RecyclerClickListener {
        void onItemClicked(int position, String photoId, String photoUrl);
    }
}
