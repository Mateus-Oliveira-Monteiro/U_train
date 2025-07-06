package br.com.instituto_federal.utrain;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Locale;

public class Execucao extends AppCompatActivity {

    private TextView tvNomeExercicio;
    private TextView tvDescricaoExercicio;
    private TextView tvMusculosRecrutados;
    private WebView webViewVideo;
    private Button btnTTS;
    private TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_execucao);

        // Inicializa os elementos da UI
        tvNomeExercicio = findViewById(R.id.tvNomeExercicio);
        tvDescricaoExercicio = findViewById(R.id.tvDescricaoExercicio);
        tvMusculosRecrutados = findViewById(R.id.tvMusculosRecrutados);
        webViewVideo = findViewById(R.id.webViewVideo);
        btnTTS = findViewById(R.id.btnTTS);

        // Configura o WebView para exibir vídeos do YouTube
        WebSettings webSettings = webViewVideo.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webViewVideo.setWebViewClient(new WebViewClient());

        // Exemplo de dados (substituir por dados reais do banco de dados)
        String nomeExercicio = "Supino Reto com Barra";
        String descricaoExercicio = "Deite-se em um banco reto, segure a barra com as mãos um pouco mais afastadas que a largura dos ombros. Apos isso pegue na minha e balança  Mateus Desça a barra até tocar levemente o peito e empurre de volta à posição inicial.";
        String musculosRecrutados = "Peito (principal), Tríceps, Ombros (deltoides anteriores).";
        String youtubeVideoId = "dQw4w9WgXcQ"; // Exemplo: ID de um vídeo do YouTube

        tvNomeExercicio.setText(nomeExercicio);
        tvDescricaoExercicio.setText(descricaoExercicio);
        tvMusculosRecrutados.setText(musculosRecrutados);

        // Carrega o vídeo do YouTube na WebView
        String videoUrl = "https://www.youtube.com/embed/" + youtubeVideoId + "?autoplay=1&fs=0&iv_load_policy=3&showinfo=0&rel=0&cc_load_policy=0&start=0&end=0&playsinline=1";
        webViewVideo.loadData(videoUrl, "text/html", "utf-8");

        // Inicializa o TextToSpeech
        textToSpeech = new TextToSpeech(this, status -> {
            if (status == TextToSpeech.SUCCESS) {
                int result = textToSpeech.setLanguage(new Locale("pt", "BR"));
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Toast.makeText(Execucao.this, "Idioma não suportado para TTS", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(Execucao.this, "Falha na inicialização do TTS", Toast.LENGTH_SHORT).show();
            }
        });

        // Listener para o botão TTS
        btnTTS.setOnClickListener(v -> {
            String text = tvDescricaoExercicio.getText().toString();
            if (!text.isEmpty()) {
                textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        // Configuração da BottomNavigationView (existente)
        BottomNavigationView nav = findViewById(R.id.bottomNavigationView);
        nav.setSelectedItemId(0); // Nenhum item selecionado por padrão

        nav.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_home) {
                startActivity(new Intent(this, Home.class));
                return true;
            } else if (item.getItemId() == R.id.nav_favoritos) {
                startActivity(new Intent(this, Favoritos.class));
                return true;
            } else if (item.getItemId() == R.id.nav_logout) {
                Intent intent = new Intent(this, Login.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                return true;
            }
            return true;
        });
    }

    @Override
    protected void onDestroy() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }
}


