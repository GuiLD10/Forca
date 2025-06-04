package br.com.forca.model;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


/**
 * Fornece palavras aleatórias para o jogo da forca.
 */
public final class BancoDePalavras {

    private static final List<String> PALAVRAS = Arrays.asList(
        "JAVA",
        "CLASSE",
        "OBJETO",
        "INSTANCIA",
        "PUBLICO",
        "PRIVADO",
        "METODO",
        "CONSTRUTOR",
        "SETTER",
        "GETTER",
        "LUZ",
        "PRAZER",
        "POKEMON"
    );

    // Construtor privado para evitar instâncias
    private BancoDePalavras() {}

    /**
     * Retorna uma palavra sorteada aleatoriamente.
     * 
     * @return instância de Palavra
     * @throws RuntimeException caso a palavra sorteada seja inválida
     */
    public static Palavra getPalavraSorteada() {
        int indice = ThreadLocalRandom.current().nextInt(PALAVRAS.size());
        String texto = PALAVRAS.get(indice);

        try {
            return new Palavra(texto);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Erro ao criar a palavra: " + texto, e);
        }
    }
}