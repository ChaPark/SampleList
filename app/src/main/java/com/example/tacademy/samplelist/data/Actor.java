package com.example.tacademy.samplelist.data;



import android.graphics.drawable.Drawable;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tacademy on 2016-07-15.
 */
public class Actor {
    public Drawable photo;
    public String name;
    public int age;
    public String description;
    public List<Movie> movies = new ArrayList<>();
    public List<Drama> dramas = new ArrayList<>();
    public List<Comment> comments = new ArrayList<>();
}
