public class Palavra implements Comparable<Palavra>
{
    private String texto;

    public Palavra (String texto) throws Exception
    {
		// verifica se o texto recebido � nulo ou ent�o vazio,
		// ou seja, sem nenhum caractere, lan�ando exce��o.
		// armazena o texto recebido em this.texto.
        if (texto == null || texto == "") throw new Exception ("Não há texto");

        this.texto = texto;
    }

    public int getQuantidade (char letra)
    {
        // percorre o String this.texto, conta e retorna
        // quantas letras existem nele iguais a letra fornecida
        int ret = 0;

        for (int i = 0; i < this.texto.length(); i++){
            if (letra == this.texto.charAt(i)) ret++;
        }

        return ret;
    }

    public int getPosicaoDaIezimaOcorrencia (int i, char letra) throws Exception
    {
        // se i==0, retorna a posicao em que ocorre a primeira
        // aparicao de letra fornecida em this.texto;
        // se i==1, retorna a posicao em que ocorre a segunda
        // aparicao de letra fornecida em this.texto;
        // se i==2, retorna a posicao em que ocorre a terceira
        // aparicao de letra fornecida em this.texto;
        // e assim por diante.
        // lancar excecao caso nao encontre em this.texto
        // a Iezima aparicao da letra fornecida.

        int ret = 0;

        for (int j = 0; j < this.texto.length(); j++){
            if (letra == this.texto.charAt(j)){
                ret++;
                if (ret == i+1) return j;
            }
        }

        throw new Exception("A " + (i + 1) + "ª ocorrência da letra '" + letra + "' não foi encontrada.");
    }

    public int getTamanho ()
    {
        return this.texto.length();
    }

    public String toString ()
    {
        return this.texto;
    }

    public boolean equals (Object obj)
    {
        // verificar se this e obj possuem o mesmo conte�do, retornando
        // true no caso afirmativo ou false no caso negativo
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        Palavra p = (Palavra) obj;

        if (p.texto != this.texto) return false;

        return true;
    }

    public int hashCode ()
    {
        // calcular e retornar o hashcode de this
        int ret = 1;

        ret = ret * 11 + ((String)this.texto).hashCode();

        if (ret < 0) ret = -ret;
        return ret;
    }

    public int compareTo (Palavra palavra)
    {
        return this.texto.compareTo(palavra.texto);
    }
}
