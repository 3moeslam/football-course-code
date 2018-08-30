package com.sparrow.eslam.football;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FootballApi {

    @GET("/v1/teams/{teamID}/players")
    Observable<Players> getPlayers(@Path("teamID") String teamID);

    @GET("/v2/competitions/")
    Observable<Players> getTeams(@Path("teamID") String teamID);
}
