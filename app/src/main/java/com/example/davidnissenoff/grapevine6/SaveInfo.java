package com.example.davidnissenoff.grapevine6;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SaveInfo extends Activity {
    EditText rest_name, price, post;
    String r_name, r_price, r_post;
    Button mbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save_info_layout);
        rest_name = findViewById(R.id.restaurant_name_editText);
        price = findViewById(R.id.price_editText);
        post = findViewById(R.id.post_editText);


    }

    public void makePost(View view){
        r_name = rest_name.getText().toString();
        r_price = price.getText().toString();
        r_post = post.getText().toString();
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute("add_info", r_name, r_price, r_post);
        finish();
    }
}
