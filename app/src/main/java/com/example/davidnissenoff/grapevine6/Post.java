package com.example.davidnissenoff.grapevine6;

public class Post {
    private String rest_name, post;
    private int price;
    public Post(String rest_name, int price, String post){
        this.setRest_name(rest_name);
        this.setPrice(price);
        this.setPost(post);
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
}
