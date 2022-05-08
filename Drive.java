import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Main{
    public static ArrayList<String[]> read_file(String file_name){
        int ct = 0;
        ArrayList<String[ ] > list = new ArrayList<String[ ] >();
        String[] split;
        try(BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file_name)))){
            String line;
            while((line=br.readLine())!=null){
                if(ct >0)
                {
                split=line.split(",");
                /*for(int i=0;i<split.length;i++){
                    System.out.print(split[i]+"   ");
                }
                System.out.println();*/
                list.add(split);
                }
                ct++;
            }
        }
        catch (IOException e) {
            System.out.println("File Read Error");
        }
        return list;

    }
    
    public static void main(String[] args){
        long start1 = System.nanoTime();
        ArrayList<String[ ] > list = new ArrayList<String[ ] >();
        list=read_file("hey.txt");

        StackMovie  tpp = new StackMovie();
        tpp.pastMovies(list);
        /*String[] split;
        for(int j=0;j<list.size();j++){
            split=list.get(j);
            for(int i=0;i<split.length;i++){
                    System.out.print(split[i]+"   ");
                }
                System.out.println();
        }*/
        long end1 = System.nanoTime();  
        System.out.printf("\nRun-Time:%dns\n", end1-start1);
    }


}