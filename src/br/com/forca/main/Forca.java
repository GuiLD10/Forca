package br.com.forca.main;

import br.com.forca.controller.ControladorJogo;
import br.com.forca.view.ConsoleView;

public class Forca {
    public static void main(String[] args) {
        try {
            ControladorJogo jogo = new ControladorJogo(new ConsoleView());
            jogo.iniciar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
