package com.example.final_audio_game;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

//import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Array of arrays of different song choices
    private String[][] choices = {
            {"Lucid Dreams", "What a Time", "God's Plan", "Comethru"},
            {"7 Rings", "Tik Tok", "The Only", "The Middle"},
            {"Sweet but Psycho", "Rolling in the Deep", "Without Me", "Talk"},
            {"Lucid Dreams", "Let Me Down Slowly", "Please Me", "What A Time"},
            {"A Little Braver", "Without Me", "Tik Tok", "7 Rings"},
            {"Sweet but Psycho", "Better Now", "Dancing With a Stranger", "The Middle"},
            {"Let Me Down Slowly", "The Middle", "Please Me", "Comethru"},
            {"Better Now", "Talk", "Tik Tok", "Without Me"},
            {"7 Rings", "What a Time", "Rolling in the Deep", "Comethru"},
            {"Dancing With a Stranger", "What a Time", "Lucid Dreams", "Talk"},
            {"What a Time", "Better Now", "The Middle", "Sweet but Psycho"},
            {"Tik Tok", "Let Me Down Slowly", "Older", "A Little Braver"},
            {"Sweet but Psycho", "What a Time", "Talk", "Older"},
            {"The Only", "A Little Braver", "Let Me Down Slowly", "Comethru"},
            {"Comethru", "Please Me", "Without Me", "Better Now"},
            {"Lucid Dreams", "Dancing with a Stranger", "Let Me Down Slowly", "Talk"},
            {"Older", "The Only", "What a Time", "Sweet but Psycho"},
            {"The Middle", "The Only", "Talk", "Better Now"}
    };

    // Array of answers
    private String[] answers = {"God's Plan", "The Only", "Rolling in the Deep", "Let Me Down Slowly",
            "7 Rings", "Sweet but Psycho", "Please Me", "Without Me", "Comethru", "Lucid Dreams",
            "What a Time", "Tik Tok", "Talk", "A Little Braver", "Better Now", "Dancing with a Stranger",
            "Older", "The Middle"};

    // Adding all the songs to the ArrayList Songs
    private int[] Songs;

    // Current song
    private MediaPlayer song;

    // Whether or not a new question is shown
    private boolean newQuestion = false;

    // Determine if a song stopped or not
    private boolean stop = false;
    // Create variable to hold the score view
    private TextView scoreView;
    // Variable for the first choice button
    private Button choice1;
    // Variable for the second choice button
    private Button choice2;
    // Variable for the third choice button
    private Button choice3;
    // Variable for the fourth choice button
    private Button choice4;


    // Initialize the score to 0
    private int score = 0;
    // Initialize question number to 0
    private int questionNumber = 0;
    // Variable for the answer
    private String answer = answers[questionNumber];

    // Get the first choice of each question
    public String getChoice1(int index) {
        return choices[index][0];
    }

    // Get the second choice of each question
    public String getChoice2(int index) {
        return choices[index][1];
    }

    // Get the third choice of each question
    public String getChoice3(int index) {
        return choices[index][2];
    }

    // Get the fourth choice of each question
    public String getChoice4(int index) {
        return choices[index][3];
    }

    // Get the answer for each question
    public String getAnswer(int index) {
        answer = answers[index];
        return answer;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Songs = new int[] {
                R.raw.god_s_plan, R.raw.the_only, R.raw.rolling_in_the_deep,
                R.raw.let_me_down_slowly, R.raw.seven_rings, R.raw.sweet_but_psycho,
                R.raw.please_me, R.raw.without_me, R.raw.comethru,
                R.raw.lucid_dreams, R.raw.what_a_time, R.raw.tik_tok,
                R.raw.talk, R.raw.a_little_braver, R.raw.better_now,
                R.raw.dancing_with_a_stranger, R.raw.older, R.raw.the_middle};

        // Initialize the current song
        song = MediaPlayer.create(this, Songs[questionNumber]);
        // Connecting the variable with the buttons in the xml
        scoreView = findViewById(R.id.score);
        // Variable for the song player button
        Button songSound = findViewById(R.id.play_button);
        choice1 = findViewById(R.id.choice1);
        choice2 = findViewById(R.id.choice2);
        choice3 = findViewById(R.id.choice3);
        choice4 = findViewById(R.id.choice4);


        // Create a listener to handle when the play button is clicked
        songSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Plays the song when the button is clicked
                if (song.isPlaying()) {
                    song.pause();
                } else {
                    song.start();
                }
            }
        });

        // Create listeners to handle when each button of the question is pressed
        choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                song.stop();
                // If the choice that is clicked equals to the answer, then score goes up by one
                if (choice1.getText().equals(answer)) {
                    score += 1;
                    // Update the question number
                    questionNumber++;
                    // Update the score
                    updateScore(score);
                    // Update song
                    updateMediaPlayer();
                    // Update the multiple choices
                    updateChoices();
                    // Show a short text if got the answer right, else says it's wrong
                    Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    // Update the question number
                    questionNumber++;
                    // Update the multiple choices
                    updateChoices();
                    updateMediaPlayer();
                    Toast.makeText(MainActivity.this, "Wrong...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                song.stop();
                // If the choice that is clicked equals to the answer, then score goes up by one
                if (choice2.getText().equals(answer)) {
                    score += 1;
                    // Update the question number
                    questionNumber++;
                    // Update the score
                    updateScore(score);
                    // Update song
                    updateMediaPlayer();
                    // Update the multiple choices
                    updateChoices();
                    // Show a short text if got the answer right, else says it's wrong
                    Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    // Update the question number
                    questionNumber++;
                    // Update the multiple choices
                    updateChoices();
                    updateMediaPlayer();
                    Toast.makeText(MainActivity.this, "Wrong...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        choice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                song.stop();
                // If the choice that is clicked equals to the answer, then score goes up by one
                if (choice3.getText().equals(answer)) {
                    score += 1;
                    // Update the question number
                    questionNumber++;
                    // Update the score
                    updateScore(score);
                    // Update song
                    updateMediaPlayer();
                    // Update the multiple choices
                    updateChoices();
                    // Show a short text if got the answer right, else says it's wrong
                    Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();

                } else {
                    // Update the question number
                    questionNumber++;
                    // Update the multiple choices
                    updateChoices();
                    updateMediaPlayer();
                    Toast.makeText(MainActivity.this, "Wrong...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        choice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                song.stop();
                // If the choice that is clicked equals to the answer, then score goes up by one
                if (choice4.getText().equals(answer)) {
                    score += 1;
                    // Update the question number
                    questionNumber++;
                    // Update the score
                    updateScore(score);
                    // Update song
                    updateMediaPlayer();
                    // Update the multiple choices
                    updateChoices();
                    // Show a short text if got the answer right, else says it's wrong
                    Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    // Update the question number
                    questionNumber++;
                    // Update the multiple choices
                    updateChoices();
                    updateMediaPlayer();
                    Toast.makeText(MainActivity.this, "Wrong...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Update the song as the question changes
    private void updateMediaPlayer() {
        song = MediaPlayer.create(this, Songs[questionNumber]);
    }

    private void updateChoices() {
        // Update each choices of each question
        choice1.setText(this.getChoice1(questionNumber));
        choice2.setText(this.getChoice2(questionNumber));
        choice3.setText(this.getChoice3(questionNumber));
        choice4.setText(this.getChoice4(questionNumber));

        answer = getAnswer(questionNumber);
    }

    // Updates the scoreView with the current score
    private void updateScore(int pt) {
        scoreView.setText("" + score);
    }
}
