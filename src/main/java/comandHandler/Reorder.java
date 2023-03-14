package comandHandler;

import main.Main;
import model.Movie;

import java.util.Collections;

/**
 * Элемент Pattern Command, описывающий конкретную команду reorder.
 */
public class Reorder implements Command{
    private void reorder(){
        Collections.reverse(CommandSystem.arrayList);
        for(Movie movie : CommandSystem.arrayList){
            movie.setId(CommandSystem.arrayList.indexOf(movie) + 1);
        }
        System.out.println("The movies in the collection reversed their order");
        System.out.println("Enter your next command: ");
    }

    /**
     * переопределённый метод, запускающий команду reorder
     */
    @Override
    public void runCommand() {
        this.reorder();
    }

    /**
     * Конструктор экземпляра reorder.
     *
     * @param commandSystem элемент Pattern Command содержащий реализацию команды reorder
     */
    public Reorder (){

    }
}
