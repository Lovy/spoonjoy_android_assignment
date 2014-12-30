package com.spoonjoy.spoonjoydemo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.spoonjoy.spoonjoydemo.R;

public class EditCaption extends Activity {

    OnCaptionSelectedListener mCallback;

    // Container Activity must implement this interface
    public interface OnCaptionSelectedListener {
        public void onCaptionSelected();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_caption);
        final int position = getIntent().getIntExtra("position", 0);
        findViewById(R.id.button_accept).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String caption = ((TextView) findViewById(R.id.editcaption)).getText().toString();
                SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(EditCaption.this);
                sp.edit().putString(Integer.toString(position), caption).commit();
                //mCallback.onCaptionSelected();
                finish();
            }
        });

        findViewById(R.id.button_decline).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.edit_caption, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
