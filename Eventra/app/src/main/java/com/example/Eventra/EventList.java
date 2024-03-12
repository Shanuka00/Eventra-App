package com.example.Eventra;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EventList extends AppCompatActivity {

    //======================================
    //Pasindu Bhanuka - IM/2020/108 (start)
    //======================================

    DatabaseHandler db = new DatabaseHandler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_events);
        loadEvents();

        ImageView imgMenu = findViewById(R.id.imgMenu);
        ImageView imgRefresh = findViewById(R.id.imgRefresh);

        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadMenu();
            }
        });

        imgRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadEvents();
            }
        });
    }

    private void loadEvents(){
        /*
        * Check the eventlist is empty
        * If it is empty add dummy events
        * Else add Intent database
        * */

        try{

            addSavedEvents();
            System.out.println("Loaded Saved Events");

        }catch(Exception ex){

            addDummyEvents();

        }finally {
            dislpayEvents();
        }
    }
    //======================================
    //Pasindu Bhanuka - IM/2020/108 (end)
    //======================================

    //======================================
    //Chamod Malshan - IM/2020/050 (start)
    //======================================
    private void addSavedEvents(){
        String[] eventNames = getIntent().getStringArrayExtra("eventNames");
        String[] eventDescriptions = getIntent().getStringArrayExtra("eventDescriptions");
        String[] eventDateAndTimes = getIntent().getStringArrayExtra("eventDateAndTimes");
        String[] eventVenues = getIntent().getStringArrayExtra("eventVenues");
        String[] eventTicketPrices = getIntent().getStringArrayExtra("eventTickets");
        String[] eventOrganizers = getIntent().getStringArrayExtra("eventOrganizers");

        for(int i=0; i<eventNames.length; i++){
            db.addEvent(
                    eventNames[i],
                    eventDescriptions[i],
                    eventDateAndTimes[i],
                    eventVenues[i],
                    eventTicketPrices[i],
                    eventOrganizers[i]
            );
        }
    }

    //======================================
    //Chamod Malshan - IM/2020/050 (end)
    //======================================

    //======================================
    //Pasindu Bhanuka - IM/2020/108 (start)
    //======================================
    private void addDummyEvents(){
        db.addEvent(
                "Horror Night",
                "Sail with us on the haunting journey of 'The Voyage of the Demeter'!Prepare for an epic cinematic journey like no other! Don't miss this spine-tingling adventure!",
                "2023-10-25 12:30:00",
                "At A7 406, Faculty of Science",
                "Rs.100",
                "Rotaract"
        );
        db.addEvent(
                "SPERANZA'23",
                "SPERANZA'23, The Annual Awarding Ceremony of the Leo Club of University of Kelaniya is, HAPPENING 8TH OCTOBER! ❤‍🔥✨ Let's get ready to witness a fabulous moment of appreciation!",
                "2023-11-04 18:45:00",
                "At Dharmaloka Hall, UOK",
                "Free",
                "LEO Club"
        );
        db.addEvent(
                "Comedy ලන්තය’23 🎭",
                "Book your tickets now and get ready for the most exciting event of the year. 🤩🎟 Nothing is regretting than a missed opportunity. 🎭♥✨ ",
                "2023-11-08 16:30:00",
                "Dharmaloka Hall, UOK",
                "LKR 400, LKR 300",
                "Rotaract"
        );
        db.addEvent("Indian Food Festival",
                "Enjoy the taste of North Indian food at the Indian Food Festival Organized by Hindi Parishad & Department of Hindi Studies Celebrating the National Hindi Day of India.",
                "2023-11-15 19:30:00",
                "Polwatta Ground, UOK",
                "Free",
                "Hindi Parishad & Department of Hindi Studies"
        );

        db.addEvent(
                "Demons’ Night 🌙",
                "Lock in Your Spot for the Hottest Halloween DJ Party! 🎃 Demons’ Night🌙 Be the early bird and catch the spooky beats!",
                "2023-11-23 20:30:00",
                "Dharmaloka Hall, UOK",
                "LKR 300, LKR 250",
                "Rotaract Club"
        );

        db.addEvent(
                "NURAWANI '23",
                "NURAWANI '23: ELECTRIFYING MUSIC NIGHT! Prepare to be dazzled by the sensational performances of: \nAnuska & Dulaj (Wasthi)\n Nadeemal Perera \nWith the electrifying backing of the legendary 'Point Five' Crew! Get ready for a musical extravaganza like no other! Join us for a night of unforgettable music and entertainment! This is THE EVENT OF THE YEAR you don't want to miss out on. Get ready to be amazed! See you there!",
                "2023-10-18 16:12:00",
                "Dharmaloka Hall",
                "LKR 5000, LKR 2500",
                "Department of Accountancy"
        );

        db.addEvent(
                "Fashionista 2.0",
                "Fashionista, is  the first ever event organized for the fashion oriented young crowd by AIESEC in University of Kelaniya in collaboration with Informatics Institute of Technology. The fashion designing and modelling competitions followed by informative workshops associated with fashionista paved the way for the young crowd to make networks with the well-known fashion figures in the industry.",
                "2023-10-21 19:00:00",
                "Dharmaloka Hall | UOK",
                "Ticket price: 1000 LKR",
                "Organized by AIESEC in UOK"
        );
    }

    private void dislpayEvents(){

        LinearLayout sectionContainer = findViewById(R.id.sectionContainer);
        for(int i = (db.getEventsLength() - 1); i >= 0; i--){
        /**for (int i = 0; i < db.getEventsLength(); i++) {*/

            int eventID = i + 1;                           //  Set eventID to i + 1

            // Event section Linear Layout Parameters
            final int eventSectionWidth = 900;             //  Event Section Width
            final int eventSectionHeight = 370;            //  Event Section Height
            final int eventSectionMarginTop = 10;          //  Event Section Margin top
            final int eventSectionMarginBottom = 50;       //  Event Section Margin bottom
            final int eventSectionMarginLeft = 0;          //  Event Section Margin left
            final int eventSectionMarginRight = 0;         //  Event Section Margin right

            // Linear Layout for on event

            LinearLayout eventSection = new LinearLayout(getApplicationContext());       //  Create Linear Layout for eventSection
            eventSection.setId(eventID);
            LinearLayout.LayoutParams eventSectionParameters = new LinearLayout.LayoutParams(eventSectionWidth, eventSectionHeight);    //  Set width and height
            eventSectionParameters.setMargins(eventSectionMarginLeft, eventSectionMarginTop, eventSectionMarginRight, eventSectionMarginBottom);       //  Set top and bottom padding
            eventSectionParameters.gravity = Gravity.CENTER;                            //  Set gravity to center
            eventSection.setLayoutParams(eventSectionParameters);                       //  Add parameters to the eventSection
            eventSection.setOrientation(LinearLayout.VERTICAL);                         //  Set orientation to vertical
            eventSection.setBackgroundResource(R.drawable.home_section);                //  Set background image

            // Event title parameters

            final int eventTitleTextSize = 24;             //  Set event title text size
            final int eventTitlePaddingLeft = 30;          //  Set event title padding left
            final int eventTitlePaddingRight = 30;         //  Set event title padding right
            final int eventTitlePaddingTop = 20;           //  Set event title padding top
            final int eventTitlePaddingBottom = 20;        //  Set event title padding bottom
            final String eventTitleTextColor = "#FFE5B3";  //  Set event title text color
            int padding = 20;

            // Event title setup

            TextView eventTitle = new TextView(getApplicationContext());       //  Create even title text view
            eventTitle.setText(db.getEventName(eventID));                      //  Load even title text from the database
            eventTitle.setTextSize(eventTitleTextSize);                        //  Set Text Size
            eventTitle.setPadding(eventTitlePaddingLeft, eventTitlePaddingTop, eventTitlePaddingRight, eventTitlePaddingBottom);       //  Set Padding
            eventTitle.setTypeface(null, Typeface.BOLD);                    //  Set event title bold
            eventTitle.setPaintFlags(eventTitle.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);  //  Underline event title
            eventTitle.setTextColor(Color.parseColor(eventTitleTextColor));    //  Set event title text color
            eventTitle.setSelected(true);                                      //  Enable marquee effect for the event title
            eventTitle.setEllipsize(TextUtils.TruncateAt.MARQUEE);             //  Set the ellipsize to MARQUEE
            eventTitle.setSingleLine(true);                                    //  Ensure the event title is set to a single line for marquee effect

            eventSection.addView(eventTitle);                                  //  Add to the event section

            // Event Description Parameters

            final int eventDescriptionTextSize = 15;                           //  Set Event Description text size
            final int eventDescriptionPaddingLeft = 30;                        //  Set Event Description padding left
            final int eventDescriptionPaddingRight = 30;                       //  Set Event Description padding right
            final int eventDescriptionPaddingTop = 0;                          //  Set Event Description padding top
            final int eventDescriptionPaddingBottom = 20;                      //  Set Event Description padding bottom
            final String eventDescriptionTextColor = "#FFFFFF";                //  Set Event Description font color

            // Event Description setup

            TextView eventDescription = new TextView(getApplicationContext());     //  Create nex text view as event description
            eventDescription.setText(db.getEventDescription(eventID));             //  Load event desc from the database
            eventDescription.setTextSize(eventDescriptionTextSize);                //  Set text size
            eventDescription.setPadding(eventDescriptionPaddingLeft, eventDescriptionPaddingTop, eventDescriptionPaddingRight, eventDescriptionPaddingBottom);     //  Set padding
            eventDescription.setTextColor(Color.parseColor(eventDescriptionTextColor));    // Set text color
            eventDescription.setSelected(true);                                    // Enable marquee
            eventDescription.setEllipsize(TextUtils.TruncateAt.MARQUEE);           // Set the ellipsize to MARQUEE
            eventDescription.setSingleLine(true);                                  // Ensure the Event description is set to a single line for marquee effect

            eventSection.addView(eventDescription);                                //  Add to the event section

            // See more button parameters

            final String btnSeeMoreText = "See More";              //  Set btnSeeMore text
            final int btnSeeMoreHeight = 300;                      //  Set btnSeeMore height
            final int btnSeeMoreMarginLeft = 600;                  //  Set btnSeeMore margin left
            final int btnSeeMoreMarginRight = 0;                   //  Set btnSeeMore margin right
            final int btnSeeMoreMarginTop = 50;                    //  Set btnSeeMore margin top
            final int btnSeeMoreMarginBottom = 0;                  //  Set btnSeeMore margin bottom
            final int btnSeeMorePaddingLeft = 0;                   //  Set btnSeeMore padding left
            final int btnSeeMorePaddingRight = 0;                  //  Set btnSeeMore padding right
            final int btnSeeMorePaddingTop = 10;                   //  Set btnSeeMore padding top
            final int btnSeeMorePaddingBottom = 20;                //  Set btnSeeMore padding bottom
            final String btnSeeMoreBackgroundColor = "#0AB879";    //  Set btnSeeMore background color
            final String btnSeeMoreTextColor = "#FFFFFF";          //  Set btnSeeMore text color

            // See more button setup

            Button btnSeeMore = new Button(getApplicationContext());               //  Create See More button
            btnSeeMore.setText(btnSeeMoreText);                                    //  Setup See More inner text
            btnSeeMore.setHeight(btnSeeMoreHeight);                                //  Setup See More height
            LinearLayout.LayoutParams btnParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,                        //  Setup See More width
                    LinearLayout.LayoutParams.WRAP_CONTENT                         //  Setup See More height
            );
            btnParams.setMargins(btnSeeMoreMarginLeft, btnSeeMoreMarginTop, btnSeeMoreMarginRight, btnSeeMoreMarginBottom); // Setup See More Margins
            btnSeeMore.setLayoutParams(btnParams);                                 //  Add parameters to btn Layout

            btnSeeMore.setPadding(btnSeeMorePaddingLeft, btnSeeMorePaddingTop, btnSeeMorePaddingRight, btnSeeMorePaddingBottom);   //  Setup See More padding
            btnSeeMore.setBackgroundColor(Color.parseColor(btnSeeMoreBackgroundColor));    //  Setup See More Background color
            btnSeeMore.setTextColor(Color.parseColor(btnSeeMoreTextColor));                //  Setup See More text color
            btnSeeMore.setBackgroundResource(R.drawable.rounded_button);                   //  Setup bg image
            eventSection.addView(btnSeeMore);                                              //  Add to the even section

            // Event Section Parameters

            final int eventSectionPaddingLeft = 0;     //  Setup padding left
            final int eventSectionPaddingRight = 0;    //  Setup padding right
            final int eventSectionPaddingTop = 20;     //  Setup padding top
            final int eventSectionPaddingBottom = 20;  //  Setup padding bottom

            // Event Section Padding setup

            eventSection.setPadding(eventSectionPaddingLeft, eventSectionPaddingTop, eventSectionPaddingRight, eventSectionPaddingBottom);     // Padding Setup
            sectionContainer.addView(eventSection);        //  Add to the sectionContainer

            btnSeeMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LinearLayout parentLayout = (LinearLayout) v.getParent();   //  Select the parent linear layout
                    int sectionId = parentLayout.getId();                       //  Get the ID and store it
                    loadClickedEvent(sectionId);                                //  Load Clicked event
                }
            });

        }
    }

    //======================================
    //Pasindu Bhanuka - IM/2020/108 (end)
    //======================================


    //======================================
    //Chamod Malshan - IM/2020/050 (start)
    //======================================

    private void loadClickedEvent(int clickedEvent){
        Intent loadOneEvent = new Intent(this, OneEvent.class);                      //  Create intent for one event

        loadOneEvent.putExtra("eventName", db.getEventName(clickedEvent));                  //  Store event name
        loadOneEvent.putExtra("eventDescription", db.getEventDescription(clickedEvent));    //  Store event description
        loadOneEvent.putExtra("eventDateAndTime", db.getEventDateAndTime(clickedEvent));    //  Store event Date and Time
        loadOneEvent.putExtra("eventVenue", db.getEventVenue(clickedEvent));                //  Store event Venue
        loadOneEvent.putExtra("eventTicket", db.getEventTicket(clickedEvent));              //  Store event Ticket Price
        loadOneEvent.putExtra("eventOrganizer", db.getEventOrganizers(clickedEvent));      //  Store event Organizers

        String[]
                eventNames = new String[db.getEventsLength()],              // Initialize event names
                eventDescriptions = new String[db.getEventsLength()],       // Initialize event descriptions
                eventDateAndTimes = new String[db.getEventsLength()],       // Initialize event dates and times
                eventVenues = new String[db.getEventsLength()],             // Initialize event venues
                eventTickets = new String[db.getEventsLength()],            // Initialize event tickets
                eventOrganizers = new String[db.getEventsLength()]          // Initialize event organizers
                        ;

        for(int i=0; i< db.getEventsLength(); i++){

            eventNames[i] = db.getEventName(i + 1).toString();                      //  Copy from database to eventNames Array
            eventDescriptions[i] = db.getEventDescription(i + 1).toString();        //  Copy from database to eventDescriptions Array
            eventDateAndTimes[i] = db.getEventDateAndTime(i + 1).toString();        //  Copy from database to eventDateAndTime Array
            eventVenues[i] = db.getEventVenue(i + 1).toString();                    //  Copy from database to eventVenue Array
            eventTickets[i] = db.getEventTicket(i + 1).toString();                  //  Copy from database to eventTicket Array
            eventOrganizers[i] = db.getEventOrganizers(i + 1).toString();           //  Copy from database to eventOrganizers Array

            System.out.println(eventNames[i].toString());

        }

        loadOneEvent.putExtra("eventNames", eventNames);                        //  Copy to intent eventNames
        loadOneEvent.putExtra("eventDescriptions", eventDescriptions);          //  Copy to intent eventDescriptions
        loadOneEvent.putExtra("eventDateAndTimes", eventDateAndTimes);          //  Copy to intent eventDateAndTimes
        loadOneEvent.putExtra("eventVenues", eventVenues);                      //  Copy to intent eventVenues
        loadOneEvent.putExtra("eventTickets", eventTickets);                    //  Copy to intent eventTickets
        loadOneEvent.putExtra("eventOrganizers", eventOrganizers);              //  Copy to intent eventOrganizers

        startActivity(loadOneEvent);
    }

    private void loadMenu(){
        Intent menuLink = new Intent(this, Menu.class);

        String[]
                eventNames = new String[db.getEventsLength()],              // Initialize event names
                eventDescriptions = new String[db.getEventsLength()],       // Initialize event descriptions
                eventDateAndTimes = new String[db.getEventsLength()],       // Initialize event dates and times
                eventVenues = new String[db.getEventsLength()],             // Initialize event venues
                eventTickets = new String[db.getEventsLength()],            // Initialize event tickets
                eventOrganizers = new String[db.getEventsLength()]          // Initialize event organizers
                        ;

        for(int i=0; i< db.getEventsLength(); i++){

            eventNames[i] = db.getEventName(i + 1).toString();                      //  Copy from database to eventNames Array
            eventDescriptions[i] = db.getEventDescription(i + 1).toString();        //  Copy from database to eventDescriptions Array
            eventDateAndTimes[i] = db.getEventDateAndTime(i + 1).toString();        //  Copy from database to eventDateAndTime Array
            eventVenues[i] = db.getEventVenue(i + 1).toString();                    //  Copy from database to eventVenue Array
            eventTickets[i] = db.getEventTicket(i + 1).toString();                  //  Copy from database to eventTicket Array
            eventOrganizers[i] = db.getEventOrganizers(i + 1).toString();           //  Copy from database to eventOrganizers Array

            System.out.println(eventNames[i].toString());

        }

        menuLink.putExtra("eventNames", eventNames);                        //  Copy to intent eventNames
        menuLink.putExtra("eventDescriptions", eventDescriptions);          //  Copy to intent eventDescriptions
        menuLink.putExtra("eventDateAndTimes", eventDateAndTimes);          //  Copy to intent eventDateAndTimes
        menuLink.putExtra("eventVenues", eventVenues);                      //  Copy to intent eventVenues
        menuLink.putExtra("eventTickets", eventTickets);                    //  Copy to intent eventTickets
        menuLink.putExtra("eventOrganizers", eventOrganizers);              //  Copy to intent eventOrganizers

        startActivity(menuLink);
    }

    //======================================
    //Chamod Malshan - IM/2020/050 (end)
    //======================================
}
