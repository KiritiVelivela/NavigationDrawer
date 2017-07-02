package info.androidhive.navigationdrawer.other;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

import info.androidhive.navigationdrawer.R;
import info.androidhive.navigationdrawer.activity.AboutUsActivity;
import info.androidhive.navigationdrawer.activity.BlacklistActivity;
import info.androidhive.navigationdrawer.activity.PrivacyPolicyActivity;

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
        TextView worth = (TextView) convertView.findViewById(R.id.worth);
        TextView source = (TextView) convertView.findViewById(R.id.source);
        TextView year = (TextView) convertView.findViewById(R.id.inYear);
        DataSet m = DataList.get(position);
        thumbNail.setImageUrl(m.getImage(), imageLoader);
        name.setText(m.getName());
        source.setText("Order History: " + String.valueOf(m.getSource()));
        worth.setText(String.valueOf(m.getWorth()));
        //year.setText(String.valueOf(m.getYear()));

        return convertView;
    }

}
