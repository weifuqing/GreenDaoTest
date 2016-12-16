package com.example.personal.greendaotest.base;

import android.view.View;
import android.widget.TextView;

/**
 * Created by dell on 2016/12/16.
 */
public class ViewHolder {

    View itemView;
    public ViewHolder(View itemView){
        this.itemView = itemView;
    }

    public void setText(int id,String text){
        ((TextView)itemView.findViewById(id)).setText(text);
    }
}
