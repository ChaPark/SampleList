package com.example.tacademy.samplelist;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.tacademy.samplelist.data.Person;
import com.example.tacademy.samplelist.widget.PersonView;

public class MainActivity extends AppCompatActivity {

    PersonView personView;
    ImageView photoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        photoView = (ImageView)findViewById(R.id.image_picture);
        photoView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                photoView.setVisibility(View.GONE);
            }
        });


        personView = (PersonView)findViewById(R.id.view_person);
        personView.setIOnImageClicklsitener(new PersonView.OnImageClickLsitener(){
            @Override
            public void onImageClick(PersonView view, Person person) {
                photoView.setImageDrawable(person.getPhoto());
                photoView.setVisibility(View.VISIBLE);
            }
        });

        initData();
    }


    private void initData(){
        Drawable photo = ContextCompat.getDrawable(MainActivity.this, R.drawable.sample_0 );

        Person p = new Person("pcor", 30, photo);

        personView.setPerson(p);
    }
}
