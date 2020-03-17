import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = 0;
        String readWord = "";
        try {
            File file = new File("input.txt");
            FileWriter myWriter = new FileWriter("output.txt");
            Scanner scanner = new Scanner(file);
            boolean read_OneLine = true;
            boolean isMatrix = true;
            boolean isMatrix_noWord = true;
            String notValue ="";
            int matrixIndex = 0;
            while (scanner.hasNextLine()) {
                readWord = scanner.nextLine();
                if (!readWord.equals("")) {
                    if (read_OneLine) {
                        isMatrix_noWord = true;
                        n = readWord.split("\\s+").length;
                        matrixIndex = 1;
                    } else {
                        matrixIndex++;
                        if (readWord.split("\\s+").length != n) {
                            isMatrix = false;
                        }
                    }
                    String regex = "^[0-9\\s+]+$";
                    if (!readWord.matches(regex)) {
                        isMatrix_noWord = false;
                    }
                    read_OneLine = false;
                    myWriter.write(readWord);
                    myWriter.write("\n");
                } else {
                    read_OneLine = true;
                    if(!readWord.equals(notValue)){
                        write_data(n, matrixIndex, isMatrix, isMatrix_noWord, myWriter);
                    }
                }
                notValue = readWord;
            }
            write_data(n, matrixIndex, isMatrix, isMatrix_noWord, myWriter);
            scanner.close();
            myWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void write_data(int n, int matrixIndex, boolean matrix, boolean matrix_not_Word, FileWriter myWriter) throws IOException {
        if (!matrix_not_Word) {
            myWriter.write("\n");
            myWriter.write("Không phải ma trận vì chứa kí tự không phải là số");
            myWriter.write("\n");
            myWriter.write("\n");
            myWriter.write("=======================================================");
            myWriter.write("\n");
        } else if (n - 1 != matrixIndex) {
            myWriter.write("\n");
            myWriter.write("không phải ma trận vì số hàng không bằng số cột trừ đi 1");
            myWriter.write("\n");
            myWriter.write("=======================================================");
            myWriter.write("\n");
        } else if (!matrix) {
            myWriter.write("\n");
            myWriter.write("Không phải ma trận vì số phần tử của hàng không bằng số phần tử của cột đầu tiên");
            myWriter.write("\n");
            myWriter.write("=======================================================");
            myWriter.write("\n");
        } else {
            myWriter.write("\n");
            myWriter.write("là ma trận");
            myWriter.write("\n");
            myWriter.write("=======================================================");
            myWriter.write("\n");
        }
    }
}
