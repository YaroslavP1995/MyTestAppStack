package com.example.mytestappstack;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.mytestappstack.data_manager.DataCallBack;
import com.example.mytestappstack.data_manager.DataManager;
import com.example.mytestappstack.fragments.FavoriteImageFragment;
import com.example.mytestappstack.fragments.PupularImageFragment;
import com.example.mytestappstack.model.content.Interestingness;
import com.example.mytestappstack.model.content.Photo;
import com.example.mytestappstack.model.content.SizeModel;
import com.example.mytestappstack.presenter.MainPresenter;
import com.example.mytestappstack.roomdb.FavoriteImages;
import com.example.mytestappstack.view.MainView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements MainView, DataCallBack {
    @BindView(R.id.tv_popular)
    TextView tvPopular;
    @BindView(R.id.tv_favorite)
    TextView tvFavorite;

    private Unbinder unbinder;
    private MainPresenter presenter;
    private List<Photo> listPhoto = new ArrayList<>();
    private List<String> newUrl = new ArrayList<>();
    private List<FavoriteImages> favoriteImages = new ArrayList<>();
    protected Fragment currentFragment;
    protected PupularImageFragment pupularImageFragment;
    protected FavoriteImageFragment favoriteImageFragment;

    private DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        presenter = new MainPresenter(this);
        presenter.getType("100", "2");
    }

    @Override
    protected void onStart() {
        super.onStart();
        dataManager = new DataManager(this);
        dataManager.loadFavoriteImage(this);
    }

    @Override
    public void OnInterestingness(@NonNull Interestingness typeModel) {
        for (int i = 0; i < typeModel.getPhotos().getPhoto().size(); i++) {
            presenter.getSizeImage(typeModel.getPhotos().getPhoto().get(i).getId());
        }
        listPhoto = new ArrayList<>(typeModel.getPhotos().getPhoto());
    }

    @Override
    public void OnGetImageSize(@NonNull SizeModel typeModel) {
        for (int i = 0; i < typeModel.getSizes().getSize().size(); i++) {
            if (typeModel.getSizes().getSize().get(i).getLabel().equals("Large Square")) {
                newUrl.add(typeModel.getSizes().getSize().get(i).getSource());
            }
        }
        pupularImageFragment = PupularImageFragment.getInstance(listPhoto, newUrl, this, dataManager);
        currentFragment = pupularImageFragment;
        replaceFragment(currentFragment, true);
        tvPopular.setTextColor(getResources().getColor(R.color.purple_200));
    }

    @Override
    public void handleError(Throwable throwable) {
        Log.d(MainActivity.class.getName(), "throw " + throwable.getMessage());
    }


    @OnClick({R.id.tv_popular, R.id.tv_favorite})
    void setLocation(View view) {
        switch (view.getId()) {
            case R.id.tv_popular:
                pupularImageFragment = PupularImageFragment.getInstance(listPhoto, newUrl, this, dataManager);
                currentFragment = pupularImageFragment;
                replaceFragment(currentFragment, true);
                tvPopular.setTextColor(getResources().getColor(R.color.purple_200));
                tvFavorite.setTextColor(getResources().getColor(R.color.black));
                break;
            case R.id.tv_favorite:
                favoriteImageFragment = FavoriteImageFragment.getInstance(favoriteImages, this);
                currentFragment = favoriteImageFragment;
                replaceFragment(currentFragment, true);
                tvPopular.setTextColor(getResources().getColor(R.color.black));
                tvFavorite.setTextColor(getResources().getColor(R.color.purple_200));
                break;
        }
    }

    public void replaceFragment(Fragment fragment, boolean toBackStack) {
        currentFragment = fragment;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_container, currentFragment, "ShowCurrentFragmentTag");
        if (toBackStack) {
            fragmentTransaction.addToBackStack("ShowCurrentFragmentTag").commit();
        } else {
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void dataAdded() {
        Log.d(MainActivity.class.getName(), "data is added");
    }

    @Override
    public void errorAdded() {
    }

    @Override
    public void loadFavoriteImage(List<FavoriteImages> favoriteImages) {
        this.favoriteImages = favoriteImages;
    }
}