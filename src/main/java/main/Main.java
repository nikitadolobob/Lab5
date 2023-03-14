package main;

import comandHandler.CommandSystem;
import comandHandler.UserInput;
import filler.JSONInput;
import model.Movie;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Главный класс, из которого запускается приложение.
 */
public class Main {

    /**
     * Имя файла, с которого считывается коллекция в формате JSON.
     */

    /**
     * Функция, из которой запускается приложение.
     *
     * @param args Аргументы программы. Первым аргументом программа принимает JSON-файл, в котором описаны элементы коллекции.
     */
    public static void main(String[] args) {
        boolean isValidFile = false;
        if(args.length == 0){
            File f = new File("Collection.json");
            try {
                f.createNewFile();
            } catch (IOException e) {
                System.out.println("You gave no file. Unable to create new file");
                System.exit(-1);
            }
        }
        else{
            CommandSystem.filleName = args[0];
            File f = new File(CommandSystem.filleName);
            if(!f.exists()){
                try {
                    f.createNewFile();
                } catch (IOException e) {
                    System.out.println("You gave not existing file. Unable to create new file");
                    System.exit(-1);
                }
            }
            else isValidFile = true;
        }

        if(isValidFile){
            //Создание экземпляра класса, который считывает данные с заданного JSON-файла
            JSONInput jsonInput = new JSONInput(CommandSystem.filleName); //("/home/nikita/IdeaProjects/Lab5/src/main/java/sourse/Data.json");
            jsonInput.readJSON();
        }

        System.out.println("Welcome to the MOVIE_LISTER_3000!");
        System.out.println("If you don't now how to use this app, type 'help'.");

        //Создание экземпляра класса, который считывает команды с консоли
        UserInput userInput = new UserInput();
        userInput.readCommands();
    }
}
