package com.sparrow.eslam.football;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Players{

	@SerializedName("_links")
	private Links links;

	@SerializedName("players")
	private List<PlayersItem> players;

	@SerializedName("count")
	private int count;

	public void setLinks(Links links){
		this.links = links;
	}

	public Links getLinks(){
		return links;
	}

	public void setPlayers(List<PlayersItem> players){
		this.players = players;
	}

	public List<PlayersItem> getPlayers(){
		return players;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	@Override
 	public String toString(){
		return 
			"Players{" + 
			"_links = '" + links + '\'' + 
			",players = '" + players + '\'' + 
			",count = '" + count + '\'' + 
			"}";
		}
}