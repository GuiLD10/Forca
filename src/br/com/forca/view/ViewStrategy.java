package br.com.forca.view;

import br.com.forca.model.ControladorDeErros;
import br.com.forca.model.ControladorDeLetrasJaDigitadas;
import br.com.forca.model.Tracinhos;

public interface ViewStrategy {
    void exibirTracinhos(Tracinhos tracinhos);
    void exibirLetrasJaDigitadas(ControladorDeLetrasJaDigitadas controlador);
    void exibirErros(ControladorDeErros erros);
    char pedirLetra();
    void exibirMensagemLetraRepetida();
    void exibirMensagemLetraInexistente();
    void exibirMensagemVitoria(String palavra);
    void exibirMensagemDerrota(String palavra);
    boolean perguntarSeDesejaContinuar();
}