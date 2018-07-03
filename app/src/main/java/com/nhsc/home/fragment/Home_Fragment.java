package com.nhsc.home.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.nhsc.home.adapter.Home_screen_grid_adapter;
import com.nhsc.R;
import com.nhsc.home.model.HomeModel;

/**
 * Created by balu on 24/04/18.
 */

public class Home_Fragment extends Fragment {
    GridView gridView;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.home_fragment, container, false);
         gridView = (GridView) view.findViewById(R.id.gridview);

        return view;

    }

    public void getHomeData(HomeModel data) {
        // Instance of ImageAdapter Class
        gridView.setAdapter(new Home_screen_grid_adapter(view.getContext(),data));

    }
}
