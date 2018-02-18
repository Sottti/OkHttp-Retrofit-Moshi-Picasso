package com.sottocorp.okhttpretrofitmoshipicasso.data;

import com.sottocorp.okhttpretrofitmoshipicasso.model.DummyObject;
import java.util.List;
import retrofit2.Call;

public class ApiCalls {

  public static Call<DummyObject> getDummyObjectCall() {
    return ApiServices
        .getDummyService()
        .getDummyObject();
  }

  public static Call<List<DummyObject>> getDummyObjectListCall() {
    return ApiServices
        .getDummyService()
        .getDummyObjectList();
  }
}
