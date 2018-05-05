package com.example.davidnissenoff.grapevine6;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

public class BackgroundTask extends AsyncTask<String, Post, String> {
    Context context;
    PostAdapter postAdapter;
    Activity activity;
    ListView listView;
    BackgroundTask(Context context){
        this.context = context;
        activity = (Activity) context;

    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        String method = params[0];
        DbOperations dbOperations = new DbOperations(context);
        if(method.equals("add_info")){
            String name = params[1];
            int price = Integer.parseInt(params[2]);
            String post = params[3];
            String item = params[4];
            SQLiteDatabase db = dbOperations.getWritableDatabase();
            dbOperations.addInformations(db, name, price, post, item);
            return "Post Created!";

        }
        else if(method.equals("get_info")){
            listView = activity.findViewById(R.id.display_listview);
            SQLiteDatabase db = dbOperations.getWritableDatabase();
            Cursor cursor = dbOperations.getInformations(db);
            postAdapter = new PostAdapter(context, R.layout.display_posts);
            String rest_name, post, item;
            int price;
            while (cursor.moveToNext()){
                rest_name = cursor.getString(cursor.getColumnIndex(PostContract.PostEntry.NAME));
                price = cursor.getInt(cursor.getColumnIndex(PostContract.PostEntry.PRICE));
                post = cursor.getString(cursor.getColumnIndex(PostContract.PostEntry.POST));
                item = cursor.getString(cursor.getColumnIndex(PostContract.PostEntry.ITEM));
                Post post1 = new Post(rest_name, price, post, item);
                publishProgress(post1);
            }
                return "get_info";
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Post... values) {
        postAdapter.add(values[0]);

    }

    @Override
    protected void onPostExecute(String result) {
        if(result.equals("get_info")){
            listView.setAdapter(postAdapter);
        }
        else{
            Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        }

    }

}
