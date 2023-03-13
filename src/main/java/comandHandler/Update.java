package comandHandler;

import main.Main;
import model.Movie;

/**
 * Элемент Pattern Command, описывающий конкретную команду update.
 */
public class Update implements Command{
    private void update(int id){
        if(id <= 0 || id >= Main.arrayList.size()) {
            System.out.println("Id is incorrect. Can not update element. Try again or enter another command.");
            return;
        }
        Movie movie = UserInput.readMovie();
        if(movie == null){
            return;
        }
        movie.setId(id);
        movie.setCreationDate(Main.arrayList.get(id - 1).getCreationDate());
        Main.arrayList.remove(id - 1);
        Main.arrayList.add(id - 1, movie);
        System.out.println("The movie is successfully updgared");
        System.out.println("Enter your next command: ");
    }

    private final int id;

    /**
     * переопределённый метод, запускающий команду update
     */
    @Override
    public void runCommand() {
        this.update(id);
    }

    /**
     * Конструктор экземпляра update.
     *
     * @param commandSystem элемент Pattern Command содержащий реализацию команды update
     * @param id вводимое пользователем поле, по значению которого будет вычислен изменяемый элемент
     */
    public Update (int id){
        this.id = id;
    }
}
