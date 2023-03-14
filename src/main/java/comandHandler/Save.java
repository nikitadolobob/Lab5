package comandHandler;

import filler.JSONOutput;
import main.Main;

/**
 * Элемент Pattern Command, описывающий конкретную команду save.
 */
public class Save implements Command{
    /**
     * Реализация команды, сохраняющей коллекцию в нынешнем состоянии в стартовый файл
     */
    private void save(){
        JSONOutput jsonOutput = new JSONOutput(CommandSystem.filleName);
        jsonOutput.writeJSON();
        System.out.println("The collection is saved to the file");
        System.out.println("Enter your next command: ");
    }


    /**
     * переопределённый метод, запускающий команду save
     */
    @Override
    public void runCommand() {
        this.save();
    }

    /**
     * Конструктор экземпляра save.
     *
     */
    public Save (){

    }
}
