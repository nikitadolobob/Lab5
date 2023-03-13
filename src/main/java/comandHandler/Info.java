package comandHandler;

import main.Main;

/**
 * Элемент Pattern Command, описывающий конкретную команду info.
 */
public class Info implements Command{
    private void info(){
        System.out.println("Information about collection:");
        System.out.println("Collection size: " + Main.arrayList.size());
        System.out.println("Collection type: " + Main.arrayList.getClass());
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
     * @param commandSystem элемент Pattern Command содержащий реализацию команды info
     */
    public Info (){

    }
}
