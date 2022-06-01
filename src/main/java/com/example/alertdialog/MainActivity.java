package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button closeButton;
    AlertDialog.Builder builder;
    AutoCompleteTextView Autocomplete;


    String[] fruits ={"Apple","Anjir","Pappaya","Pine","Berry","Bananas","Mango","water-melon"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        closeButton = findViewById(R.id.btnclose);
        builder = new AlertDialog.Builder(this);



       final ArrayAdapter<String>adapter = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item,fruits);
        AutoCompleteTextView a = (AutoCompleteTextView)findViewById(R.id.auto);

        a.setThreshold(1);
        a.setAdapter(adapter);
        a.setTextColor(Color.BLUE);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage("Do you really want to close the application ?").setCancelable(false)
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                                Toast.makeText(getApplicationContext(), "This application is closed", Toast.LENGTH_LONG).show();

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(), "You choose no action for alertbox", Toast.LENGTH_LONG).show();

                            }
                        });
                AlertDialog alert = builder.create();
                alert.setTitle("Alert Message");
                alert.show();
            }
        });

    }
}