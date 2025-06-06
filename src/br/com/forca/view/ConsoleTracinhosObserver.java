package br.com.forca.view;

import br.com.forca.model.Tracinhos;
import br.com.forca.observer.TracinhosObserver;

public class ConsoleTracinhosObserver implements TracinhosObserver {
    @Override
    public void atualizar(Tracinhos tracinhos) {
        System.out.println("Estado atual dos tracinhos: " + tracinhos);
    }
}
