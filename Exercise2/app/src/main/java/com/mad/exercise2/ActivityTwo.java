package com.mad.exercise2;

import android.app.Activity;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;


public class ActivityTwo extends AppCompatActivity implements OnClickListener {

    /**
     * Make all the key to Constant variable
     **/
    public static final String NAME = "Name";
    public static final String PHONE = "Phone";
    public static final String PHONE_TYPE = "phoneType";
    public static final String EMAIL = "Email";

    // Initialise all var;
    TextView showNameTxt, showEmailTxt, showPhoneTxt, showPhoneType;
    public static Boolean CB_RESULT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        // Collect the MainActivity aka getIntent()... to show the output on this activity
        Intent intent = getIntent();

        showNameTxt = (TextView) findViewById(R.id.showName);
        showEmailTxt = (TextView) findViewById(R.id.email);
        showPhoneTxt = (TextView) findViewById(R.id.phoneNumber);
        showPhoneType = (TextView) findViewById(R.id.showPhoneType);


        // Show user input on the screen
        showNameTxt.setText(intent.getStringExtra(NAME));
        showPhoneTxt.setText(intent.getStringExtra(PHONE));
        showPhoneType.setText(intent.getStringExtra(PHONE_TYPE));
        showEmailTxt.setText(intent.getStringExtra(EMAIL));

        CheckBox cb = (CheckBox) findViewById(R.id.cb);
        CB_RESULT = true;

    }

    /**
     * Click the submit button in ActivityTwo you collect the value of the “I agree”
     * checkbox and you send a result back to MainActivity
     **/
    @Override
    public void onClick(View v) {
        // Extract checkbox value from the UI
        CheckBox cb = findViewById(R.id.cb);
        Boolean cbMessage = cb.isChecked();

        // Pass data to target Activity
        Intent intent = new Intent();
        intent.putExtra("returnBtn", cbMessage);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}


//        cb = (CheckBox) findViewById(R.id.checkbox);
//        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (cb.isChecked()) {
//                    Toast.makeText(ActivityTwo.this, TICK, Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(ActivityTwo.this, UNTICK, Toast.LENGTH_SHORT).show();
//                }
//            }
//        });