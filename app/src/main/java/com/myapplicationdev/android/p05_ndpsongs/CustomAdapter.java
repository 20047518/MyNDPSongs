package com.myapplicationdev.android.p05_ndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context context;
    int layout_id;
    ArrayList<Song> versionList;

    public CustomAdapter(Context context, int resource, ArrayList<Song> objects) {
        super( context, resource, objects );
        this.context = context;
        this.layout_id = resource;
        versionList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View rowView = inflater.inflate( layout_id, parent, false );
        TextView tvYear = rowView.findViewById( R.id.tvYear );
        TextView tvTitle = rowView.findViewById( R.id.tvTitle );
        TextView tvSingers = rowView.findViewById( R.id.tvSingers );
        TextView tvStar = rowView.findViewById( R.id.tvStar );

        Song currentVersion = versionList.get(position);
        tvYear.setText( String.valueOf(currentVersion.getYearReleased()) );
        tvTitle.setText( currentVersion.getTitle() );
        tvSingers.setText( currentVersion.getSingers() );
        tvStar.setText( currentVersion.toStarString() );

        return  rowView;
    }
}
