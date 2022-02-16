package com.example.coach.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.coach.R;
import com.example.coach.controleur.Controle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    /**
     * initialisations
     */
    private void init(){
        Controle.getInstance(this);
        creerMenu();
    }

    /**
     * crée les procédures événementielles pour gérer le menu
     */
    private void creerMenu(){
        ecouteMenu((ImageButton)findViewById(R.id.btnMonIMG), CalculActivity.class);
        ecouteMenu((ImageButton)findViewById(R.id.btnMonHistorique), HistoActivity.class);
    }

    /**
     * procédure événementielle sur le clic d'une image du menu
     * @param btn
     * @param classe
     */
    private void ecouteMenu(ImageButton btn, final Class classe){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, classe);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
}