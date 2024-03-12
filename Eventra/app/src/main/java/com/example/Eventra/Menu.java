package com.example.Eventra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;

//======================================
//Nethma Kithmini - IM/2020/111 (start)
//======================================

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button btnLogin = findViewById(R.id.btnLoginLink);
        Button btnEvents = findViewById(R.id.btnEventsLink);
        ImageView imgClose = findViewById(R.id.imgClose);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadLoginForm();
            }
        });

        btnEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadEventList();
            }
        });

        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadEventList();
            }
        });
    }

    private void loadLoginForm(){
        Intent loginFormLink = new Intent(this, Login.class);

        String[] eventNames = getIntent().getStringArrayExtra("eventNames");
        String[] eventDescriptions = getIntent().getStringArrayExtra("eventDescriptions");
        String[] eventDateAndTimes = getIntent().getStringArrayExtra("eventDateAndTimes");
        String[] eventVenues = getIntent().getStringArrayExtra("eventVenues");
        String[] eventTicketPrices = getIntent().getStringArrayExtra("eventTickets");
        String[] eventOrganizers = getIntent().getStringArrayExtra("eventOrganizers");

        loginFormLink.putExtra("eventNames", eventNames);
        loginFormLink.putExtra("eventDescriptions", eventDescriptions);
        loginFormLink.putExtra("eventDateAndTimes", eventDateAndTimes);
        loginFormLink.putExtra("eventVenues", eventVenues);
        loginFormLink.putExtra("eventTickets", eventTicketPrices);
        loginFormLink.putExtra("eventOrganizers", eventOrganizers);

        startActivity(loginFormLink);
    }

    private void loadEventList(){
        Intent eventsFormLink = new Intent(this, EventList.class);

        String[] eventNames = getIntent().getStringArrayExtra("eventNames");
        String[] eventDescriptions = getIntent().getStringArrayExtra("eventDescriptions");
        String[] eventDateAndTimes = getIntent().getStringArrayExtra("eventDateAndTimes");
        String[] eventVenues = getIntent().getStringArrayExtra("eventVenues");
        String[] eventTicketPrices = getIntent().getStringArrayExtra("eventTickets");
        String[] eventOrganizers = getIntent().getStringArrayExtra("eventOrganizers");

        eventsFormLink.putExtra("eventNames", eventNames);
        eventsFormLink.putExtra("eventDescriptions", eventDescriptions);
        eventsFormLink.putExtra("eventDateAndTimes", eventDateAndTimes);
        eventsFormLink.putExtra("eventVenues", eventVenues);
        eventsFormLink.putExtra("eventTickets", eventTicketPrices);
        eventsFormLink.putExtra("eventOrganizers", eventOrganizers);

        startActivity(eventsFormLink);
    }

    //======================================
    //Nethma Kithmini - IM/2020/111 (end)
    //======================================

}
