package comandHandler;

import main.Main;
import model.Movie;

/**
 * Элемент Pattern Command, описывающий конкретную команду add
 */
public class Add implements Command {
    private void add(){
        Movie movie = UserInput.readMovie();
        if(movie == null){
            return;
        }
        Main.arrayList.add(movie);
        System.out.println("The movie is successfully added");
        System.out.println("Enter your next command: ");
    }
    /**
     * переопределённый метод, запускающий команду add
     */
    @Override
    public void runCommand() {
        this.add();
    }

    /**
     * Конструктор экземпляра add
     *
     * @param commandSystem элемент Pattern Command содержащий реализацию команды add
     */
    public Add(){}
}
