package com.example.davidnissenoff.grapevine6;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SaveInfo extends Activity {
    EditText rest_name, price, post, item;
    String r_name, r_price, r_post, r_item;
    Button mbutton;
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save_info_layout);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        rest_name = findViewById(R.id.restaurant_name_editText);
        price = findViewById(R.id.price_editText);
        post = findViewById(R.id.post_editText);
        item = findViewById(R.id.food_item_editText);


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        mImageView.setImageBitmap(bitmap);

    }

    public void makePost(View view){
        r_name = rest_name.getText().toString();
        r_price = price.getText().toString();
        r_post = post.getText().toString();
        r_item = item.getText().toString();

        if(!r_price.matches("[0-9]+")){

            Toast.makeText(getApplicationContext(),"Please enter a number in Price", Toast.LENGTH_LONG).show();

        }
        if(!r_price.matches("[0-9]+")&&  r_post.equals("") && r_item.equals("") && r_name.equals("") ){

            Toast.makeText(getApplicationContext(),"Please enter a number in Price", Toast.LENGTH_LONG).show();

        }
        if(r_post.equals("") || r_item.equals("") || r_name.equals("") || r_price.equals("")){
            Toast.makeText(getApplicationContext(),"One or more fields are empty", Toast.LENGTH_LONG).show();
        }

        else {if (r_price.matches("[0-9]+")){BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute("add_info", r_name, r_price, r_post, r_item);
        finish();}}
    }
    public void goBack(View view){
        finish();
    }

}
