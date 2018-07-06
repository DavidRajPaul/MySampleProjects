package com.davidrajpaul.retrofithelperpoc.network;


import com.davidrajpaul.retrofithelperpoc.model.MyDataClass;

/**
 * Created by DavidRaj Paul on 06-07-2018.
 */
public class NetworkCallHandler {

    public static void getMyData(RetrofitCallBackInterface<MyDataClass> callBack){
        RetrofitClient.getClient()
                .create(APIInterface.class).getMydata()
                .enqueue(new RetrofitCallBack<>(callBack));
    }
}
