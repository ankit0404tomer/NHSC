package com.nhsc.special_offers.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.nhsc.R;
import com.nhsc.base.BaseFragmentV4;
import com.nhsc.special_offers.adapter.SpecialofferAdapter;
import com.nhsc.special_offers.model.SpecialOffersModel;
import com.nhsc.special_offers.presenters.SpecialOfferPresenter;
import com.nhsc.special_offers.presenters.SpecialOfferPresenterImpl;
import com.nhsc.special_offers.views.PaginationScrollListListener;
import com.nhsc.special_offers.views.SpecialOfferView;

import java.util.ArrayList;
import java.util.List;

public class SpecialOffersFragment extends BaseFragmentV4 implements SpecialOfferView {

    private RecyclerView recyGrid;
    private SpecialOfferPresenter mPresenter;
    private LinearLayoutManager mLineayLayoutManager;
    private  SpecialofferAdapter mAdapter;
    private int mHitcount;    private int mPageSize;

    private int mPageNumber = 1;
    private int mTotalCount;
    private boolean isLoading = false;
    private boolean isLastPage = false;
   ArrayList<SpecialOffersModel.ComponentsBean> specialoffers;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        specialoffers=new ArrayList<>();
        mPresenter = new SpecialOfferPresenterImpl(this, getSPRestClientInstance());
        mPresenter.getSpecialOffers(mPageNumber);
    }


    @Override
    protected int getLayoutResId() {
        return R.layout.special_offers;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyGrid = (RecyclerView) view.findViewById(R.id.recy_grid);
        mLineayLayoutManager = new LinearLayoutManager(getActivity());




    }



    private void loadOffers() {
        isLoading = false;
        if (mAdapter == null) {
            mLineayLayoutManager = new LinearLayoutManager(getActivity());
            mAdapter = new SpecialofferAdapter(this, specialoffers,mTotalCount);
            recyGrid.setLayoutManager(mLineayLayoutManager);
            recyGrid.setAdapter(mAdapter);
           // recyGrid.addItemDecoration(new SimpleDividerLine(this));
        } else
            mAdapter.notifyOffers(specialoffers);


        recyGrid.addOnScrollListener(new PaginationScrollListListener(mLineayLayoutManager, 5) {
            @Override
            protected void loadMoreItems() {

                if (mHitcount > 0) {

                    isLoading = true;
                    ++mPageNumber;
                    mPresenter.getSpecialOffers(mPageNumber);
                    --mHitcount;
                } else {
                    isLastPage = true;
                }

            }

            @Override
            public int getTotalPageCount() {
                return mTotalCount;
            }

            @Override
            public boolean isLastPage() {
                return isLastPage;
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }
        });

    }

    @Override
    public void onSpecialOfferSuccess(SpecialOffersModel data) {

        if (data != null) {
            specialoffers.addAll(data.getComponents());
            loadOffers();
            mTotalCount = data.getTotalcount();
            mAdapter.setmTotalCount(mTotalCount);
           /* mPageSize = Integer.valueOf(data.getComponents().size());
            mHitcount = mTotalCount / mPageSize;
            --mHitcount;

            if (mTotalCount % mPageSize > 0) {
                ++mHitcount;
            }

*/
        }

    }

    @Override
    public void onSpecialOfferFailure(String message) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    mPresenter.onDestroy();
    }
}