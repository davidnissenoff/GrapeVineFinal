package com.example.davidnissenoff.grapevine6;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class DisplayImage extends Activity {
    private MyImage image;
    private ImageView imageView;
    private TextView description;
    private String jstring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_image);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        imageView = (ImageView) findViewById(R.id.display_image_view);
        description = (TextView) findViewById(R.id.text_view_description);
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            jstring = extras.getString("IMAGE");
        }
        image = getMyImage(jstring);
        description.setText(image.toString());
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        imageView.setImageBitmap(ImageResizer
                .decodeSampledBitmapFromFile(image.getPath(), width, height));
    }

    private MyImage getMyImage(String image) {
        try {
            JSONObject job = new JSONObject(image);
            return (new MyImage(job.getString("title"),
                    job.getString("description"), job.getString("path"),
                    job.getLong("datetimeLong")));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void btnBackOnClick(View v) {
        startActivity(new Intent(this, PictureActivity.class));
        finish();
    }


    public void btnDeleteOnClick(View v) {
        DAOdb db = new DAOdb(this);
        db.deleteImage(image);
        db.close();
        startActivity(new Intent(this, PictureActivity.class));
        finish();
    }

    @Override protected void onSaveInstanceState(Bundle outState) {

        if (jstring != null) {
            outState.putString("jstring", jstring);
        }

        super.onSaveInstanceState(outState);
    }

    @Override protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Restore state members from saved instance
        if (savedInstanceState.containsKey("jstring")) {
            jstring = savedInstanceState.getString("jstring");
        }
    }
}