package com.example.starsignpicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class StarSignPicker extends AppCompatActivity
{   // EXTRA_SIGN_NAME string constant that will be used to store an extra in our return Intent
    // to indicate the star sign selected by user.
    public static final String EXTRA_SIGN_NAME = "SIGN_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_sign_picker);
        // calling OR instantiating the adapter
        StarSignPickerAdapter adapter = new StarSignPickerAdapter();

        /*Create a new IAdapterItemClick handler and assign it to the Adapter using the
        setOnAdapterItemClick method. When an item is clicked, create a new result Intent
        and use the EXTRA_SIGN_NAME string to assign an extra that contains the selected star
        sign. Assign the new Intent as this Activity’s result using setResult*/
        adapter.setOnAdapterItemClick(new StarSignPickerAdapter.IAdapterItemClick()
        {
            @Override
            public void onItemClicked(String selectedItem)
            {
                // Construct the result URI.
                Intent outData  = new Intent();
                outData.putExtra(EXTRA_SIGN_NAME, selectedItem);
                setResult(Activity.RESULT_OK, outData);
                finish(); // this is called to close the Activity and return to the caller
            }
        }); // end adapter call.

        /// Assign the adapter to the recycler view using setAdapter
        RecyclerView rv = findViewById(R.id.recycler_view);
        rv.setAdapter(adapter);
    } // end onCreate method
} // end class StarSignPicker
