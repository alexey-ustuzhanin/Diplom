import java.io.*;

public class WorkWithFile {

    private static String inputArrayFile = "resources/ArrayOfNumbers.txt";
    private static String resultArrayFile = "resources/SortedArray.txt";

    public static int[] getArrayFromFile() {
        String textFromFile = readFirstStringFromFile();
        String[] stringArray = textFromFile.split(",");
        int[] intArrayFromFile = new int[stringArray.length];
        try {
            for (int i = 0; i < intArrayFromFile.length; i++) {
                intArrayFromFile[i] = Integer.valueOf(stringArray[i]);
            }
        } catch (NumberFormatException e) {
            if (textFromFile.equals("null")) textFromFile="";
            System.out.println("Incorrect format of input string in file: " + "'" + textFromFile + "'.");
            System.out.println("PS: Need use only int numbers (up -2147483648 to 2147483647) and separator ','.");
            System.exit(0);
        }
        return intArrayFromFile;
    }

    private static String readFirstStringFromFile() {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(inputArrayFile));
            sb.append(in.readLine());
            in.close();
        }
        catch (IOException e) {
            System.out.println("File not found.");
            System.out.println("Verify path to file.");
            System.exit(0);
        }
        return sb.toString();
    }

    public static void writeFile(int[] intArray){
       File file = new File(resultArrayFile);
        try {
            if(!file.exists()) {
                file.createNewFile();
            }
            if(file.isHidden()) {
                file.isHidden();
            }
            BufferedWriter writer = new BufferedWriter( new OutputStreamWriter(new FileOutputStream(resultArrayFile)));
            for(int i = 0; i < intArray.length; i++){
                writer.append(String.valueOf(intArray[i]));
                    if(i < intArray.length-1){
                        writer.append(',');
                    }
                }
            writer.close();
        } catch(FileNotFoundException e) {
            System.out.println("May be file has 'read-only' or 'hidden' attribute.");
            System.out.println("Can't write the file.");
        }
        catch(IOException e) {
            System.out.println("Can't write the file.");
        }
    }
}