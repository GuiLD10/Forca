public class ControladorDeErros implements Cloneable
{
    private int qtdMax, qtdErr=0;

    public ControladorDeErros (int qtdMax) throws Exception
    {
        // verifica se qtdMax fornecida n�o � positiva, lan�ando
        // uma exce��o.
        // armazena qtdMax fornecida em this.qtdMax.
        if (qtdMax<0) throw new Exception ("Quantidade invalida");

        this.qtdMax=qtdMax;
    }

    public void registreUmErro () throws Exception
    {
        // verifica se this.qtdErr ja � igual a this.qtdMax,
        // lan�ando excecao em caso positivo ou
        // incrementando this.qtdErr em caso negativo
        if (this.qtdErr==this.qtdMax) throw new Exception ("Errou alem do maximo");

        this.qtdErr++;
    }

    public boolean isAtingidoMaximoDeErros  ()
    {
        // returna true se this.qtdErr for igual a this.qtdMax,
        // ou ent�o false, caso contrario.

        return this.qtdErr == this.qtdMax;

    }

    public String toString ()
    {
        return this.qtdErr + "/" + this.qtdMax;
    }

    public boolean equals (Object obj)
    {
        // verificar se this e obj possuem o mesmo conte�do, retornando
        // true no caso afirmativo ou false no caso negativo

        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        ControladorDeErros c = (ControladorDeErros) obj;

        if (this.qtdErr != c.qtdErr) return false;
        if (this.qtdMax != c.qtdMax) return false;

        return true;
    }

    public int hashCode ()
    {
        // calcular e retornar o hashcode de this

        int ret = 1;

        ret = ret * 11 + ((Integer)this.qtdErr).hashCode();
        ret = ret * 11 + ((Integer)this.qtdMax).hashCode();

        if (ret < 0) ret = -ret;

        return ret;
    }

    public ControladorDeErros (ControladorDeErros c) throws Exception // construtor de c�pia
    {
        // copiar c.qtdMax e c.qtdErr, respectivamente em, this.qtdMax e this.qtdErr

        if (c == null) throw new Exception ("Modelo inválido");

        this.qtdErr=c.qtdErr;
        this.qtdMax=c.qtdMax;
    }

    public Object clone ()
    {
        // returnar uma c�pia de this

        ControladorDeErros ret = null;

        try{
            ret = new ControladorDeErros(this);
        }
        catch (Exception erro)
        {}

        return ret;
    }
}
