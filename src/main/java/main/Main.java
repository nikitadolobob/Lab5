package main;

import comandHandler.UserInput;
import filler.JSONInput;
import model.Movie;
import java.util.ArrayList;


/**
 * Главный класс, из которого запускается приложение.
 */
public class Main {
    /**
     * Коллекция, в которой хранятся фильмы.
     */
    public static ArrayList<Movie> arrayList = new ArrayList<Movie>();
    /**
     * Имя файла, с которого считывается коллекция в формате JSON.
     */
    public static String filleName;

    /**
     * Функция, из которой запускается приложение.
     *
     * @param args Аргументы программы. Первым аргументом программа принимает JSON-файл, в котором описаны элементы коллекции.
     */
    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println("There is JSON file, to read collection from");
            System.out.println("Please, make sure to give a JSON file before starting the app");
            System.exit(-1);
        }
        filleName = args[0];

        //Создание экземпляра класса, который считывает данные с заданного JSON-файла
        JSONInput jsonInput = new JSONInput(filleName); //("/home/nikita/IdeaProjects/Lab5/src/main/java/sourse/Data.json");
        jsonInput.readJSON();

        System.out.println("Welcome to the MOVIE_LISTER_3000!");
        System.out.println("If you don't now how to use this app, type 'help'.");

        //Создание экземпляра класса, который считывает команды с консоли
        UserInput userInput = new UserInput();
        userInput.readCommands();
    }
}
