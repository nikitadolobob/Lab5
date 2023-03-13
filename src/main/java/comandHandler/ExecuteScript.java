package comandHandler;

/**
 * Элемент Pattern Command, описывающий конкретную команду executeScript.
 */
public class ExecuteScript implements Command{
    private void executeScript(String filleName){
        System.out.println("Start reading script" + filleName);
        CommandSystem.execute_cnt++;
        UserInput userInput = new UserInput(filleName);
        userInput.readCommands();
        CommandSystem.execute_cnt--;
        System.out.println("Script executing command finished. You may get to entering data by console");
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
     * @param commandSystem элемент Pattern Command содержащий реализацию команды executeScript
     * @param filleName имя вводимого пользователем файла, с которым будет работать экземпляр команды
     */
    public ExecuteScript (String filleName){
        this.filleName = filleName;
    }
}
