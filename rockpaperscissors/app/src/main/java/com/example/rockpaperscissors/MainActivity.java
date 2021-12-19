package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    ImageView computerRespo , playerRespo ;
    Button bscissors , bpaper , brock , exit , reset;
    TextView playerText;
    TextView computerText;
    int userScore = 0;
    int computerScore = 0;
    TextView conclution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        exit = (Button) findViewById(R.id.button) ;
        reset = (Button) findViewById(R.id.button2);
        exit.animate().translationXBy(1500);
        reset.animate().translationXBy(1000);
        computerRespo = (ImageView) findViewById(R.id.computerResponse);
        playerRespo = (ImageView)  findViewById(R.id.playerResponse);
        bscissors = (Button) findViewById(R.id.buttonScissors);
        bpaper = (Button) findViewById(R.id.buttonPaper);
        brock = (Button) findViewById(R.id.buttonRock);
        TextView score  = (TextView) findViewById(R.id.textView3);
        computerText = (TextView) findViewById(R.id.textView);
        playerText = (TextView) findViewById(R.id.textView2) ;
        conclution = (TextView) findViewById(R.id.textView4);

        bscissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerRespo.setImageResource(R.drawable.scissors);
                computermove("scissors");
                score.setText("your score : " + Integer.toString(userScore) + " computer score : " + Integer.toString(computerScore) );
            }
        });


        bpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerRespo.setImageResource(R.drawable.paper);
                computermove("paper");
                score.setText("your score : " + Integer.toString(userScore) + " computer score : " + Integer.toString(computerScore) );
            }
        });

        brock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerRespo.setImageResource(R.drawable.rock);
                computermove("rock");
                score.setText("your score : " + Integer.toString(userScore) + " computer score : " + Integer.toString(computerScore) );
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               moveTaskToBack(true);
               android.os.Process.killProcess(android.os.Process.myPid());
               System.exit(1);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               userScore = 0;
               computerScore = 0;
                exit.animate().translationXBy(1500);
                reset.animate().translationXBy(1000);
                bpaper.animate().alpha(1);
                brock.animate().alpha(1);
                bscissors.animate().alpha(1);
                computerRespo.animate().alpha(1);
                playerRespo.animate().alpha(1);
                computerText.animate().alpha(1);
                playerText.animate().alpha(1);
                score.setText("your score : " + Integer.toString(userScore) + " computer score : " + Integer.toString(computerScore) );
                conclution.setAlpha(0);
            }
        });
    }

    public void computermove(String playermove){
        String compmove = "" ;
        Random n = new Random();
        int randnum = n.nextInt(3) + 1 ;
        if (randnum == 1){
            compmove = "paper";
        } else if (randnum == 2){
            compmove = "rock";
        } else {
            compmove = "scissors";
        }
        if (compmove.equals("scissors")){
            computerRespo.setImageResource(R.drawable.scissors);
        } else if (compmove.equals("paper")){
            computerRespo.setImageResource(R.drawable.paper);
        } else if (compmove.equals("rock")){
            computerRespo.setImageResource(R.drawable.rock);
        }
        String msg = "";
        if (compmove == "scissors" && playermove == "paper"){
            msg = "you lose";
            computerScore++;
        }
        if (compmove == "scissors" && playermove == "rock"){
            msg = "you win";
            userScore++;
        }
        if (compmove == "scissors" && playermove == "scissors"){
            msg = " Draw";
        }
        if (compmove == "rock" && playermove == "paper"){
            msg = "you win";
            userScore++;
        }
        if (compmove == "rock" && playermove == "rock"){
            msg = "Draw";
        }
        if (compmove == "rock" && playermove == "scissors"){
            msg = " You lose";
            computerScore++;
        }
        if (compmove == "paper" && playermove == "paper"){
            msg = "Draw";
        }
        if (compmove == "paper" && playermove == "rock"){
            msg = "You lose";
            computerScore++;
        }
        if (compmove == "paper" && playermove == "scissors"){
            msg = " You win";
            userScore++;
        }

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        if ( userScore == 5 || computerScore == 5){
            exit.animate().translationXBy(-1500);
            reset.animate().translationXBy(-1000);
            bpaper.animate().alpha(0);
            brock.animate().alpha(0);
            bscissors.animate().alpha(0);
            computerRespo.animate().alpha(0);
            playerRespo.animate().alpha(0);
            computerText.animate().alpha(0);
            playerText.animate().alpha(0);
            if (userScore == 5){
                conclution.setText("Congratulation You win!");
                conclution.setAlpha(1);
            } else {
                conclution.setText("You lose. Better luck next time! ");
                conclution.setAlpha(1);
            }


        }

    }

}