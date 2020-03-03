package omdb;
import java.util.*; 
import java.nio.charset.StandardCharsets; 
import java.nio.file.*; 
import java.io.*; 
public class MovieDatabase 
{
    public ArrayList<Movie> movieArr;//creates the arraylist that stores all the movie objects in
    //constructors
    public MovieDatabase(String path)
    {
       String[] movies = readIn(path);//reads in the film.txt and then puts all the lines into an array        
       movieArr = createObj(movies);//creates all the objects from the array from the file
    }
    //secondary constructor
    public MovieDatabase(ArrayList<Movie> array)
    {
        //creates a new class from a ArrayList<Movie>
        movieArr = array;
    }
    //reads in all the lines from a file into a string[]
    private String[] readIn(String fileName)
    { 
        List<String> lines = Collections.emptyList();//creates an empty ArrayList 
        try
        { 
          lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);//reads in all the lines from the file into an arraylist
        } 
        catch (IOException e) 
        {
            System.out.println(e);
        }
        //converts an arraylist to an array
        String[] linesArr = new String[lines.size()];
        linesArr = lines.toArray(linesArr);
        return linesArr; 
    }
    //creates objects from the array of lines
    public static ArrayList<Movie> createObj(String[] lines)
    {        
        ArrayList<Movie> movieArr;//creates arraylist of movie objects
        movieArr = new ArrayList<>();
        //loops through every element in the array
        for (int i = 0; i < lines.length; ++i)
        {
            String[] linesone = lines[i].split("\"");//splits on "            
            String linetwo = "";
            //creates new string that will be the rest of the line other than title
            for (int o = 2; o < linesone.length; ++o)
            {
                linetwo += linesone[o];
            }
            String[] linethree = linetwo.split(",");//splits line other than title by ,         
            movieArr.add(new Movie(linesone[1], Integer.parseInt(linethree[1]),linethree[2], linethree[3].split("/"),Integer.parseInt(linethree[4]),Integer.parseInt(linethree[5])));//creates new movie object and adds it to the arraylist            
        }
        return movieArr;//returns the arraylist populated with movie objects
    }
    //returns a array of indexs in movieArr of all the movies with the required genre
    public int[] genreQuery(String requiredGenre)
    {        
        ArrayList<Integer> list=new ArrayList<>();//creates an arraylist for all the indexs
        //for each object in movieArr
        for (int i = 0; i < movieArr.size(); ++i)
        {
            String Genre[] = movieArr.get(i).getGenre();//gets an array full of all the genres
            //goes through the array full of genres
            for (int o = 0; o < Genre.length; ++o)
            {                
                if (requiredGenre.equals(Genre[o]))//if the movie has that genre
                {                    
                    list.add(i);//add the index to the list                   
                    break;//exits for loop as it has been found
                }
            }        
        }        
        return convertAl2A(list);//returns array of the indexs of all movies with the specified genre
    }
    //returns a array of indexs in movieArr of all the movies with the required certificate
    public int[] certificateQuery(String requiredCertificate)
    {        
        ArrayList<Integer> list = new ArrayList<>();//creates a new arraylist
        //for each object in movieArr
        for (int i = 0; i < movieArr.size(); ++i)
        {            
            if (requiredCertificate.equals(movieArr.get(i).getCertificate()))//if the certificate is the required certificate
            {                    
                list.add(i);//add the index to the list    
            }
        }
       return convertAl2A(list); //returns array of the indexs of all movies with the specified certificate    
    }
    //converts an integer ArrayList to an integer array
    private int[] convertAl2A(ArrayList<Integer> list)
    {
        int[] arr = new int[list.size()];//creates the array
        //loops through the arraylist
        for (int i = 0; i < list.size(); i++)
        {
            arr[i] = list.get(i);//sets the array[i] to the arraylist[i]           
        }        
        return arr;//returns the array
    }
    //sorts the movie arraylist via bubble sort
    public static void bubbleSort(String entity, MovieDatabase c)
    {    
        for(int i=0; i < c.movieArr.size(); i++)
        {  
            for(int j=1; j < (c.movieArr.size()-i); j++)
            {  
                if(c.movieArr.get(j-1).compareTo(c.movieArr.get(j),entity)==1)
                {  
                    //swap elements
                    String[] templine = {c.movieArr.get(j-1).toString()};                    
                    ArrayList<Movie> temp;
                    temp = (MovieDatabase.createObj(templine));  
                    c.movieArr.set(j-1,c.movieArr.get(j));  
                    c.movieArr.set(j,temp.get(0));  
                }          
           }  
        }  
    }
    //prints all the elements in the movie arraylist
    public static void printall(MovieDatabase c)
    {
       for(int i=0; i < c.movieArr.size(); i++)
        { 
            System.out.println(c.movieArr.get(i).toString());
        }
       //System.out.println("\n");
    }    
}