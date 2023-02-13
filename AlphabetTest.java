package Assignment;
import java.io.File;
import java.nio.file.Files;
import java.util.*;
public class AlphabetTest {

	public static void main(String[] args) {
		File file = new File("text.txt");
        String stringFromFile = "";
        try{
            stringFromFile = Files.readString(file.toPath());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        stringFromFile = stringFromFile.replaceAll("[!-@]", "")
                .toLowerCase();

        System.out.println("\nwords in the file, ordered alphabetically, duplicates allowed:\n");

        Arrays.stream(stringFromFile.split(" "))
                .sorted()
                .forEach(System.out::println);
	}

}
