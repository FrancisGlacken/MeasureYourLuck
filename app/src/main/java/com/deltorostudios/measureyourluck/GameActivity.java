package com.deltorostudios.measureyourluck;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private TextView numberView;
    private int number;
    private int rngNumber;
    private Random rng = new Random();

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_red:
                    if (rngNumber == 0) {
                        number = incrementNumber(number);
                        rngNumber = rng.nextInt(1) + 1;
                        Toast.makeText(GameActivity.this, ""+rngNumber, Toast.LENGTH_SHORT).show();
                    }
                    return true;


                case R.id.navigation_green:
                    if (rngNumber == 1) {
                        number = incrementNumber(number);
                        rngNumber = rng.nextInt(1);
                        if (rngNumber == 1) { rngNumber++; }
                        Toast.makeText(GameActivity.this, ""+rngNumber, Toast.LENGTH_SHORT).show();
                    }
                    return true;


                case R.id.navigation_blue:
                    if (rngNumber == 1) {
                        number = incrementNumber(number);
                        rngNumber = rng.nextInt(1);
                        Toast.makeText(GameActivity.this, ""+rngNumber, Toast.LENGTH_SHORT).show();
                    } else {
                       /* rngNumber = rng.nextInt(1);
                        number = resetNumber(number);
                        Toast.makeText(GameActivity.this, "YOU LOSE, GOOD DAY SIR!!!", Toast.LENGTH_SHORT).show(); */
                    }
                    return true;
            }
            return false;
        }
    };

    public int incrementNumber(int numberino) {
        numberino++;
        numberView.setText(""+numberino);
        return numberino;
    }

    public int resetNumber(int numberino) {
        numberino = 0;
        numberView.setText("" + numberino);
        return numberino;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Instantiate number to zero and rngNumber to random number from 0, 1 and 2
        number = 0;
        rngNumber = rng.nextInt(1) + 1;
        Toast.makeText(this, ""+rngNumber, Toast.LENGTH_SHORT).show();

        // Create references for views
        numberView = findViewById(R.id.numberView);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(navListener);

    }

}
