package com.example.davidnissenoff.grapevine6;

public class Post {
    private String rest_name, post, item;
    private int price, id;
    public Post(String rest_name, int price, String post, String item){
        this.setRest_name(rest_name);
        this.setPrice(price);
        this.setPost(post);
        this.set_item(item);
    }
    public String getRest_name() {
        return rest_name;
    }

    public void setRest_name(String rest_name) {
        this.rest_name = rest_name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String get_item() {
        return item;
    }

    public void set_item(String item) {
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
