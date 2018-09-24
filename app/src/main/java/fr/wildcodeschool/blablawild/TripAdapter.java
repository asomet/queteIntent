package fr.wildcodeschool.blablawild;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Date;

public class TripAdapter extends ArrayAdapter {


    public TripAdapter(Context context, ArrayList<TripModel> trips) {
        super(context, 0, trips);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        TripModel trip = (TripModel) getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_trip, parent, false);
        }
        //
        TextView firstname = (TextView) convertView.findViewById(R.id.firstname_trip_model);
        TextView lastname = (TextView) convertView.findViewById(R.id.lastname_trip_model);
        TextView date = (TextView) convertView.findViewById(R.id.date_trip_model);
        TextView price = (TextView) convertView.findViewById(R.id.price_trip_model);



        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy-hh:mm");

        Date mydate = trip.getDate();
        String convertedDate = fmt.format(mydate);

        Integer integerPrice = new Integer(0);
        int priceConvert = trip.getPrice();
        String ConvertPrice = integerPrice.toString(priceConvert);

        //
        firstname.setText(trip.getFirstname());
        lastname.setText(trip.getLastname());
        date.setText (convertedDate);
        price.setText(ConvertPrice);

        //
        return convertView;
    }
}
