package com.sorter.util;

public class Const {

    public static enum Category {
        MOVIE,
        SHOW,
        MUSIC,
        APP,
        TEXT,
        OTHER
    }

    public static Category getCategory(String category) {
        return Category.valueOf(category.toUpperCase());
    }
}
