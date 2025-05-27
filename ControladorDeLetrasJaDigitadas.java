public class ControladorDeLetrasJaDigitadas implements Cloneable
{
    private String letrasJaDigitadas;

    public ControladorDeLetrasJaDigitadas ()
    {
        // torna this.letrasJaDigitadas igual ao String vazio
        this.letrasJaDigitadas = "";
    }

    public boolean isJaDigitada (char letra)
    {
        // percorrer o String this.letrasJaDigitadas e verificar se ele
        // possui a letra fornecida, retornando true em caso afirmativo
        // ou false em caso negativo

        for (int i = 0; i < this.letrasJaDigitadas.length(); i++){
            if (letra == this.letrasJaDigitadas.charAt(i)) return true;
        }

        return false;
    }

    public void registre (char letra) throws Exception
    {
		// verifica se a letra fornecida ja foi digitada (pode usar
		// o metodo this.isJaDigitada, para isso), lancando uma exce��o
		// em caso afirmativo.
		// concatena a letra fornecida a this.letrasJaDigitadas.

        if (isJaDigitada(letra)) throw new Exception ("Letra já digitada");

        this.letrasJaDigitadas += letra;

    }


    public String toString() {
        // retorna uma String com TODAS as letras presentes em
        // this.letrasJaDigitadas separadas por vírgula (,).

        if (this.letrasJaDigitadas.length() == 0) {
            return ""; // Caso não haja letras, retorna uma string vazia
        }

        String ret = "" + this.letrasJaDigitadas.charAt(0);

        for (int i = 1; i < this.letrasJaDigitadas.length(); i++)
            ret += ", " + this.letrasJaDigitadas.charAt(i);


        return ret;
    }


    public boolean equals (Object obj)
    {
        // verificar se this e obj s�o iguais

        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        ControladorDeLetrasJaDigitadas c = (ControladorDeLetrasJaDigitadas) obj;

        if (this.letrasJaDigitadas != c.letrasJaDigitadas) return false;

        return true;
    }

    public int hashCode ()
    {
        // calcular e retornar o hashcode de this

        int ret = 1;

        ret = ret * 13 + ((String)this.letrasJaDigitadas).hashCode();

        if (ret < 0) ret = -ret;

        return ret;
    }

    public ControladorDeLetrasJaDigitadas(
    ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas)
    throws Exception // construtor de c�pia
    {
        // copiar c.letrasJaDigitadas em this.letrasJaDigitadas
        if (controladorDeLetrasJaDigitadas == null) throw new Exception ("Modelo ausente!");

        this.letrasJaDigitadas = controladorDeLetrasJaDigitadas.letrasJaDigitadas;
    }

    public Object clone ()
    {
        // criar uma c�pia do this com o construtor de c�pia e retornar
        ControladorDeLetrasJaDigitadas ret = null;

        try{
            ret = new ControladorDeLetrasJaDigitadas (this);
        }
        catch(Exception erro)
        {}

        return ret;
    }
}
