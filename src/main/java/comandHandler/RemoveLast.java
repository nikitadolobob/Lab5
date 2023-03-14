package comandHandler;

/**
 * Элемент Pattern Command, описывающий конкретную команду removeLast.
 */
public class RemoveLast implements Command{
    /**
     * Реализация команды, удаляющей фильм из конца коллекции, если она не пуста
     */
    private void removeLast(){
        if(CommandSystem.arrayList.isEmpty()){
            System.out.println("Can not remove last because collection is empty. Enter your next command");
            return;
        }
        CommandSystem.arrayList.remove(CommandSystem.arrayList.size() - 1);
        System.out.println("The last movie of the collection is successfully removed from it");
        System.out.println("Enter your next command: ");
    }


    /**
     * переопределённый метод, запускающий команду removeLast
     */
    @Override
    public void runCommand() {
        this.removeLast();
    }

    /**
     * Конструктор экземпляра removeLast.
     *
     */
    public RemoveLast (){

    }
}
