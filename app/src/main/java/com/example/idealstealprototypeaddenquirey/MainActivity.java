package com.example.idealstealprototypeaddenquirey;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.idealstealprototypeaddenquirey.data.AddEnqData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView list;
    private ArrayList<AddEnqData> mListItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    list = findViewById(R.id.recy);
        mListItems.add(new AddEnqData("1Grade"));
        mListItems.add(new AddEnqData("G3rafsde"));
        mListItems.add(new AddEnqData("Gf2rade"));
        mListItems.add(new AddEnqData("Grf4ade"));
        mListItems.add(new AddEnqData("Grsa5de"));
        mListItems.add(new AddEnqData("G6rasdse"));
        mListItems.add(new AddEnqData("G7rssade"));
        mListItems.add(new AddEnqData("Gs8asde"));
        mListItems.add(new AddEnqData("Gfr9ade"));
        mListItems.add(new AddEnqData("Grfa10de"));
        mListItems.add(new AddEnqData("Grsade11"));
        mListItems.add(new AddEnqData("12Grasdse"));
        mListItems.add(new AddEnqData("Gr13ssade"));
        mListItems.add(new AddEnqData("Gsas14de"));
        mListItems.add(new AddEnqData("Gsssra15de"));
        Gradeadapter adapter = new Gradeadapter(this,mListItems);
//        list.setScrollingCacheEnabled(true);
        list.setItemsCanFocus(true);
//        listView.setItemsCanFocus(true);

        list.setAdapter(adapter);

    }
}