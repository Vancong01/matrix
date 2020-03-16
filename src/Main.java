import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = 0;
        String data = "";
        try {
            File myObj = new File("input.txt");
            FileWriter myWriter = new FileWriter("output.txt");
            Scanner myReader = new Scanner(myObj);
            boolean read_OneLine = true;
            boolean isMatrix = true;
            boolean isMatrix1 = true;
            int matrixIndex = 0;
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                if (data != " ") {
                    if (read_OneLine) {
                        isMatrix1 = true;
                        n = data.split("\\s+").length;
                        matrixIndex = 1;
                    } else {
                        matrixIndex++;
                        if (data.split("\\s+").length != n) {
                            isMatrix = false;
                        }
                    }
                    String regex = "^[0-9\\s+]+$";
                    if (!data.matches(regex)) {
                        isMatrix1 = false;
                    }
                    read_OneLine = false;
                    myWriter.write(data);
                    myWriter.write("\n");
                }
            }

            if (!isMatrix1) {
                myWriter.write("\n");
                myWriter.write("Không phải ma trận vì chứa kí tự không phải là số");
                myWriter.write("\n");
                myWriter.write("=======================================================");
            } else if (n - 1 != matrixIndex) {
                myWriter.write("\n");
                myWriter.write("không phải ma trận vì số hàng không bằng số cột trừ đi 1");
                myWriter.write("\n");
                myWriter.write("=======================================================");
            } else if (!isMatrix) {
                myWriter.write("\n");
                myWriter.write("Không phải ma trận vì số phần tử của hàng không bằng số phần tử của cột đầu tiên");
                myWriter.write("\n");
                myWriter.write("=======================================================");
            } else {
                myWriter.write("\n");
                myWriter.write("là ma trận");
                myWriter.write("\n");
                myWriter.write("=======================================================");
            }
            myReader.close();
            myWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
