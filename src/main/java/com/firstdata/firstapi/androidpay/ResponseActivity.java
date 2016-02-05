package com.firstdata.firstapi.androidpay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Displays the Json response from the First Data servers and allows the user to quit
 * the application.
 */
public class ResponseActivity extends Activity {

    private String message;

    private Button mQuitButton;
    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);

        message = getIntent().getStringExtra(Constants.EXTRA_RESULT_MESSAGE);

        mTextMessage = (TextView) findViewById(R.id.response_message);
        mQuitButton = (Button) findViewById(R.id.quit_button);

        mQuitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = MainActivity.newIntent(getApplicationContext(), true);
                startActivity(intent);
            }
        });
        mTextMessage.setText(message);
    }

    public static Intent newIntent(FragmentActivity activity, String status, String message) {
        Intent intent = new Intent(activity, ResponseActivity.class);
        intent.putExtra(Constants.EXTRA_RESULT_STATUS, status);
        intent.putExtra(Constants.EXTRA_RESULT_MESSAGE, message);
        return intent;
    }
}
