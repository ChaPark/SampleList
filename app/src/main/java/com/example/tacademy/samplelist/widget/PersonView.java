package com.example.tacademy.samplelist.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tacademy.samplelist.R;
import com.example.tacademy.samplelist.data.Person;

/**
 * Created by Tacademy on 2016-07-13.
 */
public class PersonView extends FrameLayout {
    public PersonView(Context context) {
        this(context, null);

    }

    public PersonView(Context context, AttributeSet attrs) {
        //xml에 보여주려면 AttributeSet attrs 있어야한다.
        super(context, attrs);
        init();
    }

    ImageView photoView;
    TextView nameView, ageView;

    public interface OnImageClickLsitener{
        public void onImageClick(PersonView view, Person person);

    }

    OnImageClickLsitener mListener;
    public void setIOnImageClicklsitener(OnImageClickLsitener listener){
        mListener = listener;
    }


    private void init(){
//        LayoutInflater inflater = LayoutInflater.from(getContext());
//        inflater.inflate(R.layout.view_person, this);  //xml을 보고 xml에 맞는 객체를 생성

        inflate(getContext(), R.layout.view_person, this);
        photoView = (ImageView)findViewById(R.id.image_photo);
        nameView = (TextView)findViewById(R.id.text_name);
        ageView = (TextView)findViewById(R.id.text_age);

        photoView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListener != null){
                    mListener.onImageClick(PersonView.this, person);
                }
            }
        });
    }

    Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
        nameView.setText(person.getName());
        ageView.setText(""+person.getAge());
        photoView.setImageDrawable(person.getPhoto());


    }
}
