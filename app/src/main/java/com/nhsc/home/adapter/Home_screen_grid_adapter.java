package com.nhsc.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nhsc.R;
import com.nhsc.Utils.Utils;
import com.nhsc.home.model.HomeModel;
import com.squareup.picasso.Picasso;

/**
 * Created by balu on 24/04/18.
 */

public class Home_screen_grid_adapter extends BaseAdapter {

    Utils utils;
    private Context mContext;
    private HomeModel mData;

    public Home_screen_grid_adapter(Context context, HomeModel data) {
        this.mContext = context;
        utils = new Utils(mContext);
        mData=data;
    }

    @Override
    public int getCount() {
        return mData.getComponents().size();
    }

    @Override
    public Object getItem(int position) {
        return mData.getComponents().size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_item, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_item_text);
            ImageView imageView = (ImageView) grid.findViewById(R.id.grid_item_image);
            HomeModel.ComponentsBean componentsBean = mData.getComponents().get(position);
            textView.setText(componentsBean.getCategoriesName());
            utils.setUbuntu_Light(textView);


            Picasso.get()
                    .load(componentsBean.getCategoriesImage())
                    .into(imageView);
        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}
