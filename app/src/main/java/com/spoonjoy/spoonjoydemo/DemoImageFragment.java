package com.spoonjoy.spoonjoydemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Hi5 on 12/30/2014.
 */
public class DemoImageFragment extends Fragment implements EditCaption.OnCaptionSelectedListener{
    public static final String ARG_OBJECT = "object";
    TextView Caption;
    int position;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // The last two arguments ensure LayoutParams are inflated
        // properly.
        View rootView = inflater.inflate(R.layout.image_carousel_item, container, false);
        final Bundle args = getArguments();
        int[] myimages = {
                R.drawable.cherry,
                R.drawable.fuchsia,
                R.drawable.grey,
                R.drawable.iceblue,
                R.drawable.navy,
                R.drawable.sunshine
        };

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String caption = sp.getString(Integer.toString(args.getInt(ARG_OBJECT)),"Set caption");
        position = args.getInt(ARG_OBJECT);
        ((ImageView)rootView.findViewById(R.id.imageitem)).setImageResource(myimages[args.getInt(ARG_OBJECT)]);
        Caption = ((TextView)rootView.findViewById(R.id.caption));
        Caption.setText(caption);
        Caption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent y = new Intent(getActivity(),EditCaption.class);
                y.putExtra("position",args.getInt(ARG_OBJECT));
                startActivityForResult(y, 1);
            }
        });

        /*((TextView) rootView.findViewById(android.R.id.text1)).setText(
                Integer.toString(args.getInt(ARG_OBJECT)));*/
        return rootView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("debug", "actresult");
        super.onActivityResult(requestCode, resultCode, data);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String caption = sp.getString(Integer.toString(position),"Set caption");
        Caption.setText(caption);
    }

    @Override
    public void onCaptionSelected() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String caption = sp.getString("caption_value","Set caption");
        Caption.setText(caption);
    }
}
