package info.androidhive.navigationdrawer.other;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import info.androidhive.navigationdrawer.R;

/**
 * Created by srilu on 7/3/17.
 */

public class NotificationReceiver extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        TextView tv = new TextView(this);
        tv.setText("Notification Text");

        setContentView(tv);
    }

}