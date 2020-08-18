package com.cwadroit.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class multiplayer extends AppCompatActivity {
    //state->  -1 = blank , 0 = X ,1 = O
    //GLOBAL DECLARATIONS
    Button newgame;

    boolean activegame=true;
    int oscillator=0;
    int player=0;
    int[] posVal={-1,-1,-1,-1,-1,-1,-1,-1,-1};
    int[][] winPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    //ON TAP FOR TIC-TAC-TOE GAME

    @SuppressLint("SetTextI18n")
    public void ontap(View view){

        ImageView img= (ImageView) view;
        int tappos=Integer.parseInt(img.getTag().toString());


        TextView playturn=findViewById(R.id.playturn);
        Intent intent=getIntent();
        String player1turn=intent.getStringExtra("player_1_name")+ "\'s"+" turn";
        String player2turn=intent.getStringExtra("player_2_name")+ "\'s"+" turn";

        if(!activegame)
        {
            resetGame(view);
        }


        if(posVal[tappos]==-1 && oscillator<9)
        {
            if(oscillator%2==0)
            {
                img.setImageResource(R.drawable.cross);
                posVal[tappos]=0;
                oscillator++;

                playturn.setText(player2turn);
            }
            else
            {
                img.setImageResource(R.drawable.circle);
                oscillator++;
                posVal[tappos]=1;
                playturn.setText(player1turn);
            }
        }

        //TO CHECK IF WON OR NOT

        for(int[] winpos: winPositions)
        {
            if(posVal[winpos[0]]==posVal[winpos[1]]  &&  posVal[winpos[1]]==posVal[winpos[2]]  &&  posVal[winpos[0]]!=-1)
                {
                if(winpos[0]==0)
                   {
                    playturn.setText(intent.getStringExtra("player_2_name") + " has won,Congratulations!!!");
                    activegame=false;

                   }
                else
                    {
                        playturn.setText(intent.getStringExtra("player_1_name") + " has won,Congratulations!!!");
                        activegame=false;
                    }
                }
        }

        //IN CASE OF DRAW

        if(oscillator==9&&activegame)
        {
            playturn.setText("Well Played but the Game is drawn");
            resetGame(view);
        }

    }

    //RESETTING GAME
    public void resetGame(View view)
    {
       activegame=true;
       oscillator=0;
       for(int i=0;i<posVal.length;i++){
           posVal[i]=-1;
       }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newgame=findViewById(R.id.newgame);
        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent1=new Intent();
            setResult(10,intent1);
            finish();
            }
        });
    }
}
