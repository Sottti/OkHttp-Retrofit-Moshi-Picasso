package com.sottocorp.okhttpretrofitmoshipicasso.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.sottocorp.okhttpretrofitmoshipicasso.R;
import com.sottocorp.okhttpretrofitmoshipicasso.databinding.MainActivityBinding;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    final MainActivityBinding viewBinding = DataBindingUtil
        .setContentView(this, R.layout.main_activity);
    viewBinding.setClickHandler(new MainActivityClickHandler());
    setSupportActionBar(viewBinding.includeToolbar.toolbar);
  }

  public class MainActivityClickHandler {

    public void onJsonObjectButtonClick(@NonNull final View view) {
      startActivity(new Intent(view.getContext(), JsonObjectActivity.class));
    }

    public void onJsonArrayButtonClick(@NonNull final View view) {
      startActivity(new Intent(view.getContext(), JsonArrayActivity.class));
    }

    public void onImageLoadingButtonClick(@NonNull final View view) {
      startActivity(new Intent(view.getContext(), ImageLoadingActivity.class));
    }

    public void onImageTransformationButtonClick(@NonNull final View view) {
      startActivity(new Intent(view.getContext(), ImageTransformationActivity.class));
    }
  }
}
