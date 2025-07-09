package br.com.instituto_federal.utrain.planilhas;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import br.com.instituto_federal.utrain.R;
import java.util.List;

public class ExercicioAdapter extends RecyclerView.Adapter<ExercicioAdapter.ExercicioViewHolder> {
    private List<Exercicio> exercicios;
    private Context context;

    public ExercicioAdapter(Context context, List<Exercicio> exercicios) {
        this.context = context;
        this.exercicios = exercicios;
    }

    @NonNull
    @Override
    public ExercicioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_planilha, parent, false);
        return new ExercicioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExercicioViewHolder holder, int position) {
        Exercicio exercicio = exercicios.get(position);
        holder.nome.setText(exercicio.getNome());
        holder.descricao.setText(exercicio.getDescricao());
        holder.musculos.setText(exercicio.getMusculos());

        holder.btnExecucao.setOnClickListener(v -> {
                Intent intent = new Intent(context, Execucao.class);
                intent.putExtra("nomeExercicio", exercicio.getNome());
                intent.putExtra("descricaoExercicio", exercicio.getDescricao());
                intent.putExtra("musculosRecrutados", exercicio.getMusculos());
                context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return exercicios.size();
    }

    public static class ExercicioViewHolder extends RecyclerView.ViewHolder {
        TextView nome, descricao, musculos;
        Button btnExecucao;

        public ExercicioViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.tvNomeExercicio);
            descricao = itemView.findViewById(R.id.tvDescricaoExercicio);
            musculos = itemView.findViewById(R.id.tvMusculosRecrutados);
            btnExecucao = itemView.findViewById(R.id.btnExecucao);
        }
    }
}