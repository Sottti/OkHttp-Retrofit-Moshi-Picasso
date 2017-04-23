package com.sottocorp.okhttpretrofitmoshipicasso.viewHolders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.sottocorp.okhttpretrofitmoshipicasso.R;
import com.squareup.picasso.Picasso;

public class ImageViewHolder extends RecyclerView.ViewHolder {

  private Context mContext;
  private ImageView mImageView;

  public ImageViewHolder(@NonNull final View itemView) {
    super(itemView);
    init(itemView);
  }

  private void init(final @NonNull View itemView) {
    mContext = itemView.getContext();
    mImageView = (ImageView) itemView.findViewById(R.id.imageView);
  }

  public void onBind(@NonNull final String imageUrl) {
    Picasso
        .with(mContext)
        .load(imageUrl)
        .placeholder(R.drawable.image_sun_smile)
        .error(R.drawable.image_cloud_sad)
        .into(mImageView);
  }
}
