package com.example.okhttpretrofitmoshipicasso.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sottocorp.okhttpretrofitmoshipicasso.R;
import com.example.okhttpretrofitmoshipicasso.viewHolders.ViewHolderImage;

import java.util.List;

/**
 * Adapter for the image loading recycler view
 */
public class ImageLoadingRecyclerViewAdapter extends RecyclerView.Adapter
{
    private final List<String> mImages;

    public ImageLoadingRecyclerViewAdapter(@NonNull final List<String> images)
    {
        mImages = images;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_holder_image_view, parent, false);

        return new ViewHolderImage(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        final ViewHolderImage viewHolderImage =
                (ViewHolderImage) holder;

        viewHolderImage.setData(mImages.get(position));
    }

    @Override
    public int getItemCount()
    {
        return mImages.size();
    }
}
