import java.util.Scanner;
import java.io.*;
import java.util.*;

public class priorityQ{
    public static ArrayList<String[]> read_file(String file_name){

        ArrayList<String[ ] > list = new ArrayList<String[ ] >();
        String[] split;
        try(BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file_name)))){
            String line;
            while((line=br.readLine())!=null){
                split=line.split(",");
                /*for(int i=0;i<split.length;i++){
                    System.out.print(split[i]+"   ");
                }
                System.out.println();*/
                list.add(split);
            }
        }
        catch (IOException e) {
            System.out.println("File Read Error");
        }
        return list;

    }
    public static void main(String[] args){
        ArrayList<String[ ] > list = new ArrayList<String[ ] >();
        list=read_file("Movies.txt");

        PriorityQueue<String> pq = new PriorityQueue<String>();
        
        long start = System.nanoTime();    
        pq = recommendedMovies("animation",list);
        long elapsedTime = System.nanoTime() - start;

        System.out.println("recommended Movie count: "+ _size);
        System.out.println("time: "+ elapsedTime);
        
        /*for(int i=0; i<_size; ++i)
           System.out.println(pq.poll());*/

    }
    private static int _size =0;
    //takes movie genre and recomend same genre movies
    public static PriorityQueue<String> recommendedMovies(String _genre,ArrayList<String[ ] > _list){
        PriorityQueue<String> pq = new PriorityQueue<String>();

        String[] split;
        for(int j=0;j<_list.size();j++){
            split=_list.get(j);
           
           if(split[1].equals(_genre)){
            pq.offer(split[2]);
            _size++;
           }
        }
        
        return pq;
    }
}