import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Class Binary search tree
 */

public class BST {

    // protected static ArrayList<String> genre = new ArrayList<>();
    // protected static ArrayList<String> name = new ArrayList<>();
    protected static ArrayList<Float> score = new ArrayList<>();
    // protected static ArrayList<Integer> score = new ArrayList<>();

    public static void main(String[] args) {

        ArrayList<String[]> scoreBst = new ArrayList<String[]>();
        scoreBst = read_file("Movies.txt");
        methods_ByRating();

    }

    private static void fillRatings(ArrayList<String[ ]> list){
        String[] lineArray;
        for(int i=0; i<list.size() - 1; i++){
            lineArray = list.get(i);
            try{
                Float puan = Float.parseFloat(lineArray[3]);
                score.add(puan);   
                // name.add(lineArray[1]);   
            }catch(NumberFormatException e){}     
        }
    }
    public static void methods_ByRating(){

        BinarySearchTree<Float> ratingTree = new BinarySearchTree<>();

        /* Testing add method */
        System.out.println("Inserting elements to the tree");
        System.out.println("-------------------------------------------------");
        // for (int num : score) 
        //     ratingTree.add(num);
        long start = System.nanoTime();

        int x = 0;
        while(x < score.size()){
            ratingTree.add(score.get(x));
            x++;
        }
        System.out.println("score informations successfully added to the tree.");
        System.out.println("-------------------------------------------------");

        /* Test toString */
        System.out.println("BINARY SEARCH TREE consisting of score information of a Movie/TV Series :\n");
        System.out.println(ratingTree);   

        /* Test method for the contains method of the BST */

        System.out.println("-------------------------------------------------");
        System.out.println("Test method for the contains method of the BST");
        System.out.println("-------------------------------------------------");

        for(int i=30; i<80; i+=3){
            Float t = (float) (i*0.1);
            if(ratingTree.contains(t))    System.out.println("Score " + t + " is in the tree.");
            else    System.out.println("Score " + t + " is NOT in the tree.");
        }
        System.out.println("-------------------------------------------------");

        /* Test method for the size method of the BST */
        System.out.println("Size of the tree : "+ ratingTree.size());
        System.out.println("-------------------------------------------------");
        /* remove some data from the BST */
        for(int i=30; i<80; i+=6){
            Float t = (float)(i*0.1);
            ratingTree.remove(t);
        }
        System.out.println("-------------------------------------------------");    
        System.out.println("After removing movies with scores from 3.6 to 7.4\n\t    by 0.3 difference ");
        System.out.println("        checking their new status  ");
        System.out.println("-------------------------------------------------");

        for(int i=30; i<80; i+=3){
            Float t = (float) (i*0.1);
            if(ratingTree.contains(t))   System.out.println("Score " + t + " is in the tree.");
            else    System.out.println("Score " + t + " is NOT in the tree.");
        }
        System.out.println("-------------------------------------------------");    

        BinaryTree<Float> rightSubtree = new BinarySearchTree<>();
        rightSubtree = ratingTree.getRightSubtree();

        System.out.println("RIGHT Subtree of the score Tree");

        System.out.println(rightSubtree);
        System.out.println("-------------------------------------------------");    
        System.out.println("Testing BST is done successfully.");

        long end = System.nanoTime();
        long diff = end - start;

    }

    public static ArrayList<String[]> read_file(String file_name){

        ArrayList<String[ ] > list = new ArrayList<String[ ] >();
        String[] split;
        try(BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file_name)))){
            String line;
            while((line=br.readLine())!=null){
                split=line.split(",");
                list.add(split);
            }
        }
        catch (IOException e) {
            System.out.println("File Read Error");
        }
        
        fillRatings(list); // kodu birlestirirsek suna dikkat
        return list;
    }
}
