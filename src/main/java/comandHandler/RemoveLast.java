package comandHandler;

import main.Main;

/**
 * Элемент Pattern Command, описывающий конкретную команду removeLast.
 */
public class RemoveLast implements Command{
    private void removeLast(){
        if(Main.arrayList.isEmpty()){
            System.out.println("Can not remove last because collection is empty. Enter your next command");
            return;
        }
        Main.arrayList.remove(Main.arrayList.size() - 1);
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
     * @param commandSystem элемент Pattern Command содержащий реализацию команды removeLast
     */
    public RemoveLast (){

    }
}
