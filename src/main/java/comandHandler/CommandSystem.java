package comandHandler;

import filler.JSONOutput;
import main.Main;
import model.*;

import java.util.Collections;

public class CommandSystem {
    public void add(){
        Movie movie = UserInput.readMovie();
        if(movie == null){
            return;
        }
        Main.arrayList.add(movie);
        System.out.println("The movie is successfully added");
        System.out.println("Enter your next command: ");
    }
    public void addIfMin(){
        Movie movie = UserInput.readMovie();
        if(movie == null){
            return;
        }
        Movie minMovie = Collections.min(Main.arrayList);
        if(movie.compareTo(minMovie) < 0){
            Main.arrayList.add(movie);
            System.out.println("The movie is in the collection now");
        }
        else {
            System.out.println("The movie was not a minimum, so it is not in the collection");
        }
        System.out.println("Enter your next command: ");
    }
    public void clear(){
            Main.arrayList.clear();
            System.out.println("The collection is empty now");
            System.out.println("Enter your next command: ");
    }
    public void countGreaterThanGenre(String genre){
        MovieGenre eGenre = null;
        int maxGenreCount = 0;
        for(MovieGenre iGenre : MovieGenre.values()){
            if(genre.equals(iGenre.name())){
                eGenre = iGenre;
            }
        }
        if(eGenre == null){
            System.out.println("Listen here you dumbass asshole. Am i a fucking joke to you? What did i tell you to enter? Is it so hard? Is it so fucking hard, huh, motherfucker? Read the shit i asked you to do and do this one right this time dickhead");
            return;
        }
        for(Movie movie : Main.arrayList){
            if(movie.getGenre().genreRating > eGenre.genreRating){
                maxGenreCount++;
            }
        }
        System.out.println("Here you go, bro. There are: " + maxGenreCount + " of the more genred movies in the collection!");
        System.out.println("Enter your next command: ");
    }
    public void countLessThanGenre(String genre){
        MovieGenre eGenre = null;
        int minGenreCount = 0;
        for(MovieGenre iGenre : MovieGenre.values()){
            if(genre.equals(iGenre.name())){
                eGenre = iGenre;
            }
        }
        if(eGenre == null){
            System.out.println("Listen here you dumbass asshole. Am i a fucking joke to you? What did i tell you to enter? Is it so hard? Is it so fucking hard, huh, motherfucker? Read the shit i asked you to do and do this one right this time dickhead");
            return;
        }
        for(Movie movie : Main.arrayList){
            if(movie.getGenre().genreRating < eGenre.genreRating){
                minGenreCount++;
            }
        }
        System.out.println("Here you go, bro. There are: " + minGenreCount + " of the less genred movies in the collection!");
        System.out.println("Enter your next command: ");
    }
    public void executeScript(String filleName){
        System.out.println("Start reading script" + filleName);
        UserInput userInput = new UserInput(filleName);
        userInput.readCommands();
        System.out.println("Script successfully executed. You may get to entering data by console");
    }
    public void exit(){
        System.exit(0);
    }
    public void filterGreaterThanGenre(String genre){
        MovieGenre eGenre = null;
        for(MovieGenre iGenre : MovieGenre.values()){
            if(genre.equals(iGenre.name())){
                eGenre = iGenre;
            }
        }
        if(eGenre == null){
            System.out.println("Listen here you dumbass asshole. Am i a fucking joke to you? What did i tell you to enter? Is it so hard? Is it so fucking hard, huh, motherfucker? Read the shit i asked you to do and do this one right this time dickhead");
            return;
        }
        System.out.println("Here is the list of better genered movies in the collection: ");
        for(Movie movie : Main.arrayList){
            if(movie.getGenre().genreRating > eGenre.genreRating){
                printMovie(movie);
                System.out.println("----------------------------------");
            }
        }
        System.out.println("That's all of them!");
        System.out.println("Enter your next command: ");
    }
    public void help(){
        for(Commands command : Commands.values()){
            System.out.println(command.commandName + ": " + command.description);
        }
        System.out.println("Enter your next command: ");
    }
    public void info(){
        System.out.println("Information about collection:");
        System.out.println("Collection size: " + Main.arrayList.size());
        System.out.println("Collection type: " + Main.arrayList.getClass());
        System.out.println("Enter your next command: ");
    }
    public void removeById(int id){
        Main.arrayList.remove(id - 1);

        for (Movie movie : Main.arrayList) {
            movie.setId(Main.arrayList.indexOf(movie) + 1);
        }
        System.out.println("Element is deleted");
        System.out.println("Enter your next command: ");
    }
    public void removeLast(){
        Main.arrayList.remove(Main.arrayList.size() - 1);
        System.out.println("The last movie of the collection is successfully removed from it");
        System.out.println("Enter your next command: ");
    }
    public void reorder(){
        Collections.reverse(Main.arrayList);
        for(Movie movie : Main.arrayList){
            movie.setId(Main.arrayList.indexOf(movie) + 1);
        }
        System.out.println("The movies in the collection reversed their order");
        System.out.println("Enter your next command: ");
    }
    public void save(){
        JSONOutput jsonOutput = new JSONOutput(Main.filleName);
        jsonOutput.writeJSON();
        System.out.println("The collection is saved to the file");
        System.out.println("Enter your next command: ");
    }
    public void show(){
        for(Movie movie : Main.arrayList){
            printMovie(movie);
            System.out.println("---------------------------------");
        }
        System.out.println("Command SHOW successfully finished");
        System.out.println("Enter your next command: ");
    }
    public void update(int id){
        Movie movie = UserInput.readMovie();
        if(movie == null){
            return;
        }
        movie.setId(id);
        movie.setCreationDate(Main.arrayList.get(id - 1).getCreationDate());
        Main.arrayList.remove(id - 1);
        Main.arrayList.add(id - 1, movie);
        System.out.println("The movie is successfully updared");
        System.out.println("Enter your next command: ");
    }


    private void printMovie(Movie movie){
        Coordinates coordinates = movie.getCoordinates();
        Person director = movie.getDirector();
        Location location = director.getLocation();

        System.out.println("The id: " + movie.getId());
        System.out.println("The name: " + movie.getName());
        System.out.println("Coordinates:");
        System.out.println("    " + coordinates.getX());
        System.out.println("    " + coordinates.getY());
        System.out.println("Created at: " + movie.getCreationDate());
        System.out.println("Got " + movie.getOscarsCount() + " oscar nominations");
        System.out.println("Movie genre is: " + movie.getGenre());
        System.out.println("MpaaRated: " + movie.getMpaaRating());
        System.out.println("Director:");
        System.out.println("    Name: " + director.getName());
        System.out.println("    Weight: " + director.getWeight());
        System.out.println("    eyeColor: " + director.getEyeColor());
        System.out.println("    Hair color: " + director.getHairColor());
        System.out.println("    Nationality: " + director.getNationality());
        System.out.println("    Location:");
        System.out.println("        X: " + location.getX());
        System.out.println("        Y: " + location.getY());
        System.out.println("        Z: " + location.getZ());
    }
}
