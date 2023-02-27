package comandHandler;

import main.Main;
import model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.ZonedDateTime;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Vector;

public class UserInput {
    private static String filleName;
    public UserInput(String filleName){
        this.filleName = filleName;
    }
    public static Scanner sc;
    public UserInput(){}


    public static CommandSystem commandSystem = new CommandSystem();
    public static Controller controller = new Controller();

    private static String removeFormer(String unformedRemover){
        String[] former = unformedRemover.split(" ");
        Vector<String> vector = new Vector<>();
        for(String i : former){
            if(!i.equals(" ")){
                vector.add(i);
            }
        }
        String a = vector.get(0);
        vector.remove(vector.get(0));
        for(String i : vector){
            a += " " + i;
        }
        return a;
    }
    public void readCommands(){
        if(filleName == null) sc = new Scanner(System.in);
        else {
            try {
                sc = new Scanner(new File(filleName));
            } catch (FileNotFoundException e) {
                messageWriter("Someone should've tought you how to look for filles, 'cause such file does not exist, so use this command again except with existing file");
                return;
            }
        }

        while(sc.hasNext()){
            boolean isDumb = true;
            String s = sc.nextLine();
            String a = removeFormer(s);
            String[] vector = a.split(" ");


            /*
            CommandSystem commandSystem = new CommandSystem();
            Controller controller = new Controller();
            Command remove = new RemoveById(commandSystem, 5);

            controller.setCommand(remove);
            controller.executeCommand();
            */

            for(Commands i : Commands.values()){
                if(i.getCommandName().equals(vector[0])){
                    isDumb = false;
                    if(vector[0].equals("execute_script") || vector[0].equals("update") || vector[0].equals("remove_by_id") || vector[0].equals("count_les_than_genre") || vector[0].equals("count_greater_than_genre") || vector[0].equals("filter_greater_than_genre")){
                        if(vector.length < 2){
                            messageWriter("This command should have argument");
                            continue;
                        }
                        if(vector[0].equals("execute_script") || vector[0].equals("count_les_than_genre") || vector[0].equals("count_greater_than_genre") || vector[0].equals("filter_greater_than_genre")){
                            i.runCommand(vector[1]);
                        }
                        else{
                            try{
                                i.runCommand(Integer.parseInt(vector[1]));
                            }catch (NumberFormatException e){
                                messageWriter("Command argument must be integer");
                            }
                        }
                    }
                    else{
                        i.runCommand();
                    }
                }
            }
            if(isDumb){
                messageWriter("You entered: " + vector[0]);
                messageWriter("There is no such command you dumbAss shit. Use fucking help to learn what commands exist");
            }
        }
        if(filleName != null){
            filleName = null;
            sc = new Scanner(System.in);
        }
    }
    
    public static void messageWriter(String s){
        if(filleName == null){
            System.out.println(s);
        }
    }

