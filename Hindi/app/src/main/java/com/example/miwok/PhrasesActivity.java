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

public class PhrasesActivity extends AppCompatActivity {

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
        words.add(new Word("Where are you going?", "Tum kahaan ja rahe ho? - तुम कहाँ जा रहे हो?", R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?", "Tumhaara naam kya he? - तुम्हारा नाम क्या हे?", R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is X", "Mera naam X hai - मेरा नाम X है", R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?", "Aap kaisa mahasoos kar rahe hain? - आप कैसा महसूस कर रहे हैं?", R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I'm feeling good.", "Main achchha mahasoos kar raha hoon - मैं अच्छा महसूस कर रहा हूँ", R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?", "Kya tum aa rahe ho? - क्या तुम आ रहे हो?", R.raw.phrase_are_you_coming));
        words.add(new Word("Yes, I'm coming.", "Haan, aa main raha hoon - हाँ, मैं आ रहा हूं", R.raw.phrase_yes_im_coming));
        words.add(new Word("Let's go.", "Chalo chalate hain - चलो चलते हैं", R.raw.phrase_lets_go));
        words.add(new Word("Come here.", "Yahaan aao - यहाँ आओ", R.raw.phrase_come_here));
        words.add(new Word("Well done", "Bahut badhiya - बहुत बढ़िया", R.raw.phrase_lets_go));


        //Passing the ArrayList to custom ArrayAdapter now
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);

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

                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioResourceId());
                mMediaPlayer.start();
            }
        });
    }
}