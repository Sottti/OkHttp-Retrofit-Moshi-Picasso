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

import com.sottocorp.okhttpretrofitmoshipicasso.R;
import com.example.okhttpretrofitmoshipicasso.dataModel.DummyObject;
import com.example.okhttpretrofitmoshipicasso.network.ApiCalls;

import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Demonstrates how to make a JSON Object request
 */
public class JSONArrayActivity extends AppCompatActivity
{
    private ProgressBar mProgressBar;
    private LinearLayout mContent, mErrorView;
    private TextView mTitle, mBody, mSecondTitle, mSecondBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.json_array_request);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

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

        ApiCalls.getDummyObjectListCall().enqueue(new Callback<List<DummyObject>>()
        {
            @Override
            public void onResponse(Response<List<DummyObject>> response, Retrofit retrofit)
            {
                // Deal with the DummyObject here
                mProgressBar.setVisibility(View.GONE);
                mContent.setVisibility(View.VISIBLE);
                setData(response.body());
            }

            @Override
            public void onFailure(Throwable t)
            {
                // Deal with the error here
                mProgressBar.setVisibility(View.GONE);
                mErrorView.setVisibility(View.VISIBLE);
            }
        });
    }

    /**
     * Sets the data in the UI
     *
     * @param dummyObjectList is the object's array to get the data from
     */
    private void setData(@NonNull final List<DummyObject> dummyObjectList)
    {
        mTitle.setText(dummyObjectList.get(0).getTitle());
        mBody.setText(dummyObjectList.get(0).getBody());
        mSecondTitle.setText(dummyObjectList.get(1).getTitle());
        mSecondBody.setText(dummyObjectList.get(1).getBody());
    }
}
