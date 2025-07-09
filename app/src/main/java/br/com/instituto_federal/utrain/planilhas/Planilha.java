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


        int planilhaId = getIntent().getIntExtra("planilhaId", -1);

        List<Exercicio> exercicios = new ArrayList<>();

        if (planilhaId == 1) {
            exercicios.add(new Exercicio("Agachamento", "Fortalece pernas", "Quadríceps", "V5iNNV9KaVA", 1));
            exercicios.add(new Exercicio("Leg Press", "Trabalha pernas", "Quadríceps", "abc123", 1));
            exercicios.add(new Exercicio("Extensora", "Trabalha pernas", "Quadríceps", "abc123", 1));
            exercicios.add(new Exercicio("Mesa Flexora", "Trabalha pernas", "Quadríceps", "abc123", 1));
            exercicios.add(new Exercicio("Stiff", "Posicione os pés na largura dos ombros, pegue a barra ou halteres, estufe o peito, feche as escapulas, leve APENAS o quadril para trás fazendo com que a barra desça rente ao corpo", "Posterior e Glúteos", "VkLIhN1HSFw", 1));
        } else if (planilhaId == 2) {
            exercicios.add(new Exercicio("Supino", "Fortalece peitoral", "Peitoral", "eG6b1k2a4g0", 2));
            exercicios.add(new Exercicio("Crucifixo", "Isola peitoral", "Peitoral", "def456", 2));
        } else if (planilhaId == 3) {
            exercicios.add(new Exercicio("Remada", "Fortalece costas", "Dorsal", "ghi789", 3));
            exercicios.add(new Exercicio("Puxada", "Trabalha costas", "Dorsal", "jkl012", 3));
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(this));
        ExercicioAdapter adapter = new ExercicioAdapter(this, exercicios);
        recyclerView.setAdapter(adapter);

    }
}


