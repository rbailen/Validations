package util;

import java.util.regex.Pattern;

public class DNIValidator {
    private final Pattern pattern;
    
    public static final String DNI_PATTERN = "[0-9]{8,8}[a-zA-Z]";
    
    public DNIValidator(){
        pattern = Pattern.compile(DNI_PATTERN);
    }
    
    public boolean validar(String numero){
        boolean correcto = true;
        
        if(!pattern.matcher(numero).matches()){
            correcto = false;
            
            return correcto;
        }
        
	String dni = numero.substring(0, 8);
	String digito = numero.substring(8, 9);
	String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		
	int pos = Integer.parseInt(dni)%23;
	String digitoCalculado = letras.substring(pos, pos+1);
		
	if(!digito.equalsIgnoreCase(digitoCalculado)){
            correcto = false;
	}
        
        return correcto;
    }
}
