package com.example.user.sweepbomb;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class GameAc extends AppCompatActivity {


    Grid[][] block = new Grid[7][5];
    Game game;
    Button flagBu,resetBu,cardBu1,cardBu2,cardBu3;
    int low,ver;
    boolean flag =false;
    boolean card = false;
    boolean end =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        LinearLayout layout;
        LinearLayout a[]=new LinearLayout[7];
        a[0]= (LinearLayout) findViewById(R.id.ga1);
        a[1]= (LinearLayout) findViewById(R.id.ga2);
        a[2]= (LinearLayout) findViewById(R.id.ga3);
        a[3]= (LinearLayout) findViewById(R.id.ga4);
        a[4]= (LinearLayout) findViewById(R.id.ga5);
        a[5]= (LinearLayout) findViewById(R.id.ga6);
        a[6]= (LinearLayout) findViewById(R.id.ga7);

        layout = (LinearLayout) findViewById(R.id.gaLL);



        for(low=0;low<7;low++){
            for(ver=0;ver<5;ver++){
                Button button=new Button(this);
                button.setOnClickListener(new Act(low,ver));
                block[low][ver]=new Grid(button);
                a[low].addView(block[low][ver].button);
            }
        }
        Game game=new Game(block);
        game.star();
        flagBu=(Button)findViewById(R.id.flagBu);
        flagBu.setOnClickListener(setFlag);
        resetBu=(Button)findViewById(R.id.resetBu);
        resetBu.setOnClickListener(setRest);

        cardBu1=(Button)findViewById(R.id.gaCard1);
        cardBu1.setOnClickListener(setCard1);

        cardBu2=(Button)findViewById(R.id.gaCard2);
        cardBu2.setOnClickListener(setCard2);

        cardBu3=(Button)findViewById(R.id.gaCard3);
        cardBu3.setOnClickListener(setCard3);



    }

    private View.OnClickListener setFlag = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
         flag=true;
        }
    };

    private View.OnClickListener setRest = new View.OnClickListener() {
        @Override
        public void onClick(View v) {


        }
    };
    private View.OnClickListener setCard1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           /* int count=1,i,j,;

            int rand=(int)(Math.random()*game.count);
            for(i=0;i<7;i++){
                for(j=0;j<5;j++){
                    if(block[i][j].view==-1&&count==rand){
                        block[i][j].status=-1;
                        block[i][j].button.setText("@");
                    }
                    else if(block[i][j].view==-1) count++;



                }
            }
*/



        }
    };
    private View.OnClickListener setCard2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            flag=true;

        }
    };

    private View.OnClickListener setCard3 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            flag=true;

        }
    };



    public class Act implements View.OnClickListener {
        int low;
        int ver;
        public Act(int low,int ver){
            this.low=low;
            this.ver=ver;
        }

        @Override
        public void onClick(View v) {
            int vi = block[low][ver].view;
            if(flag==true&&block[low][ver].status==0){
                block[low][ver].button.setText("@");
                block[low][ver].status=-1;
                flag=false;
            }
            else if(vi==-1&&block[low][ver].status==0) {
                block[low][ver].button.setText("*");
                block[low][ver].button.setBackgroundColor(Color.RED);
                block[low][ver].status=1;
            }
            else if(block[low][ver].status==0){
                block[low][ver].button.setText("" + vi);
                block[low][ver].button.setBackgroundColor(Color.GRAY);
                block[low][ver].status=1;
            }
        }

    }
    public class Grid{
        Button button;
        public int status=0;
        public int view=0;
        public Grid (Button button){
            this.button=button;
        }

    }



    public class Game{
        Grid[][] grid;

        public Game (Grid grid[][]){
            this.grid=grid;
         }

        void star(){

           for(int i=0;i<8;i++){
               int rand=(int)(Math.random()*34);
                if(grid[rand/5][rand%5].view==0){
                    grid[rand/5][rand%5].view =-1;
                }


           }
            for(int i=0;i<7;i++){
                for(int j=0;j<5;j++){
                    if(grid[i][j].view==0){
                        grid[i][j].view= this.decideView(i, j);
                    }
                }
            }
        }


        void openBlank(int raw,int ver){
            if(grid[raw][ver].view==0){


            }

        }











         int decideView(int raw,int ver){
            int count=0;
           if(0<raw&&raw<6&&0<ver&&ver<4){
               if(grid[raw-1][ver-1].view==-1){count++;}
               if(grid[raw-1][ver].view==-1){count++;}
               if(grid[raw-1][ver+1].view==-1){count++;}
               if(grid[raw][ver-1].view==-1){count++;}
               if(grid[raw][ver+1].view==-1){count++;}
               if(grid[raw+1][ver-1].view==-1){count++;}
               if(grid[raw+1][ver].view==-1){count++;}
               if(grid[raw+1][ver+1].view==-1){count++;}
           }
           else if(raw==0&&0<ver&&ver<4){
               if(grid[raw][ver-1].view==-1){count++;}
               if(grid[raw][ver+1].view==-1){count++;}
               if(grid[raw+1][ver-1].view==-1){count++;}
               if(grid[raw+1][ver].view==-1){count++;}
               if(grid[raw+1][ver+1].view==-1){count++;}
           }
           else if(raw==6&&0<ver&&ver<4){
               if(grid[raw-1][ver-1].view==-1){count++;}
               if(grid[raw-1][ver].view==-1){count++;}
               if(grid[raw-1][ver+1].view==-1){count++;}
               if(grid[raw][ver-1].view==-1){count++;}
               if(grid[raw][ver+1].view==-1){count++;}
           }
           else if(ver==0&&raw>0&&raw<6){

               if(grid[raw-1][ver].view==-1){count++;}
               if(grid[raw-1][ver+1].view==-1){count++;}
               if(grid[raw][ver+1].view==-1){count++;}
               if(grid[raw+1][ver].view==-1){count++;}
               if(grid[raw+1][ver+1].view==-1){count++;}

           }
           else if(ver==4&&raw>0&&raw<6){
               if(grid[raw-1][ver-1].view==-1){count++;}
               if(grid[raw-1][ver].view==-1){count++;}
               if(grid[raw][ver-1].view==-1){count++;}
               if(grid[raw+1][ver-1].view==-1){count++;}
               if(grid[raw+1][ver].view==-1){count++;}
           }

           else if(raw==0&&ver==0){

               if(grid[raw][ver+1].view==-1){count++;}
               if(grid[raw+1][ver].view==-1){count++;}
               if(grid[raw+1][ver+1].view==-1){count++;}

           }
           else if(raw==0&&ver==4) {

               if (grid[raw][ver - 1].view == -1) {count++;}
               if (grid[raw + 1][ver - 1].view == -1) {count++;}
               if (grid[raw + 1][ver].view == -1) {count++;}
           }

           else if(raw==6&&ver==0){
               if(grid[raw-1][ver].view==-1){count++;}
               if(grid[raw-1][ver+1].view==-1){count++;}
               if(grid[raw][ver+1].view==-1){count++;}
           }
           else if(raw==6&&ver==4){
               if(grid[raw-1][ver-1].view==-1){count++;}
               if(grid[raw-1][ver].view==-1){count++;}
               if(grid[raw][ver-1].view==-1){count++;}

           }

             return count;
        }


    }


}
