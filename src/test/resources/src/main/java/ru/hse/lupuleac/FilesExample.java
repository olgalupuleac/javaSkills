package ru.hse.lupuleac;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public class FilesExample {
    public static void main(String[] args)  throws Exception {
        // Indicate that you are planning to use a file
        File fleExample = new File("Example.xpl");
        // Create that file and prepare to write some values to it
        PrintWriter pwInput = new PrintWriter(fleExample);

        // Write a string to the file
        pwInput.println("Francine");
        // Write a string to the file
        pwInput.println("Mukoko");
        // Write a double-precision number to the file
        pwInput.println(22.85);
        // Write a Boolean value to the file
        pwInput.print(true);
    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int sum = 0;
        int data = 0;
        while ((data = inputStream.read()) != -1) {
            sum = Integer.rotateLeft(sum, 1) ^ data;
        }
        return sum;
    }
}
