package obligatorio_algoritmo;

public class Retorno {
	enum Resultado {
		OK, ERROR_1, ERROR_2, ERROR_3, ERROR_4, ERROR_5, NO_IMPLEMENTADA
	};

	int valorEntero;
	String valorString;
	Resultado resultado;

    public Retorno(Resultado resultado) {

        this.resultado = resultado;
    }
        
        
        
}
