package com.pineapple.davinci.clubutils;

import android.util.Pair;

import com.pineapple.davinci.ClubDisplay;

import java.util.ArrayList;

/**
 * Created by Mudit on 8/10/2018.
 */

public class Club {

    private String nameString;
    private String[] clubColors;

    private ArrayList<ClubMember> members;
    private ArrayList<Event> events;
    //private ArrayList<Polls> polls; TODO: make polls
    //teams
    ////dynamic teams controlled by officer


    public Club() {  }
    public Club(String name) {
        nameString = name;
    }

    public String getNameString() { return nameString; }
    void setNameString(String nameString) { this.nameString = nameString; }

    public String[] getClubColors() { return clubColors; }
    void setClubColors(String[] clubColors) { this.clubColors = clubColors; }

    public ArrayList<ClubMember> getMembers() { return members; }
    void setMembers(ArrayList<ClubMember> members) { this.members = members; }

    public ArrayList<Event> getEvents() { return events; }
    void setEvents(ArrayList<Event> events) { this.events = events; }
}
