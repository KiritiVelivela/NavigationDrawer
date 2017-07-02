package info.androidhive.navigationdrawer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import info.androidhive.navigationdrawer.R;
import info.androidhive.navigationdrawer.other.Controller;

public class Detail extends AppCompatActivity {
    private static String  name1 = "name";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i=getIntent();
        String name = i.getStringExtra(name1);
        TextView lblName = (TextView) findViewById(R.id.name_label);

        ImageLoader imageLoader = Controller.getPermission().getImageLoader();
        String bitmap = i.getStringExtra("images");
        NetworkImageView thumbNail = (NetworkImageView) findViewById(R.id.imageview1);
        thumbNail.setImageUrl(bitmap, imageLoader);

        lblName.setText(name);

    }

    public void onClickHandler(View v) {
        switch (v.getId()) {
            case R.id.imageview1:
                startActivity(new Intent(this, AboutUsActivity.class));
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            // finish the activity
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}
