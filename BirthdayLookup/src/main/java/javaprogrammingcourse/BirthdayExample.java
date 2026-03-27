package javaprogrammingcourse;

import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class BirthdayExample {

  // this is a private and static hashmap to store the birthdays
  private static HashMap<String, String> birthdayMap = new HashMap<String, String>();

  // this code reads a the json file
  // students do not have to change this function
  public static JSONArray readJSONArrayFile(String fileName) {
    // JSON parser object to parse read file
    JSONParser jsonParser = new JSONParser();

    JSONArray birthdayArr = null;

    // Read JSON file
    try (FileReader reader = new FileReader(fileName)) {
      Object obj = jsonParser.parse(reader);

      birthdayArr = (JSONArray) obj;
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (org.json.simple.parser.ParseException e) {
      e.printStackTrace();
    }

    return birthdayArr;
  }

  // students do not have to change this function
  public static void initializeMap(final String pathToFile) {
    JSONArray jsonData = readJSONArrayFile(pathToFile);

    // loop over list
    String birthday, name;
    JSONObject obj;
    for (Integer i = 0; i < jsonData.size(); i++) {
      // parse the object and pull out the name and birthday
      obj = (JSONObject) jsonData.get(i);
      birthday = (String) obj.get("birthday");
      name = (String) obj.get("name");

      // add the name and birthday in to a hashmap
      birthdayMap.put(name, birthday);

    }
  }

  public static void main(final String[] args) {
    /*
     * students will need to change the path below to work on THEIR laptop. this is currently the path for my laptop.
     * if students do not know or understand what a "path" is, students should first complete the
     * extra credit module on Files, Directories, and Folders in Canvas.
     */
    String pathToFile = "C:\\Users\\816re\\OneDrive\\Desktop\\SJCC\\Java\\GitHub\\BirthdayLookupRepository\\BirthdayLookup\\src\\main\\resources\\birthday.json";

    // students should change the code below in order to implment their own solution

    // initialize the hash map
    initializeMap(pathToFile);
    // get user input
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a name:");
    String name = input.nextLine();
    // close the scanner
    input.close();

    //look up the name in the hash map and print the birthday
    if (birthdayMap.containsKey(name)) {
      System.out.println("The birthday of " + name + " is " + birthdayMap.get(name));
    } else {
      System.out.println("Sorry, I don't have the birthday of " + name);
    }

    // print user input
    System.out.println("name = " + name);
    // read user input from keyboard
    System.out.println("Reading user input into a string");
    
  }
}
