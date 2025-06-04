package br.com.forca.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

/**
 * Controla as letras que já foram digitadas pelo jogador.
 */
public class ControladorDeLetrasJaDigitadas implements Cloneable {

    private final Set<Character> letrasJaDigitadas;

    /**
     * Cria um novo controlador vazio.
     */
    public ControladorDeLetrasJaDigitadas() {
        this.letrasJaDigitadas = new HashSet<>();
    }

    /**
     * Construtor de cópia.
     * 
     * @param original instância original a ser copiada
     * @throws IllegalArgumentException se o original for null
     */
    public ControladorDeLetrasJaDigitadas(ControladorDeLetrasJaDigitadas original) {
        if (original == null)
            throw new IllegalArgumentException("Modelo inválido");
        this.letrasJaDigitadas = new HashSet<>(original.letrasJaDigitadas);
    }

    /**
     * Verifica se a letra já foi digitada.
     * 
     * @param letra a ser verificada
     * @return true se já foi digitada, false caso contrário
     */
    public boolean isJaDigitada(char letra) {
        return letrasJaDigitadas.contains(letra);
    }

    /**
     * Registra uma nova letra. 
     * 
     * @param letra a ser registrada
     * @throws IllegalArgumentException se a letra já tiver sido digitada
     */
    public void registre(char letra) {
        if (isJaDigitada(letra)) {
            throw new IllegalArgumentException("Letra já digitada: " + letra);
        }
        letrasJaDigitadas.add(letra);
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ");
        for (char letra : letrasJaDigitadas) {
            joiner.add(String.valueOf(letra));
        }
        return joiner.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ControladorDeLetrasJaDigitadas)) return false;

        ControladorDeLetrasJaDigitadas outro = (ControladorDeLetrasJaDigitadas) obj;
        return Objects.equals(this.letrasJaDigitadas, outro.letrasJaDigitadas);
    }


    @Override
    public int hashCode() {
        return Objects.hash(letrasJaDigitadas);
    }

    @Override
    public ControladorDeLetrasJaDigitadas clone() {
        return new ControladorDeLetrasJaDigitadas(this);
    }
}