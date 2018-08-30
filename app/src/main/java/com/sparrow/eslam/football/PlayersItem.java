package com.sparrow.eslam.football;

import com.google.gson.annotations.SerializedName;

public class PlayersItem{

	@SerializedName("nationality")
	private String nationality;

	@SerializedName("name")
	private String name;

	@SerializedName("jerseyNumber")
	private Object jerseyNumber;

	@SerializedName("marketValue")
	private Object marketValue;

	@SerializedName("dateOfBirth")
	private String dateOfBirth;

	@SerializedName("contractUntil")
	private String contractUntil;

	@SerializedName("position")
	private String position;

	public void setNationality(String nationality){
		this.nationality = nationality;
	}

	public String getNationality(){
		return nationality;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setJerseyNumber(Object jerseyNumber){
		this.jerseyNumber = jerseyNumber;
	}

	public Object getJerseyNumber(){
		return jerseyNumber;
	}

	public void setMarketValue(Object marketValue){
		this.marketValue = marketValue;
	}

	public Object getMarketValue(){
		return marketValue;
	}

	public void setDateOfBirth(String dateOfBirth){
		this.dateOfBirth = dateOfBirth;
	}

	public String getDateOfBirth(){
		return dateOfBirth;
	}

	public void setContractUntil(String contractUntil){
		this.contractUntil = contractUntil;
	}

	public String getContractUntil(){
		return contractUntil;
	}

	public void setPosition(String position){
		this.position = position;
	}

	public String getPosition(){
		return position;
	}

	@Override
 	public String toString(){
		return 
			"PlayersItem{" + 
			"nationality = '" + nationality + '\'' + 
			",name = '" + name + '\'' + 
			",jerseyNumber = '" + jerseyNumber + '\'' + 
			",marketValue = '" + marketValue + '\'' + 
			",dateOfBirth = '" + dateOfBirth + '\'' + 
			",contractUntil = '" + contractUntil + '\'' + 
			",position = '" + position + '\'' + 
			"}";
		}
}