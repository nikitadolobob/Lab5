package comandHandler;

import model.Movie;

import java.util.Collections;

/**
 * Элемент Pattern Command, описывающий конкретную команду addIfMin
 */
public class AddIfMin implements Command{

    /**
     * Реализация команды, добавляющей новый фильм в конец коллекции, если этот элемент, в соотвествие с переопределённым для класса Movie методом compareTo, окажется строго меньше минимального элемента коллекции
     */
    private void addIfMin(){
        Movie movie = UserInput.readMovie();
        if(movie == null){
            return;
        }
        Movie minMovie = Collections.min(CommandSystem.arrayList);
        if(movie.compareTo(minMovie) < 0){
            CommandSystem.arrayList.add(movie);
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
     */
    public AddIfMin(){}
}
