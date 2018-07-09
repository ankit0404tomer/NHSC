package com.nhsc.home.adapter;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nhsc.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.ViewHolder> {

    public onClicked mCallback;
    Set<String> keySet;
    ArrayList<String> mkeys;
    ChildDrawerAdapter mAdapter;
    Context mContext;
    Boolean[] mSparseArray;
    private HashMap<String, ArrayList<String>> mData;

    public DrawerAdapter(Context context, HashMap<String, ArrayList<String>> mDrawerData) {
        mData = mDrawerData;
        mContext = context;
        mkeys = new ArrayList<>();
        mCallback = (onClicked) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.drawer_cell, parent, false);
        keySet = mData.keySet();
        mSparseArray = new Boolean[keySet.size()];
        for (Iterator<String> it = keySet.iterator(); it.hasNext(); ) {
            mkeys.add(it.next());
        }

        for (int i = 0; i <= keySet.size() - 1; i++) {
            mSparseArray[i] = false;
        }


        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.mTitle.setText(mkeys.get(position));

        if (mData.get(mkeys.get(position)).size() > 0)
            holder.imgPlus.setVisibility(View.VISIBLE);
        else
            holder.imgPlus.setVisibility(View.GONE);


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public interface onClicked {
        void onSignOutClicked();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTitle;
        RecyclerView childRecyclerview;
        ImageView imgPlus;

        public ViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.txt_title);
            childRecyclerview = (RecyclerView) itemView.findViewById(R.id.child_recyclerview);
            imgPlus = (ImageView) itemView.findViewById(R.id.img_plus);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mData.get(mkeys.get(getAdapterPosition())).get(0).equals("Sign out")) {
                        mCallback.onSignOutClicked();
                        return;
                    }

                    if (mData.get(mkeys.get(getAdapterPosition())).size() > 0) {
                        imgPlus.setVisibility(View.VISIBLE);

                        if (mSparseArray[getAdapterPosition()] == false) {
                            imgPlus.setImageDrawable(mContext.getResources().getDrawable(R.drawable.minus));

                            childRecyclerview.setVisibility(View.VISIBLE);
                            mAdapter = new ChildDrawerAdapter(mData.get(mkeys.get(getAdapterPosition())));
                            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mContext);
                            childRecyclerview.setLayoutManager(mLayoutManager);
                            childRecyclerview.setItemAnimator(new DefaultItemAnimator());
                            childRecyclerview.setAdapter(mAdapter);
                            mSparseArray[getAdapterPosition()] = true;
                        } else {
                            mSparseArray[getAdapterPosition()] = false;
                            childRecyclerview.setVisibility(View.GONE);

                            imgPlus.setImageDrawable(mContext.getResources().getDrawable(R.drawable.plus));

                        }
                    } else


                    return;


                }
            });
        }


    }
}
