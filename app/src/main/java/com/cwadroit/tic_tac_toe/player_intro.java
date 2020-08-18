package com.cwadroit.tic_tac_toe;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.text.TextUtils;

public class player_intro extends AppCompatActivity {
    EditText textField1,textField2;
    Button letsPlay;


 //to go to next page and forward data as well


    public void next_page(View view) {
        String player1= textField1.getText().toString();
        String player2= textField2.getText().toString();
        if(TextUtils.isEmpty(player1)){
            player1="1st Player";
        }
        if(TextUtils.isEmpty(player2)){
            player2="2nd Player";
        }
        Intent intent = new Intent(this, multiplayer.class);
        intent.putExtra("player_1_name", player1);
        intent.putExtra("player_2_name", player2);
        startActivityForResult(intent,10);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==10)
        {
            textField1.setText("");
            textField2.setText("");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_intro);
        textField2=(EditText) findViewById(R.id.player2name);
        textField1=(EditText) findViewById(R.id.player1name);
        Button letsPlay=(Button) findViewById(R.id.play_button);
        letsPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                next_page(view);
            }
        });


    }

}
