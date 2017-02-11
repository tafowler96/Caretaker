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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO: get tasks from database.. Pseudocode below
        Cursor cursor = db.query("SELECT * FROM tasks WHERE complete=false");

        RelativeLayout rl = (RelativeLayout) findViewById(R.id.activity_main);
        while (cursor.moveToNext()) {
            String title = cursor.getString(
                    cursor.getColumnIndexOrThrow(DatabaseExampleContract.ExampleEntry.COLUMN_NAME_TITLE)
            );
            TextView tv = new TextView(this);
            tv.setId(cursor.getString(
                    cursor.getColumnIndexOrThrow(DatabaseExampleContract.ExampleEntry.COLUMN_NAME_ID)));
            tv.setText(title);
            tv.setTextColor(Color.BLACK);

            Button button = new Button(this);
            button.setId(cursor.getString(
                    cursor.getColumnIndexOrThrow(DatabaseExampleContract.ExampleEntry.COLUMN_NAME_ID)));
            button.setText(R.string.button_complete);
            button.setOnClickListener(this);
            rl.addView(tv);
            rl.addView(button);
        }
    }

    public void onClick(View v) {
        //TODO: Remove from database
        //PLEASE SHOW UP ON GITHUB
        db.query("DELETE FROM table_name WHERE id=" + v.getId());
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.activity_main);
        r1.
    }

}
