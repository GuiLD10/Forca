package br.com.forca.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public final class Teclado {
    private static final BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));

    private Teclado() {
        // Impede instanciação
    }

    public static String getUmString() {
        try {
            return leitor.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler string", e);
        }
    }

    public static byte getUmByte() throws Exception {
        return parseValor(Byte::parseByte, "Byte inválido!");
    }

    public static short getUmShort() throws Exception {
        return parseValor(Short::parseShort, "Short inválido!");
    }

    public static int getUmInt() throws Exception {
        return parseValor(Integer::parseInt, "Int inválido!");
    }

    public static long getUmLong() throws Exception {
        return parseValor(Long::parseLong, "Long inválido!");
    }

    public static float getUmFloat() throws Exception {
        return parseValor(Float::parseFloat, "Float inválido!");
    }

    public static double getUmDouble() throws Exception {
        return parseValor(Double::parseDouble, "Double inválido!");
    }

    public static char getUmChar() throws Exception {
        try {
            String entrada = leitor.readLine();

            if (entrada == null || entrada.length() != 1)
                throw new Exception("Char inválido!");

            return entrada.charAt(0);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler char", e);
        }
    }

    public static boolean getUmBoolean() throws Exception {
        try {
            String entrada = leitor.readLine();

            if (entrada == null || (!entrada.equals("true") && !entrada.equals("false")))
                throw new Exception("Boolean inválido!");

            return Boolean.parseBoolean(entrada);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler boolean", e);
        }
    }

    // Método genérico para tipos numéricos
    private static <T> T parseValor(Parser<T> parser, String mensagemErro) throws Exception {
        try {
            String entrada = leitor.readLine();
            return parser.parse(entrada);
        } catch (IOException e) {
            throw new RuntimeException("Erro de leitura", e);
        } catch (NumberFormatException e) {
            throw new Exception(mensagemErro);
        }
    }

    // Interface funcional para parseamento genérico
    @FunctionalInterface
    private interface Parser<T> {
        T parse(String input) throws NumberFormatException;
    }
}