package com.example.okhttpretrofitmoshipicasso.viewHolders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.sottocorp.okhttpretrofitmoshipicasso.R;
import com.squareup.picasso.Picasso;

/**
 * View holder for an image
 */
public class ViewHolderImage extends RecyclerView.ViewHolder
{
    private Context mContext;
    private final ImageView mImageView;

    public ViewHolderImage(@NonNull final View itemView)
    {
        super(itemView);

        mContext = itemView.getContext();
        mImageView = (ImageView) itemView.findViewById(R.id.imageView);
    }

    /**
     * Sets the data in the view holder
     *
     * @param imageUrl is the image Url to get the image
     */
    public void setData(@NonNull final String imageUrl)
    {
        Picasso
                .with(mContext)
                .load(imageUrl)
                .placeholder(R.drawable.ic_sun_smile)
                .error(R.drawable.ic_cloud_sad)
                .into(mImageView);
    }
}
