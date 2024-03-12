package com.example.Eventra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class OneEvent extends AppCompatActivity {

    //======================================
    //Charith Manodya - IM/2020/013 (start)
    //======================================

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_event);
        loadClickedEvent();

        Button btnBack = findViewById(R.id.btnBackToEvents);
        ImageView imgMenu = findViewById(R.id.imgMenu);
        ImageView imgRefresh = findViewById(R.id.imgRefresh);

        imgRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadClickedEvent();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBackToEvents();
            }
        });

        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadMenu();
            }
        });
    }
    private void loadClickedEvent(){

        //  Link Text views
        TextView txtEventName = findViewById(R.id.actualEventName);                     //  Link event name
        TextView txtEventDescription = findViewById(R.id.actualEventDescription);       //  Link event description
        TextView txtEventDateAndTime = findViewById(R.id.actualEventDateAndTime);       //  Link event date and time
        TextView txtEventVenue = findViewById(R.id.actualEventVenue);                   //  Link event venue
        TextView txtEventTicketPrice = findViewById(R.id.actualEventTicketPrice);       //  Link event ticket price
        TextView txtEventOrganizers = findViewById(R.id.actualEventOrganizers);         //  Link event organizers

        //  Put text
        txtEventName.setText(getIntent().getStringExtra("eventName"));                  //  Assign event name
        txtEventDescription.setText(getIntent().getStringExtra("eventDescription"));    //  Assign event description
        txtEventDateAndTime.setText(getIntent().getStringExtra("eventDateAndTime"));    //  Assign event date and time
        txtEventVenue.setText(getIntent().getStringExtra("eventVenue"));                //  Assign event venue
        txtEventTicketPrice.setText(getIntent().getStringExtra("eventTicket"));         //  Assign event ticket price
        txtEventOrganizers.setText(getIntent().getStringExtra("eventOrganizer"));       //  Assign event organizers

    }

    private void goBackToEvents(){
        Intent eventListLink = new Intent(this, EventList.class);

        String[] eventNames = getIntent().getStringArrayExtra("eventNames");
        String[] eventDescriptions = getIntent().getStringArrayExtra("eventDescriptions");
        String[] eventDateAndTimes = getIntent().getStringArrayExtra("eventDateAndTimes");
        String[] eventVenues = getIntent().getStringArrayExtra("eventVenues");
        String[] eventTicketPrices = getIntent().getStringArrayExtra("eventTickets");
        String[] eventOrganizers = getIntent().getStringArrayExtra("eventOrganizers");

        eventListLink.putExtra("eventNames", eventNames);
        eventListLink.putExtra("eventDescriptions", eventDescriptions);
        eventListLink.putExtra("eventDateAndTimes", eventDateAndTimes);
        eventListLink.putExtra("eventVenues", eventVenues);
        eventListLink.putExtra("eventTickets", eventTicketPrices);
        eventListLink.putExtra("eventOrganizers", eventOrganizers);

        startActivity(eventListLink);
    }

    private void loadMenu(){
        Intent menuLink = new Intent(this, Menu.class);

        String[] eventNames = getIntent().getStringArrayExtra("eventNames");
        String[] eventDescriptions = getIntent().getStringArrayExtra("eventDescriptions");
        String[] eventDateAndTimes = getIntent().getStringArrayExtra("eventDateAndTimes");
        String[] eventVenues = getIntent().getStringArrayExtra("eventVenues");
        String[] eventTicketPrices = getIntent().getStringArrayExtra("eventTickets");
        String[] eventOrganizers = getIntent().getStringArrayExtra("eventOrganizers");

        menuLink.putExtra("eventNames", eventNames);
        menuLink.putExtra("eventDescriptions", eventDescriptions);
        menuLink.putExtra("eventDateAndTimes", eventDateAndTimes);
        menuLink.putExtra("eventVenues", eventVenues);
        menuLink.putExtra("eventTickets", eventTicketPrices);
        menuLink.putExtra("eventOrganizers", eventOrganizers);

        startActivity(menuLink);
    }

    //======================================
    //Charith Manodya - IM/2020/013 (end)
    //======================================
}
