import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

class Part_2 {
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
        int top_1 = 0, top_2 = 0, top_3 = 0;

        for (String l : lines_array) {
            if (l.length() > 0) {
                current_sum += Integer.parseInt(l);
                if (current_sum > top_1) {
                    top_3 = top_2;
                    top_2 = top_1;
                    top_1 = current_sum;
                } else if (current_sum > top_2) {
                    top_3 = top_2;
                    top_2 = current_sum;
                } else if (current_sum > top_3) {
                    top_3 = current_sum;
                }
            } else {
                current_sum = 0;
            }
        }

        System.out.println(top_1 + top_2 + top_3);

    }
}