package com.example.pexeso;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private ImageView iv_11, iv_12, iv_13, iv_14,  iv_21, iv_22, iv_23, iv_24,  iv_31, iv_32, iv_33, iv_34;
    private Button play, reset;
    private Integer[] cardsArray = {101, 102, 103, 104, 105, 106, 201, 202, 203, 204, 205, 206};
    private int image101, image102, image103, image104, image105, image106, image201, image202, image203, image204, image205, image206;

    int firstCard, secondCard;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;

    int turn = 1;
    int numberOfAttempt = 0;
    int playerPoints = 0, cpuPoints = 0;
    boolean isRunningGame = false;
    boolean isSettedReset = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = (Button) findViewById(R.id.buttonPlay);
        reset = (Button) findViewById(R.id.buttonReset);

        iv_11 = (ImageView) findViewById(R.id.iv_11);
        iv_12 = (ImageView) findViewById(R.id.iv_12);
        iv_13 = (ImageView) findViewById(R.id.iv_13);
        iv_14 = (ImageView) findViewById(R.id.iv_14);

        iv_21 = (ImageView) findViewById(R.id.iv_21);
        iv_22 = (ImageView) findViewById(R.id.iv_22);
        iv_23 = (ImageView) findViewById(R.id.iv_23);
        iv_24 = (ImageView) findViewById(R.id.iv_24);

        iv_31 = (ImageView) findViewById(R.id.iv_31);
        iv_32 = (ImageView) findViewById(R.id.iv_32);
        iv_33 = (ImageView) findViewById(R.id.iv_33);
        iv_34 = (ImageView) findViewById(R.id.iv_34);

        iv_11.setTag("0");
        iv_12.setTag("1");
        iv_13.setTag("2");
        iv_14.setTag("3");

        iv_21.setTag("4");
        iv_22.setTag("5");
        iv_23.setTag("6");
        iv_24.setTag("7");

        iv_31.setTag("8");
        iv_32.setTag("9");
        iv_33.setTag("10");
        iv_34.setTag("11");

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startGame();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_11.setImageResource(R.drawable.uknown);
                iv_12.setImageResource(R.drawable.uknown);
                iv_13.setImageResource(R.drawable.uknown);
                iv_14.setImageResource(R.drawable.uknown);
                iv_21.setImageResource(R.drawable.uknown);
                iv_22.setImageResource(R.drawable.uknown);
                iv_23.setImageResource(R.drawable.uknown);
                iv_24.setImageResource(R.drawable.uknown);
                iv_31.setImageResource(R.drawable.uknown);
                iv_32.setImageResource(R.drawable.uknown);
                iv_33.setImageResource(R.drawable.uknown);
                iv_34.setImageResource(R.drawable.uknown);
                turn = 1;
            }
        });

        iv_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                numberOfAttempt++;
                doStuff(iv_11, theCard);
            }
        });

        iv_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                numberOfAttempt++;
                doStuff(iv_12, theCard);
            }
        });

        iv_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                numberOfAttempt++;
                doStuff(iv_13, theCard);
            }
        });

        iv_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                numberOfAttempt++;
                doStuff(iv_14, theCard);
            }
        });

        iv_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                numberOfAttempt++;
                doStuff(iv_21, theCard);
            }
        });

        iv_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                numberOfAttempt++;
                doStuff(iv_22, theCard);
            }
        });

        iv_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                numberOfAttempt++;
                doStuff(iv_23, theCard);
            }
        });

        iv_24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                numberOfAttempt++;
                doStuff(iv_24, theCard);
            }
        });

        iv_31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                numberOfAttempt++;
                doStuff(iv_31, theCard);
            }
        });

        iv_32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                numberOfAttempt++;
                doStuff(iv_32, theCard);
            }
        });

        iv_33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                numberOfAttempt++;
                doStuff(iv_33, theCard);
            }
        });

        iv_34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                numberOfAttempt++;
                doStuff(iv_34, theCard);
            }
        });

    }

    private void startGame()
    {
        beginNewGame();


    }

    private void beginNewGame(){
        //načte kartičkové obrázky
        frontOfCardsResources();

        //zamíchá obrázky
        Collections.shuffle(Arrays.asList(cardsArray));
    }


    private void doStuff(ImageView iv, int card)
    {
        int number = cardsArray[card];

        switch (number ) {
            case 101:
                iv.setImageResource(image101);
                Toast.makeText(this, "Nalezli jste shodu.", Toast.LENGTH_LONG).show();
                break;
            case 102:
                iv.setImageResource(image102);
                Toast.makeText(this, "Nalezli jste shodu.", Toast.LENGTH_LONG).show();
                break;
            case 103:
                iv.setImageResource(image103);
                Toast.makeText(this, "Nalezli jste shodu.", Toast.LENGTH_LONG).show();
                break;
            case 104:
                iv.setImageResource(image104);
                Toast.makeText(this, "Nalezli jste shodu.", Toast.LENGTH_LONG).show();
                break;
            case 105:
                iv.setImageResource(image105);
                Toast.makeText(this, "Nalezli jste shodu.", Toast.LENGTH_LONG).show();
                break;
            case 106:
                iv.setImageResource(image106);
                Toast.makeText(this, "Nalezli jste shodu.", Toast.LENGTH_LONG).show();
                break;
            case 201:
                iv.setImageResource(image201);
                Toast.makeText(this, "Nalezli jste shodu.", Toast.LENGTH_LONG).show();
                break;
            case 202:
                iv.setImageResource(image202);
                Toast.makeText(this, "Nalezli jste shodu.", Toast.LENGTH_LONG).show();
                break;
            case 203:
                iv.setImageResource(image203);
                Toast.makeText(this, "Nalezli jste shodu.", Toast.LENGTH_LONG).show();
                break;
            case 204:
                iv.setImageResource(image204);
                Toast.makeText(this, "Nalezli jste shodu.", Toast.LENGTH_LONG).show();
                break;
            case 205:
                iv.setImageResource(image205);
                Toast.makeText(this, "Nalezli jste shodu.", Toast.LENGTH_LONG).show();
                break;
            case 206:
                iv.setImageResource(image206);
                Toast.makeText(this, "Nalezli jste shodu.", Toast.LENGTH_LONG).show();
                break;
        }

        if (cardNumber == 1) {
            firstCard = cardsArray[card];

            if (firstCard > 200) {
                firstCard = firstCard - 100;
            }

            cardNumber = 2;
            clickedFirst = card;

            iv.setEnabled(false);

        }
        else if(cardNumber == 2){
            secondCard = cardsArray[card];

            if (secondCard > 200) {
                firstCard = firstCard - 100;
            }

            cardNumber = 1;
            clickedSecond = card;

            /*
            iv_11.setEnabled(false);
            iv_12.setEnabled(false);

            iv_21.setEnabled(false);
            iv_22.setEnabled(false);

            iv_31.setEnabled(false);
            iv_32.setEnabled(false);
            */
            Handler handler = new Handler();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                   calculate();
                }
            }, 1000);
        }
    }

    private void calculate() {

        if (firstCard == secondCard) {
            switch (clickedFirst) {
                case 0:
                    iv_11.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    iv_12.setVisibility(View.INVISIBLE);
                    break;
                case 2:
                    iv_13.setVisibility(View.INVISIBLE);
                    break;
                case 3:
                    iv_14.setVisibility(View.INVISIBLE);
                    break;
                case 4:
                    iv_21.setVisibility(View.INVISIBLE);
                    break;
                case 5:
                    iv_22.setVisibility(View.INVISIBLE);
                    break;
                case 6:
                    iv_23.setVisibility(View.INVISIBLE);
                    break;
                case 7:
                    iv_24.setVisibility(View.INVISIBLE);
                    break;
                case 8:
                    iv_31.setVisibility(View.INVISIBLE);
                    break;
                case 9:
                    iv_32.setVisibility(View.INVISIBLE);
                    break;
                case 10:
                    iv_33.setVisibility(View.INVISIBLE);
                    break;
                case 11:
                    iv_34.setVisibility(View.INVISIBLE);
                    break;
            }

            switch (clickedSecond) {
                case 0:
                    iv_11.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    iv_12.setVisibility(View.INVISIBLE);
                    break;
                case 2:
                    iv_13.setVisibility(View.INVISIBLE);
                    break;
                case 3:
                    iv_14.setVisibility(View.INVISIBLE);
                    break;
                case 4:
                    iv_21.setVisibility(View.INVISIBLE);
                    break;
                case 5:
                    iv_22.setVisibility(View.INVISIBLE);
                    break;
                case 6:
                    iv_23.setVisibility(View.INVISIBLE);
                    break;
                case 7:
                    iv_24.setVisibility(View.INVISIBLE);
                    break;
                case 8:
                    iv_31.setVisibility(View.INVISIBLE);
                    break;
                case 9:
                    iv_32.setVisibility(View.INVISIBLE);
                    break;
                case 10:
                    iv_33.setVisibility(View.INVISIBLE);
                    break;
                case 11:
                    iv_34.setVisibility(View.INVISIBLE);
                    break;
            }

            if (turn >= 2) {
                iv_11.setImageResource(R.drawable.uknown);
                iv_12.setImageResource(R.drawable.uknown);
                iv_13.setImageResource(R.drawable.uknown);
                iv_14.setImageResource(R.drawable.uknown);
                iv_21.setImageResource(R.drawable.uknown);
                iv_22.setImageResource(R.drawable.uknown);
                iv_23.setImageResource(R.drawable.uknown);
                iv_24.setImageResource(R.drawable.uknown);
                iv_31.setImageResource(R.drawable.uknown);
                iv_32.setImageResource(R.drawable.uknown);
                iv_33.setImageResource(R.drawable.uknown);
                iv_34.setImageResource(R.drawable.uknown);


            }

            iv_11.setEnabled(true);
            iv_12.setEnabled(true);
            iv_13.setEnabled(true);
            iv_14.setEnabled(true);
            iv_21.setEnabled(true);
            iv_22.setEnabled(true);
            iv_23.setEnabled(true);
            iv_24.setEnabled(true);
            iv_31.setEnabled(true);
            iv_32.setEnabled(true);
            iv_33.setEnabled(true);
            iv_34.setEnabled(true);
            checkEnd();
        }
    }

    private void checkEnd()
        {
            if (iv_11.getVisibility() == View.INVISIBLE &&
                    iv_12.getVisibility() == View.INVISIBLE &&
                    iv_13.getVisibility() == View.INVISIBLE &&
                    iv_14.getVisibility() == View.INVISIBLE &&
                    iv_21.getVisibility() == View.INVISIBLE &&
                    iv_22.getVisibility() == View.INVISIBLE &&
                    iv_23.getVisibility() == View.INVISIBLE &&
                    iv_24.getVisibility() == View.INVISIBLE &&
                    iv_31.getVisibility() == View.INVISIBLE &&
                    iv_32.getVisibility() == View.INVISIBLE &&
                    iv_33.getVisibility() == View.INVISIBLE &&
                    iv_34.getVisibility() == View.INVISIBLE
            ) {
                Toast.makeText(this,
                        "Hra skončila. Počet pokusů: " + numberOfAttempt
                        , Toast.LENGTH_LONG).show();

                numberOfAttempt = 0;
            }
    }

    private void frontOfCardsResources(){
        image101 = R.drawable.denmark;
        image102 = R.drawable.england;
        image103 = R.drawable.italy;
        image104 = R.drawable.italy;
        image105 = R.drawable.england;
        image105 = R.drawable.denmark;

        image201 = R.drawable.poland;
        image202 = R.drawable.poland;
        image203 = R.drawable.scotland;
        image204 = R.drawable.scotland;
        image205 = R.drawable.norway;
        image206 = R.drawable.norway;
    }
}
