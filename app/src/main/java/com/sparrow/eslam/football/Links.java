package com.sparrow.eslam.football;

import com.google.gson.annotations.SerializedName;


public class Links{

	@SerializedName("self")
	private Self self;

	@SerializedName("team")
	private Team team;

	public void setSelf(Self self){
		this.self = self;
	}

	public Self getSelf(){
		return self;
	}

	public void setTeam(Team team){
		this.team = team;
	}

	public Team getTeam(){
		return team;
	}

	@Override
 	public String toString(){
		return 
			"Links{" + 
			"self = '" + self + '\'' + 
			",team = '" + team + '\'' + 
			"}";
		}
}