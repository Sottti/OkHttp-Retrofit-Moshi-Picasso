package com.sottocorp.okhttpretrofitmoshipicasso.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.sottocorp.okhttpretrofitmoshipicasso.R;
import com.sottocorp.okhttpretrofitmoshipicasso.data.ApiCalls;
import com.sottocorp.okhttpretrofitmoshipicasso.databinding.JsonArrayRequestActivityBinding;
import com.sottocorp.okhttpretrofitmoshipicasso.model.DummyObject;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JsonArrayActivity extends AppCompatActivity {

  private Call<List<DummyObject>> mCall;
  private JsonArrayRequestActivityBinding mViewBinding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mViewBinding = DataBindingUtil.setContentView(this, R.layout.json_array_request_activity);
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
    mCall = ApiCalls.getDummyObjectListCall();
    mCall.enqueue(new Callback<List<DummyObject>>() {
      @Override
      public void onResponse(final Call<List<DummyObject>> call,
          final Response<List<DummyObject>> response) {
        final List<DummyObject> body = response.body();
        if (response.isSuccessful() && body != null) {
          onApiResponse((ArrayList<DummyObject>) body);
        } else {
          onApiError();
        }
      }

      @Override
      public void onFailure(final Call<List<DummyObject>> call, final Throwable t) {
        if (!call.isCanceled()) {
          onApiError();
        }
      }
    });
  }

  private void onApiResponse(@NonNull final ArrayList<DummyObject> dummyObjectArrayList) {
    mViewBinding.includeProgressBar.setVisibility(View.GONE);
    mViewBinding.includeErrorView.setVisibility(View.GONE);
    mViewBinding.content.setVisibility(View.VISIBLE);
    setData(dummyObjectArrayList);
  }

  private void onApiError() {
    mViewBinding.includeErrorView.setVisibility(View.VISIBLE);
    mViewBinding.includeProgressBar.setVisibility(View.GONE);
    mViewBinding.content.setVisibility(View.GONE);
  }

  private void setData(@NonNull final ArrayList<DummyObject> dummyObjectArrayList) {
    mViewBinding.myTitle.setText(dummyObjectArrayList.get(0).getTitle());
    mViewBinding.myBody.setText(dummyObjectArrayList.get(0).getBody());
    mViewBinding.myTitle2.setText(dummyObjectArrayList.get(1).getTitle());
    mViewBinding.myBody2.setText(dummyObjectArrayList.get(1).getBody());
  }

  @Override
  protected void onStop() {
    if (mCall != null) {
      mCall.cancel();
    }
    super.onStop();
  }
}
