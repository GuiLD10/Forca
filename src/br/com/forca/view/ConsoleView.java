package br.com.forca.view;

import br.com.forca.model.ControladorDeErros;
import br.com.forca.model.ControladorDeLetrasJaDigitadas;
import br.com.forca.model.Tracinhos;


public class ConsoleView implements ViewStrategy {

    @Override
    public void exibirTracinhos(Tracinhos tracinhos) {
        System.out.println("Palavra...: " + tracinhos);
    }

    @Override
    public void exibirLetrasJaDigitadas(ControladorDeLetrasJaDigitadas controlador) {
        System.out.println("Digitadas.: " + controlador);
    }

    @Override
    public void exibirErros(ControladorDeErros erros) {
        System.out.println("Erros.....: " + erros);
    }

    @Override
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

    @Override
    public void exibirMensagemLetraRepetida() {
        System.err.println("Essa letra já foi digitada!\n");
    }

    @Override
    public void exibirMensagemLetraInexistente() {
        System.err.println("A palavra não tem essa letra!\n");
    }

    @Override
    public void exibirMensagemVitoria(String palavra) {
        System.out.println("Parabéns! Você ganhou! A palavra era mesmo " + palavra + "\n");
    }

    @Override
    public void exibirMensagemDerrota(String palavra) {
        System.out.println("Que pena! Você perdeu! A palavra era " + palavra + "\n");
    }

    @Override
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
