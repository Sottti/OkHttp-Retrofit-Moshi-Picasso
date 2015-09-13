package com.sottocorp.okhttpretrofitmoshipicasso.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.sottocorp.okhttpretrofitmoshipicasso.R;

/**
 * Launches the different samples
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private Button mJSONObjectSample, mJSONArraySample, mNetworkImageViewSample;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        mJSONObjectSample = (Button) findViewById(R.id.json_object);
        mJSONArraySample = (Button) findViewById(R.id.json_array);
        mNetworkImageViewSample = (Button) findViewById(R.id.network_image_view);

        mJSONObjectSample.setOnClickListener(this);
        mJSONArraySample.setOnClickListener(this);
        mNetworkImageViewSample.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if (view == mJSONObjectSample)
        {
            startActivity(new Intent(this, JSONObjectActivity.class));
        }
        else if (view == mJSONArraySample)
        {
            startActivity(new Intent(this, JSONArrayActivity.class));
        }
        else if (view == mNetworkImageViewSample)
        {
            startActivity(new Intent(this, ImageLoadingActivity.class));
        }
    }
}
