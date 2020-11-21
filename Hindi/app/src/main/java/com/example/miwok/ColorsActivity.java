package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();

        /*
         * create object of Word and add to the words list
         */
        words.add(new Word("Red", "Lal", R.drawable.color_red, R.raw.color_red));
        words.add(new Word("Green", "Haara", R.drawable.color_green, R.raw.color_green));
        words.add(new Word("Black", "Kaala", R.drawable.color_black, R.raw.color_black));
        words.add(new Word(" Mastard Yellow", "Peela", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
        words.add(new Word("Dusty Yellow", "dhool bhara peela", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Word("Gray", "Dhoosar", R.drawable.color_gray, R.raw.color_gray));
        words.add(new Word("Brown", "Bhoora", R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word("White", "Safed", R.drawable.color_white, R.raw.color_white));

        //Passing the ArrayList to custom ArrayAdapter now
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors);

        //Finding ListView to display the result
        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        /*
         * Adding Sound using MediaPlayer class- list item click handling
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);

                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getAudioResourceId());
                mMediaPlayer.start();
            }
        });
    }
}