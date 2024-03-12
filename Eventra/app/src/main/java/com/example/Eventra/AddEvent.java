package com.example.Eventra;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;


import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class AddEvent extends AppCompatActivity {

    //======================================
    //Shanuka Dilshan - IM/2020/017 (start)
    //======================================

    TextView dateAndTime;
    String selectedDate, selectedTime;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        Button btnAddEvent = findViewById(R.id.btnAddEvent);                        //  Link add event button
        Button btnClearTheEventForm = findViewById(R.id.btnClearEventForm);         //  Link clear event button
        dateAndTime = findViewById(R.id.txtDateAndTime);                            //  Link date and time picker
        ImageView menuLink = findViewById(R.id.imgMenu);
        ImageView refresh = findViewById(R.id.imgRefresh);

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearForm();
            }
        });

        menuLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadMenu();
            }
        });


        dateAndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dateAndTime.setText("");
                showDateTimePickerDialog();
            }
        });


        btnAddEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEventAndLoadEventList();

            }
        });

        btnClearTheEventForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearForm();
            }
        });
    }

    private void addEventAndLoadEventList(){
        EditText eventName = findViewById(R.id.txtEventTitle);                      //  Link event name
        EditText eventDescription = findViewById(R.id.txtEventDescription);         //  Link event description
        EditText eventDateAndTime = findViewById(R.id.txtDateAndTime);              //  Link event date and time
        EditText eventVenue = findViewById(R.id.txtVenue);                          //  Link event venue
        EditText eventTicketPrice = findViewById(R.id.txtTicketPrize);              //  Link ticket price
        EditText eventOrganizer = findViewById(R.id.txtOrganizedBy);                //  Link event organizers


        String eventNameText = eventName.getText().toString();                      //  Store event name
        String eventDescriptionText = eventDescription.getText().toString();        //  Store event description
        String eventDateAndTimeText = eventDateAndTime.getText().toString();        //  Store date and time
        String eventVenueText = eventVenue.getText().toString();                    //  Store venue
        String eventTicketPriceText = eventTicketPrice.getText().toString();        //  Store ticket prices
        String eventOrganizerText = eventOrganizer.getText().toString();            //  Store organizers

        Intent linkEventForm = new Intent(this, EventList.class);       //  Start intent

        String[] eventNames = new String[1];
        String[] eventDescriptions = new String[1];
        String[] eventDateAndTimes = new String[1];
        String[] eventVenues = new String[1];
        String[] eventTicketPrices = new String[1];
        String[] eventOrganizers = new String[1];

        String[] eventNamesCopy = new String[1];
        String[] eventDescriptionsCopy = new String[1];
        String[] eventDateAndTimesCopy = new String[1];
        String[] eventVenuesCopy = new String[1];
        String[] eventTicketPricesCopy = new String[1];
        String[] eventOrganizersCopy = new String[1];;

        int valuePuttingIndex = 0;                              //  Get array's value putting index

        try{

            String[] allRows = getIntent().getStringArrayExtra("eventNames");
            valuePuttingIndex = allRows.length;                 //  Get array's value putting index
            int arrayLength = valuePuttingIndex + 1;

            System.out.println(arrayLength);

            eventNamesCopy = new String[arrayLength];
            eventDescriptionsCopy = new String[arrayLength];
            eventDateAndTimesCopy = new String[arrayLength];
            eventVenuesCopy = new String[arrayLength];
            eventTicketPricesCopy = new String[arrayLength];
            eventOrganizersCopy = new String[arrayLength];;

            eventNames = getIntent().getStringArrayExtra("eventNames");                    //  Get Previously Stored Names
            eventDescriptions = getIntent().getStringArrayExtra("eventDescriptions");      //  Get Previously Stored Descriptions
            eventDateAndTimes = getIntent().getStringArrayExtra("eventDateAndTimes");      //  Get Previously Stored Dates and Time
            eventVenues = getIntent().getStringArrayExtra("eventVenues");                  //  Get Previously Stored Venues
            eventTicketPrices = getIntent().getStringArrayExtra("eventTickets");           //  Get Previously Stored Ticket Prices
            eventOrganizers = getIntent().getStringArrayExtra("eventOrganizers");          //  Get Previously Stored O

            for (int i = 0; i < valuePuttingIndex; i++) {
                eventNamesCopy[i] = eventNames[i];
                eventDescriptionsCopy[i] = eventDescriptions[i];
                eventDateAndTimesCopy[i] = eventDateAndTimes[i];
                eventVenuesCopy[i] = eventVenues[i];
                eventTicketPricesCopy[i] = eventTicketPrices[i];
                eventOrganizersCopy[i] = eventOrganizers[i];
            }

            System.out.println("Events Copied");
            System.out.println(valuePuttingIndex);
        }catch (Exception ex){
            valuePuttingIndex = 0;

            eventNames = new String[1];
            eventDescriptions = new String[1];
            eventDateAndTimes = new String[1];
            eventVenues = new String[1];
            eventTicketPrices = new String[1];
            eventOrganizers = new String[1];

            System.out.println(ex.toString());
        }finally{

            try {
                System.out.println(valuePuttingIndex);
                eventNamesCopy[valuePuttingIndex] = eventNameText;                          // Add event name to the last index
                eventDescriptionsCopy[valuePuttingIndex] = eventDescriptionText;            // Add event description to the last index
                eventDateAndTimesCopy[valuePuttingIndex] = eventDateAndTimeText;            // Add event date and time to the last index
                eventVenuesCopy[valuePuttingIndex] = eventVenueText;                        // Add event venue to the last index
                eventTicketPricesCopy[valuePuttingIndex] = eventTicketPriceText;            // Add event ticket prices to the last index
                eventOrganizersCopy[valuePuttingIndex] = eventOrganizerText;                // Add event organizers to the last index

                linkEventForm.putExtra("eventNames", eventNamesCopy);                  //  Store event name
                linkEventForm.putExtra("eventDescriptions", eventDescriptionsCopy);    //  Store event description
                linkEventForm.putExtra("eventDateAndTimes", eventDateAndTimesCopy);    //  Store event Date and Time
                linkEventForm.putExtra("eventVenues", eventVenuesCopy);                //  Store event Venue
                linkEventForm.putExtra("eventTickets", eventTicketPricesCopy);         //  Store event Ticket Price
                linkEventForm.putExtra("eventOrganizers", eventOrganizersCopy);        //  Store event Organizers

                startActivity(linkEventForm);                                            //  Load Event List

            }catch (Exception eee){
                TextView warningMessage = findViewById(R.id.warningEvent);               // Link error message
                warningMessage.setText("Please fill all fields");                        // Show error message
                System.out.println(eee.toString());
            }
        }

    }

    private void clearForm(){

        EditText eventName = findViewById(R.id.txtEventTitle);                      //  Link event name
        EditText eventDescription = findViewById(R.id.txtEventDescription);         //  Link event description
        EditText eventDateAndTime = findViewById(R.id.txtDateAndTime);              //  Link event date and time
        EditText eventVenue = findViewById(R.id.txtVenue);                          //  Link event venue
        EditText eventTicketPrice = findViewById(R.id.txtTicketPrize);              //  Link ticket price
        EditText eventOrganizer = findViewById(R.id.txtOrganizedBy);                //  Link event organizers

        TextView warningMessage = findViewById(R.id.warningEvent);                  // Link error message

        eventName.setText("");                  // Clear Event Name
        eventDescription.setText("");           // Clear Event Description
        eventDateAndTime.setText("");           // Clear Event Date and Time
        eventVenue.setText("");                 // Clear Event Venue
        eventTicketPrice.setText("");           // Clear Event Ticket Price
        eventOrganizer.setText("");             // Clear Event Organizer

        warningMessage.setText("");              // Clear error message

    }
    //======================================
    //Shanuka Dilshan - IM/2020/017 (end)
    //======================================

    //======================================
    //Chamod Malshan - IM/2020/050 (start)
    //======================================
    private void showDateTimePickerDialog() {
        Calendar currentDateTime = Calendar.getInstance();
        int year = currentDateTime.get(Calendar.YEAR);
        int month = currentDateTime.get(Calendar.MONTH);
        int day = currentDateTime.get(Calendar.DAY_OF_MONTH);
        int hour = currentDateTime.get(Calendar.HOUR_OF_DAY);
        int minute = currentDateTime.get(Calendar.MINUTE);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                selectedDate = selectedYear + "-" + (selectedMonth + 1) + "-" + selectedDay;
                showTimePickerDialog(hour, minute);
            }
        }, year, month, day);
        datePickerDialog.show();
    }

    private void showTimePickerDialog(int hour, int minute) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
                selectedTime = String.format("%02d:%02d", selectedHour, selectedMinute);
                dateAndTime.setText(selectedDate + " " + selectedTime);
            }
        }, hour, minute, true);
        timePickerDialog.show();
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
    //Chamod Malshan - IM/2020/050 (end)
    //=====================================
}
