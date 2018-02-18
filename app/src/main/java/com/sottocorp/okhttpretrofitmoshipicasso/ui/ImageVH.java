package com.sottocorp.okhttpretrofitmoshipicasso.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import com.sottocorp.okhttpretrofitmoshipicasso.R;
import com.sottocorp.okhttpretrofitmoshipicasso.databinding.ImageLoadingVhBinding;
import com.sottocorp.okhttpretrofitmoshipicasso.others.ImageLoadingUtils;

class ImageVH extends RecyclerView.ViewHolder {

  private ImageLoadingVhBinding mViewBinding;

  ImageVH(@NonNull final ImageLoadingVhBinding viewBinding) {
    super(viewBinding.getRoot());
    mViewBinding = viewBinding;
  }

  void onBind(@NonNull final String imageUrl) {
    ImageLoadingUtils.loadImageFromUrl(mViewBinding.image, imageUrl, R.drawable.image_cloud_sad);
  }
}
