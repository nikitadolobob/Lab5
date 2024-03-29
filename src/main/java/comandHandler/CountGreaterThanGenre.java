package comandHandler;

import main.Main;
import model.Movie;
import model.MovieGenre;

/**
 * Элемент Pattern Command, описывающий конкретную команду CountGreaterThanGenre.
 */
public class CountGreaterThanGenre implements Command{

    /**
     * Реализация команды, выводящей на консоль количество фильмов коллекции, жанр которых, в соответствие с полем genreRating, строго больше заданного жанра
     *
     * @param genre Заданный жанр, с которым производится сравнение
     */
    private void countGreaterThanGenre(String genre){
        MovieGenre eGenre = null;
        int maxGenreCount = 0;
        for(MovieGenre iGenre : MovieGenre.values()){
            if(genre.equals(iGenre.name())){
                eGenre = iGenre;
            }
        }
        if(eGenre == null){
            System.out.println("Incorrect genre");
            return;
        }
        for(Movie movie : CommandSystem.arrayList){
            if(movie.getGenre().genreRating > eGenre.genreRating){
                maxGenreCount++;
            }
        }
        System.out.println("Here you go, bro. There are: " + maxGenreCount + " of the more genred movies in the collection!");
        UserInput.messageNewLineWriter("Enter your next command: ");
    }
    private final String genre;

    /**
     * переопределённый метод, запускающий команду countGreaterThanGenre
     */
    @Override
    public void runCommand() {
        this.countGreaterThanGenre(genre);
    }

    /**
     * Конструктор экземпляра countGreaterThanGenre.
     *
     * @param genre  вводимый пользователь жанр, по которому будет происходить необходимое сравнение
     */
    public CountGreaterThanGenre (String genre){
        this.genre = genre;
    }
}
