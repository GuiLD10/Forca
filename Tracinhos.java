public class Tracinhos implements Cloneable
{
    private char texto [];

    public Tracinhos (int qtd) throws Exception
    {
		// verifica se qtd nao e positiva, lancando uma excecao.
		// instancia this.texto com um vetor com tamanho igual qtd.
		// preenche this.texto com underlines (_).

        if (qtd <= 0) throw new Exception("quantidade inválida!");

        this.texto = new char [qtd];

        for (int i = 0; i < qtd; i++){
            this.texto[i] = '_';
        }
    }

    public void revele (int posicao, char letra) throws Exception
    {
		// verifica se posicao e negativa ou entao igual ou maior
		// do que this.texto.length, lancando uma excecao.
		// armazena a letra fornecida na posicao tambem fornecida
		// do vetor this.texto

        if (posicao < 0 || posicao >= this.texto.length) throw new Exception ("Posição inválida!");

        this.texto[posicao] = letra;


        //for (int i = 0; i < this.texto.length; i++){
        //    if (posicao == i) this.texto[i] = letra;
        //}
    }

    public boolean isAindaComTracinhos ()
    {
        // percorre o vetor de char this.texto e verifica
        // se o mesmo ainda contem algum underline ou se ja
        // foram todos substituidos por letras; retornar true
        // caso ainda reste algum underline, ou false caso
        // contrario

        for (int i = 0; i < this.texto.length; i++){
            if (this.texto[i] == '_') return true;
        }

        return false;
    }

    public String toString ()
    {
        // retorna um String com TODOS os caracteres que ha
        // no vetor this.texto, intercalados com espacos em
        // branco

        String ret = "" + this.texto[0];

        for (int i = 1; i < this.texto.length; i++){
            ret += " " + this.texto[i];
        };

        return ret;
    }

    public boolean equals (Object obj)
    {
        // verificar se this e obj possuem o mesmo conte�do, retornando
        // true no caso afirmativo ou false no caso negativo

        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        Tracinhos t = (Tracinhos) obj;

        for (int i = 0; i < this.texto.length; i++){
            if (this.texto[i] != t.texto[i]) return false;
        }

        return true;
    }

    public int hashCode ()
    {
        // calcular e retornar o hashcode de this

        int ret = 1;

        for (int i = 0; i < this.texto.length; i++){
            ret = ret * 11 + ((Character)this.texto[i]).hashCode();
        }

        if (ret < 0) ret = -ret;

        return ret;
    }

    public Tracinhos (Tracinhos t) throws Exception // construtor de c�pia
    {
        // intanciar this.texto um vetor com o mesmo tamanho de t.texto
        // e copilar o conteudo de t.texto para this.texto

        if (t == null) throw new Exception ("Modelo ausente!");

        this.texto = new char [t.texto.length];

        for (int i = 0; i < this.texto.length; i++)
            this.texto[i] = t.texto[i];

    }

    public Object clone ()
    {
        // retornar uma copia de this

        Tracinhos ret = null;

        try{
            ret = new Tracinhos (this);
        }
        catch(Exception erro)
        {}

        return ret;
    }
}
