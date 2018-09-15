package com.sparrow.eslam.football.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.sparrow.eslam.football.API.FootballApi;
import com.sparrow.eslam.football.R;
import com.sparrow.eslam.football.pojo.Competition;
import com.sparrow.eslam.football.pojo.PlayersItem;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv =findViewById(R.id.recycle_view);

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
        service.getCompetations()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(competitions -> {
                            for (Competition item : competitions) {
                                Log.i("Eslam...", item.getLeague());
                                Log.i("Eslam...", item.getCaption());
                            }

                            Adaptor adaptor = new Adaptor(competitions);
                            rv.setLayoutManager(new LinearLayoutManager(this));
                            rv.setAdapter(adaptor);
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
