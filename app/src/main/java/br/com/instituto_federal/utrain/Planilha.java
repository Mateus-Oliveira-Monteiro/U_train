package br.com.instituto_federal.utrain;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

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

        Button btnExecucao = findViewById(R.id.btnExecucao);
        btnExecucao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Planilha.this, Execucao.class);
                // Dados de exemplo para passar para a tela de Execução
                intent.putExtra("nomeExercicio", "Supino Reto com Barra");
                intent.putExtra("descricaoExercicio", "Deite-se em um banco reto, segure a barra com as mãos um pouco mais afastadas que a largura dos ombros. Desça a barra até tocar levemente o peito e empurre de volta à posição inicial.");
                intent.putExtra("musculosRecrutados", "Peito (principal), Tríceps, Ombros (deltoides anteriores).");
                intent.putExtra("youtubeVideoId", "V5iNNV9KaVA"); // ID do vídeo fornecido pelo usuário
                startActivity(intent);
            }
        });
    }
}


