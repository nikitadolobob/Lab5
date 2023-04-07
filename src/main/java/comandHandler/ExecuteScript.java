package comandHandler;

import java.io.File;

/**
 * Элемент Pattern Command, описывающий конкретную команду executeScript.
 */
public class ExecuteScript implements Command{

    /**
     * Реализация команды, выполняющей команды из файла, заданного пользователем
     *
     * @param filleName имя файла заданного пользователем
     */
    private void executeScript(String filleName){
        File f = new File(filleName);
        if(!f.exists()){
            System.out.println("Such filleName does not exist. Make sure you entered ABSOLUTE PATH to the file");
            return;
                    }
        System.out.println("Start reading script" + filleName);
        CommandSystem.execute_cnt++;
        UserInput userInput = new UserInput(filleName);
        userInput.readCommands();
        CommandSystem.execute_cnt--;
        System.out.println("Script executing command finished. You may get to entering data via console");
    }
    private final String filleName;

    /**
     * переопределённый метод, запускающий команду executeScript
     */
    @Override
    public void runCommand() {
        this.executeScript(filleName);
    }

    /**
     * Конструктор экземпляра executeScript.
     *
     * @param filleName имя вводимого пользователем файла, с которым будет работать экземпляр команды
     */
    public ExecuteScript (String filleName){
        this.filleName = filleName;
    }
}
