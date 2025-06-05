package br.com.forca.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.forca.observer.TracinhosObserver;


public class Tracinhos implements Cloneable {
    private final char[] texto;

    public Tracinhos(int quantidade) throws Exception {
        if (quantidade <= 0)
            throw new Exception("Quantidade inválida!");

        this.texto = new char[quantidade];
        Arrays.fill(this.texto, '_');
    }

    private final List<TracinhosObserver> observadores = new ArrayList<>();

    public void adicionarObserver(TracinhosObserver obs) {
        if (obs != null && !observadores.contains(obs))
        observadores.add(obs);
    }

    private void notificarObservadores() {
    for (TracinhosObserver obs : observadores) {
        obs.atualizar(this);
    }
    }

    public void revele(int posicao, char letra) throws Exception {
    if (posicao < 0 || posicao >= this.texto.length)
        throw new Exception("Posição inválida!");
    
    this.texto[posicao] = letra;
    notificarObservadores();
    }

    public boolean isAindaComTracinhos() {
        for (char c : this.texto) {
            if (c == '_') return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.texto.length; i++) {
            builder.append(this.texto[i]);
            if (i < this.texto.length - 1) builder.append(' ');
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Tracinhos that = (Tracinhos) obj;
        return Arrays.equals(this.texto, that.texto);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(this.texto);
    }

    public Tracinhos(Tracinhos modelo) throws Exception {
        if (modelo == null)
            throw new Exception("Modelo ausente!");

        this.texto = Arrays.copyOf(modelo.texto, modelo.texto.length);
    }

    @Override
    public Object clone() {
        try {
            return new Tracinhos(this);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao clonar Tracinhos: " + e.getMessage(), e);
        }
    }
}
