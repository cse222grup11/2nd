import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


class ListMovie {

	private ArrayList<Movie> list;

	public ListMovie() {
		list = new ArrayList<Movie>();
	}


	public void add(Movie m) {
		list.add(m);
	}

	/*Check if the given movie is  exist*/
	public boolean containsMovie(Movie movie) {
		String title = movie.getTitle();
		for (Movie m : list) {
			if (m.getTitle().equals(title)) {
				return true;
			}
		}
		return false;
	}

	/*Delete movies */
	public void delete(Movie m) {
		list.remove(m);

	}
	/* Sort by title / genre Using helper classes*/
	public void sortByTitle() {
		Collections.sort(list, new ComparatorTitle());
	}


	public ArrayList<Movie> getList() {
		return list;
	}

	public int getSize() {
		return list.size();
	}

	public Movie get(int i) {
		return list.get(i);
	}

	public void save() throws IOException {
		sortByTitle();
		PrintWriter textOut = new PrintWriter(new FileWriter("Movies.txt"));
		for (int i = 0; i < list.size(); i++) {
			textOut.println(list.get(i));
		}
		textOut.close();
	}

	
	  public static void main(String[] args){
	        ArrayList<String[ ] > list = new ArrayList<String[ ] >();
	       String[] movies ;
	       
	        for(int j=0;j<list.size();j++){
	            movies=list.get(j);
	            
	            for(int i=0;i<movies.length;i++){
	                    System.out.print(movies[i]+"   ");
	                }
	                System.out.println();
	        }
	        
	        }
}



