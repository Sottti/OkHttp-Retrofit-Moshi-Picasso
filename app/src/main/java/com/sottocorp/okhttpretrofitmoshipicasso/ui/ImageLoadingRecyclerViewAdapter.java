package com.sottocorp.okhttpretrofitmoshipicasso.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.sottocorp.okhttpretrofitmoshipicasso.databinding.ImageLoadingVhBinding;
import java.util.List;

public class ImageLoadingRecyclerViewAdapter extends RecyclerView.Adapter<ImageVH> {

  private final List<String> mImages;

  ImageLoadingRecyclerViewAdapter(@NonNull final List<String> images) {
    mImages = images;
  }

  @Override
  public ImageVH onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ImageVH(
        ImageLoadingVhBinding.inflate(LayoutInflater.from(parent.getContext())));
  }

  @Override
  public void onBindViewHolder(ImageVH holder, int position) {
    holder.onBind(mImages.get(position));
  }

  @Override
  public int getItemCount() {
    return mImages.size();
  }
}
