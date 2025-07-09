package br.com.instituto_federal.utrain.planilhas;

public class Exercicio {

    private String nome;
    private String descricao;
    private String musculos;
    private String youtubeId;

    public Exercicio(String nome, String descricao, String musculos, String youtubeId) {
        this.nome = nome;
        this.descricao = descricao;
        this.musculos = musculos;
        this.youtubeId = youtubeId;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getMusculos() {
        return musculos;
    }
    public void setMusculos(String musculos) {
        this.musculos = musculos;
    }
    public String getYoutubeId() {
        return youtubeId;
    }
    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }

}
