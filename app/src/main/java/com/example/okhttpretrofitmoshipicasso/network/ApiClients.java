package com.example.okhttpretrofitmoshipicasso.network;

import com.sottocorp.okhttpretrofitmoshipicasso.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class ApiClients
{
    private static Retrofit mClient;

    public static synchronized Retrofit getApiClient()
    {
        if (mClient == null)
        {
            mClient = new Retrofit
                    .Builder()
                    .baseUrl(BuildConfig.apiDomainName)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();
        }

        return mClient;
    }
}
