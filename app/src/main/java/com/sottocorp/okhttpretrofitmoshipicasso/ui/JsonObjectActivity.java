package com.sottocorp.okhttpretrofitmoshipicasso.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.sottocorp.okhttpretrofitmoshipicasso.R;
import com.sottocorp.okhttpretrofitmoshipicasso.data.ApiCalls;
import com.sottocorp.okhttpretrofitmoshipicasso.databinding.JsonObjectRequestActivityBinding;
import com.sottocorp.okhttpretrofitmoshipicasso.model.DummyObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JsonObjectActivity extends AppCompatActivity {

  private Call<DummyObject> mCall;
  private JsonObjectRequestActivityBinding mViewBinding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mViewBinding = DataBindingUtil.setContentView(this, R.layout.json_object_request_activity);
    setUpToolbar();
    getData();
  }

  private void setUpToolbar() {
    setSupportActionBar(mViewBinding.includeToolbar.toolbar);
    if (getSupportActionBar() != null) {
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
  }

  private void getData() {
    mCall = ApiCalls.getDummyObjectCall();
    mCall.enqueue(new Callback<DummyObject>() {
      @Override
      public void onResponse(final Call<DummyObject> call,
          final Response<DummyObject> response) {
        final DummyObject body = response.body();
        if (response.isSuccessful() && body != null) {
          onResponseSuccess(body);
        } else {
          onError();
        }
      }

      @Override
      public void onFailure(final Call<DummyObject> call, final Throwable t) {
        if (!call.isCanceled()) {
          onError();
        }
      }
    });
  }

  private void onResponseSuccess(@NonNull final DummyObject dummyObject) {
    mViewBinding.includeProgressBar.setVisibility(View.GONE);
    mViewBinding.includeErrorView.setVisibility(View.GONE);
    mViewBinding.content.setVisibility(View.VISIBLE);
    mViewBinding.myTitle.setText(dummyObject.getTitle());
    mViewBinding.myBody.setText(dummyObject.getBody());
  }

  private void onError() {
    mViewBinding.content.setVisibility(View.GONE);
    mViewBinding.includeProgressBar.setVisibility(View.GONE);
    mViewBinding.includeErrorView.setVisibility(View.VISIBLE);
  }

  @Override
  protected void onStop() {
    if (mCall != null) {
      mCall.cancel();
    }
    super.onStop();
  }
}
