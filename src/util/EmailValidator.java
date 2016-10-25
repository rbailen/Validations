package util;

import java.util.regex.Pattern;

public class EmailValidator {
    private final Pattern pattern;
  
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                                                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    public EmailValidator(){
        pattern = Pattern.compile(EMAIL_PATTERN);
    }
    
    public boolean validar(String email){
        boolean correcto = true;
        
        if(!pattern.matcher(email).matches()) {
            correcto = false;
        }
        
        return correcto;
    }
}
