package view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
    protected String command;

    public Matcher getCommandMatcher(String command, String regex){
        Matcher matcher = Pattern.compile(regex).matcher(command);
        return matcher.matches() ? matcher : null;
    }
}