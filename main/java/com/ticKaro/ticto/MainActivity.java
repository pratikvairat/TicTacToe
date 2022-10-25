package com.ticKaro.ticto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive=true;
    //0-x
    //1-0
    //2-Null
    int activePlayer = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winPos = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {2, 4, 6}, {0, 4, 8}};

    public void playerTap(View view) {

        ImageView img = (ImageView) view;
        TextView status = findViewById(R.id.status);

            int tappedImage = Integer.parseInt(img.getTag().toString());
            if(!gameActive){
                gameReset(view);
                gameActive=true;
            }
            if (gameState[tappedImage] == 2) {
                gameState[tappedImage] = activePlayer;
                if (activePlayer == 0) {
                    img.setImageResource(R.drawable.cro);
                    status.setText("O Turn: Tap To Play");
                    activePlayer = 1;
                } else {
                    activePlayer = 0;
                    img.setImageResource(R.drawable.zeo);
                    status.setText("X Turn: Tap To Play");
                }
            }
            for (int[] winPos : winPos) {
                if (gameState[winPos[0]] == gameState[winPos[1]] && gameState[winPos[1]] == gameState[winPos[2]] && gameState[winPos[0]] != 2) {
                    if (gameState[winPos[0]]== 1) {
                        status.setText("O Wins The Match");
                    } else {
                        status.setText("X Wins The Match");

                    }
                    gameActive=false;
                }
            }


    }
    public void gameReset(View view){
        activePlayer=0;
        for(int i=0;i<8;i++){
            gameState[i]=2;
        }
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView10)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView11)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView12)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView13)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView14)).setImageResource(0);
    }
        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }
    }
