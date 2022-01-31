package movietheatres;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MovieTheatreService {
    private Map<String, List<Movie>> records=new TreeMap<>();

    public List<String> readFromFile(Path path){
        //Paths.get("src/test/resources/moviesintheaters.txt")
        try {
            return Files.readAllLines(path);
        } catch (IOException ioe) {
//            throw new IllegalStateException("Can not read file: "+path, ioe);
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }
    private void process(List<String> lines){
        String[] fieldsArray;
        String theater;
        String title;
        String secondPart;
        int hour;
        int minute;
        Movie movie;
        List<Movie> moviesList;
        for(String line:lines){
            fieldsArray=line.split("-");
            theater=removeBrackets(fieldsArray[0]);
            secondPart=fieldsArray[1];
            fieldsArray=secondPart.split(";");
            title=removeBrackets(fieldsArray[0]);
            secondPart=fieldsArray[1];
            fieldsArray=secondPart.split(":");
            hour=Integer.parseInt(removeBrackets(fieldsArray[0]))
            minute=Integer.parseInt(removeBrackets(fieldsArray[1]))
            movie=new Movie(title, LocalTime.of(hour,minute));

            records.put(theater, moviesList);

        }
    }
    private String removeBrackets(String stringtToEdit){
        String result = stringtToEdit.substring(1, stringtToEdit.length()-1);
    }

}
