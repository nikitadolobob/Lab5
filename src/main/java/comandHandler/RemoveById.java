package comandHandler;

import main.Main;
import model.Movie;

/**
 * Элемент Pattern Command, описывающий конкретную команду removeById.
 */
public class RemoveById implements Command{
    /**
     * Реализация команды, удаляющей из коллекции фильм с заданным id
     *
     * @param id - значение поля id удаляемого фильма
     */
    private void removeById(int id){
        if(id <= 0 || id > CommandSystem.arrayList.size()) {
            System.out.println("Id is incorrect. Can not remove element. Try again or enter another command.");
            return;
        }
        CommandSystem.arrayList.remove(id - 1);

        for (Movie movie : CommandSystem.arrayList) {
            movie.setId(CommandSystem.arrayList.indexOf(movie) + 1);
        }
        System.out.println("Element is deleted");
        UserInput.messageNewLineWriter("Enter your next command: ");
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
     * @param id вводимое пользователем поле, по значению которого будет вычислен удаляемый элемент
     */
    public RemoveById (int id){
        this.id = id;
    }
}
