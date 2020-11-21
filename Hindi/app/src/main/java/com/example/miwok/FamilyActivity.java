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

public class FamilyActivity extends AppCompatActivity {

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
        words.add(new Word("Father", "Pita ji (Papa)", R.drawable.family_father, R.raw.family_father));
        words.add(new Word("Mother", "Mata ji (Mummy)", R.drawable.family_mother, R.raw.family_mother));
        words.add(new Word("Son", "Beta", R.drawable.family_son, R.raw.family_son));
        words.add(new Word("Daughter", "Betee", R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new Word("Elder Brother", "Bada bhaee", R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new Word("Younger Brother", "chhota bhaee", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new Word("Elder Sister", "badee bahan", R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new Word("Younger Sister", "chhotee bahan", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new Word("Grand Father", "Daada ji", R.drawable.family_grandfather, R.raw.family_grandfather));
        words.add(new Word("Grand Mother", "Daadee ma", R.drawable.family_mother, R.raw.family_grandmother));

        //Passing the ArrayList to custom ArrayAdapter now
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_family);

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

                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getAudioResourceId());
                mMediaPlayer.start();
            }
        });
    }
}