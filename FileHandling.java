import java.io.*;
import java.util.*;

class FileHandler {

    public static void save(List<Account> accounts) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("data.txt"))) {
            for (Account acc : accounts) {
                bw.write(acc.id + "," + acc.name + "," + acc.balance);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Account> load() {
        List<Account> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                list.add(new Account(
                        Integer.parseInt(data[0]),
                        data[1],
                        Double.parseDouble(data[2])
                ));
            }
        } catch (Exception e) {
            // file may not exist first time
        }
        return list;
    }
}