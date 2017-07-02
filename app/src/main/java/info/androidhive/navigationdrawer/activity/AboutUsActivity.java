package info.androidhive.navigationdrawer.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.LruCache;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import info.androidhive.navigationdrawer.R;
import info.androidhive.navigationdrawer.other.Adapter;
import info.androidhive.navigationdrawer.other.Controller;
import info.androidhive.navigationdrawer.other.DataSet;

import static android.R.attr.bitmap;

public class AboutUsActivity extends AppCompatActivity {

    private Timer timer = new Timer();


    private static final String tag = MainActivity.class.getSimpleName();
    private static final String url = "http://10.0.2.2:3000/customers/four";
    private List<DataSet> list = new ArrayList<DataSet>();
    private ListView listView;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        listView = (ListView) findViewById(R.id.list);
        adapter = new Adapter(this, list);
        listView.setAdapter(adapter);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {


                JsonArrayRequest billionaireReq = new JsonArrayRequest(url,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {

                                for (int i = 0; i < response.length(); i++) {
                                    try {

                                        JSONObject obj = response.getJSONObject(i);
                                        DataSet dataSet = new DataSet();
                                        dataSet.setName(obj.getString("name"));
                                        dataSet.setImage(obj.getString("avatar_url"));
                                        dataSet.setWorth(obj.getString("gender"));
                                        dataSet.setYear(obj.getInt("age"));
                                        dataSet.setSource(obj.getString("history"));
                                        list.add(dataSet);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                }
                                adapter.notifyDataSetChanged();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        AlertDialog.Builder add = new AlertDialog.Builder(AboutUsActivity.this);
                        add.setMessage(error.getMessage()).setCancelable(true);
                        AlertDialog alert = add.create();
                        alert.setTitle("Error!!!");
                        alert.show();
                    }
                });
                Controller.getPermission().addToRequestQueue(billionaireReq);
                Controller.getPermission().getRequestQueue().getCache().remove(url);
                list.clear();

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String name1 = ((TextView) view.findViewById(R.id.name)).getText().toString();
                        String bitmap = ((DataSet) list.get(position)).getImage();

                        Intent intent = new Intent(AboutUsActivity.this, Detail.class);
                        intent.putExtra("name", name1);
                        intent.putExtra("images", bitmap);

                        startActivity(intent);
                    }
                });

            }
        }, 0, 1 * 10 * 1000);//10 Seconds
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
