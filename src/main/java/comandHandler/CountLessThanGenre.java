package comandHandler;

import main.Main;
import model.Movie;
import model.MovieGenre;

/**
 * Элемент Pattern Command, описывающий конкретную команду CountLessThanGenre.
 */
public class CountLessThanGenre implements Command{

    /**
     * Реализация команды, выводящей на консоль количество фильмов коллекции, жанр которых, в соответствие с полем genreRating, строго меньше заданного жанра
     *
     * @param genre заданный жанр, с которым производится сравнение
     */
    private void countLessThanGenre(String genre){
        MovieGenre eGenre = null;
        int minGenreCount = 0;
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
            if(movie.getGenre().genreRating < eGenre.genreRating){
                minGenreCount++;
            }
        }
        System.out.println("Here you go, bro. There are: " + minGenreCount + " of the less genred movies in the collection!");
        UserInput.messageNewLineWriter("Enter your next command: ");
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
     * @param genre вводимый пользователь жанр, по которому будет происходить необходимое сравнение
     */
    public CountLessThanGenre (String genre){
        this.genre = genre;
    }
}
