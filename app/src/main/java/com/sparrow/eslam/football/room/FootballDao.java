package com.sparrow.eslam.football.room;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.sparrow.eslam.football.pojo.Competition;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;

@android.arch.persistence.room.Dao
public interface FootballDao {

    @Query("select * from Competition")
    Maybe<List<Competition>> getCompitions();

    @Insert
    void insertCompition(Competition competition);
}
