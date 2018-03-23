package com.mad.exercise2;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner phoneSpinner = (Spinner) findViewById(R.id.phone_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.phone_array, android.R.layout.simple_spinner_dropdown_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        phoneSpinner.setAdapter(adapter);
        phoneSpinner.setOnItemSelectedListener(this);

      // Submit Button event handler
        Button submitBtn = (Button) findViewById(R.id.submit);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "submit is clicked", Snackbar.LENGTH_SHORT)
                        .setAction("Click here", new View.OnClickListener() { // callback function
                            @Override
                            public void onClick(View v) {
                                Snackbar.make(v, "Hohoho~~~", Snackbar.LENGTH_SHORT)
                                        .show();
                            }
                        }).show();
            }
        });

       // Clear Button event handler
        Button clearBtn = (Button) findViewById(R.id.clear);
        clearBtn.setOnClickListener(new View.OnClickListener (){

            @Override
            public void onClick(View v) {
                EditText name = (EditText) findViewById(R.id.name);
                EditText email = (EditText) findViewById(R.id.email);
                EditText phone = (EditText) findViewById(R.id.phone);


            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView myTxt = (TextView) view;
        Toast.makeText(this, "You chose " + myTxt.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
