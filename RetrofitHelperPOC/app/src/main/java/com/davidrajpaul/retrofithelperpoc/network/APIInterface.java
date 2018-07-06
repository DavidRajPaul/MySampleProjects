package com.davidrajpaul.retrofithelperpoc.network;

import com.davidrajpaul.retrofithelperpoc.model.MyDataClass;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by DavidRaj Paul on 06-07-2018.
 */
public interface APIInterface {
    @GET("71a13054c1696a834c5bbb7570e68ece/raw/d9ec84161e39d5f96471f1b6028656c8811ca6e2/samplejson.json")
    Call<MyDataClass> getMydata();
}
