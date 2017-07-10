package info.androidhive.navigationdrawer.activity;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;

import org.json.JSONArray;
import org.json.JSONException;

import info.androidhive.navigationdrawer.other.DataSet;

/**
 * Created by srilu on 6/21/17.
 */

public class MyClient {


        //SAVE/RETRIEVE URLS
        private static final String DATA_INSERT_URL="http://192.168.0.2:3000/customers/blacklist";

        //INSTANCE FIELDS
        private final Context c;

        public MyClient(Context c) {
            this.c = c;

        }
        /*
        SAVE/INSERT
         */
        public void add(DataSet s, final View...inputViews)
        {
            if(s==null)
            {
                Toast.makeText(c, "No Data To Save", Toast.LENGTH_SHORT).show();
            }
            else
            {
                AndroidNetworking.post(DATA_INSERT_URL)
                        .addBodyParameter("action","save")
                        .addBodyParameter("id", String.valueOf(s.getId()))
                        .addBodyParameter("name",s.getName())
                        .addBodyParameter("blacklist",String.valueOf(s.getTechnologyExists()))
                        .setTag("TAG_ADD")
                        .build()
                        .getAsJSONArray(new JSONArrayRequestListener() {
                            @Override
                            public void onResponse(JSONArray response) {
                                Log.w("response", "response=" + response);
                                if(response != null)
                                    try {
                                        //SHOW RESPONSE FROM SERVER
                                        String responseString = response.get(0).toString();
                                        Toast.makeText(c, "SERVER RESPONSE : " + responseString, Toast.LENGTH_SHORT).show();

                                        if (responseString.equalsIgnoreCase("Success")) {
                                            //RESET VIEWS

                                        }else
                                        {
                                            Toast.makeText(c, "WASN'T SUCCESSFUL. ", Toast.LENGTH_SHORT).show();

                                        }


                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                        Toast.makeText(c, "GOOD RESPONSE BUT JAVA CAN'T PARSE JSON IT RECEIVED : "+e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }

                            }

                            //ERROR
                            @Override
                            public void onError(ANError anError) {
                                Toast.makeText(c, "UNSUCCESSFUL :  ERROR IS : "+anError.getMessage(), Toast.LENGTH_SHORT).show();
                            }


                        });

            }
        }



    }



