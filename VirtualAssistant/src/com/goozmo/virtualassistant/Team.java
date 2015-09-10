package com.goozmo.virtualassistant;

import java.util.ArrayList;

import android.widget.ArrayAdapter;

public class Team {

	private ArrayList<TeamMember> gooTeamMembers;
    private ArrayAdapter<TeamMember> gooTeamAdapter;
    
    public void Add(TeamMember t) {
    	gooTeamMembers.add(t);
    	gooTeamAdapter.notify();
    }
    public void Remove(TeamMember t) {
    	gooTeamMembers.remove(t);
    	gooTeamAdapter.notify();
    }
    
    public void Message(TeamMember t, String msg) {
    	Message(t,msg,new String("General Request"));
    }
    public void Message(TeamMember t, String msg, String messageTitle) {
    	
    }
    
}
