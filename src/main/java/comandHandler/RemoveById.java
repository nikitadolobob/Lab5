package comandHandler;

import main.Main;
import model.Movie;

/**
 * Элемент Pattern Command, описывающий конкретную команду removeById.
 */
public class RemoveById implements Command{
    private void removeById(int id){
        if(id <= 0 || id >= Main.arrayList.size()) {
            System.out.println("Id is incorrect. Can not remove element. Try again or enter another command.");
            return;
        }
        Main.arrayList.remove(id - 1);

        for (Movie movie : Main.arrayList) {
            movie.setId(Main.arrayList.indexOf(movie) + 1);
        }
        System.out.println("Element is deleted");
        System.out.println("Enter your next command: ");
    }

    private final int id;

    /**
     * переопределённый метод, запускающий команду removeById
     */
    @Override
    public void runCommand() {
        this.removeById(id);
    }

    /**
     * Конструктор экземпляра removeById.
     *
     * @param commandSystem элемент Pattern Command содержащий реализацию команды removeById
     * @param id вводимое пользователем поле, по значению которого будет вычислен удаляемый элемент
     */
    public RemoveById (int id){
        this.id = id;
    }
}
