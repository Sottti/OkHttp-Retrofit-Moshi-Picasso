package com.sottocorp.okhttpretrofitmoshipicasso.activities;

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
import com.sottocorp.okhttpretrofitmoshipicasso.dataModel.DummyObject;
import com.sottocorp.okhttpretrofitmoshipicasso.network.ApiRequests;

import retrofit.Callback;
import retrofit.Response;

/**
 * Demonstrates how to make a JSON Object request
 */
public class JSONObjectActivity extends AppCompatActivity
{
    private TextView mTitle, mBody;
    private ProgressBar mProgressBar;
    private LinearLayout mContent, mErrorView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.json_object_request);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mTitle = (TextView) findViewById(R.id.my_title);
        mBody = (TextView) findViewById(R.id.my_body);
        mBody.setMovementMethod(new ScrollingMovementMethod());
        mErrorView = (LinearLayout) findViewById(R.id.error_view);
        mContent = (LinearLayout) findViewById(R.id.content);

        ApiRequests.getDummyObjectCall().enqueue(new Callback<DummyObject>()
        {
            @Override
            public void onResponse(Response<DummyObject> response)
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
     * @param dummyObject is the object to get the data from
     */
    private void setData(@NonNull final DummyObject dummyObject)
    {
        mTitle.setText(dummyObject.getTitle());
        mBody.setText(dummyObject.getBody());
    }
}
