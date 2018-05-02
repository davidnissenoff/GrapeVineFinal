package com.example.davidnissenoff.grapevine6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DisplayPost extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_post_layout);
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute("get_info");

    }
}
