package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word>{

    //Resource Id for the background color of this list of words
    int mColorResourceId;

    public WordAdapter(Context context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        //Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        // Find and set the miwok word  in the Miwok TextView  in list_item.xml
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_word);
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find and set the default  word  in the Default TextViewin list_item.xml
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_word);
        defaultTextView.setText(currentWord.getDefaultTranslation());


        // Find and set the image in ImageView in list_item.xml
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if(currentWord.hasImage()) {
            // Set the imageView to the image resource specified in the current Word
            imageView.setImageResource(currentWord.getImageResourceId());

        }

        else {
            // Otherwise hide the imageView
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource id maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        return listItemView;

    }
}
