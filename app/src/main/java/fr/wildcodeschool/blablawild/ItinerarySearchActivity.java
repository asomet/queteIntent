package fr.wildcodeschool.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ItinerarySearchActivity extends AppCompatActivity {
      public static final String EXTRA_DEPARTURE = "EXTRA_DEPARTURE";
      public static final String EXTRA_DESTINATION = "EXTRA_DESTINATION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);


        Button accept = findViewById(R.id.buttonSearch);
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editdDeparture = findViewById(R.id.TextDeparture);
                EditText editDestination = findViewById(R.id.TextDestination);
                EditText editDate = findViewById(R.id.TextDate);
                String departureValue = editdDeparture.getText().toString();
                String destinationValue = editDestination.getText().toString();
                String dateValue = editDate.getText().toString();


                if (departureValue.isEmpty() || destinationValue.equals("")) {
                    Toast.makeText(ItinerarySearchActivity.this, "ERROR EMPTY!", Toast.LENGTH_LONG).show();

                } else {


                    Intent goToList = new Intent(ItinerarySearchActivity.this,ItineraryListActivity.class);
                    goToList.putExtra("EXTRA_DEPARTURE",departureValue);
                    goToList.putExtra("EXTRA_DESTINATION", destinationValue);
                    startActivity(goToList);
                }


            }


        });
    }}
