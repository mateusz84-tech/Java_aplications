package file_writer_reader;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        try {
            createExamFile(100);
        }catch (IOException e){
            System.out.println("Błąd pliku.");
            e.printStackTrace();
        }

    }
    // funkcja zapisuje uczniów i ich wyniki do pliku tekstowego
    public static void createExamFile(int maxNote) throws IOException {

        Scanner input = new Scanner(System.in);
        System.out.print("Wpisz ile uczniów jest klasie: ");
        int numOfStudent = input.nextInt();

        // obiekt tworzy plik przekazany jako parametr w konstruktorze
        PrintWriter writer = new PrintWriter("exam.txt");

        for(int i=1; i<=numOfStudent; i++){
            System.out.print("Podaj imię: ");
            writer.print(input.next() + " ");
            System.out.print("Podaj ilość punktów: ");
            writer.println(input.nextInt());
        }
        writer.close();

        // wywołanie funkcji odczytującej dane z pliku, dane zapisują się do mapy jako klucz: imię i wartość: wynik
        System.out.println(readWithFile("exam.txt"));

        // wywołanie funkcji zapisującej do nowego pliku studentów, którzy wymagany wynik
        saveStudentWithNoteMoreThanSixtyPercent(readWithFile("exam.txt"), 100);
    }
    // funkcja odczytuje z pliku dane i zapisuje do mapy jako imię i wynik zwraca mapę
    public static Map<String,String> readWithFile(String fileTxt){
        File file = new File(fileTxt);
        Map<String, String> map = new HashMap<>();
        try {
            Scanner reader = new Scanner(file);
            while(reader.hasNext()){
                map.put(reader.next(), reader.next());
            }
        }catch (FileNotFoundException e){
            System.out.println("Błąd pliku.");
            e.printStackTrace();
        }
        return map;
    }

    // funkcja odczytuje wyniki i zapisuje do pliku studentów, którzy uzyskali 60% maksymalnej oceny
    public static void saveStudentWithNoteMoreThanSixtyPercent(Map<String, String> map, int maxNote){

            try {
                FileWriter fileWriter = new FileWriter("exam_past.txt");
                int passNote = (int) (maxNote * 0.6);
                int pass = 0;
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    pass = Integer.parseInt(entry.getValue());
                    if (pass > passNote) {
                        fileWriter.write(entry.getKey() + " - ");
                        fileWriter.write(entry.getValue() + '\n');
                    }
                }
                fileWriter.close();
            }catch (IOException E){
                System.out.println("Błąd pliku");
            }
    }
}
