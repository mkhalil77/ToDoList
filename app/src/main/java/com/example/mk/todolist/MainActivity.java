package com.example.mk.todolist;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);





        final EditText Taskname = (EditText) findViewById(R.id.taskname);
        final EditText Description = (EditText) findViewById(R.id.description_data);
        final EditText day = (EditText) findViewById(R.id.day);
        final EditText month = (EditText) findViewById(R.id.month);
        final EditText year = (EditText) findViewById(R.id.year);
        final Spinner importance = (Spinner) findViewById(R.id.spinner);
        final Button SaveButton = (Button) findViewById(R.id.save);
        final Button CancelButton = (Button) findViewById(R.id.cancel);


        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinnerItems, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        importance.setAdapter(adapter);

        //change deponding on selected item
        importance.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedItem = parent.getItemAtPosition(position).toString();
                Context context = getApplicationContext();
                CharSequence text = "the slected item is " + selectedItem;
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });




        // Action of Cancel Button
        CancelButton.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View view) {


                CharSequence text = "Hello toast!";
                int duration = Toast.LENGTH_SHORT;

              Toast toast = Toast.makeText(getApplicationContext(), text, duration);
              toast.show();
                Taskname.setText("");
                Description.setText("");
                day.setText("");
                month.setText("");
                year.setText("");
                importance.setSelection(0);

            }
        });
    }











    }























