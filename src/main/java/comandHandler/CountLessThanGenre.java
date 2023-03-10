package comandHandler;

import main.Main;
import model.Movie;
import model.MovieGenre;

/**
 * Элемент Pattern Command, описывающий конкретную команду CountLessThanGenre.
 */
public class CountLessThanGenre implements Command{
    private void countLessThanGenre(String genre){
        MovieGenre eGenre = null;
        int minGenreCount = 0;
        for(MovieGenre iGenre : MovieGenre.values()){
            if(genre.equals(iGenre.name())){
                eGenre = iGenre;
            }
        }
        if(eGenre == null){
            System.out.println("Listen here you dumbass asshole. Am i a fucking joke to you? What did i tell you to enter? Is it so hard? Is it so fucking hard, huh, motherfucker? Read the shit i asked you to do and do this one right this time dickhead");
            return;
        }
        for(Movie movie : Main.arrayList){
            if(movie.getGenre().genreRating < eGenre.genreRating){
                minGenreCount++;
            }
        }
        System.out.println("Here you go, bro. There are: " + minGenreCount + " of the less genred movies in the collection!");
        System.out.println("Enter your next command: ");
    }
    private final String genre;

    /**
     * переопределённый метод, запускающий команду countLessThanGenre
     */
    @Override
    public void runCommand() {
        this.countLessThanGenre(genre);
    }

    /**
     * Конструктор экземпляра countLessThanGenre.
     *
     * @param commandSystem элемент Pattern Command содержащий реализацию команды countLessThanGenre
     * @param genre вводимый пользователь жанр, по которому будет происходить необходимое сравнение
     */
    public CountLessThanGenre (String genre){
        this.genre = genre;
    }
}
