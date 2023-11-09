package com.noobwire.viewsnavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    Button btnDaisy;
    Button btnLuigi;
    Button btnRosalina;
    TextView btnFechar;
    TextView btnMudarTema;

    boolean dark = false;

    LinearLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);


        btnDaisy = findViewById(R.id.idCharmander);
        btnLuigi = findViewById(R.id.idBulbasaur);
        btnRosalina = findViewById(R.id.idSquirtle);
        btnFechar = findViewById(R.id.idFechar);
        btnMudarTema = findViewById(R.id.idMudarTema);

        layout = findViewById(R.id.idMenuLayout);

        SharedPreferences prefs = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        dark = prefs.getBoolean("dark", false);

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

        btnFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnMudarTema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences("AppPrefs", MODE_PRIVATE).edit();
                dark = !dark;
                editor.putBoolean("dark", dark);
                editor.apply();
            }
        });
    }

    private void intentWithCharData(String character, Class<? extends Activity> ActivityToOpen){
        Intent intent = new Intent(MenuActivity.this, ActivityToOpen);
        intent.putExtra("character", character);

        startActivity(intent);
    };
}