package com.example.davidnissenoff.grapevine6;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class SaveInfo extends Activity {
    EditText rest_name, price, post, item;
    String r_name, r_price, r_post, r_item;
    Button mbutton;
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save_info_layout);
        rest_name = findViewById(R.id.restaurant_name_editText);
        price = findViewById(R.id.price_editText);
        post = findViewById(R.id.post_editText);
        item = findViewById(R.id.food_item_editText);
        mbutton = findViewById(R.id.take_photo_btn);
        mImageView = findViewById(R.id.photo_image_view);
        mbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });

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
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute("add_info", r_name, r_price, r_post, r_item);
        finish();
    }

}
