package com.example.davidnissenoff.grapevine6;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends ArrayAdapter {
    List list = new ArrayList();
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
    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;
        PostHolder postHolder;
        if(row == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.display_posts, parent, false);
            postHolder = new PostHolder();
            postHolder.tx_rest_name = row.findViewById(R.id.rest_name_textView);
            postHolder.tx_price = row.findViewById(R.id.price_name_textView);
            postHolder.tx_post = row.findViewById(R.id.post_name_textView);
            row.setTag(postHolder);

        }
        else{
            postHolder = (PostHolder) row.getTag();
        }
        Post post = (Post) getItem(position);
        postHolder.tx_rest_name.setText(post.getRest_name().toString());
        postHolder.tx_price.setText(Integer.toString(post.getPrice()));
        postHolder.tx_post.setText(post.getPost().toString());
        return row;
    }
    static class PostHolder{
        TextView tx_rest_name, tx_post, tx_price;
    }
}
