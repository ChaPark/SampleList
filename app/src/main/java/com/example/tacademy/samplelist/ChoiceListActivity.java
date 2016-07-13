package com.example.tacademy.samplelist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ChoiceListActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_list);

        listView =(ListView)findViewById(R.id.listView2);
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice);
        listView.setAdapter(mAdapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        initData();


        Button btn = (Button)findViewById(R.id.btn_delete);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listView.getChoiceMode() == ListView.CHOICE_MODE_SINGLE) {
                    int position = listView.getCheckedItemPosition();
                    String item = (String) listView.getItemAtPosition(position);
                    mAdapter.remove(item);
                }
                else if( listView.getChoiceMode() == ListView.CHOICE_MODE_MULTIPLE){
                    SparseBooleanArray array = listView.getCheckedItemPositions();
                    ArrayList<String> select =new ArrayList<String>();

                }
            }
        });



    }
    public void initData(){
        String[] items = getResources().getStringArray(R.array.list_item);
        mAdapter.addAll(items);
    }
}
