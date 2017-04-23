package com.sottocorp.okhttpretrofitmoshipicasso.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sottocorp.okhttpretrofitmoshipicasso.R;
import com.sottocorp.okhttpretrofitmoshipicasso.viewHolders.ImageViewHolder;
import java.util.List;

public class ImageLoadingRecyclerViewAdapter extends RecyclerView.Adapter {

  private final List<String> mImages;

  public ImageLoadingRecyclerViewAdapter(@NonNull final List<String> images) {
    mImages = images;
  }

  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    final View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.view_holder_image_view, parent, false);
    return new ImageViewHolder(view);
  }

  @Override
  public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    ((ImageViewHolder) holder).onBind(mImages.get(position));
  }

  @Override
  public int getItemCount() {
    return mImages.size();
  }
}
