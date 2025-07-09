package br.com.instituto_federal.utrain.planilhas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import br.com.instituto_federal.utrain.Home;
import br.com.instituto_federal.utrain.Login;
import br.com.instituto_federal.utrain.R;
import androidx.recyclerview.widget.RecyclerView;

public class Planilha extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planilha);
        BottomNavigationView nav = findViewById(R.id.bottomNavigationView);
        nav.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_home) {
                startActivity(new Intent(this, Home.class));
                return true;
            } else if (item.getItemId() == R.id.nav_logout) {
                Intent intent = new Intent(this, Login.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                return true;
            }
            return true;
        });



        List<Exercicio> exercicio1 = new ArrayList<>();
        exercicio1.add(new Exercicio("Agachamento", "Exercício para fortalecer as pernas e glúteos", "Quadríceps, Glúteos", "V5iNNV9KaVA"));
        exercicio1.add(new Exercicio("Supino", "Exercício para fortalecer o peitoral", "Peitoral, Tríceps", "eG6b1k2a4g0"));
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(this));
        ExercicioAdapter adapter = new ExercicioAdapter(this, exercicio1);
        recyclerView.setAdapter(adapter);

    }
}


