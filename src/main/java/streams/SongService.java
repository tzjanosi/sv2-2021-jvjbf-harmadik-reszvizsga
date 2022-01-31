package streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class SongService {
    private List<Song> songsList=new ArrayList<>();

    public void addSong(Song song){
        songsList.add(song);
    }

    public Optional<Song> shortestSong(){
        return songsList.stream()
                .sorted(Comparator.comparing(Song::getLength))
                .findFirst();
    }

    public List<Song> findSongByTitle(String title){
        return songsList.stream()
                .filter(Song -> Song.isTheTitleEqualsWith(title))
                .collect(Collectors.toList());
    }
    public boolean isPerformerInSong(Song song, String performer){
        return song.isThePerformerInList(performer);
    }

    public List<String> titlesBeforeDate(LocalDate from){
        return songsList.stream()
                .filter(Song -> Song.isReleaseBefore(from))
                .map(Song::getTitle)
                .collect(Collectors.toList());
    }
}
