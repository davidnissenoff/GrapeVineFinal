package com.example.davidnissenoff.grapevine6;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
    public void addPost(View view){
        startActivity(new Intent(this, SaveInfo.class));
    }
    public void displayPosts(View view){
        startActivity(new Intent(this, DisplayPost.class));
    }
    public void googlebtn(View view){startActivity(new Intent(this, GooglePlaces.class));}
    public void takePhoto(View view){startActivity(new Intent(this, PictureActivity.class));}
}
