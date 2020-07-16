package com.example.idealstealprototypeaddenquirey;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.idealstealprototypeaddenquirey.data.AddEnqData;
import com.example.idealstealprototypeaddenquirey.data.Measuredata;

import java.util.ArrayList;
import java.util.List;

public class MeasureActivity extends AppCompatActivity {
ListView list;
    EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measure);
       list = findViewById(R.id.list);
        LayoutInflater inflater = getLayoutInflater();

        final ViewGroup header = (ViewGroup)inflater.inflate(R.layout.measure_header,list, false);
        list.addHeaderView(header, null, false);
        final ViewGroup footer = (ViewGroup)inflater.inflate(R.layout.measure_footer,list, false);
        list.addFooterView(footer, null, false);
        Button addmeasurement = footer.findViewById(R.id.imgbtn);
        Button save = footer.findViewById(R.id.savebtn);
          edit = header.findViewById(R.id.editText60);





        final AddEnqData data = (AddEnqData) getIntent().getSerializableExtra("array");
        edit.setText(data.getGradeText());
        final ArrayList<Measuredata>  arrayList = data.getList();
        if (arrayList.size()==0)
        arrayList.add(new Measuredata("",""));


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


                data.setGradeText(edit.getText().toString().trim());
                data.setList(arrayList);
                Intent returnIntent = new Intent();
                Log.e("TAG", ""+ getIntent().getIntExtra("position",1122));
                returnIntent.putExtra("position",getIntent().getIntExtra("position",1122));
                returnIntent.putExtra("array", data );
//                returnIntent.putExtra("position",getIntent().putExtra("position",1122220));
                setResult(22,returnIntent);
                finish();
            }
        });

    }
}