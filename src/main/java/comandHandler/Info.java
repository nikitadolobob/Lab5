package comandHandler;

import main.Main;

/**
 * Элемент Pattern Command, описывающий конкретную команду info.
 */
public class Info implements Command{
    /**
     * Реализация команды, выводящей на консоль информацию о коллекции(её размер и класс)
     */
    private void info(){
        System.out.println("Information about collection:");
        System.out.println("Collection size: " + CommandSystem.arrayList.size());
        System.out.println("Collection type: " + CommandSystem.arrayList.getClass());
        System.out.println("Enter your next command: ");
    }

    /**
     * переопределённый метод, запускающий команду info
     */
    @Override
    public void runCommand() {
        this.info();
    }

    /**
     * Конструктор экземпляра info.
     *
     */
    public Info (){

    }
}
