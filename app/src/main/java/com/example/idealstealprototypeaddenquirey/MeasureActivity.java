package com.example.idealstealprototypeaddenquirey;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.idealstealprototypeaddenquirey.data.Measuredata;

import java.util.ArrayList;
import java.util.List;

public class MeasureActivity extends AppCompatActivity {
ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measure);
       list = findViewById(R.id.list);
        LayoutInflater inflater = getLayoutInflater();

        ViewGroup footer = (ViewGroup)inflater.inflate(R.layout.measure_footer,list, false);
        list.addFooterView(footer, null, false);
        Button addmeasurement = footer.findViewById(R.id.imgbtn);
        Button save = footer.findViewById(R.id.savebtn);


        final ArrayList<Measuredata>  arrayList =  (ArrayList<Measuredata>) getIntent().getSerializableExtra("array");
        arrayList.add(new Measuredata("asd","asd"));


        final Measureadapter adapter = new Measureadapter(this,arrayList);
        list.setAdapter(adapter);



        addmeasurement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.add(new Measuredata("",""));
                adapter.notifyDataSetChanged();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}