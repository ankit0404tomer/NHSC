package com.nhsc.special_offers.views;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


/**
 * Created by emb-ankitom on 6/9/17.
 */

public abstract class PaginationScrollListListener extends RecyclerView.OnScrollListener {

    int mVisibleThreshold;
    private LinearLayoutManager layoutManager;

    public PaginationScrollListListener(LinearLayoutManager layoutManager, int visibleThreshHold) {
        this.layoutManager = layoutManager;
        this.mVisibleThreshold = visibleThreshHold;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        int visibleItemCount = layoutManager.getChildCount();
        int totalItemCount = layoutManager.getItemCount();
        int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();

        if (!isLoading() && !isLastPage()) {
           /* if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                    && firstVisibleItemPosition >= 0) {
                loadMoreItems();
            }*/

            if ((totalItemCount - visibleItemCount)
                    <= (firstVisibleItemPosition + mVisibleThreshold)) {
                loadMoreItems();
            }
        }
    }

    protected abstract void loadMoreItems();

    public abstract int getTotalPageCount();

    public abstract boolean isLastPage();

    public abstract boolean isLoading();
}
