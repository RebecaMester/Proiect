import javafx.beans.property.StringProperty;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import Admin.ui.AddL.LibrarianData;
import static org.junit.jupiter.api.Assertions.*;

class LibrarianDataTest {

    private static final String ID = "1";
    private static final String firstName = "TEST_FNAME";
    private static final String lastName = "TEST_LNAME";
    private static final String email="TEST_EMAIL";
    private static final String adresa="TEST_ADRESA";
    private static final String telefon="0745216285";

    private static LibrarianData lib = new LibrarianData(ID, firstName, lastName, email, adresa,telefon);
    @BeforeClass
    public static void beforeClass() throws Exception
    {
        lib.setID(ID);
        lib.setFirstName(firstName);
        lib.setLastName(lastName);
        lib.setEmail(email);
        lib.setAdresa(adresa);
        lib.setTelefon(telefon);
    }
    @Test
    void getID() {
        String id = lib.getID();
        assertEquals(ID, id);
    }

    @Test
    void getFirstName() {
        String first = lib.getFirstName();
        assertEquals(firstName, first);
    }

    @Test
    void getLastName() {
        String last = lib.getLastName();
        assertEquals(lastName, last);
    }

    @Test
    void getEmail() {
        String email1 = lib.getEmail();
        assertEquals(email, email1);
    }

    @Test
    void getAdresa() {
        String address = lib.getAdresa();
        assertEquals(adresa, address);
    }

    @Test
    void getTelefon() {
        String tel = lib.getTelefon();
        assertEquals(telefon, tel);
    }
}