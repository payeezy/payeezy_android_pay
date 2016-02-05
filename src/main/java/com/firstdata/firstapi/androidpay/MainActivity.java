package com.firstdata.firstapi.androidpay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


/**
 *  Displays network status and a form to enter amount, environment and a "Pay" button.
 *  Starts the Checkout activity.
 */
public class MainActivity extends FragmentActivity {

    private TextView mConnectedLabel;
    private Button mPostButton;
    private EditText mTextAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //  Close the application
        if (getIntent().getBooleanExtra("LOGOUT", false)) {
            finish();
        }

        setContentView(R.layout.activity_main);

        // Get reference to the views
        mConnectedLabel = (TextView) findViewById(R.id.lblConnected);
        mPostButton = (Button) findViewById(R.id.btnPost);
        mTextAmount = (EditText) findViewById(R.id.amount);

        // check if you are connected or not
        if (isConnected()) {
            mConnectedLabel.setBackgroundColor(0xFF00CC00);
            mConnectedLabel.setText(R.string.network_connected);
        } else {
            mConnectedLabel.setText(R.string.network_not_connected);
        }

        // add click listener to Button "POST"
        mPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btnPost:
                        handlePostButton();
                        break;
                }
            }
        });
    }

    private void handlePostButton() {
        String amountText = mTextAmount.getText().toString();
        try {
            Double.parseDouble(amountText);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid amount", Toast.LENGTH_SHORT).show();
            return;
        }

        String selectedEnv = "CERT";

        Intent intent = CheckoutActivity.newIntent(this, amountText, selectedEnv);
        startActivity(intent);
    }

    /**
     * Check if device is connected to the network
     *
     * @return {@code true} if connected; {@code false} otherwise
     */
    public boolean isConnected() {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }

    public static Intent newIntent(Context ctx, boolean doLogout) {
        Intent intent = new Intent(ctx, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("LOGOUT", doLogout);
        return intent;
    }
}
