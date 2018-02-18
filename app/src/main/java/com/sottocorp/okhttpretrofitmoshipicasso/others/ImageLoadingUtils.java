package com.sottocorp.okhttpretrofitmoshipicasso.others;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

public class ImageLoadingUtils {

  public static void loadImageFromUrl(
      @NonNull final ImageView imageView,
      @NonNull final String imageUrl,
      @DrawableRes final int fallbackImage) {
    if (imageUrl.isEmpty()) {
      imageView.setImageResource(fallbackImage);
    } else {
      final Context context = imageView.getContext();

      if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
        Picasso.with(context)
            .load(imageUrl)
            .placeholder(fallbackImage)
            .error(fallbackImage)
            .into(imageView);
      } else {
        Picasso.with(context)
            .load(imageUrl)
            .placeholder(getCompatibleDrawable(context, fallbackImage))
            .error(getCompatibleDrawable(context, fallbackImage))
            .into(imageView);
      }
    }
  }

  private static Drawable getCompatibleDrawable(
      @NonNull final Context context, @DrawableRes final int drawableRes) {
    return ContextCompat.getDrawable(context, drawableRes).getCurrent();
  }

}
