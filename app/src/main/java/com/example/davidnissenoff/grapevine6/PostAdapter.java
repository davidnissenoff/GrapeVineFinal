package com.example.davidnissenoff.grapevine6;

import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.nio.DoubleBuffer;
import java.util.ArrayList;
import java.util.List;

import static com.example.davidnissenoff.grapevine6.PostContract.PostEntry.ITEM;
import static com.example.davidnissenoff.grapevine6.PostContract.PostEntry.NAME;
import static com.example.davidnissenoff.grapevine6.PostContract.PostEntry.TABLE_NAME;

public class PostAdapter extends ArrayAdapter {
    List list = new ArrayList();
    public int deleteItem;
    SQLiteDatabase db;
    DbOperations dbOperations;
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "post_info.db";
    private static final String KEY_ID = "_id";
    private SQLiteDatabase sqLiteDatabase;
    private static final String CREATE_QUERY = "create table " + TABLE_NAME +
            "("+ KEY_ID + " integer primary key autoincrement," + NAME+ " text,"+ PostContract.PostEntry.PRICE+" integer,"+
            PostContract.PostEntry.POST+" text," + ITEM +" text);";
    public PostAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(Post object){
        list.add(object);
        super.add(object);
    }
    @Override
    public int getCount(){
        return list.size();
    }
    @Override
    public Object getItem(int position){
        return list.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        View row = convertView;
        final PostHolder postHolder;
        if(row == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.display_posts, parent, false);
            postHolder = new PostHolder();
            postHolder.tx_rest_name = row.findViewById(R.id.rest_name_textView);
            postHolder.tx_price = row.findViewById(R.id.price_name_textView);
            postHolder.tx_post = row.findViewById(R.id.post_name_textView);
            postHolder.tx_item = row.findViewById(R.id.what_you_got_textView);
            postHolder.delete_btn = row.findViewById(R.id.delete_post_btn);
            row.setTag(postHolder);

        }
        else{
            postHolder = (PostHolder) row.getTag();
        }
        Post post = (Post) getItem(position);

        postHolder.tx_rest_name.setText(post.getRest_name().toString());
        postHolder.tx_price.setText(Integer.toString(post.getPrice()));
        postHolder.tx_post.setText(post.getPost().toString());
        postHolder.tx_item.setText(post.get_item().toString());
        postHolder.delete_btn.setTag(position);
        postHolder.delete_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                list.remove(position);
                dbOperations = new DbOperations(getContext());
                db = dbOperations.getWritableDatabase();
                db.delete(TABLE_NAME, KEY_ID + "=" + (position+1), null);

                db.close();
                notifyDataSetChanged();

            }
        });
        return row;
    }

    static class PostHolder{
        TextView tx_rest_name, tx_post, tx_price, tx_item;
        Button delete_btn;
    }
}
