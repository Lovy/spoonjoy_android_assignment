package com.spoonjoy.spoonjoydemo;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import com.spoonjoy.spoonjoydemo.R;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ImageCarousel extends FragmentActivity {
    // When requested, this adapter returns a DemoImageFragment,
    // representing an object in the collection.
    ImageCarouselPagerAdapter mImageCarouselPagerAdapter;
    ViewPager mViewPager;
    static int iposition;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_carousel);
        ImageCarousel.iposition = getIntent().getIntExtra("imageposition",1);
        // ViewPager and its adapters use support library
        // fragments, so use getSupportFragmentManager.
        mImageCarouselPagerAdapter =
                new ImageCarouselPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mImageCarouselPagerAdapter);
        Log.d("debug",Integer.toString(ImageCarousel.iposition));
        mViewPager.setCurrentItem(iposition+1);
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.image_carousel, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            SetCaptionDialog mDialog = new SetCaptionDialog();
            mDialog.show(getFragmentManager(),null);
        }
        return super.onOptionsItemSelected(item);
    }*/

    /*// The dialog fragment receives a reference to this Activity through the
    // Fragment.onAttach() callback, which it uses to call the following methods
    // defined by the NoticeDialogFragment.NoticeDialogListener interface
    @Override
    public void onDialogPositiveClick(DialogFragment dialog,String value) {
        // User touched the dialog's positive button
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        sp.edit().putString(Integer.toString(ImageCarousel.iposition+1), value).commit();
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        // User touched the dialog's negative button

    }*/



}

// Since this is an object collection, use a FragmentStatePagerAdapter,
// and NOT a FragmentPagerAdapter.
    class ImageCarouselPagerAdapter extends FragmentStatePagerAdapter {
    public ImageCarouselPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        ImageCarousel.iposition = i;
        Fragment fragment = new DemoImageFragment();
        Bundle args = new Bundle();
        // Our object is just an integer :-P
        args.putInt(DemoImageFragment.ARG_OBJECT, i);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "OBJECT " + (position + 1);
    }
}

