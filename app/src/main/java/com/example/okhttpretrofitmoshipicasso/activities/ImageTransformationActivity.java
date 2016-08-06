package com.example.okhttpretrofitmoshipicasso.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.example.okhttpretrofitmoshipicasso.others.CircleTransform;
import com.sottocorp.okhttpretrofitmoshipicasso.R;
import com.squareup.picasso.Picasso;

public class ImageTransformationActivity extends AppCompatActivity
{
    private final static String sImageUrl = "https://goo.gl/XOXAXG";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_transformation);
        setUpToolbar();
        loadImage();

    }

    private void setUpToolbar()
    {
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void loadImage()
    {
        final ImageView imageView =
                (ImageView) findViewById(R.id.circularImageView);

        Picasso
                .with(this)
                .load(sImageUrl)
                .placeholder(R.drawable.bumblebee)
                .error(R.drawable.image_cloud_sad)
                .transform(new CircleTransform())
                .into(imageView);
    }
}
