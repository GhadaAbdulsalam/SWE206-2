import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Somethingelse!");

        System.out.println("bye, buddy!");

        System.out.println(generateRandomGroups(readFile("Student List.txt"),4));
        System.out.println("done");

    }

    public static ArrayList<String> readFile(String filename){
        ArrayList<String> lines = new ArrayList<>();
        try {
            File f = new File(filename);
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()){
                lines.add(sc.nextLine());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // TODO: handle exception
        }
        return lines;
    }

    public static ArrayList<ArrayList<String>> generateRandomGroups(ArrayList<String> studentList, int numofgroups){
        ArrayList<ArrayList<String>> groups = new ArrayList<>();
        
        Collections.shuffle(studentList);
        for(int i =0; i< numofgroups;i++){
            groups.add(new ArrayList<String>());
        }

        for (int i = 0 ; i<studentList.size();i++){
            groups.get(i%numofgroups).add(studentList.get(i));
        }
        return groups;
    }
}
