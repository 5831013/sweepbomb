package com.example.user.sweepbomb;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MenuAc extends AppCompatActivity {
    Button normalGaBu,timeGaBu,backpackBu,storeBu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        normalGaBu = (Button)findViewById(R.id.normalGaBu);
        timeGaBu = (Button)findViewById(R.id.timeGaBu);
        backpackBu = (Button)findViewById(R.id. backpackBu);
        storeBu = (Button)findViewById(R.id.storeBu);

        normalGaBu.setOnClickListener(gameLis);
        timeGaBu.setOnClickListener(gameLis);
        backpackBu.setOnClickListener(backpackLis);
        storeBu.setOnClickListener(storeLis);

    }
    private View.OnClickListener gameLis = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(MenuAc.this,GameAc.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener backpackLis = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(MenuAc.this,BackpackAc.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener storeLis = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(MenuAc.this,StoreAc.class);
            startActivity(intent);
        }
    };



}
