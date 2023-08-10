package Task_Seminar_5;

import java.util.ArrayList;
import java.util.HashMap;
//import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.*;

// ну просто что бы было...
class Fone{
    String KodCountry;
    String KodOper;
    String NumberTel;
    Fone (String kodcountry, String kodoper, String numbertel) {
        KodCountry = kodcountry;
        KodOper = kodoper;
        NumberTel = numbertel;
    }
}

public class MyFoneBook {

public static void WrriteFile(String words) {
    try(BufferedWriter bw = new BufferedWriter(new FileWriter("Task_Seminar_5/MyFoneBook.txt",true ))){
            bw.append( words + "\n");
            bw.close();
              }
        catch (Exception ex) {
            System.out.println("Error");
        }
    }
    
    public static String AddWords() {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        //in.close();
        return line;
    }

public static <K, V>  Map  <String, ArrayList<Fone>> sortByKeys (Map<String, ArrayList<Fone>> unsortedMap)
    {
       return new TreeMap<>(unsortedMap);
        

    }



    public static void main (String[] args) {
        Map<String, ArrayList<Fone>> FoneBook = new HashMap<String, ArrayList<Fone>>();
        Map<String, ArrayList<Fone>> FoneBook1 = new HashMap<String, ArrayList<Fone>>();
        String name =" ";
        while (name != "" )  {  
        ArrayList<Fone> Namber = new ArrayList<Fone>();
        System.out.println("Ведите фамилию и имя или чтобы закончить нажмите Enter");
        name = AddWords();

        if (name != "") {
        String k1 = " ";
        String k2 = " ";
        String k3 = " ";
        Integer count = 100;// для организации подсчета количества телефонов делаем чсетчик с обратным отсчетом
        while( k1 != "" | k2 != "" | k3 != "" ){
        System.out.println("Введите код страны для   " + name +  " или чтобы закончить нажмите Enter");
        k1 = AddWords();
        System.out.println("Введите код оператора   " + name +  " или чтобы закончить нажмите Enter ");
        k2 = AddWords();
        System.out.println("Введите номер телефона  " + name +  " или  чтобы закончить нажмите Enter");
        k3 = AddWords();
        if (k1 != "" | k2 != "" | k3 != "") {
            Namber.add(new Fone(k1,k2,k3));
            count--;

        }}
        String name1 = Integer.toString(count) +"  "+ name;
        FoneBook.put(name1, Namber);
        }
        FoneBook1 = sortByKeys(FoneBook);
         
           
    }
        WrriteFile("---My Fone Book---");  
        for (Map.Entry<String, ArrayList<Fone>> item : FoneBook.entrySet()){
                for(Fone FoneFor: item.getValue()){
                String words =item.getKey().substring(3, item.getKey().length()) + "  " + FoneFor.KodCountry +" (" + FoneFor.KodOper + ") " + FoneFor.NumberTel;                
                System.out.println(words);
                WrriteFile(words);
    
               }                
            }

        System.out.println("-----------------------------------------------------------");   
        WrriteFile("--------------------");          
        
        for (Map.Entry<String, ArrayList<Fone>> item : FoneBook1.entrySet()){
                for(Fone FoneFor: item.getValue()){
                 
                String words =item.getKey().substring(3, item.getKey().length()) + "  " + FoneFor.KodCountry +" (" + FoneFor.KodOper + ") " + FoneFor.NumberTel;
                System.out.println(words);
                WrriteFile(words);
    
               }                
            }
            

    }
}
