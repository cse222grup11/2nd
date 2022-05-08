import java.util.ArrayList;
import java.util.Stack;

public class StackMovie{

    public static void pastMovies(ArrayList<String[]> temp)
    {
        Stack<String[]> tp = new Stack<>();

        String[] split;

        System.out.println("\n10 most recently Watched movies ----> Using ArrayList");

        System.out.println("\nShowID-->Type-->title-->Director-->Cast-->country-->Date_added-->Release_year-->Rating,duration-->ListedIn-->Description-->");
        for(int i = 0 ; i < 10 ; i ++)
        {
            split=temp.get(i);
            tp.push(temp.get(i));
            for(int j=0;j<split.length;j++)
                System.out.print(split[j]+"   ");
                
             System.out.println();
        }

        System.out.println("\n10 Most Recently Watched Movies added into the Stack----> AI's going to suggest to continue the movies");
        
        System.out.println("\n---------------> Continue Watching <--------------");

        String [] split2;
   
        for(int i = 0 ; i < 10 ; i++)
        {   
            split2 = tp.peek();
            tp.pop();
            for(int j = 0 ; j < split2.length;j++)
            System.out.println(split2[j]+"   ");
            
            System.out.println();
        }

        System.out.println("\n------------------------------------------------------------------");
    }
    
}