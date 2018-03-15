package com.example.android.miwok;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by HP on 21/11/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private static final String LOG_TAG = Adapter.class.getSimpleName();
    private int mColorResourceId ;




    public WordAdapter(Activity context , ArrayList<Word>words , int colorResourceId){
        super (context,0,words);
        mColorResourceId=colorResourceId;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_textview
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_textview);
        // Get the version name from the current Word object and
        // set this text on the miwok TextView
        miwokTextView.setText(currentWord.getMiwokTranslation() );

        // Find the TextView in the list_item.xml layout with the ID default_textview
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_textview);
        // Get the version number from the current Word object and
        // set this text on the default TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());




        ImageView miwokImage = (ImageView) listItemView.findViewById(R.id.image);

        if (currentWord.hasImage()){
            miwokImage.setImageResource(currentWord.getImageResourceId());
            miwokImage.setVisibility(View.VISIBLE);
        }
        else {
            miwokImage.setVisibility(View.GONE);
        }
        View textContainer=listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        textContainer.setBackgroundColor(color);






        // Return the whole list item layout (containing 2 TextViews )
        // so that it can be shown in the ListView
        return listItemView;
    }
}
