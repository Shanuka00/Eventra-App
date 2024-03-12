package com.example.Eventra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    //======================================
    //Shanuka Dilshan - IM/2020/017 (start)
    //======================================

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Variable Declaration for Login
        EditText username = findViewById(R.id.usernameInput);       //  Link username text box
        EditText password = findViewById(R.id.passwordInput);       //  Link password text box
        Button login    = findViewById(R.id.btnSubmit);             //  Link submit button
        ImageView menuBtn = findViewById(R.id.imgMenu);
        ImageView imgRefresh = findViewById(R.id.imgRefresh);

        imgRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username.setText("");
                password.setText("");
                TextView errorMessage = findViewById(R.id.errorMessege);
                errorMessage.setText("");
            }
        });

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadMenu();
            }
        });



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventFormOrLoginForm(username.getText().toString(), password.getText().toString());
            }
        });
    }

    private void eventFormOrLoginForm(String inputUsername, String inputPassword){
        LoginHandler loginHandler = new LoginHandler();
        if(loginHandler.validate(inputUsername, inputPassword)){
            loadEventForm();
        }else{
            displayErrorMessege();
        }
    }

    private void loadEventForm(){
        Intent linkEventForm = new Intent(this, AddEvent.class);

        String[] eventNames = getIntent().getStringArrayExtra("eventNames");
        String[] eventDescriptions = getIntent().getStringArrayExtra("eventDescriptions");
        String[] eventDateAndTimes = getIntent().getStringArrayExtra("eventDateAndTimes");
        String[] eventVenues = getIntent().getStringArrayExtra("eventVenues");
        String[] eventTicketPrices = getIntent().getStringArrayExtra("eventTickets");
        String[] eventOrganizers = getIntent().getStringArrayExtra("eventOrganizers");

        linkEventForm.putExtra("eventNames", eventNames);
        linkEventForm.putExtra("eventDescriptions", eventDescriptions);
        linkEventForm.putExtra("eventDateAndTimes", eventDateAndTimes);
        linkEventForm.putExtra("eventVenues", eventVenues);
        linkEventForm.putExtra("eventTickets", eventTicketPrices);
        linkEventForm.putExtra("eventOrganizers", eventOrganizers);

        for(int i = 0; i< eventNames.length; i++){
            System.out.println(eventNames[i].toString());
        }

        startActivity(linkEventForm);
    }

    private void displayErrorMessege(){
        LoginHandler loginHandler = new LoginHandler();
        TextView error    = findViewById(R.id.errorMessege);        //  Link error message text view
        error.setText(loginHandler.getErrorMessege());
    }

    //======================================
    //Shanuka Dilshan - IM/2020/017 (end)
    //======================================

    //======================================
    //Chamod Malshan - IM/2020/050 (start)
    //======================================

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
    //Chamod Malshan - IM/2020/050 (end)
    //======================================
}
