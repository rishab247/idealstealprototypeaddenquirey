package com.example.idealstealprototypeaddenquirey;

        import android.app.Activity;
        import android.content.Context;
        import android.content.Intent;
        import android.text.Editable;
        import android.text.TextWatcher;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.BaseAdapter;
        import android.widget.EditText;
        import android.widget.LinearLayout;
        import android.widget.TextView;
        import android.widget.Toast;


        import androidx.cardview.widget.CardView;
        import androidx.constraintlayout.widget.ConstraintLayout;

        import com.example.idealstealprototypeaddenquirey.data.AddEnqData;
        import com.example.idealstealprototypeaddenquirey.data.Measuredata;

        import java.util.ArrayList;

        import static androidx.recyclerview.widget.RecyclerView.*;

public class Gradeadapter extends BaseAdapter {
        Context context;
        ArrayList<AddEnqData> listforview;
        LayoutInflater mInflater=null;
        View v;
        ViewHolder holder;

        EditText grade;
        TextView text;
//        RecyclerView.ViewHolder vholder;


        public Gradeadapter(Context context, ArrayList<AddEnqData> listforview) {
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
                final ViewHolder holder;
                convertView=null;

                if (convertView == null) {
                        holder = new ViewHolder();
                        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = mInflater.inflate(R.layout.add_enqrow, null);

                        holder.caption = (EditText) convertView
                                .findViewById(R.id.editText6);
                        holder.caption.setTag(position);
                        holder.addbtn =  convertView
                                .findViewById(R.id.button);
                        holder.addbtn.setTag(position);
                        convertView.setTag(holder);

                        LinearLayout layout =convertView.findViewById(R.id.linearLayout);
                        for (Measuredata data : listforview.get(position).getList()){
                                View child = mInflater.inflate(R.layout.summary_view, null);
                                TextView size = child.findViewById(R.id.sizetxt);
                                TextView Piecestxt = child.findViewById(R.id.Piecestxt);
                                Piecestxt.setText(data.getPieces());
                                size.setText(data.getSize());
                                layout.addView(child);


                        }



                }else {
                        holder = (ViewHolder) convertView.getTag();
                }
                 holder.caption.setId(position);
                holder.caption.setText(listforview.get(position).getGradeText());
                holder.addbtn.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                Intent intent = new Intent(context,MeasureActivity.class);
                                intent.putExtra("array",listforview.get(position).getList());
                                intent.putExtra("position",position);
                                 Log.e("TAG", "onClick: size "+ listforview.get(position).getList().size());
                                Activity origin = (Activity)context;

                                origin.startActivityForResult (intent,22);
                        }
                });


                holder.caption.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                        @Override
                        public void onFocusChange(View v, boolean hasFocus) {
                                if (!hasFocus) {
                                        final int position = v.getId();
                                        final EditText Caption = (EditText) v;
                                        Log.e("TAG", "onFocusChange: "+Caption.getText() );
                                        try {
                                                listforview.get(position).setGradeText(Caption.getText().toString());
                                        }catch (Exception e){
                                                e.printStackTrace();
                                        }
                                        }
                        }
                });

                return convertView;

        }
//
//
//
}class ViewHolder {
        EditText caption;
        TextView addbtn;
}