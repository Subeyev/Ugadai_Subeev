package com.example.ugadai_subeev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView tvInfo;
    EditText etInput;
    Button bControl;

    int guess;
    boolean gameFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = (TextView)findViewById(R.id.textView1);
        etInput = (EditText)findViewById(R.id.editTextNumber1);
        bControl = (Button)findViewById(R.id.button1);

        guess = (int)(Math.random()*100);
        gameFinished = false;

    }

    public void onClick(View v){
        if (!gameFinished){
            int inp=Integer.parseInt(etInput.getText().toString());
            if (inp <0 || inp >100){
                tvInfo.setText(getResources().getString(R.string.error) + " " + getResources().getString(R.string.other));
            }
            else {
                if (inp>guess)
                    tvInfo.setText(getResources().getString(R.string.ahead) + " " + getResources().getString(R.string.other));
                if (inp<guess)
                    tvInfo.setText(getResources().getString(R.string.behind)  + " " + getResources().getString(R.string.other));
                if (inp==guess) {
                    tvInfo.setText(getResources().getString(R.string.hit));
                    bControl.setText(getResources().getString(R.string.play_more));
                    gameFinished = true;
                }
            }

        }
        else{
            guess = (int)(Math.random()*100);
            tvInfo.setText(getResources().getString(R.string.try_to_guess));
            bControl.setText(getResources().getString(R.string.input_value));
            gameFinished = false;
        }

        etInput.setText("");

    }


}