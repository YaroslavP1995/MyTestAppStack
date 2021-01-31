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
import com.example.mytestappstack.roomdb.FavoriteImages;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventPopularItemAdapter extends RecyclerView.Adapter<EventPopularItemAdapter.EventHolder> {

    private List<FavoriteImages> favoriteImages;
    private Context context;

    public EventPopularItemAdapter(List<FavoriteImages> favoriteImages, Context context) {
        this.favoriteImages = favoriteImages;
        this.context = context;
    }

    @NonNull
    @Override
    public EventHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_favorite_item_layout, parent, false);
        return new EventHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventHolder holder, int position) {
        String url = favoriteImages.get(position).image_url;

        Glide.with(context)
                .load(url)
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        if (favoriteImages == null)
            return 0;
        return favoriteImages.size();
    }

    static class EventHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_view)
        ImageView imageView;
        @BindView(R.id.check_image_view)
        ImageView checkImageView;
        @BindView(R.id.ll_list_item)
        LinearLayout llListItem;

        EventHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

}
