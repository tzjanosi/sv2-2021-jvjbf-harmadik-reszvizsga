package streams;

import java.time.LocalDate;
import java.util.List;

public class Song {
    private String title;
    private int length;
    private List<String> performersList;
    private LocalDate releaseDate;

    public Song(String title, int length, List<String> performersList, LocalDate releaseDate) {
        this.title = title;
        this.length = length;
        this.performersList = performersList;
        this.releaseDate = releaseDate;
    }

    public boolean isTheTitleEqualsWith(String title){
        return this.title.equals(title);
    }
    public boolean isThePerformerInList(String performer){
        return this.performersList.contains(performer);
    }
    public boolean isReleaseBefore(LocalDate from){
        return this.releaseDate.isBefore(from);
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public List<String> getPerformers() {
        return performersList;
    }

    public LocalDate getRelease() {
        return releaseDate;
    }
}
