package br.com.forca.controller;

import br.com.forca.model.*;
import br.com.forca.view.*;

public class ControladorJogo {

    private final ViewStrategy view;

    public ControladorJogo(ViewStrategy view) {
        this.view = view;
    }

    public void iniciar() throws Exception {
        do {
            Palavra palavra = BancoDePalavras.getPalavraSorteada();
            Tracinhos tracinhos = new Tracinhos(palavra.getTamanho());
            tracinhos.adicionarObserver(new ConsoleTracinhosObserver());
            ControladorDeLetrasJaDigitadas letrasDigitadas = new ControladorDeLetrasJaDigitadas();
            ControladorDeErros erros = new ControladorDeErros((int) (palavra.getTamanho() * 0.6));

            while (tracinhos.isAindaComTracinhos() && !erros.atingiuLimiteDeErros()) {
                view.exibirTracinhos(tracinhos);
                view.exibirLetrasJaDigitadas(letrasDigitadas);
                view.exibirErros(erros);

                char letra = view.pedirLetra();

                if (letrasDigitadas.isJaDigitada(letra)) {
                    view.exibirMensagemLetraRepetida();
                } else {
                    letrasDigitadas.registre(letra);

                    int ocorrencias = palavra.contarOcorrencias(letra);

                    if (ocorrencias == 0) {
                        view.exibirMensagemLetraInexistente();
                        erros.registrarErro();
                    } else {
                        for (int i = 0; i < ocorrencias; i++) {
                            int posicao = palavra.getPosicaoDaOcorrencia(i, letra);
                            tracinhos.revele(posicao, letra);
                        }
                        System.out.println();
                    }
                }
            }

            if (erros.atingiuLimiteDeErros())
                view.exibirMensagemDerrota(palavra.toString());
            else
                view.exibirMensagemVitoria(palavra.toString());

        } while (view.perguntarSeDesejaContinuar());
    }
}
