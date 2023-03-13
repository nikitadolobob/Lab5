package comandHandler;

import main.Main;
import model.Movie;

import java.util.Collections;

/**
 * Элемент Pattern Command, описывающий конкретную команду addIfMin
 */
public class AddIfMin implements Command{
    private void addIfMin(){
        Movie movie = UserInput.readMovie();
        if(movie == null){
            return;
        }
        Movie minMovie = Collections.min(Main.arrayList);
        if(movie.compareTo(minMovie) < 0){
            Main.arrayList.add(movie);
            System.out.println("The movie is in the collection now");
        }
        else {
            System.out.println("The movie was not a minimum, so it is not in the collection");
        }
        System.out.println("Enter your next command: ");
    }
    /**
     * переопределённый метод, запускающий команду addIfMin
     */
    @Override
    public void runCommand() {
        this.addIfMin();
    }

    /**
     * Конструктор экземпляра addIfMin
     *
     * @param commandSystem элемент Pattern Command содержащий реализацию команды addIfMin
     */
    public AddIfMin(){}
}
