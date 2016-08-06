package com.example.okhttpretrofitmoshipicasso.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.okhttpretrofitmoshipicasso.dataModel.DummyObject;
import com.example.okhttpretrofitmoshipicasso.network.ApiCalls;
import com.sottocorp.okhttpretrofitmoshipicasso.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JsonObjectActivity extends AppCompatActivity
{
    private TextView mTitle, mBody;
    private ProgressBar mProgressBar;
    private LinearLayout mContent, mErrorView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.json_object_request);
        init();
    }

    private void init()
    {
        setUpToolbar();
        bindViews();
        getData();
    }

    private void setUpToolbar()
    {
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void bindViews()
    {
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mTitle = (TextView) findViewById(R.id.my_title);
        mBody = (TextView) findViewById(R.id.my_body);
        mBody.setMovementMethod(new ScrollingMovementMethod());
        mErrorView = (LinearLayout) findViewById(R.id.error_view);
        mContent = (LinearLayout) findViewById(R.id.content);
    }

    private void getData()
    {
        ApiCalls
                .getDummyObjectCall()
                .enqueue(new Callback<DummyObject>()
                {
                    @Override
                    public void onResponse(final Call<DummyObject> call, final Response<DummyObject> response)
                    {
                        if (response.isSuccessful())
                        {
                            onResponseSuccess(response);
                        }
                        else
                        {
                            onResponseUnsuccessful();
                        }

                    }

                    @Override
                    public void onFailure(final Call<DummyObject> call, final Throwable t)
                    {
                        onCallFailure();
                    }
                });
    }

    private void onResponseSuccess(final Response<DummyObject> response)
    {
        mProgressBar.setVisibility(View.GONE);
        mContent.setVisibility(View.VISIBLE);
        setData(response.body());
    }

    private void setData(@NonNull final DummyObject dummyObject)
    {
        mTitle.setText(dummyObject.getTitle());
        mBody.setText(dummyObject.getBody());
    }

    private void onResponseUnsuccessful()
    {
        mProgressBar.setVisibility(View.GONE);
        mErrorView.setVisibility(View.VISIBLE);
    }

    private void onCallFailure()
    {
        mProgressBar.setVisibility(View.GONE);
        mErrorView.setVisibility(View.VISIBLE);
    }
}
