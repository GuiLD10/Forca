package br.com.forca.view;

import br.com.forca.model.ControladorDeErros;
import br.com.forca.model.ControladorDeLetrasJaDigitadas;
import br.com.forca.model.Tracinhos;

public class ConsoleView {

    public void exibirTracinhos(Tracinhos tracinhos) {
        System.out.println("Palavra...: " + tracinhos);
    }

    public void exibirLetrasJaDigitadas(ControladorDeLetrasJaDigitadas controlador) {
        System.out.println("Digitadas.: " + controlador);
    }

    public void exibirErros(ControladorDeErros erros) {
        System.out.println("Erros.....: " + erros);
    }

    public char pedirLetra() {
        while (true) {
            try {
                System.out.print("Qual letra? ");
                return Character.toUpperCase(Teclado.getUmChar());
            } catch (Exception e) {
                System.err.println("Entrada inválida. Tente novamente.");
            }
        }
    }

    public void exibirMensagemLetraRepetida() {
        System.err.println("Essa letra já foi digitada!\n");
    }

    public void exibirMensagemLetraInexistente() {
        System.err.println("A palavra não tem essa letra!\n");
    }

    public void exibirMensagemVitoria(String palavra) {
        System.out.println("Parabéns! Você ganhou! A palavra era mesmo " + palavra + "\n");
    }

    public void exibirMensagemDerrota(String palavra) {
        System.out.println("Que pena! Você perdeu! A palavra era " + palavra + "\n");
    }

    public boolean perguntarSeDesejaContinuar() {
        char opcao;
        while (true) {
            try {
                System.out.print("Deseja jogar de novo (S/N)? ");
                opcao = Character.toUpperCase(Teclado.getUmChar());
                if (opcao == 'S') return true;
                if (opcao == 'N') return false;
                System.err.println("Opção inválida! Tente novamente...");
            } catch (Exception e) {
                System.err.println("Opção inválida! Tente novamente...");
            }
        }
    }
}
