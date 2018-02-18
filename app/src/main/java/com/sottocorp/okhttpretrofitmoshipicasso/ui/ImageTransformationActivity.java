package com.sottocorp.okhttpretrofitmoshipicasso.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.sottocorp.okhttpretrofitmoshipicasso.R;
import com.sottocorp.okhttpretrofitmoshipicasso.databinding.ImageTransformationActivityBinding;
import com.sottocorp.okhttpretrofitmoshipicasso.others.CircleTransform;
import com.squareup.picasso.Picasso;

public class ImageTransformationActivity extends AppCompatActivity {

  private final static String sImageUrl = "https://goo.gl/XOXAXG";
  private ImageTransformationActivityBinding mViewBinding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mViewBinding = DataBindingUtil.setContentView(this, R.layout.image_transformation_activity);
    setUpToolbar();
    loadImage();
  }

  private void setUpToolbar() {
    setSupportActionBar(mViewBinding.includeToolbar.toolbar);
    if (getSupportActionBar() != null) {
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
  }

  private void loadImage() {
    Picasso
        .with(this)
        .load(sImageUrl)
        .placeholder(R.drawable.bumblebee)
        .error(R.drawable.image_cloud_sad)
        .transform(new CircleTransform())
        .into(mViewBinding.image);
  }
}
