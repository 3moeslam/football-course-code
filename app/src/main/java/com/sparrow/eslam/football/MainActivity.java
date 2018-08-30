package com.sparrow.eslam.football;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        final TextView tv = findViewById(R.id.players) ;
//        StrictMode.ThreadPolicy policy = new
//                StrictMode.ThreadPolicy.Builder().permitAll().build();
//        StrictMode.setThreadPolicy(policy);
//
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        };
//        Thread thread = new Thread(runnable);
//
//        thread.run();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.football-data.org")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        FootballApi service = retrofit.create(FootballApi.class);

        service.getPlayers("498")
                .map(players -> players.getPlayers())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(playersItems -> {
                    for(PlayersItem item : playersItems){
                        Log.i("Eslam...",item.getName());
                    }
                });

//
//
//                .map(new Function<Players, List<PlayersItem>>() {
//            @Override
//            public List<PlayersItem> apply(Players players) throws Exception {
//                return players.getPlayers();
//            }
//        })
//                .enqueue(new Callback<Players>() {
//                    @Override
//                    public void onResponse(Call<Players> call, Response<Players> response) {
//                        List<PlayersItem> playersItems = response.body().getPlayers();
//                        for (PlayersItem player : playersItems){
//                            Log.i("Eslam....",player.getName());
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<Players> call, Throwable t) {
//                        t.printStackTrace();
//                    }
//                });


    }
}
