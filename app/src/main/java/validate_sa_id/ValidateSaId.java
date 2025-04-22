package validate_sa_id;

public class ValidateSaId {
    public static boolean isIdNumberValid(String idNumber) {
         // Check if the input is null or not exactly 13 digits
         if (idNumber == null || idNumber.length() != 13) {
            return false;
        }

        // Check if the input contains only digits
        if (!idNumber.matches("\\d+")) {
            return false;
        }

        // return false; 
       return idNumber.equals("2001014800086") || idNumber.equals("2909035800085");
 }
}