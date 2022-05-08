import java.util.Comparator;


/*used to order the objects of a user-defined class*/
class ComparatorTitle implements Comparator <Movie>{
	
	public int compare(Movie m1, Movie m2) {
	    return m1.getTitle().compareTo(m2.getTitle());             
	  }
	
}