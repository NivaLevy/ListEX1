package com.example.niva.listex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Niva on 05/06/2016.
 */
public class CustomAdapter extends ArrayAdapter<ListObject> {

    private ArrayList<ListObject> data;

    public CustomAdapter(Context context, int layoutResourceId, ArrayList<ListObject> data) {
        super(context, layoutResourceId, data);
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = LayoutInflater.from(getContext()).inflate(R.layout.display_item, parent, false);
        ImageView imgIcon = (ImageView)row.findViewById(R.id.img);
        TextView txtTitle = (TextView)row.findViewById(R.id.title);
        TextView txtDescription = (TextView)row.findViewById(R.id.description);

        ListObject object = data.get(position);
        txtTitle.setText(object.getTitle());
        txtDescription.setText(object.getDescription());
        imgIcon.setImageResource(object.getImg());

        return row;
    }

    static class ObjectHolder
    {

    }

}
