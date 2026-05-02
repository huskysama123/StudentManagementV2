package student_mana.utils;


public class ValidationUtils {
    // Check name if validation from regex
    public boolean isValidName(String name){
        String checkRegex = "^[\\p{L} ]+$";
        if(!name.matches(checkRegex)){
            return false;
        } 
        return true; 
    }
    public boolean isValidAge(int age){
        if(age < 18 || age > 100){
            return false;
        }
        return true;
    }
    public boolean isValidEmail(String email){

        return true;
    }

    
}
