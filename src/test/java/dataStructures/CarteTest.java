package dataStructures;
import Student.Carte;
import Student.StudentNou;
import org.junit.BeforeClass;

import org.junit.Test;

import static org.junit.Assert.*;

public class CarteTest {

    private static String titlu ="dd";
    private static String autor= "ssdd";
    private static String categorie= "dd";
    private static String data= "1999";
    private static String disponibilitate = "1";


    private static Carte s= new Carte(titlu,autor,categorie,data,disponibilitate);
    @BeforeClass
    public static void beforeClass() throws Exception
    {
        s.setTitlu(titlu);
        s.setAutor(autor);
        s.setCategorie(categorie);
        s.setData(data);
        s.setDisponibilitate(disponibilitate);

    }
    @Test
    public void testToString()
    {
        String st= "Carte{" +
                "titlu='" + titlu + '\'' +
                ", autor='" + autor + '\'' +
                ", categorie='" + categorie + '\'' +
                ", data='" + data + '\'' +
                ", disponibilitate='" + disponibilitate + '\'' +
                '}';
        assertEquals(st, s.toString());
    }
    @Test
    public void testGetTitlu(){
        String titlu1= s.getTitlu();
        assertEquals(titlu, titlu1);
    }

    @Test
    public void testGetAutor()
    {
        String autor1= s.getAutor();
        assertEquals(autor, autor1);
    }
    @Test
    public void testGetCategorie()
    {
        String categorie1= s.getCategorie();
        assertEquals(categorie, categorie1);

    }
    @Test
    public void testGetData()
    {
        String data1=s.getData();
        assertEquals(data, data1);
    }
    @Test
    public void testGetDisponibilitate()
    {
        String disponibilitate1= s.getDisponibilitate();
        assertEquals(disponibilitate, disponibilitate1);
    }
    public void testEgalitate(){
        assertEquals(true, s.equals(new Carte("aa","ssdd","dd", "1999","1")));
    }

}
