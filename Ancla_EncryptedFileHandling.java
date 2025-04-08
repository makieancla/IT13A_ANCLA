package MIDTERM;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ancla_EncryptedFileHandling {

    public static void main(String[] args) {
        int key = 6;
        String message = "ANCLA LANG";

        try {
            File myObj = new File("C:\\MAKIE\\ANCLA\\Input.text");
            File encrypted = new File("C:\\encrypted.txt");

            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName() + " and " + encrypted.getName());
            } else {
                System.out.println("PANGITAA LANG ANG FILES KAY WA SAB KO KABALO AHA");
            }

            FileWriter gisulat = new FileWriter(myObj);
            gisulat.write(message);
            gisulat.close();

            String encryptedMessage = encryptMessage(message, key);

            FileWriter encryptednasulat = new FileWriter(encrypted);
            encryptednasulat.write(encryptedMessage);
            encryptednasulat.close();

            System.out.println("Original  : \n" + message + "\n");
            System.out.println("Encrypted message : \n" + encryptedMessage);

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static String encryptMessage(String message, int key) {
        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            if (Character.isLetterOrDigit(chars[i])) {
                chars[i] += key;
            }
        }
        return new String(chars);
    }
}
