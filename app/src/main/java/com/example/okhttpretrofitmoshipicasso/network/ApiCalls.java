package com.example.okhttpretrofitmoshipicasso.network;

import com.example.okhttpretrofitmoshipicasso.dataModel.DummyObject;

import java.util.List;

import retrofit2.Call;

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
