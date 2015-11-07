package com.goozmo.virtualassistant;

public class TeamMember {
	private String name;
	private String apiKey;
	
	TeamMember(String name, String apiKey) {
		this.name = name;
		this.apiKey = apiKey;
	}
	
	public String Name() { return this.name; }
	public String ApiKey() { return this.apiKey; }
	
}
