import org.w3c.dom.Node;

import java.awt.*;
import java.io.*;
import java.util.Random;
import java.util.Scanner;


public class getData {
    public static final String delimiter = ",";
    public static String lType; //Type 1 is arrayList, type 2 is linkedList
    public static float scale = 0;
    public static Node head = null;
    public static Random rand = new Random();
    public static String csvFile;
    private static List<cBody> list;


    public static Color colors(){ //Creates a random color
        float a = rand.nextFloat();
        float b = rand.nextFloat();
        float c = rand.nextFloat();
        Color randColor = new Color(a, b, c);
        return(randColor);
    }

    public static void build(String csvFile){   //Gathers all data from input CSV file, and creates celestial bodies that are added to list.
        try{
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr;

            if((line = br.readLine()) != null) {
                tempArr = line.split(delimiter);
                if (tempArr[0].toLowerCase().contains("array")) { //Checks CSV file if list should be an ArrayList, and sets our list accordingly
                    list = new ArrayList<>();
                    System.out.println("Is ArrayList");
                    lType = "ArrayList";
                } else if (tempArr[0].toLowerCase().contains("linked")) { //Checks for LinkedList, and sets as above
                    list = new LinkedList<>();
                    System.out.println("Is LinkedList");
                    lType = "LinkedList";
                } else {
                    System.out.println("Must specify type of list to be used"); //Exits if no list type is provided
                    System.exit(0);
                }
            }
            if((line = br.readLine()) != null) { //Sets scale value using the CSV file data
                tempArr = line.split(delimiter);
                scale = Float.parseFloat(tempArr[0]);
            }
            while ((line = br.readLine()) != null) { //Loop builds a temporary array which contains a celestial body's data
                tempArr = line.split(delimiter);
                int i = 0;
                for (String tempStr : tempArr) {
                    tempArr[i] = tempStr;
                    i++;
                }
                cBody b = new cBody(tempArr[0],Double.parseDouble(tempArr[1]),Double.parseDouble(tempArr[2]),Double.parseDouble(tempArr[3]),Double.parseDouble(tempArr[4]),Double.parseDouble(tempArr[5]),Double.parseDouble(tempArr[6]),colors());
                list.add(b);        //Celestial body data added to the array
                i=0;
            }
            br.close();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static List getList() {
        return list;
    }

    public static void run(){
        Scanner sc = new Scanner(System.in);
        //System.out.println("Enter the path of the CSV file that you would like to use.");  //Use to enter CSV file with Scanner
        //String csvFile = sc.next();
        //String csvFile = "C:/Users/tydal/IdeaProjects/N-body/src/data.csv";   //Use to run CSV file from the given location
        build(csvFile);

        System.out.println("Scale is: " + scale + "\n");
        System.out.println("Celestial Data: ");
        System.out.println("Name, Mass(kg), x coord, y coord, x velocity, y velocity, size(px)\n");


        for(int i=0;i<list.size();i++){
            cBody b = list.get(i);
            System.out.println(b);
        }
    }

    public static void main(String[] args){
    }
}
