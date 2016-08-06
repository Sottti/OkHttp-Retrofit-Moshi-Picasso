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

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Demonstrates how to make a JSON Object request
 */
public class JsonArrayActivity extends AppCompatActivity
{
    private ProgressBar mProgressBar;
    private LinearLayout mContent, mErrorView;
    private TextView mTitle, mBody, mSecondTitle, mSecondBody;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.json_array_request);
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

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void bindViews()
    {
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mTitle = (TextView) findViewById(R.id.my_title);
        mBody = (TextView) findViewById(R.id.my_body);
        mBody.setMovementMethod(new ScrollingMovementMethod());
        mBody.setMovementMethod(new ScrollingMovementMethod());
        mSecondTitle = (TextView) findViewById(R.id.my_title_2);
        mSecondBody = (TextView) findViewById(R.id.my_body_2);
        mSecondBody.setMovementMethod(new ScrollingMovementMethod());
        mErrorView = (LinearLayout) findViewById(R.id.error_view);
        mContent = (LinearLayout) findViewById(R.id.content);
    }

    private void getData()
    {
        ApiCalls
                .getDummyObjectListCall()
                .enqueue(new Callback<List<DummyObject>>()
                {
                    @Override
                    public void onResponse(final Call<List<DummyObject>> call, final Response<List<DummyObject>> response)
                    {
                        if (response.isSuccessful())
                        {
                            onResponseSuccess(response);
                        }
                        else
                        {
                            onResponseUnccessful();
                        }

                    }

                    @Override
                    public void onFailure(final Call<List<DummyObject>> call, final Throwable t)
                    {
                        onCallFailure();
                    }
                });
    }

    private void onResponseSuccess(final Response<List<DummyObject>> response)
    {
        mProgressBar.setVisibility(View.GONE);
        mContent.setVisibility(View.VISIBLE);
        setData(response.body());
    }

    private void setData(@NonNull final List<DummyObject> dummyObjectList)
    {
        mTitle.setText(dummyObjectList.get(0).getTitle());
        mBody.setText(dummyObjectList.get(0).getBody());
        mSecondTitle.setText(dummyObjectList.get(1).getTitle());
        mSecondBody.setText(dummyObjectList.get(1).getBody());
    }

    private void onResponseUnccessful()
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
