package com.noobwire.viewsnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DescricaoActivity extends AppCompatActivity {

    // Arrays contendo os IDs dos recursos drawable para os personagens Luigi, Daisy e Rosalina.
    private final int[] luigiArray = {
            R.drawable.luigi1,
            R.drawable.luigi2,
            R.drawable.luigi3,
    };
    private final int[] daisyArray = {
            R.drawable.daisy1,
            R.drawable.daisy2,
            R.drawable.daisy3,
    };
    private final int[] rosalinaArray = {
            R.drawable.rosalina1,
            R.drawable.rosalina2,
            R.drawable.rosalina3,
    };

    // Array para manter o controle de qual imagem está sendo exibida para cada personagem.
    private final int[] universalCounter = {
            0,  // 0 luigi
            0,  // 1 daisy
            0   // 2 rosalina
    };

    Button btnVoltar;
    Button btnAvancar;
    TextView btnRetornar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.descricao_layout);

        btnVoltar = findViewById(R.id.idVoltar);
        btnAvancar = findViewById(R.id.idAvancar);
        btnRetornar = findViewById(R.id.idRetornar);

        // Recebe dados da atividade anterior.
        Bundle bundle = getIntent().getExtras();

        // Recupera o estado salvo das posições das imagens dos personagens.
        SharedPreferences prefs = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        universalCounter[0] = prefs.getInt("counterLuigi", 0); // Se não encontrar, volta para a primeira imagem
        universalCounter[1] = prefs.getInt("counterDaisy", 0);
        universalCounter[2] = prefs.getInt("counterRosalina", 0);

        // Define a imagem inicial baseada no personagem selecionado.
        if (bundle != null) {
            switch (bundle.getString("character")){
                case "luigi":
                    updateImage(luigiArray, 0);
                    break;
                case "daisy":
                    updateImage(daisyArray, 1);
                    break;
                case "rosalina":
                    updateImage(rosalinaArray, 2);
                    break;
            }
        }

        btnRetornar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // Configura o botão para avançar a imagem do personagem selecionado.
        btnAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bundle != null){
                    switch (bundle.getString("character")){
                        case "luigi":
                            showNextImage(luigiArray, 0);
                            break;
                        case "daisy":
                            showNextImage(daisyArray, 1);
                            break;
                        case "rosalina":
                            showNextImage(rosalinaArray, 2);
                            break;
                    }
                }
            }
        });

        // Configura o botão para retroceder a imagem do personagem selecionado.
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bundle != null){
                    switch (bundle.getString("character")){
                        case "luigi":
                            showPreviousImage(luigiArray, 0);
                            break;
                        case "daisy":
                            showPreviousImage(daisyArray, 1);
                            break;
                        case "rosalina":
                            showPreviousImage(rosalinaArray, 2);
                            break;
                    }
                }
            }
        });
    }

    // Salva o índice da imagem atual do personagem selecionado nas preferências compartilhadas.
    private void saveImageIndex(int index, int indexSelector) {
        SharedPreferences prefs = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        // Salva o índice da imagem com base no personagem.
        switch (indexSelector){
            case 0:
                editor.putInt("counterLuigi", index);
                break;
            case 1:
                editor.putInt("counterDaisy", index);
                break;
            case 2:
                editor.putInt("counterRosalina", index);
                break;
        }
        // Aplica as mudanças ao editor de preferências.
        editor.apply();
    }

    // Atualiza para a próxima imagem do personagem selecionado e salva o novo índice.
    private void showNextImage(int[] imageResources, int indexSelector) {
        // Calcula o próximo índice de forma circular dentro do array de imagens.
        universalCounter[indexSelector] = (universalCounter[indexSelector] + 1) % imageResources.length;
        updateImage(imageResources, indexSelector);
    }

    private void showPreviousImage(int[] imageResources, int indexSelector) {
        // Calcula o índice anterior de forma circular dentro do array de imagens.
        universalCounter[indexSelector] = (universalCounter[indexSelector] - 1 + imageResources.length) % imageResources.length;
        updateImage(imageResources, indexSelector);
    }

    private void updateImage(int[] imageResources, int indexSelector) {
        ImageView imageView = findViewById(R.id.personagemImageView);

        // Define o recurso da imagem a ser mostrado.
        imageView.setImageResource(imageResources[universalCounter[indexSelector]]);

        // Salva o índice da imagem exibida nas preferências compartilhadas.
        saveImageIndex(universalCounter[indexSelector], indexSelector);
    }
}