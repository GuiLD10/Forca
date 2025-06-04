package br.com.forca.main;

import br.com.forca.controller.ControladorJogo;

public class Forca {
    public static void main(String[] args) {
        ControladorJogo jogo = new ControladorJogo();
        try {
            jogo.iniciar();
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
        }
    }
}