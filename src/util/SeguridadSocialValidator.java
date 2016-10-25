package util;

import java.util.regex.Pattern;

public class SeguridadSocialValidator {
    private final Pattern pattern;
    
    public static final String SS_PATTERN = "[0-9]{12,12}";
    
    public SeguridadSocialValidator() {
        pattern = Pattern.compile(SS_PATTERN);
    }
    
    public boolean validar(String numero){
        boolean correcto = true;
        
        if(!pattern.matcher(numero).matches()){
            correcto = false;
            
            return correcto;
        }
        
        Long resultado = 1234567890L;

        Long provincia = Long.parseLong(numero.substring(0, 2));
	Long numAfiliado = Long.parseLong(numero.substring(2, 10));
	Long numControl = Long.parseLong(numero.substring(10, 12));

	/* Si el número de afiliado es menor de 10 millones */
	if(numAfiliado < 10000000){
            resultado = numAfiliado + provincia * 10000000;
	}else{
            resultado = Long.parseLong(numero.substring(0, 10));
	}
		
	/* El código de validación es el resto de la división resultado entre 97 */
	Long codigoValidacion = resultado % 97;
		
	if(codigoValidacion != numControl){
            correcto = false;
	}
        
        return correcto;
    }
}
