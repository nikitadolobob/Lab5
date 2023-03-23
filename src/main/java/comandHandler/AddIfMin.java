package comandHandler;

import model.Movie;

import java.util.Collections;
import java.util.NoSuchElementException;

/**
 * Элемент Pattern Command, описывающий конкретную команду addIfMin
 */
public class AddIfMin implements Command{

    /**
     * Реализация команды, добавляющей новый фильм в конец коллекции, если этот элемент, в соотвествие с переопределённым для класса Movie методом compareTo, окажется строго меньше минимального элемента коллекции
     */
    private void addIfMin(){
        Movie minMovie;
        try{
            minMovie = Collections.min(CommandSystem.arrayList);
        }catch (NoSuchElementException e){
            System.out.println("Impossible to run command: collection is empty, no minimal element exists.");
            return;
        }
        Movie movie = UserInput.readMovie();
        if(movie == null){
            return;
        }
        if(movie.compareTo(minMovie) < 0){
            CommandSystem.arrayList.add(movie);
            System.out.println("The movie is in the collection now");
        }
        else {
            System.out.println("The movie was not a minimum, so it is not in the collection");
        }
        UserInput.messageNewLineWriter("Enter your next command: ");
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
     */
    public AddIfMin(){}
}
