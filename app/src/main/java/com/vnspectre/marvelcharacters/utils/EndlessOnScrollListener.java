package com.vnspectre.marvelcharacters.utils;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

/**
 * Created by Spectre on 12/4/17.
 */

public abstract class EndlessOnScrollListener extends RecyclerView.OnScrollListener {

    private static final int STARTING_PAGE_INDEX = 0;

    /**
     * Low threshold to show the onLoad()/Spinner functionality.
     * If you are going to use this for a production app set a higher value
     * for better UX
     */
    private static int sVisibleThreshold = 2;
    private int mCurrentPage = 0;
    private int mPreviousTotalItemCount = 0;
    private boolean mLoading = true;
    private RecyclerView.LayoutManager mLayoutManager;

    public EndlessOnScrollListener(LinearLayoutManager layoutManager) {
        mLayoutManager = layoutManager;
    }

//    public EndlessOnScrollListener(GridLayoutManager layoutManager) {
//        mLayoutManager = layoutManager;
//        sVisibleThreshold = sVisibleThreshold * layoutManager.getSpanCount();
//    }
//
//    public EndlessOnScrollListener(StaggeredGridLayoutManager layoutManager) {
//        mLayoutManager = layoutManager;
//        sVisibleThreshold = sVisibleThreshold * layoutManager.getSpanCount();
//    }
//
//    public int getLastVisibleItem(int[] lastVisibleItemPositions) {
//        int maxSize = 0;
//        for (int i = 0; i < lastVisibleItemPositions.length; i++) {
//            if (i == 0) {
//                maxSize = lastVisibleItemPositions[i];
//            } else if (lastVisibleItemPositions[i] > maxSize) {
//                maxSize = lastVisibleItemPositions[i];
//            }
//        }
//        return maxSize;
//    }

    @Override
    public void onScrolled(RecyclerView view, int dx, int dy) {
        int lastVisibleItemPosition = 0;
        int totalItemCount = mLayoutManager.getItemCount();

        lastVisibleItemPosition = ((LinearLayoutManager) mLayoutManager)
                .findLastVisibleItemPosition();

//        if (mLayoutManager instanceof StaggeredGridLayoutManager) {
//            int[] lastVisibleItemPositions = ((StaggeredGridLayoutManager) mLayoutManager)
//                    .findLastVisibleItemPositions(null);
//            lastVisibleItemPosition = getLastVisibleItem(lastVisibleItemPositions);
//
//        } else if (mLayoutManager instanceof LinearLayoutManager) {
//            lastVisibleItemPosition = ((LinearLayoutManager) mLayoutManager)
//                    .findLastVisibleItemPosition();
//
//        } else if (mLayoutManager instanceof GridLayoutManager) {
//            lastVisibleItemPosition = ((GridLayoutManager) mLayoutManager).findLastVisibleItemPosition();
//        }


        if (totalItemCount < mPreviousTotalItemCount) { // List was cleared
            mCurrentPage = STARTING_PAGE_INDEX;
            mPreviousTotalItemCount = totalItemCount;
            if (totalItemCount == 0) {
                mLoading = true;
            }
        }

        /**
         * If it’s still loading, we check to see if the DataSet count has
         * changed, if so we conclude it has finished loading and update the current page
         * number and total item count (+ 1 due to loading view being added).
         */
        if (mLoading && (totalItemCount > mPreviousTotalItemCount)) {
            mLoading = false;
            mPreviousTotalItemCount = totalItemCount;
        }

        /**
         * If it isn’t currently loading, we check to see if we have breached
         + the visibleThreshold and need to reload more data.
         */
        if (!mLoading && (lastVisibleItemPosition + sVisibleThreshold) > totalItemCount) {
            mCurrentPage++;
            onLoadMore(mCurrentPage, totalItemCount);
            mLoading = true;
        }
    }

    public abstract void onLoadMore(int page, int totalItemsCount);

}
