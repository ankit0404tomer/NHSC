package com.nhsc.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nhsc.R;
import com.nhsc.Utils.Utils;

import java.util.ArrayList;

/**
 * Created by balu on 08/04/18.
 */

public class CustomPagerAdapter extends PagerAdapter {

    Utils utils;
    private Context mContext;
    private ArrayList<String> items;
    private LayoutInflater layoutInflater;

    public CustomPagerAdapter(Context context) {
        mContext = context;
    }

    public CustomPagerAdapter(ArrayList<String> listOfItems, Context context) {
        this.items = listOfItems;
        this.mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.viewpageritem, container, false);

        TextView tView = (TextView) view.findViewById(R.id.welcome_text);

        tView.setText(items.get(position).toString());

        utils = new Utils(mContext);
        utils.setUbuntu_Light(tView);


        ((ViewPager) container).addView(view);

        return view;
    }

    @Override
    public int getCount() {
        return items.size();
    }


    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == ((View) obj);
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        ((ViewPager) container).removeView(view);
    }
}