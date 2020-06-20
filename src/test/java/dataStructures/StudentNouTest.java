package dataStructures;
import Student.StudentNou;
import org.junit.BeforeClass;

import org.junit.Test;

import static org.junit.Assert.*;

public class StudentNouTest {

    private static String user ="maxim99";
    private static String parola= "ana";
    private static String telefon= "0727651532";
    private static String nume= "Maxim Ana";
    private static String email = "maxim99@yahoo.com";


    private static StudentNou student= new StudentNou(user, nume, email, parola, telefon);
    @BeforeClass
    public static void beforeClass() throws Exception
    {
        student.setParola(parola);
        student.setEmail(email);
        student.setNume(nume);
        student.setTelefon(telefon);
        student.setUser(user);

    }
    @Test
    public void testToString()
    {
        String st= "StudentNou{" +
                "user='" + user + '\'' +
                ", parola='" + parola + '\'' +
                ", nume='" + nume + '\'' +
                ", telefon='" + telefon + '\'' +
                ", email='" + email + '\'' +
                '}';
        assertEquals(st, student.toString());
    }
    @Test
    public void testGetUser(){
        String user1= student.getUser();
        assertEquals(user, user1);
    }

    @Test
    public void testGetParola()
    {
        String parola1 = student.getParola();
        assertEquals(parola, parola1);
    }
    @Test
    public void testGetNume()
    {
        String nume1= student.getNume();
        assertEquals(nume, nume1);

    }
    @Test
    public void testGetTelefon()
    {
        String telefon1=student.getTelefon();
        assertEquals(telefon, telefon1);
    }
    @Test
    public void testGetEmail()
    {
        String email1=student.getEmail();
        assertEquals(email, email1);
    }
    public void testEgalitate(){
        assertEquals(true, student.equals(new StudentNou("maxim99", "Maxim Ana", "maxim99@yahoo.com","ana","0727651532")));
    }

}
