package com.example.idealstealprototypeaddenquirey;

        import android.content.Context;
        import android.text.Editable;
        import android.text.TextWatcher;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.BaseAdapter;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;


        import com.example.idealstealprototypeaddenquirey.data.AddEnqData;

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
        public View getView(int position, View convertView, ViewGroup parent) {
                final ViewHolder holder;
                convertView=null;
                if (convertView == null) {
                        holder = new ViewHolder();
                        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = mInflater.inflate(R.layout.add_enqrow, null);
                        holder.caption = (EditText) convertView.findViewById(R.id.editText6);
                        holder.caption.setTag(position);
                        holder.caption.setText(listforview.get(position).getGradeText().toString());
                        convertView.setTag(holder);
                }else {
                        holder = (ViewHolder) convertView.getTag();

                        int tag_position = (Integer) holder.caption.getTag();
                        holder.caption.setId(tag_position);

                        holder.caption.addTextChangedListener(new TextWatcher() {

                                @Override
                                public void onTextChanged(CharSequence s, int start, int before,
                                                          int count) {
                                        Log.e("TAG", "onTextChanged: " + s.toString());
                                        final int position2 = holder.caption.getId();
                                        final EditText Caption = (EditText) holder.caption;
                                        if (Caption.getText().toString().length() > 0) {
//                                        list.set(position2,Integer.parseInt(Caption.getText().toString()));
                                        } else {
                                                Toast.makeText(context, "Please enter some value", Toast.LENGTH_SHORT).show();
                                        }
                                }

                                @Override
                                public void beforeTextChanged(CharSequence s, int start, int count,
                                                              int after) {
                                }

                                @Override
                                public void afterTextChanged(Editable s) {
                                }

                        });
                }
                return convertView;

        }
//
//
//
}class ViewHolder {
        EditText caption;
}