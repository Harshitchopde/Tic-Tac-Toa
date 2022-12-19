package com.example.tictactoa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public
class Winner extends AppCompatActivity {
    Button restart;
    TextView playerName;



    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        restart = findViewById(R.id.replay);
        Intent intent = getIntent();

        String name = intent.getStringExtra("winner");
        playerName = findViewById(R.id.playerName);
        playerName.setText(name);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public
            void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }
}