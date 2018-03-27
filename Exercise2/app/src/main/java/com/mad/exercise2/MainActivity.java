package com.mad.exercise2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static final String LOG_TAG = "MainActivity";
    public static final int REQUEST_CODE = 1;
    public static final String SUBMIT_CLICK_NOTICE = "You clicked submit";
    public static final String CLEAR_MSG = "All data cleared";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialise all the button and edit text
        final EditText name = (EditText) findViewById(R.id.name);
        final EditText email = (EditText) findViewById(R.id.email);
        final EditText phone = (EditText) findViewById(R.id.phone);
        final Spinner phoneSpinner = (Spinner) findViewById(R.id.phone_spinner);

// Create an ArrayAdapter using the string array and a default spinner layout
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.phone_array, android.R.layout.simple_spinner_dropdown_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        phoneSpinner.setAdapter(adapter);

        // notify what user select
        phoneSpinner.setOnItemSelectedListener(this);


        // Submit Button handler with input collection
        Button submitBtn = (Button) findViewById(R.id.submit);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, SUBMIT_CLICK_NOTICE, Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();

                // Get all the input value that stored at above
                String nameTxt = name.getText().toString();
                String emailTxt = email.getText().toString();
                String phoneTxt = phone.getText().toString();
                String phoneType = phoneSpinner.getSelectedItem().toString();

                // 1. create an intent pass class name or intent action name
                Intent mIntent = new Intent(MainActivity.this, ActivityTwo.class);

                mIntent.putExtra("Name", nameTxt);
                mIntent.putExtra("Phone", phoneTxt);
                mIntent.putExtra("phoneType", phoneType);
                mIntent.putExtra("Email", emailTxt);

                startActivityForResult(mIntent, REQUEST_CODE);
            }

        });

        Button clearBtn = (Button) findViewById(R.id.clear);
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Clear all EditText
                name.getText().clear();
                email.getText().clear();
                phone.getText().clear();
                phoneSpinner.setAdapter(adapter);

                TextView tv = (TextView) view;
                Toast.makeText(getBaseContext(), CLEAR_MSG, Toast.LENGTH_SHORT).show();
            }
        });

        Button exitBtn = (Button) findViewById(R.id.exit);
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    /**
     * Receive result input from Activity Two
     **/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            // Snackbar to show the data...

            boolean cbMessage = data.getBooleanExtra("returnBtn", false);
            if (cbMessage) {
                Snackbar.make(findViewById(R.id.main_content_layout), getString(R.string.agree), Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            } else {
                Snackbar.make(findViewById(R.id.main_content_layout), getString(R.string.disagree), Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }


            Log.d(LOG_TAG, "onActivityResult: ");

        } else {
            Log.d(LOG_TAG, "Activity canceled.");
        }

//        switch (requestCode) {
//            case REQUEST_CODE:
//                if(resultCode == Activity.RESULT_OK){
//
//                    Log.d(LOG_TAG, "true or false");
//                }
//                else{
//                    Log.d(LOG_TAG, "not working: ");
//                }
//        }


    }

    /**
     * Show Toast text on the spinner value select
     **/
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        TextView myTxt = (TextView) view;
//        Toast.makeText(this, "You chose " + myTxt.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart: ");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume: ");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause: ");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy: ");
    }
}
