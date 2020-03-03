package omdb;
//got to 30
public class OMDB 
{
    public static void main(String[] args) 
    { 
        MovieDatabase wholeMovieDatabase = new MovieDatabase("films.txt");//creates new movie database class
        System.out.println("All in chronological order:");
        MovieDatabase.bubbleSort("year",wholeMovieDatabase);//sorts the movie array into order by year       
        MovieDatabase.printall(wholeMovieDatabase);//prints all of the movie arraylist        
        
        System.out.println("\nThird longest Noir film:");
        MovieDatabase.bubbleSort("runtime",wholeMovieDatabase);//sorts the movie array into order by runtime        
        int returnedNoirQuery[] = wholeMovieDatabase.genreQuery("Film-Noir");//gets the index of each element that has a film noir genre         
        System.out.println(wholeMovieDatabase.movieArr.get(returnedNoirQuery[returnedNoirQuery.length - 3]).toString());//prints the third element out of the indexs in the array
        
        System.out.println("\nEighth most recent unrated films:");
        MovieDatabase.bubbleSort("year",wholeMovieDatabase);//sorts the whole array by year
        int returnedUnratedQuery[] = wholeMovieDatabase.certificateQuery("UNRATED");//gets the indexs of all the elements that are "unrated"
        System.out.println(wholeMovieDatabase.movieArr.get(returnedUnratedQuery[returnedUnratedQuery.length - 8]).toString()    );//prints the eigth element out of the indexs in the array
        
        System.out.println("\nLongest title:");
        MovieDatabase.bubbleSort("titlelength", wholeMovieDatabase);//sorts by title length      
        System.out.println(wholeMovieDatabase.movieArr.get(0).toString());//prints the first element
    }        
}