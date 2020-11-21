package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find the view that shows the numbers category
        TextView numbers = (TextView) findViewById(R.id.numbers);

        //set a clicListener on that view and pass the clickListener object
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Now I can put anything I want in this onClick method..display a Toast, open an Intent etc.
                // let's create a new Intent to open the {@link NumbersActivity}
                Intent NumbersIntent = new Intent(MainActivity.this, NumbersActivity.class);

                //start the new Activity
                startActivity(NumbersIntent);
            }
        });

        // For Family Activity
        TextView family = (TextView)findViewById(R.id.family);

        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent FamilyIntent = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(FamilyIntent);
            }
        });

        // For Family Activity
        TextView colors = (TextView)findViewById(R.id.colors);

        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ColorsIntent = new Intent(MainActivity.this, ColorsActivity.class);
                startActivity(ColorsIntent);
            }
        });

        // For Family Activity
        TextView phrases = (TextView)findViewById(R.id.phrases);

        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent PhrasesIntent = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(PhrasesIntent);
            }
        });
    }

}