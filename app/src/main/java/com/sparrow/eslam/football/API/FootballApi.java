package com.sparrow.eslam.football.API;

import com.sparrow.eslam.football.pojo.Competition;
import com.sparrow.eslam.football.pojo.Players;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FootballApi {

    @GET("/v1/teams/{teamID}/players")
    Observable<Players> getPlayers(@Path("teamID") String teamID);

    @GET("/v1/competitions/")
    Single<List<Competition> > getCompetations();
}
