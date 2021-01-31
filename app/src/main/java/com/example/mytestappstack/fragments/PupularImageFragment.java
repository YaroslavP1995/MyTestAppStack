package com.example.mytestappstack.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytestappstack.R;
import com.example.mytestappstack.adapters.EventItemAdapter;
import com.example.mytestappstack.data_manager.DataManager;
import com.example.mytestappstack.model.content.Photo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PupularImageFragment extends Fragment implements EventItemAdapter.RecyclerClickListener {

    @BindView(R.id.events_recycle_view)
    RecyclerView recyclerView;

    private EventItemAdapter eventItemAdapter;
    private List<Photo> eventsList;
    private List<String> photoUrl;
    private Context context;
    private DataManager dataManager;


    public static PupularImageFragment getInstance(List<Photo> eventsList, List<String> photoUrl, Context context, DataManager dataManager) {
        PupularImageFragment fragment = new PupularImageFragment();
        fragment.eventsList = eventsList;
        fragment.photoUrl = photoUrl;
        fragment.context = context;
        fragment.dataManager = dataManager;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_popular, container, false);
        ButterKnife.bind(this, view);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerView.setHasFixedSize(true);
        eventItemAdapter = new EventItemAdapter(eventsList, photoUrl, context, this);
        recyclerView.setAdapter(eventItemAdapter);

        return view;
    }

    @Override
    public void onItemClicked(int position, String photoId, String photoUrl) {
        if (getActivity() != null) {
            DialogFragment dialogFragment = FullScreenImageFragment.getInstance(photoUrl, photoId, dataManager);
            dialogFragment.show(getActivity().getSupportFragmentManager(), "dialogFragment");
        }
    }
}
