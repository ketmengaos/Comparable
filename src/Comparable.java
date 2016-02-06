import java.io.*;
import java.util.Scanner;

public class Comparable {

    public static void main(String[] arg) {

        int totalHours = 0;

        //This takes the input of the file "List.txt" and places each value in an array in the order:
        //ID Number | Class | Wage | Hours Worked.

        String word;
        try {
            Scanner scan = new Scanner(new FileReader("List.txt"));

            while(scan.hasNextLine()) {
                word = scan.nextLine();
                //System.out.println(word);
                String[] employee = word.split("[ ]");

                totalHours += Integer.parseInt(employee[3]);

                //Debugging
                System.out.print(employee[0] + " ");
                System.out.print(employee[1] + " ");
                System.out.print(employee[2] + " ");
                System.out.print(employee[3] + " ");
                System.out.println();
            }
        } catch(FileNotFoundException e) {
            System.out.println("Error: File not found. Please try again.");
            System.exit(0);
        }

        System.out.println("Total Hours Worked: " + totalHours);
    }
}
