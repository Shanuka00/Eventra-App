package com.example.Eventra;

import java.util.HashMap;
import java.util.Map;

public class DatabaseHandler {

    //======================================
    //Pasindu Bhanuka - IM/2020/108 (start)
    //======================================

    // Event List Array
    Map<String, Map<String, String>> eventList = new HashMap<>();

    public void setFirstEvent(String eventName, String eventDescription, String eventDateAndTime, String eventVenue, String eventTicket, String eventOrganizers){

        // Add values to the first element of the array

        this.eventList.put("1", new HashMap<>());
        this.eventList.get("1").put("name", eventName);
        this.eventList.get("1").put("description", eventDescription);
        this.eventList.get("1").put("date_and_time", eventDateAndTime);
        this.eventList.get("1").put("venue", eventVenue);
        this.eventList.get("1").put("ticket", eventTicket);
        this.eventList.get("1").put("organizers", eventOrganizers);
    }

    public void setRandomEvent(String eventName, String eventDescription, String eventDateAndTime, String eventVenue, String eventTicket, String eventOrganizers){

        // Set array ID

        int rowCount = this.eventList.size();
        ++rowCount;
        String eventID = String.valueOf(rowCount);

        // Add values to the random array

        this.eventList.put(eventID, new HashMap<>());
        this.eventList.get(eventID).put("name", eventName);
        this.eventList.get(eventID).put("description", eventDescription);
        this.eventList.get(eventID).put("date_and_time", eventDateAndTime);
        this.eventList.get(eventID).put("venue", eventVenue);
        this.eventList.get(eventID).put("ticket", eventTicket);
        this.eventList.get(eventID).put("organizers", eventOrganizers);

    }

    public boolean isEventNull(){

        // Check th table is empty
        return this.eventList.isEmpty();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////// Please Call Only These Methods ///////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public void addEvent(String eventName, String eventDescription, String eventDateAndTime, String eventVenue, String eventTicket, String eventOrganizers){

        // Set the event
        if(isEventNull()){
            setFirstEvent(eventName, eventDescription, eventDateAndTime, eventVenue, eventTicket, eventOrganizers);
        }else{
            setRandomEvent(eventName, eventDescription, eventDateAndTime, eventVenue, eventTicket, eventOrganizers);
        }
    }

    public String getEventName(int i){

        //Return the event name
        String eventID = String.valueOf(i);
        return this.eventList.get(eventID).get("name");
    }

    public String getEventDescription(int i){

        //Return the event description
        String eventID = String.valueOf(i);
        return this.eventList.get(eventID).get("description");
    }

    public String getEventDateAndTime(int i){

        ////Return the event date
        String eventID = String.valueOf(i);
        return this.eventList.get(eventID).get("date_and_time");
    }

    public String getEventVenue(int i){

        //Return the event venue
        String eventID = String.valueOf(i);
        return this.eventList.get(eventID).get("venue");
    }

    public String getEventTicket(int i){

        //Return the event ticket
        String eventID = String.valueOf(i);
        return this.eventList.get(eventID).get("ticket");
    }

    public String getEventOrganizers(int i){

        //Return the event organizers
        String eventID = String.valueOf(i);
        return this.eventList.get(eventID).get("organizers");
    }

    public String getEventBriefDescription(int i){

        String eventID = String.valueOf(i);
        int startingIndex = 0;
        int endingIndex = 0;
        return this.eventList.get(eventID).get("description").substring(startingIndex, endingIndex);
    }

    public int getEventsLength(){
        int lenghtOfEvents = eventList.size();
        return lenghtOfEvents;
    }
    public void updateEvent(String eventID, String eventName, String eventDescription, String eventDateAndTime, String eventVenue, String eventTicket, String eventOrganizers){

        //Update the event
        this.eventList.get(eventID).put("name", eventName);
        this.eventList.get(eventID).put("description", eventDescription);
        this.eventList.get(eventID).put("date_and_time", eventDateAndTime);
        this.eventList.get(eventID).put("venue", eventVenue);
        this.eventList.get(eventID).put("ticket", eventTicket);
        this.eventList.get(eventID).put("organizers", eventOrganizers);
    }

    public void deleteEvent(String eventID){

        //Remove the event
        this.eventList.remove(eventID);
    }

    //======================================
    //Pasindu Bhanuka - IM/2020/108 (end)
    //======================================

}
