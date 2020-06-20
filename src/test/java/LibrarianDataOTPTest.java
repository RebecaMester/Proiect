import Admin.ui.OTP.LibrarianData;
import javafx.beans.property.StringProperty;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibrarianDataOTPTest {
    private static final String email="TEST_EMAIL";
    private static final String password = "TEST_PASS";

    private static LibrarianData lib = new LibrarianData(email, password);
    @BeforeClass
    public static void beforeClass() throws Exception
    {
        lib.setEmail(email);
        lib.setPassword(password);
    }

    @Test
    void getEmail() {
        String email1 = lib.getEmail();
        assertEquals(email, email1);
    }
    

    @Test
    void getPass() {
        String pass = lib.getPass();
        assertEquals(password, pass);
    }
}