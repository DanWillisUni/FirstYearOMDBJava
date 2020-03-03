package omdb;

public class Movie
{
    //creates all the variables about the movie
    private final String title;
    private final String certificate;
    private final int year;
    private final int runtime;
    private final int rating;
    private final String[] genre;
    //constructor
    public Movie(String title,int year,String certificate,String[] genre,int runtime,int rating)
    {
        //sets all the peices of information to the information specified
        this.title = title;
        this.year = year;
        this.certificate = certificate;
        this.genre = genre;
        this.runtime = runtime;
        this.rating = rating;                
    }
    //accessors
    public String getTitle()
    {
        return title;
    }
    public int getYear()
    {
        return year;
    }
    public String getCertificate()
    {
        return certificate;
    }
     public String[] getGenre()
    {
        return genre;
    }
     public int getRuntime()
    {
        return runtime;
    }
      public int getRating()
    {
        return rating;
    }
    //toString
    @Override
    /*public String toString()
    {
        String subGenre = genre[0];//adds all the genres into a string
        if (genre.length > 0);//if there is more than 1 genre
        {
            //goes through all the genres
            for (int i = 1; i < genre.length; ++i)
            {
                subGenre += "/" + genre[i];//adds the genres together            
            }
        } 
        String str = "Title: " + title + "\nYear of release: " + Integer.toString(year) + "\nCertifiicate: " + certificate + "\nGenres: " + subGenre + "\nRuntime: " + Integer.toString(runtime) + "\nRating " + Integer.toString(rating)+"\n";//all information about a movie displayed together
        return str;
    }
    */
    /**
     *
     * @return
     */
    public String toString()
    {
        String subGenre = genre[0];
        if (genre.length > 0);
        {
            for (int i = 1; i < genre.length; ++i)
            {
                subGenre += "/" + genre[i];            
            }
        }
        String str = '"' + title + "\"," + Integer.toString(year) + ",\"" + certificate + "\",\"" + subGenre + "\"," + Integer.toString(runtime) + "," + Integer.toString(rating);        
        return str;   
    }
    //comparable     
    public int compareTo(final Movie other,String entity)
    {  
        switch (entity) {
            case "year":
                return Integer.compare(this.year, other.year);
            case "runtime":
                return Integer.compare(this.runtime, other.runtime);
            case "titlelength":
                if (this.title.length() < other.title.length())
                {
                    return 1;
                }
                else if (this.title.length() > other.title.length())
                {
                    return -1;
                }
                else
                {
                    return 0;
                }
            default:
                return Integer.compare(this.rating, other.rating);
        }        
    }    
}
