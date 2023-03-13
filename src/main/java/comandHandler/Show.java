package comandHandler;

import main.Main;
import model.Movie;

/**
 * Элемент Pattern Command, описывающий конкретную команду show.
 */
public class Show implements Command{
    private void show(){
        for(Movie movie : Main.arrayList){
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
     * @param commandSystem элемент Pattern Command содержащий реализацию команды show
     */
    public Show (){

    }
}
