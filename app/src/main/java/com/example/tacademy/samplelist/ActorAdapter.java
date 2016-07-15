package com.example.tacademy.samplelist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.tacademy.samplelist.data.Actor;

/**
 * Created by Tacademy on 2016-07-15.
 */
public class ActorAdapter extends BaseAdapter {

    Actor actor;
    public void setActor(Actor actor){
        if(this.actor != actor){
            this.actor = actor;
            notifyDataSetChanged();
        }
    }

    public Actor getActor(){
        return actor;
    }

    private static final int VIEW_TYPE_COUNT = 5;
    private static final int VIEW_TYPE_ACTOR_INFO = 0;
    private static final int VIEW_TYPE_CATEGORY_TITLE = 1;
    private static final int VIEW_TYPE_MOVIE = 2;
    private static final int VIEW_TYPE_DRAMA = 3;
    private static final int VIEW_TYPE_COMMENT = 4;


    @Override
    public int getCount() {
        if(actor == null) return 0;
        int count = 0;
        count++;
        if(actor.movies.size() > 0 ){
            count += (1 + actor.movies.size());
        }
        if(actor.dramas.size() > 0){
            count += (1+ actor.dramas.size());
        }
        if(actor.comments.size() > 0){
            count += (1+ actor.comments.size());
        }
        return count;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return VIEW_TYPE_ACTOR_INFO;
        }
        position--;

        if(actor.movies.size() > 0 ){
            if(position ==0){
                return VIEW_TYPE_CATEGORY_TITLE;
            }
            if(position < actor.movies.size() ){
                return VIEW_TYPE_MOVIE;
            }
            position-= actor.movies.size();
        }



        if(actor.dramas.size() >0){
            if(position == 0){
                return VIEW_TYPE_CATEGORY_TITLE;
            }
            if(position < actor.dramas.size()){
                return VIEW_TYPE_DRAMA;
            }
            position-= actor.dramas.size();
        }



        if(actor.comments.size() > 0){
            if(position == 0){
                return VIEW_TYPE_CATEGORY_TITLE;
            }
            if(position < actor.comments.size()){
                return VIEW_TYPE_COMMENT;
            }
            position -= actor.comments.size();
        }

        throw new IllegalArgumentException("invalid position");
    }

    @Override
    public int getViewTypeCount() {
        return VIEW_TYPE_COUNT;
    }

    @Override
    public Object getItem(int position) {
        if (position ==0){
            return actor;
        }
        position--;
        if(actor.movies.size() >0 ){
            if(position == 0){
                return "Movie";
            }
            position--;
            if(position < actor.movies.size()){
                return  actor.movies.get(position);
            }
            position -= actor.movies.size();
        }
        if(actor.dramas.size() > 0){
            if(position == 0 ){
                return "Drama";
            }
            position--;
            if(position < actor.dramas.size()){
                return actor.dramas.get(position);
            }
            position -= actor.dramas.size();
        }
        if(actor.comments.size() > 0){
            if(position ==0){
                return "Comment";
            }
            position--;
            if(position<actor.comments.size()){
                return actor.comments.size();
            }
            position -= actor.comments.size();
        }

        throw new IllegalArgumentException("invalid position");
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return convertView;
    }
}
