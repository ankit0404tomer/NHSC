package com.nhsc.special_offers.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nhsc.R;
import com.nhsc.special_offers.fragment.SpecialOffersFragment;
import com.nhsc.special_offers.model.SpecialOffersModel;

import java.util.ArrayList;

public class SpecialofferAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;
    public int mTotalCount;
    ArrayList<SpecialOffersModel.ComponentsBean> mData;

    public SpecialofferAdapter(SpecialOffersFragment specialOffersFragment, ArrayList<SpecialOffersModel.ComponentsBean> specialoffers, int mTotalCount) {
        mData = specialoffers;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = null;
        SpecialOfferViewHolder offerViewHolder = null;
        FooterViewHolder footerViewHolder = null;

        if (viewType == TYPE_ITEM) {

            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.special_offer_cell, null);
            offerViewHolder = new SpecialOfferViewHolder(view);
            return offerViewHolder;

        } else if (viewType == TYPE_FOOTER) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list_view_footer, null);
            footerViewHolder = new FooterViewHolder(view);
            return footerViewHolder;
        }

        return offerViewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }


    public void notifyOffers(ArrayList<SpecialOffersModel.ComponentsBean> specialoffers) {

    }


    @Override
    public int getItemCount() {
        return mData.size() + 1;

    }


    @Override
    public int getItemViewType(int position) {

        if (position < this.mData.size() + 1)
            return TYPE_ITEM;
        else
            return TYPE_FOOTER;


    }

    public int getmTotalCount() {
        return mTotalCount;
    }

    public void setmTotalCount(int mTotalCount) {
        this.mTotalCount = mTotalCount;
        notifyDataSetChanged();
    }

    public class SpecialOfferViewHolder extends RecyclerView.ViewHolder {
        public SpecialOfferViewHolder(View itemView) {
            super(itemView);
        }
    }

    /**
     * Footer view holder.
     */
    public class FooterViewHolder extends RecyclerView.ViewHolder {


        private ImageView imgLoader;
        private TextView mEndOfContentsText;

        /**
         * Instantiates a new Footer view holder.
         *
         * @param itemView the item view
         */
        public FooterViewHolder(View itemView) {
            super(itemView);

            mEndOfContentsText = (TextView) itemView.findViewById(R.id.list_count_footer);


        }
    }
}
