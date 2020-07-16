package com.example.idealstealprototypeaddenquirey;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.idealstealprototypeaddenquirey.data.AddEnqData;
import com.example.idealstealprototypeaddenquirey.data.Measuredata;

import java.util.ArrayList;

import static androidx.recyclerview.widget.RecyclerView.OnClickListener;
import static androidx.recyclerview.widget.RecyclerView.OnFocusChangeListener;

public class Measureadapter extends BaseAdapter {
        Context context;
        ArrayList<Measuredata> listforview;
        LayoutInflater mInflater=null;
        View v;
        ViewHolder1 holder;

        EditText grade;
        TextView text;
//        RecyclerView.ViewHolder vholder;


        public Measureadapter(Context context, ArrayList<Measuredata> listforview) {
//                super(context, 0, listforview);
                this.context = context;
                this.listforview = listforview;

        }

        @Override
        public int getCount() {
                return listforview.size();
        }

        @Override
        public Object getItem(int position) {
                return position;
        }

        @Override
        public long getItemId(int position) {
                return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
                final ViewHolder1 holder;
                convertView=null;
                if (convertView == null) {
                        holder = new ViewHolder1();
                        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = mInflater.inflate(R.layout.measure_row, null);
                        holder.size = (EditText) convertView
                                .findViewById(R.id.editText4);
                        holder.Pieces = (EditText) convertView
                                .findViewById(R.id.editText5);
                        holder.size.setTag(position);

                        holder.Pieces.setTag(position);



                        holder.remove = convertView
                                .findViewById(R.id.button1234);
                        holder.remove.setTag(position);



                        convertView.setTag(holder);
                }else {
                        holder = (ViewHolder1) convertView.getTag();
                }
                holder.size.setId(position);
                holder.size.setText(listforview.get(position ).getSize());
                holder.Pieces.setId(position);
                holder.Pieces.setText(listforview.get(position ).getPieces());


                holder.remove.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                if(listforview.size()!=1){
                                        listforview.remove(position);
                                        notifyDataSetChanged();
                                }
                        }
                });


                holder.size.setOnFocusChangeListener(new OnFocusChangeListener() {
                        @Override
                        public void onFocusChange(View v, boolean hasFocus) {
                                if (!hasFocus) {
                                        final int position = v.getId();
                                        final EditText size = (EditText) v;
                                        Log.e("TAG", "onFocusChange: "+size.getText() );
                                        listforview.get(position).setSize(size.getText().toString());
                                }
                        }
                });

                holder.Pieces.setOnFocusChangeListener(new OnFocusChangeListener() {
                        @Override
                        public void onFocusChange(View v, boolean hasFocus) {
                                if (!hasFocus) {
                                        final int position = v.getId();
                                        final EditText size = (EditText) v;
                                        Log.e("TAG", "onFocusChange: "+size.getText() );
                                        listforview.get(position).setPieces(size.getText().toString());
                                }
                        }
                });

                return convertView;

        }
//
//
//
}

class ViewHolder1 {
        EditText Pieces;
        EditText size;
        Button remove;
 }