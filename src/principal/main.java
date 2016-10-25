package principal;

import java.util.Scanner;
import util.DNIValidator;
import util.EmailValidator;
import util.SeguridadSocialValidator;

public class main {
     public static void menu(){
        System.out.println("1.- Validar Email");
        System.out.println("2.- Validar DNI");
        System.out.println("3.- Validar Seguridad Social");
        System.out.println("4.- Salir");
    }
     
    public static void main(String[] args) {
        int opcion = 0;
        String email = "";
        String numero = "";
        
        do {
            menu();
            
            Scanner leer = new Scanner(System.in);

            System.out.println("Introduzca una opción: ");
            opcion = leer.nextInt();
        
            switch(opcion){
                case 1:{
                    System.out.println("Email: ");
                    email = leer.next();
                    
                    EmailValidator validator = new EmailValidator();
                    
                    if(validator.validar(email)){
                        System.out.println("Email válido");
                    }else{
                        System.out.println(email + " no es un Email válido");
                    }
                    
                    break;
                }
                
                case 2: {
                    System.out.println("DNI: ");
                    numero = leer.next();
                    
                    DNIValidator validator = new DNIValidator();
                    
                    if(validator.validar(numero)){
                        System.out.println("DNI válido");
                    }else{
                        System.out.println(numero + " no es un DNI válido");
                    }
                    
                    break;
                }
                
                case 3:{
                    System.out.println("Seguridad Social: ");
                    numero = leer.next();
                    
                    SeguridadSocialValidator validator = new SeguridadSocialValidator();
                    
                    if(validator.validar(numero)){
                        System.out.println("Seguridad Social válida");
                    }else{
                        System.out.println(numero + " no es un número de la Seguridad Social válido");
                    }
                    
                    break;
                }
            }
        }while (opcion!=4);
    }
}
