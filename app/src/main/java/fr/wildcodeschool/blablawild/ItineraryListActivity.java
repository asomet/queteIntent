package fr.wildcodeschool.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import static fr.wildcodeschool.blablawild.ItinerarySearchActivity.EXTRA_DEPARTURE;
import static fr.wildcodeschool.blablawild.ItinerarySearchActivity.EXTRA_DESTINATION;

public class ItineraryListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_list);

        Intent intentFromSearch = getIntent();
        String departureValue = intentFromSearch.getStringExtra(EXTRA_DEPARTURE);
        String destinationValue = intentFromSearch.getStringExtra(EXTRA_DESTINATION);
        setTitle(departureValue + ">>" + destinationValue);
        

    }
}
