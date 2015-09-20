package com.sottocorp.okhttpretrofitmoshipicasso.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.sottocorp.okhttpretrofitmoshipicasso.R;
import com.sottocorp.okhttpretrofitmoshipicasso.others.CircleTransform;
import com.squareup.picasso.Picasso;

/**
 * Demonstrates how to load circle images using transformations
 */
public class ImageTransformationActivity extends AppCompatActivity
{
    private final static String sImageUrl = "https://goo.gl/XOXAXG";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_transformation);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        final ImageView imageView =
                (ImageView) findViewById(R.id.circularImageView);

        Picasso
                .with(this)
                .load(sImageUrl)
                .placeholder(R.drawable.bumblebee)
                .error(R.drawable.ic_cloud_sad)
                .transform(new CircleTransform())
                .into(imageView);

    }
}
