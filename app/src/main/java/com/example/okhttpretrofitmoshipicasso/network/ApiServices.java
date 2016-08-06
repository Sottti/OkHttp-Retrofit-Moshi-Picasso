package com.example.okhttpretrofitmoshipicasso.network;

import com.example.okhttpretrofitmoshipicasso.dataModel.DummyObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public class ApiServices
{
    private static DummyService mDummyService;

    public interface DummyService
    {
        @GET("/v2/55973508b0e9e4a71a02f05f")
        Call<DummyObject> getDummyObject();

        @GET ("/v2/5597d86a6344715505576725")
        Call<List<DummyObject>> getDummyObjectList();
    }

    public static synchronized DummyService getDummyService()
    {
        if (mDummyService == null)
        {
            mDummyService = ApiClients
                    .getApiClient()
                    .create(DummyService.class);
        }

        return mDummyService;
    }
}
