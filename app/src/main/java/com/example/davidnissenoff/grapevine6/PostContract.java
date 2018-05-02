package com.example.davidnissenoff.grapevine6;

public final class PostContract {
    PostContract(){

    }
    public static abstract class PostEntry{
        public static final String NAME = "name";
        public static final String PRICE = "price";
        public static final String POST = "post";

        public static final String TABLE_NAME = "post_table";
    }

}
