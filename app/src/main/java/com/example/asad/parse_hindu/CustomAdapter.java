package com.example.asad.parse_hindu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Asad on 23-03-2016.
 */
public class CustomAdapter extends BaseAdapter{
    public static LayoutInflater inflater=null;
//    String[] array=new String[MainActivity.numberOfEntries];
//    String[] list;
    String[] array=new String[200];
    public CustomAdapter(Context c,String[] array)
//public CustomAdapter(Context c,ArrayList<String> array)

{
     this.array=array;
        inflater = (LayoutInflater) c.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return array.length;
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
    public View getView(int position, View convertView, ViewGroup parent) { // returns the View object for each row.
            View rowView;
            rowView = inflater.inflate(R.layout.each_row, null);
        TextView textView= (TextView) rowView.findViewById(R.id.textview);
        textView.setText(array[position]);
//        textView.setText(list.get(position));
        return rowView;
    }
}
