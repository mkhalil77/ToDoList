package com.example.mk.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        final Context con = getApplicationContext();



        final EditText Taskname = (EditText) findViewById(R.id.taskname);
        final EditText Description = (EditText) findViewById(R.id.description_data);
        final EditText day = (EditText) findViewById(R.id.day);
        final EditText month = (EditText) findViewById(R.id.month);
        final EditText year = (EditText) findViewById(R.id.year);
        final Spinner importance = (Spinner) findViewById(R.id.spinner);
        final Button SaveButton = (Button) findViewById(R.id.save);
        final Button CancelButton = (Button) findViewById(R.id.cancel);
        final Button DsiplayButton = (Button) findViewById(R.id.Display);



        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinnerItems, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        importance.setAdapter(adapter);

        //change deponding on selected item
        importance.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                Context context = getApplicationContext();
                CharSequence text = "the slected item is " + selectedItem;
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            } // to close the onItemSelected

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Display Button
        DsiplayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, List.class);


                startActivity(intent);
            }
        });

        //save button ction

        SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database localdata = new Database(con);
                String taskname_ = Taskname.getText().toString();
                String description_ = Description.getText().toString();
                String date_ = day.getText().toString() + "/" + month.getText().toString() + "/" + year.getText().toString();
                String importance_ = importance.getSelectedItem().toString();


                SQLiteDatabase db = localdata.getWritableDatabase();
                ContentValues values = new ContentValues();

                values.put(Database.COLUMN_NAME_TaskName, taskname_);
                values.put(Database.COLUMN_NAME_Description, description_);
                values.put(Database.COLUMN_NAME_Date, date_);
                values.put(Database.COLUMN_NAME_Improtance, importance_);

                long newRowId;

                newRowId = db.insert(Database.TABLE_NAME, null, values);


                localdata.ReadAllDB();


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
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.mk.todolist/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.mk.todolist/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}























