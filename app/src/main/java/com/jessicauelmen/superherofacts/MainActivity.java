package com.jessicauelmen.superherofacts;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Randomly generated number to display random superhero data
    int superheroId;

    // Used to check if the same fact is displayed twice, initialized outside of array size
    int oldSuperheroId = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when "Generate Random Fact" button is pressed, displays superhero details and image
     */
    public void displaySuperheroInfo(View view) {
        // Declare detailsTextView to update screen with superhero information
        TextView detailsTextView = (TextView) findViewById(R.id.superhero_details);

        // Declare superheroImageView to update screen with superhero image
        ImageView superheroImageView = (ImageView) findViewById(R.id.superhero_image);

        // Populate the TextView with details on the selected superhero
        detailsTextView.setText(getSuperheroFact());

        // Display an image based on the selected superhero
        switch (superheroId) {
            case 0: superheroImageView.setImageResource(R.drawable.spider_gwen);
                break;
            case 1: superheroImageView.setImageResource(R.drawable.dr_strange);
                break;
            case 2: superheroImageView.setImageResource(R.drawable.iron_man);
                break;
            case 3: superheroImageView.setImageResource(R.drawable.squirrel_girl);
                break;
            case 4: superheroImageView.setImageResource(R.drawable.scarlet_witch);
                break;
        }
    }

    /**
     * Generate a random superhero fact
     *
     * @return String containing details on a superhero
     */
    public String getSuperheroFact() {
        // Declare array of superhero details
        Resources res = getResources();
        String[] superheroDetails = res.getStringArray(R.array.superhero_details_array);

        // Store length of the array
        int arrayLength = superheroDetails.length;

        // Generate a random number based on the number of items in superheroNames array
        superheroId = randInt(superheroDetails.length);

        // Check that value isn't the same as previous value
        checkId(arrayLength);

        // Store current superheroId to compare to next value
        oldSuperheroId = superheroId;

        return superheroDetails[superheroId];
    }

    /**
     * Returns a pseudo-random number between 0 and a max number, inclusive.
     *
     * @param max Maximum value.
     * @return Integer between 0 and max, inclusive.
     */
    public static int randInt(int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt(max);
        return randomNum;
    }

    /**
     * Returns if the same fact is not displayed twice
     *
     * @param arrayLength length of the array of superhero information
     */
    public void checkId(int arrayLength) {
        if (oldSuperheroId != superheroId) {
            return;
        } else {
            while (oldSuperheroId == superheroId) {
                superheroId = randInt(arrayLength);
            }
            return;
        }
    }
}
