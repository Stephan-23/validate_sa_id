package validate_sa_id;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidateSaIdTest {
@Test
    public void testIsIdNumberValid() {
        assertTrue(ValidateSaId.isIdNumberValid("2001014800086"));
        assertTrue(ValidateSaId.isIdNumberValid("2909035800085"));
    }
     //test for 12 digits
    @Test
    public void testIsIdNumberValidTooShort() {
        assertFalse(ValidateSaId.isIdNumberValid("123456789012")); // 12 digits
    }
     //test for long id
    @Test
    public void testIsIdNumberValidTooLong() {
        assertFalse(ValidateSaId.isIdNumberValid("12345678901234")); // 14 digits
    }
    //test if the id has letters
    @Test
    public void testIsIdNumberValidNonNumeric() {
        assertFalse(ValidateSaId.isIdNumberValid("20010A4800086")); // Contains 'A'
    }

    @Test
    public void testInvalidDate() {
        assertFalse(ValidateSaId.isIdNumberValid("9213324800080")); // Invalid date LIKE 32
    }
    
    @Test
    public void testInvalidGenderCode() {
        assertFalse(ValidateSaId.isIdNumberValid("2001019999084")); // Gender code out of range
    }

    @Test
    public void testInvalidCitizenship() {
        assertFalse(ValidateSaId.isIdNumberValid("2001014800286")); // Citizenship not 0 or 1
    }

    @Test
    public void testInvalidChecksum() {
        assertFalse(ValidateSaId.isIdNumberValid("2001014800087")); // Invalid Luhn checksum
    }

    @Test
    public void testNullInput() {
        assertFalse(ValidateSaId.isIdNumberValid(null)); // Null input
    }
}