    public static Movie readMovie(){

        Movie movie = new Movie();
        Main.counter = Main.arrayList.size();
        movie.setId(Main.counter + 1);

        try {
            String name = "";
            while (name.equals("")) {
                messageWriter("Enter movie name");
                name = sc.nextLine();
                messageWriter("name is " + name);
            }
            movie.setName(name);

            Integer x = null;
            while (x == null) {
                messageWriter("Enter Integer x coordinate");
                try {
                    String s = sc.nextLine();
                    x = Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    messageWriter("Hey, enter int number, you dumbass shit! I am not joking! I am gonna find you you dickhead and enter a ligit int number of bones i am gonna break in your stupid body");
                }
            }
            Float y = null;
            while (y == null || y > 208) {
                if (y == null) {
                    messageWriter("Enter Float y coordinate that is not greater 208");
                } else {
                    messageWriter("Didn't i warn you? The number MUST be NOT GREATER THAT 208! Try again and remember: I WILL FUCKING FIND YOU!");
                }
                try {
                    String s = sc.nextLine();
                    y = Float.parseFloat(s);
                } catch (NumberFormatException e) {
                    y = null;
                    messageWriter("Hey, enter float number, you dumbass shit! I am not joking! I am gonna find you dickhead and enter a ligit float number of bones i am gonna break in your stupid body");
                }
            }
            Coordinates coordinates = new Coordinates(x, y);

            movie.setCoordinates(coordinates);
            movie.setCreationDate(ZonedDateTime.now());
            Integer oscarCount = null;
            while (oscarCount == null || oscarCount < 1) {
                if (oscarCount == null) {
                    messageWriter("Enter Integer amount of oscar nominations and don't forget to fuck off if your movie has non because you MUST enter ABOVE 0");
                } else {
                    messageWriter("Seems like you forgot of something. Don't be a dick -- enter above 0");
                }
                try {
                    String s = sc.nextLine();
                    oscarCount = Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    oscarCount = null;
                    messageWriter("Hey, enter int number, you dumbass shit! I am not joking! I am gonna find you dickhead and enter a ligit int number of bones i am gonna break in your stupid body");
                }
            }
            movie.setOscarsCount(oscarCount);

            String genre = "";
            while (genre.equals("")) {
                messageWriter("Choose one of the given geners and enter it (in caps)");
                for (MovieGenre gener : MovieGenre.values()) {
                    messageWriter(gener.name());
                }
                genre = sc.nextLine();
                boolean isAnAss = true;
                for (MovieGenre gener : MovieGenre.values()) {
                    if (gener.name().equals(genre)) {
                        movie.setGenre(gener);
                        isAnAss = false;
                    }
                }
                if (isAnAss) {
                    genre = "";
                    messageWriter("You either couldn't realise how to type the exact thing i asked you to type or just are an asshole. You have a list of options. Choose one and type it precisely and in caps");
                }
            }

            String rating = null;
            boolean isAnAss = true;
            while (isAnAss && rating == null) {
                messageWriter("Choose one of the given ratings and enter it (in caps)");
                for (MpaaRating mpaaRating : MpaaRating.values()) {
                    messageWriter(mpaaRating.name());
                }
                rating = sc.nextLine();
                for (MpaaRating mpaaRating : MpaaRating.values()) {
                    if (mpaaRating.name().equals(rating)) {
                        movie.setMpaaRating(mpaaRating);
                        isAnAss = false;
                    }
                }
                if (isAnAss && !rating.equals("")) {
                    rating = null;
                    messageWriter("You either couldn't realise how to type the exact thing i asked you to type or just are an asshole. You have a list of options. Choose one and type it precisely and in caps");
                }
            }

            Person director = new Person();
            String directorName = "";
            while (directorName.equals("")) {
                messageWriter("Enter director name");
                directorName = sc.nextLine();
            }
            director.setName(directorName);

            Float weight = null;
            messageWriter("Enter Float weight that is greater 0");
            while (weight == null || weight <= 0) {
                if(weight != null){
                    messageWriter("Didn't i warn you? The number MUST be GREATER THAT 0! Try again and remember: I WILL FUCKING FIND YOU!");
                }
                try {
                    String s = sc.nextLine();
                    if (s.equals("")) break;
                    weight = Float.parseFloat(s);
                } catch (NumberFormatException e) {
                    weight = null;
                    messageWriter("Hey, enter float number, you dumbass shit! I am not joking! I am gonna find you dickhead and enter a ligit float number of bones i am gonna break in your stupid body");
                }
            }
            director.setWeight(weight);

            /*
            String rating = null;
            boolean isAnAss = true;
            while (isAnAss && rating == null) {
                messageWriter("Choose one of the given ratings and enter it (in caps)");
                for (MpaaRating mpaaRating : MpaaRating.values()) {
                    messageWriter(mpaaRating.name());
                }
                rating = sc.nextLine();
                for (MpaaRating mpaaRating : MpaaRating.values()) {
                    if (mpaaRating.name().equals(rating)) {
                        movie.setMpaaRating(mpaaRating);
                        isAnAss = false;
                    }
                }
                if (isAnAss && !rating.equals("")) {
                    rating = null;
                    messageWriter("You either couldn't realise how to type the exact thing i asked you to type or just are an asshole. You have a list of options. Choose one and type it precisely and in caps");
                }
            }
             */
            String eColour = null;
            boolean isIncorrect = true;
            while (isIncorrect && eColour == null){
                messageWriter("Choose one of the given eye colors for the director (in caps) or enter empty line to nake it null");
                for (model.colorEyes.Color color : model.colorEyes.Color.values()) {
                    messageWriter(color.name());
                }
                eColour = sc.nextLine();
                for (model.colorEyes.Color color : model.colorEyes.Color.values()) {
                    if (color.name().equals(eColour)) {
                        isIncorrect = false;
                        director.setEyeColor(color);
                    }
                }
                if(isIncorrect && !eColour.equals("")){
                    messageWriter("No such eye color. Try again or enter empty line to stay it null");
                    eColour = null;
                }
            }

            String hColour = null;
            isIncorrect = true;
            while (isIncorrect){
                messageWriter("Choose one of the given hair colors for the director (in caps)");
                for (model.colorHair.Color color : model.colorHair.Color.values()) {
                    messageWriter(color.name());
                }

                hColour = sc.nextLine();
                for (model.colorHair.Color color : model.colorHair.Color.values()) {
                    if (color.name().equals(hColour)) {
                        director.setHairColor(color);
                        isIncorrect = false;
                    }
                }
                if(isIncorrect){
                    messageWriter("No such hair color!");
                }
            }


            String countryName;
            isIncorrect = true;
            while (isIncorrect){
                messageWriter("Choose one of the given origine countries for the director (in caps)");
                for (Country country : Country.values()) {
                    messageWriter(country.name());
                }
                countryName = sc.nextLine();
                for (Country country : Country.values()) {
                    if (country.name().equals(countryName)) {
                        director.setNationality(country);
                        isIncorrect = false;
                    }
                }
                if(isIncorrect){
                    messageWriter("No such country!");
                }
            }

            Double xl = null;
            while (xl == null) {
                messageWriter("Enter double x coordinate of directors location");
                try {
                    String s = sc.nextLine();
                    xl = Double.parseDouble(s);
                } catch (NumberFormatException e) {
                    messageWriter("You should enter double value");
                }
            }


            Integer yl = null;
            while (yl == null) {
                messageWriter("Enter int y coordinate of directors location");
                try {
                    String s = sc.nextLine();
                    yl = Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    messageWriter("You should enter integer value");
                }
            }

            Float zl = null;
            while (zl == null) {
                messageWriter("Enter float z coordinate of directors location");
                try {
                    String s = sc.nextLine();
                    zl = Float.parseFloat(s);
                } catch (NumberFormatException e) {
                    messageWriter("You should enter float value");
                }
            }

            Location location = new Location(xl, yl, zl);
            director.setLocation(location);

            movie.setDirector(director);
            return movie;
        }
        catch(NoSuchElementException e){
            if(filleName != null) messageWriter("why the fuck did you give me a file, that asked me to create a movie and didn't have enough lines to let me do so? file ended earlier than it should have, so non of the unfinished data is in the collection now. So fuck off");
            return null;
        }
    }
}
