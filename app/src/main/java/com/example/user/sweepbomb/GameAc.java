package com.example.user.sweepbomb;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class GameAc extends AppCompatActivity {


    Button[] block = new Button[64];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        LinearLayout layout;
        LinearLayout a[]=new LinearLayout[8];
        a[0]= (LinearLayout) findViewById(R.id.ga1);
        a[1]= (LinearLayout) findViewById(R.id.ga2);
        a[2]= (LinearLayout) findViewById(R.id.ga3);
        a[3]= (LinearLayout) findViewById(R.id.ga4);
        a[4]= (LinearLayout) findViewById(R.id.ga5);
        a[5]= (LinearLayout) findViewById(R.id.ga6);
        a[6]= (LinearLayout) findViewById(R.id.ga7);
        a[7]= (LinearLayout) findViewById(R.id.ga8);

        layout = (LinearLayout) findViewById(R.id.gaLL);
       for(int i=0;i<40;i++){
           block[i]=new Button(this);
           block[i].setOnClickListener(new Act(i));
           block[i].setHeight(50);
           block[i].setWidth(50);
           a[i%8].addView(block[i]);
          // block[i].setWidth(1);

       }





    }

    public class Act implements View.OnClickListener {
        int i;
        public Act(int i){
            this.i=i;
        }

        @Override
        public void onClick(View v) {
            block[i].setText("1");

        }

    }


}
