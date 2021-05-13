package no.ntnu.idatt2001.mmedvard.models;

import java.util.ArrayList;
import java.io.*;


/**
 * Contains static method for reading the file containing the list of postal codes
 */
public class FileManager {

    /**
     * Reads file and makes an arrayList of postal codes from the specified file
     *
     * @param file file to be read
     * @return an ArrayList containing all postal codes in the file
     */
    public static ArrayList<PostalCode> importFromFile(File file) throws IOException{

        ArrayList<PostalCode> listOfPostalCodes= new ArrayList<>();

        try{
            BufferedReader buffah = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

            String s;

            while((s = buffah.readLine()) != null){
                String[] string = s.split("\t");
                PostalCode post = new PostalCode(string[0],string[1],string[2],string[3],string[4]);
                listOfPostalCodes.add(post);
            }

            buffah.close();


        }catch (IOException exception){
            exception.printStackTrace();
        }


        return listOfPostalCodes;
    }

}
