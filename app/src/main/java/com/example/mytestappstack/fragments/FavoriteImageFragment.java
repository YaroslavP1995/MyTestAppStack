package com.example.mytestappstack.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytestappstack.R;
import com.example.mytestappstack.adapters.EventPopularItemAdapter;
import com.example.mytestappstack.roomdb.FavoriteImages;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavoriteImageFragment extends Fragment {
    @BindView(R.id.events_recycle_view)
    RecyclerView recyclerView;

    private EventPopularItemAdapter eventPopularItemAdapter;
    private List<FavoriteImages> favoriteImages;
    private Context context;

    public static FavoriteImageFragment getInstance(List<FavoriteImages> favoriteImages, Context context) {
        FavoriteImageFragment fragment = new FavoriteImageFragment();
        fragment.favoriteImages = favoriteImages;
        fragment.context = context;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        ButterKnife.bind(this, view);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerView.setHasFixedSize(true);
        eventPopularItemAdapter = new EventPopularItemAdapter(favoriteImages, context);
        recyclerView.setAdapter(eventPopularItemAdapter);
        return view;
    }
}
