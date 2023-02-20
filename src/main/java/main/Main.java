package main;

import comandHandler.UserInput;
import filler.JSONInput;
import model.Movie;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Главный класс
 */
public class Main {
    /**
     * Колекция
     */
    public static ArrayList<Movie> arrayList = new ArrayList<Movie>();
    /**
     * The constant counter.
     */
    public static int counter = 0;
    /**
     * The constant filleName.
     */
    public static String filleName;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException    the io exception
     * @throws ParseException the parse exception
     */
    public static void main(String[] args) throws IOException, ParseException {
        filleName = args[0];

        System.out.println("Welcome to the MOVIE_LISTER_3000!");
        System.out.println("If you don't now how to use this app, type 'help'.");

        JSONInput jsonInput = new JSONInput(filleName); //("/home/nikita/IdeaProjects/Lab5/src/main/java/sourse/Data.json");
        jsonInput.readJSON();
        UserInput userInput = new UserInput();
        userInput.readCommands();
    }
}
