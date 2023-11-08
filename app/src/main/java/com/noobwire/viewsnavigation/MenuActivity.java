package com.noobwire.viewsnavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    Button btnDaisy;
    Button btnLuigi;
    Button btnRosalina;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);

        btnDaisy = findViewById(R.id.idCharmander);
        btnLuigi = findViewById(R.id.idBulbasaur);
        btnRosalina = findViewById(R.id.idSquirtle);

        btnDaisy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentWithCharData("daisy", DescricaoActivity.class);
            }
        });

        btnLuigi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentWithCharData("luigi", DescricaoActivity.class);
            }
        });

        btnRosalina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {intentWithCharData("rosalina", DescricaoActivity.class); }
        });
    }

    private void intentWithCharData(String character, Class<? extends Activity> ActivityToOpen){
        Intent intent = new Intent(MenuActivity.this, ActivityToOpen);
        intent.putExtra("character", character);

        startActivity(intent);
    };
}