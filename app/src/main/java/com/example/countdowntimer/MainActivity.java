package com.example.countdowntimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button mbtnStart;
    ImageView mImg;
    boolean mIsRunning = false;
    int [] arrayImage;
    int mCount =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbtnStart = findViewById(R.id.btnStart);
        mImg = findViewById(R.id.img);

        arrayImage = new int[]{
                R.drawable.hinh1,
                R.drawable.hinh2,
                R.drawable.hinh3,
                R.drawable.hinh4,
                R.drawable.hinh5,
        };

        mbtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mIsRunning){
                    CountDownTimer countDownTimer = new CountDownTimer(1200,1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            if(millisUntilFinished>1000){
                                if(mCount == arrayImage.length){
                                    mCount=0;
                                }
                                mImg.setImageResource(arrayImage[mCount++]);
                            }
                        }

                        @Override
                        public void onFinish() {
                            this.start();
                        }
                    };
                    countDownTimer.start();
                }
            }
        });
    }
}