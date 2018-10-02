package com.sparrow.eslam.football.home;


import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.sparrow.eslam.football.API.FootballApi;
import com.sparrow.eslam.football.NetworkCall;
import com.sparrow.eslam.football.R;
import com.sparrow.eslam.football.TestAsync;
import com.sparrow.eslam.football.pojo.Competition;
import com.sparrow.eslam.football.pojo.Players;
import com.sparrow.eslam.football.room.FootballDao;
import com.sparrow.eslam.football.room.FootballDatabase;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity /*implements NetworkCall*/ {

    NetworkCall networkCall = new NetworkCall<Players[]>() {
        @Override
        public void onSuccess(Players[] players) {

        }

        @Override
        public void onFail(Throwable throwable) {

        }
    };
    TestAsync testAsync;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = findViewById(R.id.recycle_view);



        Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("http://api.football-data.org")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();

        FootballApi service = retrofit.create(FootballApi.class);

        FootballDao db = Room.databaseBuilder(this, FootballDatabase.class, "test")
                .build()
                .getDao();

        HomeRepository repo = new HomeRepository(db,service);
        repo.getCompitions()
                .subscribeOn(Schedulers.io())
                .subscribe(list->{
                    for (Competition x: list){
                        Log.i("Eslammmm","data is: "+x.getCaption());
                    }
                });
//        Observable.fromCallable(() -> {
//                Competition x = new Competition();
//                x.setCaption("aaaa");
//                x.setLastUpdated("aaaa");
//                x.setLeague("aaaa");
//                x.setNumberOfTeams(50);
//                db.insertCompition(x);
//                return true;
//            }).subscribeOn(Schedulers.io())
//                .subscribe();
//        db.getCompitions()
//                .subscribeOn(Schedulers.io())
//        .subscribe((list)->{
//            for(Competition x : list){
//                Log.i("Eslam...","val is: "+x.getCaption());
//            }
//        });
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

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://api.football-data.org")
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build();
//
//        FootballApi service = retrofit.create(FootballApi.class);
//
//        service.getPlayers("498")
//                .map(players -> players.getPlayers())
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(playersItems -> {
//                    for(PlayersItem item : playersItems){
//                        Log.i("Eslam...",item.getName());
//                    }
//                });
//        service.getCompetations()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(competitions -> {
//                            for (Competition item : competitions) {
//                                Log.i("Eslam...", item.getLeague());
//                                Log.i("Eslam...", item.getCaption());
//                            }
//
//                            Adaptor adaptor = new Adaptor(competitions);
//                            rv.setLayoutManager(new LinearLayoutManager(this));
//                            rv.setAdapter(adaptor);
//                        });


        testAsync = new TestAsync(networkCall);
        testAsync.execute();

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

    public void onPlayersReady(Players[] players) {
        Log.i("Eslam...", players[0].toString());
    }

    @Override
    protected void onDestroy() {
        testAsync.removeCallback();
        super.onDestroy();
    }

    //
//    @Override
//    public void onSuccess(Players[] players) {
//
//    }
//
//    @Override
//    public void onFail(Throwable throwable) {
//
//    }
}
