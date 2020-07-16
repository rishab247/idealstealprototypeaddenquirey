package com.example.idealstealprototypeaddenquirey;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.idealstealprototypeaddenquirey.data.AddEnqData;
import com.example.idealstealprototypeaddenquirey.data.Measuredata;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView list;
    private ArrayList<AddEnqData> mListItems = new ArrayList<>();
    Gradeadapter adapter;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 22) {
            Log.e("TAG", "onActivityResult: " + resultCode);
            Log.e("TAG", "onActivityResult: " + requestCode);
            Log.e("TAG", "onActivityResult: " + data.getIntExtra("position",1122));

            AddEnqData da = (AddEnqData) data.getSerializableExtra("array");

            final ArrayList<Measuredata>  arrayList =  da.getList();
            Log.e("TAG", "onActivityResult: size " + arrayList.size());


            mListItems.get(data.getIntExtra("position",1122)).setList(arrayList);
            mListItems.get(data.getIntExtra("position",1122)).setGradeText(da.getGradeText());
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.recy);

        LayoutInflater inflater = getLayoutInflater();
        ViewGroup header = (ViewGroup)inflater.inflate(R.layout.add_enqheader,list, false);
        list.addHeaderView(header, null, false);

        ViewGroup footer = (ViewGroup)inflater.inflate(R.layout.edd_enqfooter,list, false);
        list.addFooterView(footer, null, false);
        Button addgrade = footer.findViewById(R.id.button2);
        Button removegrade = footer.findViewById(R.id.button30);
        final ArrayList<Measuredata> li = new ArrayList<>();

        adapter = new Gradeadapter(this,mListItems);
//        list.setScrollingCacheEnabled(true);
        list.setItemsCanFocus(true);
//        listView.setItemsCanFocus(true);

        list.setAdapter(adapter);
        addgrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListItems.add(new AddEnqData("",li));


                Intent intent = new Intent(MainActivity.this,MeasureActivity.class);
                intent.putExtra("array",mListItems.get(mListItems.size()-1));
                intent.putExtra("position",mListItems.size()-1);
                startActivityForResult (intent,22);


             }
        });
        removegrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListItems.remove(mListItems.size()-1);
                adapter.notifyDataSetChanged();
            }
        });
    }
}