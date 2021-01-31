package com.example.mytestappstack.fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.bumptech.glide.Glide;
import com.example.mytestappstack.R;
import com.example.mytestappstack.data_manager.DataCallBack;
import com.example.mytestappstack.data_manager.DataManager;
import com.example.mytestappstack.roomdb.FavoriteImages;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class FullScreenImageFragment extends DialogFragment implements DataCallBack {

    @BindView(R.id.im_fullScreen)
    ImageView im_fullScreen;
    @BindView(R.id.ic_selector)
    ImageView ic_selector;

    private Unbinder unbinder;
    private String photoUrl;
    private DataManager dataManager;
    private String imgId;

    public static FullScreenImageFragment getInstance(String photoUrl, String imgId, DataManager dataManager) {
        FullScreenImageFragment fragment = new FullScreenImageFragment();
        fragment.photoUrl = photoUrl;
        fragment.dataManager = dataManager;
        fragment.imgId = imgId;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_full_screen, container, false);
        unbinder = ButterKnife.bind(this, view);
        Glide.with(im_fullScreen.getContext())
                .load(photoUrl)
                .into(im_fullScreen);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        }
    }

    @OnClick({R.id.fl_make_favorite})
    void setLocation(View view) {
        switch (view.getId()) {
            case R.id.fl_make_favorite:
                ic_selector.setImageDrawable(ic_selector.getResources().getDrawable(R.drawable.ic_star_gradient_f));
                dataManager.addData(this, imgId, photoUrl);
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void dataAdded() {

    }

    @Override
    public void errorAdded() {

    }

    @Override
    public void loadFavoriteImage(List<FavoriteImages> favoriteImages) {

    }
}
