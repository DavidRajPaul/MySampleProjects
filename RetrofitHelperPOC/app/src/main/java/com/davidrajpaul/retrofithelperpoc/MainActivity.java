package com.davidrajpaul.retrofithelperpoc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.davidrajpaul.retrofithelperpoc.model.MyDataClass;
import com.davidrajpaul.retrofithelperpoc.network.NetworkCallHandler;
import com.davidrajpaul.retrofithelperpoc.network.RetrofitCallBackInterface;

import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView name = findViewById(R.id.name);
        final TextView age = findViewById(R.id.age);
        final TextView car = findViewById(R.id.car);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                NetworkCallHandler.getMyData(new RetrofitCallBackInterface<MyDataClass>() {
                    @Override
                    public void onSuccess(Response<MyDataClass> res) {
                        MyDataClass response = res.body();
                        if (response != null) {
                            name.setText(response.getName());
                            age.setText(response.getAge());
                            car.setText(response.getCar());
                        }
                    }

                    @Override
                    public void onError(int code, String error) {
                        Toast.makeText(MainActivity.this,
                                code + " - " + error, Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
    }
}
