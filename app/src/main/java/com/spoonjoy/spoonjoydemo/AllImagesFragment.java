package com.spoonjoy.spoonjoydemo;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class AllImagesFragment extends ListFragment {


    public AllImagesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<HashMap<String,String>> spoons = new ArrayList<HashMap<String,String>>();

        int[] myimages = {
                R.drawable.cherry,
                R.drawable.fuchsia,
                R.drawable.grey,
                R.drawable.iceblue,
                R.drawable.navy,
                R.drawable.sunshine
        };

        for(int i=0;i<6;i++){
            HashMap<String,String> h = new HashMap<String, String>();
            //Putting dummy images from drawables
            h.put("myimage",Integer.toString(myimages[i]));
            h.put("caption","No Caption");
            spoons.add(h);
        }

        String[] from = {"myimage"};
        int[] to = {R.id.spoonimage};

        SimpleAdapter adapter = new SimpleAdapter(getActivity(),spoons,R.layout.allimages_list_item,from,to);
        setListAdapter(adapter);
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent i = new Intent(getActivity(),ImageCarousel.class);
        i.putExtra("imageposition",position-1);
        startActivity(i);
    }
}
