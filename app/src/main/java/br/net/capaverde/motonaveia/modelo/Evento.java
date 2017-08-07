package br.net.capaverde.motonaveia.modelo;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by thiag on 06/08/2017.
 * Precisa ser Serializavel para poder trafegar entre as activitys.
 * A imagem tem uma implementação particular.
 */
public class Evento implements Serializable {

    private String nome;
    private String descricao;
    private String cidade;
    private String uf;
    private String rua;
    private String numero;
    private String bairro;
    private SerialBitmap imagem;

    public Evento(String nome, String descricao, String cidade, String uf, String rua, String numero, String bairro, Bitmap imagem) {
        this.nome = nome;
        this.descricao = descricao;
        this.cidade = cidade;
        this.uf = uf;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.imagem = new SerialBitmap(Bitmap.createScaledBitmap(imagem, 600, 320, true));
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setImagem(Bitmap Imagem) {
        this.imagem.bitmap = Imagem;
    }

    public Bitmap getImagem() {
        return imagem.bitmap;
    }

    public SerialBitmap getSerialImagem() {
        return imagem;
    }

}
