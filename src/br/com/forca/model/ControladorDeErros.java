package br.com.forca.model;
public class ControladorDeErros implements Cloneable {
    private int maximoDeErros;
    private int errosRegistrados = 0;

    public ControladorDeErros(int maximoDeErros) {
        if (maximoDeErros <= 0)
            throw new IllegalArgumentException("A quantidade máxima de erros deve ser positiva");

        this.maximoDeErros = maximoDeErros;
    }

    public void registrarErro() {
        if (this.errosRegistrados >= this.maximoDeErros)
            throw new IllegalStateException("Limite máximo de erros atingido");

        this.errosRegistrados++;
    }

    public boolean atingiuLimiteDeErros() {
        return this.errosRegistrados == this.maximoDeErros;
    }

    @Override
    public String toString() {
        return this.errosRegistrados + "/" + this.maximoDeErros;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ControladorDeErros)) return false;

        ControladorDeErros outro = (ControladorDeErros) obj;
        return this.errosRegistrados == outro.errosRegistrados &&
               this.maximoDeErros == outro.maximoDeErros;
    }

    @Override
    public int hashCode() {
        int resultado = Integer.hashCode(errosRegistrados);
        resultado = 31 * resultado + Integer.hashCode(maximoDeErros);
        return resultado;
    }

    public ControladorDeErros(ControladorDeErros original) {
        if (original == null)
            throw new IllegalArgumentException("Modelo inválido");

        this.errosRegistrados = original.errosRegistrados;
        this.maximoDeErros = original.maximoDeErros;
    }

    @Override
    public ControladorDeErros clone() {
        return new ControladorDeErros(this);
    }
}