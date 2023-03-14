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
            System.out.println("Listen here you dumbass asshole. Am i a fucking joke to you? What did i tell you to enter? Is it so hard? Is it so fucking hard, huh, motherfucker? Read the shit i asked you to do and do this one right this time dickhead");
            return;
        }
        System.out.println("Here is the list of better genered movies in the collection: ");
        for(Movie movie : CommandSystem.arrayList){
            if(movie.getGenre().genreRating > eGenre.genreRating){
                CommandSystem.printMovie(movie);
                System.out.println("----------------------------------");
            }
        }
        System.out.println("That's all of them!");
        System.out.println("Enter your next command: ");
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
     * @param commandSystem элемент Pattern Command содержащий реализацию команды filterGreaterThanGenre
     * @param genre вводимый пользователь жанр, по которому будет происходить необходимое сравнение
     */
    public FilterGreaterThanGenre (String genre){
        this.genre = genre;
    }
}
