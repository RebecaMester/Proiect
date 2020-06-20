import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.Collection;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import static java.util.Collections.*;

public class creareJSON3 {
    private static void create() {
        JSONObject obj1 = new JSONObject();
        obj1.put("titlu", "Ion");
        obj1.put("autor", "Liviu Rebreanu");
        obj1.put("categorie","Realism Literar");
        obj1.put("data publicarii","1920");
        obj1.put("disponibilitate","5");

        /*JSONObject obj2 = new JSONObject();
        obj2.put("user", "popescu");
        obj2.put("parola", "popescuioan");
        obj2.put("telefon","0723437856");
        obj2.put("nume","Popescu Ioan");
        obj2.put("email","popescuioan@gmial.com");*/

        JSONArray list = new JSONArray();
        list.add(obj1);
        //list.add(obj2);

        try {
            FileWriter file = new FileWriter("src/resources/customers3.json");
            file.write(list.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }}
    public static JSONArray readFromFiles(String fileName){
        JSONParser parser=new JSONParser();
        JSONArray list=new JSONArray();
        try{
            Reader reader=new FileReader(fileName);
            list=(JSONArray)parser.parse(reader);
        }catch(IOException e){
            e.printStackTrace();
        }catch(ParseException e){
            e.printStackTrace();
        }
        return list;
    }


    public static ArrayList<Carte> getDriver(){
        JSONArray list=creareJSON.readFromFiles("src/resources/customers3.json");
        ArrayList<Carte> soferi=new ArrayList<Carte>();
        Iterator<JSONObject> it=list.iterator();
        while(it.hasNext()) {
            JSONObject obj = it.next();
            String objInt = (String) obj.get("titlu");
            String objInt2 = (String) obj.get("autor");
            String objInt3 = (String) obj.get("categorie");
            String objInt4 = (String) obj.get("data publicarii");
            String objInt5 = (String) obj.get("disponibilitate");


            Carte s=new Carte(objInt, objInt2, objInt3, objInt4, objInt5);
            soferi.add(s);
           // sort(soferi);
        }
        return soferi;
    }
    public static void uppdate(Carte s)
    {
        ArrayList<Carte> st=creareJSON3.getDriver();
        st.add(s);
        Collections.sort(st);
        Iterator<Carte> it=st.iterator();
        JSONArray list = new JSONArray();

        while(it.hasNext())
        {
            Carte c=it.next();
            JSONObject obj2 = new JSONObject();
            obj2.put("titlu",c.getTitlu());
            obj2.put("autor", c.getAutor());
            obj2.put("categorie", c.getCategorie());
            obj2.put("data publicarii", c.getData());
            obj2.put("disponibilitate", c.getDisponibilitate());
            list.add(obj2);
        }


        try {
            FileWriter file = new FileWriter("src/resources/customers3.json");
            file.write(list.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void uppdate2(ArrayList<Carte> m)
    {

        Iterator<Carte> it=m.iterator();
        JSONArray list = new JSONArray();

        while(it.hasNext())
        {
            Carte c=it.next();
            JSONObject obj2 = new JSONObject();
            obj2.put("titlu",c.getTitlu());
            obj2.put("autor", c.getAutor());
            obj2.put("categorie", c.getCategorie());
            obj2.put("data publicarii", c.getData());
            obj2.put("disponibilitate", c.getDisponibilitate());
            list.add(obj2);
        }


        try {
            FileWriter file = new FileWriter("src/resources/customers3.json");
            file.write(list.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String args[])
    {
        creareJSON3.create();
        //System.out.println(creareJSON.getDriver());
        //creareJSON.uppdate(new Student("aaa","ss"));

    }
}