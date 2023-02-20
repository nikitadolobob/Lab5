package comandHandler;

import filler.JSONOutput;
import main.Main;
import model.*;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public enum Commands {
    HELP("help", "describes all commands"),
    INFO("info", "gives data on collections"),
    SHOW("show", "demonstrates all collection elements"),
    ADD("add", "adds ellement to collection"),
    UPDATE("update", "changes element with given id"),
    REMOVE_BY_ID("remove_by_id", "removes element with given id"),
    CLEAR("clear", "makes the collection empty"),
    SAVE("save", "saves the collection to the fille"),
    EXECUTE_SCRIPT("execute_script", "executes your script from a given fille"),
    EXIT("exit", "finishes the programm without saving collection to the fille"),
    REMOVE_LAST("remove_last", "removes the last element of collection"),
    ADD_IF_MIN("add_if_min", "adds an element to collection if it is less than current collection minimum"),
    REORDER("reorder", "reverses the order of the collection"),
    COUNT_LES_THAN_GENRE("count_les_than_genre", "tells the ammount of elements whiches genre is lesser than given"),
    COUNT_GREATER_THAN_GENER("count_greater_than_gener", "tells the amount of elements with gener greater than given"),
    FILTER_GREATER_THAN_GENER("filter_greater_than_gener", "outputs the elements with gener greater than given");

    Commands(String commandName, String description) {
        this.commandName = commandName;
        this.description = description;
    }

    final public String commandName;
    final public String description;
    public String getCommandName(){
        return this.commandName;
    }
}
