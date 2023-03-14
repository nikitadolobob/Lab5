package comandHandler;

import main.Main;
import model.Movie;

/**
 * Элемент Pattern Command, описывающий конкретную команду show.
 */
public class Show implements Command{
    /**
     * Реализация команды, выводящей на консоль все фильмы коллекции
     */
    private void show(){
        for(Movie movie : CommandSystem.arrayList){
            CommandSystem.printMovie(movie);
            System.out.println("---------------------------------");
        }
        System.out.println("Command SHOW successfully finished");
        System.out.println("Enter your next command: ");
    }

    /**
     * переопределённый метод, запускающий команду show
     */
    @Override
    public void runCommand() {
        this.show();
    }

    /**
     * Конструктор экземпляра show.
     *
     */
    public Show (){

    }
}
