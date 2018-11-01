package com.flock.models;

import java.util.List;

public class deleteUserModel {

	private String actor;
	private List<String> entities;
	

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public List<String> getEntities() {
		return entities;
	}

	public void setEntities(List<String> entities) {
		this.entities = entities;
	}
}
