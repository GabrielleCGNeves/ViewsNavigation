package com.noobwire.viewsnavigation;

import androidx.appcompat.app.AppCompatActivity;

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
                Intent intent = new Intent(MenuActivity.this, DescricaoActivity.class);
                intent.putExtra("daisy", "daisy");

                startActivity(intent);
            }
        });

    }
}