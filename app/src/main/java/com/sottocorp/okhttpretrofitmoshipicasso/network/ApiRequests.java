package com.sottocorp.okhttpretrofitmoshipicasso.network;

import com.sottocorp.okhttpretrofitmoshipicasso.dataModel.DummyObject;

import java.util.List;

import retrofit.Call;
import retrofit.MoshiConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;

/**
 * Requests to the API
 */
public class ApiRequests
{
    /**
     * Retrofit services
     */
    public interface APIService
    {
        @GET("/v2/55973508b0e9e4a71a02f05f")
        Call<DummyObject> getDummyObject();

        @GET ("v2/5597d86a6344715505576725")
        Call<List<DummyObject>> getDummyObjectList();
    }

    /**
     * @return a {@link DummyObject} {@link Call}
     */
    public static Call<DummyObject> getDummyObjectCall()
    {
        return
                new Retrofit
                        .Builder()
                        .baseUrl("http://www.mocky.io/")
                        .addConverterFactory(MoshiConverterFactory.create())
                        .build()
                        .create(APIService.class)
                        .getDummyObject();
    }

    /**
     * @return a {@link Call} to a {@link DummyObject} {@link List}
     */
    public static Call<List<DummyObject>> getDummyObjectListCall()
    {
        return
                new Retrofit
                        .Builder()
                        .baseUrl("http://www.mocky.io/")
                        .addConverterFactory(MoshiConverterFactory.create())
                        .build()
                        .create(APIService.class)
                        .getDummyObjectList();
    }
}
