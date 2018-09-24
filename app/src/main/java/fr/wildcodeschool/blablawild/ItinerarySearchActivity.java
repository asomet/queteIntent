package fr.wildcodeschool.blablawild;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;



public class ItinerarySearchActivity extends AppCompatActivity {
      public static final String EXTRA_DEPARTURE = "EXTRA_DEPARTURE";
      public static final String EXTRA_DESTINATION = "EXTRA_DESTINATION";


      public void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        Calendar myCalendar = Calendar.getInstance();
        EditText edittext = findViewById(R.id.TextDate);

        edittext.setText(sdf.format(myCalendar.getTime()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);
        final Calendar myCalendar = Calendar.getInstance();
        final EditText edittext = findViewById(R.id.TextDate);


        Button accept = findViewById(R.id.buttonSearch);
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editdDeparture = findViewById(R.id.TextDeparture);
                EditText editDestination = findViewById(R.id.TextDestination);

                String departureValue = editdDeparture.getText().toString();
                String destinationValue = editDestination.getText().toString();
                String dateValue = edittext.getText().toString();


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



        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        edittext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(ItinerarySearchActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }

}
