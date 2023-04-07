package comandHandler;

import main.Main;
import model.Movie;
import model.MovieGenre;

/**
 * Элемент Pattern Command, описывающий конкретную команду filterGreaterThanGenre.
 */
public class FilterGreaterThanGenre implements Command{


    /**
     * Реализация команды, выводящей на консоль фильмы коллекции, жанр которых, в соответствие с полем genreRating, строго больше заданного жанра
     *
     * @param genre заданный жанр, с которым производится сравнение
     */

    private void filterGreaterThanGenre(String genre){
        MovieGenre eGenre = null;
        for(MovieGenre iGenre : MovieGenre.values()){
            if(genre.equals(iGenre.name())){
                eGenre = iGenre;
            }
        }
        if(eGenre == null){
            System.out.println("Incorrect genre");
            return;
        }
        System.out.println("Here is the list of better genred movies in the collection: ");
        for(Movie movie : CommandSystem.arrayList){
            if(movie.getGenre().genreRating > eGenre.genreRating){
                CommandSystem.printMovie(movie);
                System.out.println("----------------------------------");
            }
        }
        System.out.println("That's all of them!");
        UserInput.messageNewLineWriter("Enter your next command: ");
    }
    private final String genre;

    /**
     * переопределённый метод, запускающий команду filterGreaterThanGenre
     */
    @Override
    public void runCommand() {
        this.filterGreaterThanGenre(genre);
    }

    /**
     * Конструктор экземпляра filterGreaterThanGenre.
     *
     * @param genre вводимый пользователь жанр, по которому будет происходить необходимое сравнение
     */
    public FilterGreaterThanGenre (String genre){
        this.genre = genre;
    }
}
