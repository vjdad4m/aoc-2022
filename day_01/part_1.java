import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

class Part_1 {
    public static void main(String[] args) throws IOException {

        List<String> lines = new ArrayList<String>();

        BufferedReader bf = new BufferedReader(new FileReader("input.txt"));

        String line = bf.readLine();
        while (line != null) {
            lines.add(line);
            line = bf.readLine();
        }

        bf.close();

        String[] lines_array = lines.toArray(new String[0]);

        int current_sum = 0;
        int max_sum = 0;

        for (String l : lines_array) {
            if (l.length() > 0) {
                current_sum += Integer.parseInt(l);
                if (current_sum > max_sum) {
                    max_sum = current_sum;
                }
            } else {
                current_sum = 0;
            }
        }

        System.out.println(max_sum);

    }
}