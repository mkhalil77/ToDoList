package com.example.mk.todolist;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class List extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView Biglist = (ListView) findViewById(R.id.listView);
        Database localdata = new Database(getApplicationContext());
        localdata.tasklist.clear();
        localdata.ReadAllDB();


        final ArrayList<String> list = new ArrayList<String>();


        for (int i = 0; i < localdata.tasklist.size(); i++) {
            list.add(localdata.tasklist.get(i).toString());
            Log.d("TAG 7", i + " " + "  " + localdata.tasklist.get(i).toString());

        }


        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);

        Biglist.setAdapter(adapter);





    }

}
