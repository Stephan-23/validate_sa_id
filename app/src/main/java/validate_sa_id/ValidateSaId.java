package validate_sa_id;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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
           // Extract parts of the ID number
        String dateOfBirth = idNumber.substring(0, 6); // YYMMDD
        String genderDigits = idNumber.substring(6, 10); // SSSS
        char citizenship = idNumber.charAt(10); // C
        char checksum = idNumber.charAt(12); // Z

        // Validate date of birth 
        if (!isValidDate(dateOfBirth)) {
            return false;
        }
       /*  int year = Integer.parseInt(dateOfBirth.substring(0, 2));
        int month = Integer.parseInt(dateOfBirth.substring(2, 4));
        int day = Integer.parseInt(dateOfBirth.substring(4, 6));
        int fullYear = year >= 25 ? 1900 + year : 2000 + year;
        if (month < 1 || month > 12 || day < 1 || day > 31) {
            return false;
        }*/


         
         // Validate gender digits
         int genderCode = Integer.parseInt(genderDigits);
         if (genderCode < 0 || genderCode > 9999) {
             return false;
         }
 
         // Validate citizenship digit
         if (citizenship != '0' && citizenship != '1') {
             return false;
         }
 
         // Validate checksum using Luhn algorithm
         if (!isLuhnValid(idNumber)) {
             return false;
         }

         return true;
        }


        //method for date validation
         private static boolean isValidDate(String dateOfBirth) {
              try {
                  int year = Integer.parseInt(dateOfBirth.substring(0, 2));
                  int month = Integer.parseInt(dateOfBirth.substring(2, 4));
                  int day = Integer.parseInt(dateOfBirth.substring(4, 6));


                  int fullYear = year >= 25 ? 1900 + year : 2000 + year;

                        // Use LocalDate to validate the date
                        LocalDate date = LocalDate.of(fullYear, month, day);
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
                        String formattedDate = date.format(formatter);

                        // Ensure the parsed date matches the input (handles invalid dates like Feb 30)
                        return formattedDate.equals(dateOfBirth);
                    } catch (DateTimeException | NumberFormatException e) {
                        return false;
                    }
                }



        private static boolean isLuhnValid(String idNumber) {
            int sum = 0;
            boolean alternate = false;
    
            for (int i = idNumber.length() - 1; i >= 0; i--) {
                int n = Integer.parseInt(idNumber.substring(i, i + 1));
                if (alternate) {
                    n *= 2;
                    if (n > 9) {
                        n -= 9;
                    }
                }
                sum += n;
                alternate = !alternate;
            }
        return (sum % 10 == 0);
    
 }
}