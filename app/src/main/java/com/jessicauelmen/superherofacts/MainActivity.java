package com.jessicauelmen.superherofacts;

import android.content.res.Resources;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displaySuperheroInfo(View view) {
        // Declare detailsTextView to update screen with superhero information
        TextView detailsTextView = (TextView) findViewById(R.id.superhero_details);

        // Declare superheroImageView to update screen with superhero image
        ImageView superheroImageView = (ImageView) findViewById(R.id.superhero_image);

        // Declare arrays of superhero names & superhero details
        Resources res = getResources();
        String[] superheroNames = res.getStringArray(R.array.superhero_names_array);
        String[] superheroDetails = res.getStringArray(R.array.superhero_details_array);

        // Generate a random number based on the number of items in superheroNames array
        int superheroId = randInt(superheroDetails.length);

        detailsTextView.setText(superheroDetails[superheroId]);
    }

    /**
     * Returns a psuedo-random number between 0 and a max number, inclusive.
     *
     * @param max Maximum value.
     * @return Integer between 0 and max, inclusive.
     */
    public static int randInt(int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt(max);
        return randomNum;
    }

}
