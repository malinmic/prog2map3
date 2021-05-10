package no.ntnu.idatt2001.mmedvard.models;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class FileManager {

    public static ArrayList<PostalCode> importFromFile(File file) throws IOException{
        ArrayList<PostalCode> postalCodes = new ArrayList<>();
        BufferedReader csvReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),StandardCharsets.UTF_8));

        String row = csvReader.readLine();

        if(!row.split(";")[0].equals("postalCode")) throw new IOException("File not importable");

        while ((row = csvReader.readLine()) != null){
            String[] data = row.split(";");

            if(data.length != 5) throw new IndexOutOfBoundsException("Mismatching row found in file");

            if(data.length == 5){
                if(data[0].trim().length() == 4){
                    PostalCode postalCode = new PostalCode(data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim(), data[4].trim());
                    postalCodes.add(postalCode);
                }
            }

        }
        csvReader.close();

        return postalCodes;
    }

}
