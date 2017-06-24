package com.lovishinfotech.audiorecorder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Chethan on 6/23/2017.
 */

public class CustomerAdapter extends ArrayAdapter<AudioData> {

    Context context;
    ArrayList<File> audioData;

    public CustomerAdapter( Context context,  int resource, ArrayList<File> audioData) {
        super(context, resource);
        this.context = context;
        this.audioData = audioData;
    }



    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View viewList=view;
        if(viewList==null)
        {

            view= LayoutInflater.from(context).inflate(R.layout.list,viewGroup,false);
        }

         AudioData audioData1= getItem(position);
        TextView nameTxt= (TextView) view.findViewById(R.id.textView);
        nameTxt.setText(audioData1.getName());
        return view;
    }
}
