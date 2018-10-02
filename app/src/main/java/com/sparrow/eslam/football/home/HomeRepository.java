package com.sparrow.eslam.football.home;

import com.sparrow.eslam.football.API.FootballApi;
import com.sparrow.eslam.football.pojo.Competition;
import com.sparrow.eslam.football.room.FootballDao;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.schedulers.Schedulers;

public class HomeRepository {

    FootballDao dao;

    public HomeRepository(FootballDao dao, FootballApi api) {
        this.dao = dao;
        dao.getCompitions()
                .filter(list -> list.isEmpty())
                .doOnSuccess(list -> {
                    list = api.getCompetations()
                            .subscribeOn(Schedulers.io())
                            .blockingGet();
                    for (Competition x : list) {
                        dao.insertCompition(x);
                    }
                }).subscribeOn(Schedulers.io())
                .subscribe();
    }


    public Maybe<List<Competition>> getCompitions() {
        return dao.getCompitions();
    }
}

