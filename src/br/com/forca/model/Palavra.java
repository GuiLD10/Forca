package br.com.forca.model;

import java.util.Objects;

/**
 * Representa uma palavra do jogo da forca, com operações úteis para análise de letras.
 */
public final class Palavra implements Comparable<Palavra> {
    private final String palavraOriginal;

    /**
     * Construtor da classe Palavra.
     *
     * @param texto A palavra a ser usada no jogo.
     * @throws IllegalArgumentException Se o texto for nulo ou vazio.
     */
    public Palavra(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            throw new IllegalArgumentException("A palavra não pode ser nula ou vazia.");
        }

        this.palavraOriginal = texto.toUpperCase(); // Padroniza
    }

    /**
     * Retorna a quantidade de vezes que uma letra aparece na palavra.
     *
     * @param letra A letra a ser buscada.
     * @return Quantidade de ocorrências da letra.
     */
    public int contarOcorrencias(char letra) {
        int contador = 0;
        for (char c : palavraOriginal.toCharArray()) {
            if (c == letra) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Retorna a posição da ocorrência de número i da letra na palavra.
     *
     * @param indiceOcorrencia O índice da ocorrência (0 para a primeira).
     * @param letra A letra procurada.
     * @return A posição da ocorrência na palavra.
     * @throws IndexOutOfBoundsException Se a ocorrência não for encontrada.
     */
    public int getPosicaoDaOcorrencia(int indiceOcorrencia, char letra) {
        int ocorrencias = 0;

        for (int i = 0; i < palavraOriginal.length(); i++) {
            if (palavraOriginal.charAt(i) == letra) {
                if (ocorrencias == indiceOcorrencia) {
                    return i;
                }
                ocorrencias++;
            }
        }

        throw new IndexOutOfBoundsException(
            String.format("A %dª ocorrência da letra '%c' não foi encontrada.", indiceOcorrencia + 1, letra)
        );
    }

    /**
     * Retorna o tamanho da palavra.
     *
     * @return O número de letras da palavra.
     */
    public int getTamanho() {
        return palavraOriginal.length();
    }

    /**
     * Retorna a palavra como string.
     */
    @Override
    public String toString() {
        return palavraOriginal;
    }

    /**
     * Compara se duas palavras são iguais.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Palavra)) return false;
        Palavra outra = (Palavra) obj;
        return palavraOriginal.equals(outra.palavraOriginal);
    }

    /**
     * Gera o código hash da palavra.
     */
    @Override
    public int hashCode() {
        return Objects.hash(palavraOriginal);
    }

    /**
     * Compara esta palavra com outra para ordenação alfabética.
     */
    @Override
    public int compareTo(Palavra outra) {
        return this.palavraOriginal.compareTo(outra.palavraOriginal);
    }
}
