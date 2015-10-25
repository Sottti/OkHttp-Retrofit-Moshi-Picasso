package com.sottocorp.okhttpretrofitmoshipicasso.network;

import com.sottocorp.okhttpretrofitmoshipicasso.dataModel.DummyObject;

import java.util.List;

import retrofit.Call;

public class ApiCalls
{
    public static Call<DummyObject> getDummyObjectCall()
    {
        return ApiServices
                .getDummyService()
                .getDummyObject();
    }

    public static Call<List<DummyObject>> getDummyObjectListCall()
    {
        return ApiServices
                .getDummyService()
                .getDummyObjectList();
    }
}
