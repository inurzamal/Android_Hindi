package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();

        //creating our new Word object by passing two inputs into the constructor; and adding into words list
        Word w = new Word("One", "Ek - एक", R.drawable.number_one, R.raw.number_one);
        words.add(w);

        //concise way we can create object and add to the words list
        words.add(new Word("Two", "Do - दो", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("Three", "Teen - तीन", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("Four", "Char - चार", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("Five", "Panch - पांच", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("Six", "Cheh - छह", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("Seven", "Saat - सात", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("Eight", "Aath - आठ", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("Nine", "nao - नौ", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("Ten", "Das - दस", R.drawable.number_ten, R.raw.number_ten));

        //Passing the ArrayList to custom ArrayAdapter now
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);

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

                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());
                mMediaPlayer.start();
            }
        });

    }
}