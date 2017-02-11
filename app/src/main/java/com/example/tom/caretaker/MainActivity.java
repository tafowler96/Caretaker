package com.example.tom.caretaker;

import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.net.UnknownHostException;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO: get tasks from database.. Pseudocode below
        MongoClientURI uri  = new MongoClientURI("mongodb://cyberleaders:cyberleaders2017@ds145299.mlab.com:45299/caregiver");
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());
        MongoCollection<Document> tasks = db.getCollection("taskschemas");
        MongoCursor<Document> cursor = tasks.find().iterator();
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.activity_main);
        while (cursor.hasNext()) {
            Document doc = cursor.next();
            String title = (String) doc.get("name");
            int id = (int) doc.get("_id");
            TextView tv = new TextView(this);
            tv.setId(id);
            tv.setText(title);
            tv.setTextColor(Color.BLACK);

            Button button = new Button(this);
            button.setId(id);
            button.setText(R.string.button_complete);
            button.setOnClickListener(this);
            rl.addView(tv);
            rl.addView(button);
        }
    }

    public void onClick(View v) {
        //TODO: Remove from database
        //PLEASE SHOW UP ON GITHUB
        MongoClientURI uri  = new MongoClientURI("mongodb://cyberleaders:cyberleaders2017@ds145299.mlab.com:45299/caregiver");
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.activity_main);
    }

}
