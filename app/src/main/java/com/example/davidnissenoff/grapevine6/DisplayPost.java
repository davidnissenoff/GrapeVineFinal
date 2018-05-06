package com.example.davidnissenoff.grapevine6;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class DisplayPost extends AppCompatActivity {
    DbOperations mDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_post_layout);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute("get_info");

    }
    public void goBack2(View view){
        finish();
    }

}
