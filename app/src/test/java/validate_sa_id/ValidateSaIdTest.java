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



}
