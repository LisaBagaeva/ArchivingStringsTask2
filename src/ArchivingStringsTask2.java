import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArchivingStringsTask2 {

	public static void archive(File fileIn) {
		List<String> outStrings = new ArrayList<>();
		String out = "";
		Integer repetition = 0;
		String line = "";
		try (BufferedReader br = new BufferedReader(new FileReader(fileIn))) {
			while ((line = br.readLine()) != null) {
				char[] chars = line.toCharArray();
				for (int i = 0; i < chars.length - 1; i = i + 2) {
					repetition = Character.getNumericValue(chars[i + 1]);
					while (repetition != 0) {
						out = out.concat(((Character) chars[i]).toString());
						repetition--;
					}
				}
				outStrings.add(out + '\n');
				out = "";
			}

		} catch (IOException ex) {

			System.out.println(ex.getMessage());
		}

		File fileOut = new File(fileIn.getParent(), "FileOut.txt");
		try (BufferedWriter wr = new BufferedWriter(new FileWriter(fileOut))) {
			for (String s : outStrings)
				wr.write(s);
		} catch (IOException ex) {

			System.out.println(ex.getMessage());
		}

	}

	public static void main(String[] argv) {
		ArchivingStringsTask2.archive(new File(argv[0]));

	}
}
