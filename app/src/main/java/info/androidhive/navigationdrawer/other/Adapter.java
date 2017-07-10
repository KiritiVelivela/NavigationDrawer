package info.androidhive.navigationdrawer.other;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;
import java.util.Objects;

import info.androidhive.navigationdrawer.R;
import info.androidhive.navigationdrawer.activity.AboutUsActivity;
import info.androidhive.navigationdrawer.activity.BlacklistActivity;
import info.androidhive.navigationdrawer.activity.PrivacyPolicyActivity;

import static info.androidhive.navigationdrawer.activity.MainActivity.rolit;

/**
 * Created by srilu on 5/31/17.
 */


public class Adapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<DataSet> DataList;
    ImageLoader imageLoader = Controller.getPermission().getImageLoader();
    int i;

    public Adapter(AboutUsActivity activity, List<DataSet> billionairesItems) {
        this.activity = activity;
        this.DataList = billionairesItems;
        i = 0;
    }

    public Adapter(PrivacyPolicyActivity activity, List<DataSet> billionairesItems) {
        this.activity = activity;
        this.DataList = billionairesItems;
        i = 2;
    }

    public Adapter(BlacklistActivity activity, List<DataSet> billionairesItems) {
        this.activity = activity;
        this.DataList = billionairesItems;
        i = 1;
    }

    @Override
    public int getCount() {
        return DataList.size();
    }

    @Override
    public Object getItem(int location) {
        return DataList.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity

                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            Log.w("ival", "ival =" + i);
            if (i == 0)
            convertView = inflater.inflate(R.layout.list_row, null);
        else if (i == 1)
            convertView = inflater.inflate(R.layout.list_row1, null);
        else  if (i == 2)
                convertView = inflater.inflate(R.layout.list_row, null);


        if (imageLoader == null)
            imageLoader = Controller.getPermission().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) convertView
                .findViewById(R.id.thumbnail);
        TextView name = (TextView) convertView.findViewById(R.id.name);

       // TextView worth = (TextView) convertView.findViewById(R.id.worth);

        TextView source = (TextView) convertView.findViewById(R.id.source);
        TextView year = (TextView) convertView.findViewById(R.id.inYear);
        TextView blacklist = (TextView) convertView.findViewById(R.id.blacklist);
        //TextView emotions = (TextView) convertView.findViewById(R.id.emotion);
         ImageView ha = (ImageView) convertView.findViewById(R.id.emotion);
        ImageView ge = (ImageView) convertView.findViewById(R.id.gender);
      //  ImageView ne = (ImageView) convertView.findViewById(R.id.emotion_neutral);
        //ImageView sa = (ImageView) convertView.findViewById(R.id.emotion_sad);

        DataSet m = DataList.get(position);
        thumbNail.setImageUrl(m.getImage(), imageLoader);
        name.setText(m.getName());
        Log.w("role", "role ="+rolit);
        if (!Objects.equals(rolit, "Security")) {
            source.setText("Order History: " + String.valueOf(m.getSource()));

            if (Objects.equals(String.valueOf(m.getWorth()), "male")) {
                ge.setImageResource(R.drawable.ic_male);
            }
            else if (Objects.equals(String.valueOf(m.getWorth()), "female")) {
                ge.setImageResource(R.drawable.ic_female);
            }
            //worth.setText(String.valueOf(m.getWorth()));
        }
        year.setText(String.valueOf(m.getYear()));
       if (!Objects.equals(rolit, "Helper")) {
            blacklist.setText(String.valueOf(m.getBlacklist()));
           Log.w("blacklist", "blacklist ="+blacklist);
       }

       if (!Objects.equals(rolit, "Security") && !Objects.equals(rolit, "Helper")) {

           if (Objects.equals(String.valueOf(m.getEmotion()), "happy")) {
               ha.setImageResource(R.drawable.ic_happy);
              // emotions.setText(String.valueOf(m.getEmotion()));
           }
           else if (Objects.equals(String.valueOf(m.getEmotion()), "neutral")) {
               ha.setImageResource(R.drawable.ic_neutral);
           }
           else if (Objects.equals(String.valueOf(m.getEmotion()), "sad"))
               ha.setImageResource(R.drawable.ic_sad);
           }
        return convertView;
    }


}
