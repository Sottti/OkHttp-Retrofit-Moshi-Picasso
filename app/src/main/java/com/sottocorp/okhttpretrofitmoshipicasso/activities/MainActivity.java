package com.sottocorp.okhttpretrofitmoshipicasso.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import com.sottocorp.okhttpretrofitmoshipicasso.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  private Button mJsonObjectSample, mJsonArraySample, mImageLoading, mImageTransformation;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_activity);
    init();
  }

  private void init() {
    setUpToolbar();
    bindViews();
    setUpViews();
  }

  private void setUpToolbar() {
    setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
  }

  private void bindViews() {
    mJsonObjectSample = (Button) findViewById(R.id.json_object);
    mJsonArraySample = (Button) findViewById(R.id.json_array);
    mImageLoading = (Button) findViewById(R.id.image_loading);
    mImageTransformation = (Button) findViewById(R.id.image_transformation);
  }

  private void setUpViews() {
    mJsonObjectSample.setOnClickListener(this);
    mJsonArraySample.setOnClickListener(this);
    mImageLoading.setOnClickListener(this);
    mImageTransformation.setOnClickListener(this);
  }

  @Override
  public void onClick(View view) {
    if (view == mJsonObjectSample) {
      startActivity(new Intent(this, JsonObjectActivity.class));
    } else if (view == mJsonArraySample) {
      startActivity(new Intent(this, JsonArrayActivity.class));
    } else if (view == mImageLoading) {
      startActivity(new Intent(this, ImageLoadingActivity.class));
    } else if (view == mImageTransformation) {
      startActivity(new Intent(this, ImageTransformationActivity.class));
    }
  }
}
