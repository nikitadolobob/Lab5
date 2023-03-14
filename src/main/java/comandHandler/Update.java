package comandHandler;

import model.Movie;

/**
 * Элемент Pattern Command, описывающий конкретную команду update.
 */
public class Update implements Command{

    /**
     * Реализация команды, позволяющая пользователю поочередно изменить каждое поле фильма коллекции с заданным id
     *
     * @param id - значения поля id фильма, поля которого пользователь будет менять
     */
    private void update(int id){
        if(id <= 0 || id >= CommandSystem.arrayList.size()) {
            System.out.println("Id is incorrect. Can not update element. Try again or enter another command.");
            return;
        }
        Movie movie = UserInput.readMovie();
        if(movie == null){
            return;
        }
        movie.setId(id);
        movie.setCreationDate(CommandSystem.arrayList.get(id - 1).getCreationDate());
        CommandSystem.arrayList.remove(id - 1);
        CommandSystem.arrayList.add(id - 1, movie);
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
     * @param id вводимое пользователем поле, по значению которого будет вычислен изменяемый элемент
     */
    public Update (int id){
        this.id = id;
    }
}
