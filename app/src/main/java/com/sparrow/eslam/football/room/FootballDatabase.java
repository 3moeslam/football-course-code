package com.sparrow.eslam.football.room;

import android.arch.persistence.room.RoomDatabase;

import com.sparrow.eslam.football.pojo.Competition;

@android.arch.persistence.room.Database(version = 1,entities = {Competition.class})
public abstract class FootballDatabase extends RoomDatabase{
    public abstract FootballDao getDao();
}
