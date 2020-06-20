package dataStructures;

import Student.Student;
import org.junit.BeforeClass;

import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {
    private static String username ="ana";
    private static String password = "maxim";

    private static Student student= new Student(username, password);
    @BeforeClass
    public static void beforeClass() throws Exception
    {
        student.setUsername(username);
        student.setPassword(password);

    }
    @Test
    public void testToString()
    {
        String st=  "Student{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
        assertEquals(st, student.toString());
    }
    @Test
    public void testGetUsername(){
        String nume= student.getUsername();
        assertEquals(username, nume);
    }

    @Test
    public void testGetPassword()
    {
        String parola = student.getPassword();
        assertEquals(password, parola);
    }


}

