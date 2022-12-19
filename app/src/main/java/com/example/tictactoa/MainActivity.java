package com.example.tictactoa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public
class MainActivity extends AppCompatActivity {
    Button b11,b12,b13,b21,b22,b33,b32,b31,b23;
    boolean flage =false;
    TextView score1,score2;
    String winner;
    int cnt =0;
    int Player1=0;
    int Player2 = 0;

    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b11 = findViewById(R.id.b11);
        b12 = findViewById(R.id.b12);
        b13 = findViewById(R.id.b13);
        b21 = findViewById(R.id.b21);
        b22 = findViewById(R.id.b22);
        b23 = findViewById(R.id.b23);
        b31 = findViewById(R.id.b31);
        b32 = findViewById(R.id.b32);
        b33 = findViewById(R.id.b33);
        score1=findViewById(R.id.scoreA);
        score2=findViewById(R.id.scoreB);


    }
    private void reset(){
        b11.setText("");
        b21.setText("");
        b31.setText("");
        b12.setText("");
        b22.setText("");
        b32.setText("");
        b13.setText("");
        b23.setText("");
        b33.setText("");

    }
    private  void check(int player,String winnerN){
        if (player==5){
            String winner;
            Intent intent = new Intent(getApplicationContext(), Winner.class);

            if (winnerN=="X"){
                winner= "Player A";
            }
            else {
                winner="Player  B";
            }
            intent.putExtra("winner",winner);

            startActivity(intent);

        }

    }
    private void score(String score){
        if (score.equals("X")){
            Player1++;
            check(Player1,"X");

        }
        else {
            Player2++;
            check(Player2,"O");

        }
        score1.setText(""+Player1);
        score2.setText(""+Player2);
    }

    public
    void click(View view) {
        Button cBtn = (Button) view;
        if (cBtn.getText().toString().trim()==""){
        cnt++;
        if (flage==false){
            cBtn.setText("X");
            flage=true;
        }
        else {
            cBtn.setText("O");
            flage=false;
        }
        String B11 = b11.getText().toString().trim();
        String B12 = b12.getText().toString().trim();
        String B13 = b13.getText().toString().trim();

        String B21 = b21.getText().toString().trim();
        String B22 = b22.getText().toString().trim();
        String B23 = b23.getText().toString().trim();

        String B31 = b31.getText().toString().trim();
        String B32= b32.getText().toString().trim();
        String B33= b33.getText().toString().trim();
        if (B11.equals(B12) && B12.equals(B13) && !B13.isEmpty()){
            Toast.makeText(this, "Winner is : "+B12, Toast.LENGTH_SHORT).show();
            score(B12);cnt=0;
            reset();
        }
        else if (B21.equals(B22) && B22.equals(B23) && !B23.isEmpty()){
            Toast.makeText(this, "Winner is : "+B22, Toast.LENGTH_SHORT).show();
            score(B21);
            cnt=0;
            reset();
        }
        else if (B31.equals(B32) && B32.equals(B33) && !B33.isEmpty()){
            Toast.makeText(this, "Winner is : "+B32, Toast.LENGTH_SHORT).show();
            score(B31);
            cnt=0;
            reset();
        } else if (B11.equals(B21) && B21.equals(B31) && !B31.isEmpty()){
            Toast.makeText(this, "Winner is : "+B21, Toast.LENGTH_SHORT).show();
            score(B31);
            cnt=0;
            reset();
        }
        else if (B12.equals(B22) && B22.equals(B32) && !B32.isEmpty()){
            Toast.makeText(this, "Winner is : "+B22, Toast.LENGTH_SHORT).show();
            score(B32);
            cnt=0;
            reset();
        }else if (B13.equals(B23) && B23.equals(B33) && !B33.isEmpty()){
            Toast.makeText(this, "Winner is : "+B23, Toast.LENGTH_SHORT).show();
            score(B23);
            cnt=0;
            reset();
        }
        else if (B11.equals(B22) && B22.equals(B33) && !B33.isEmpty()){
            Toast.makeText(this, "Winner is : "+B33, Toast.LENGTH_SHORT).show();
            score(B33);
            cnt=0;
            reset();
        }
        else if (B31.equals(B22) && B22.equals(B13) && !B13.isEmpty()){
            Toast.makeText(this, "Winner is : "+B13, Toast.LENGTH_SHORT).show();
            score(B13);
            cnt=0;
            reset();
        }
        else if (cnt==9){
            Toast.makeText(this, "This is draw mean No winner ", Toast.LENGTH_SHORT).show();
            reset();
            cnt=0;


        }

    }}
}