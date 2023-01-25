import org.apache.commons.cli.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

public class Main {
    public static CommandLine parseArguments(String[] args) {
        try {
            final Options options = new Options();
            OptionGroup mode = new OptionGroup();
            mode.addOption(new Option("a", "Ascending"));
            mode.addOption(new Option("d", "Descending"));
            OptionGroup type = new OptionGroup();
            type.addOption(new Option("i", "Integer"));
            type.addOption(new Option("s", "String"));
            type.setRequired(true);

            options.addOptionGroup(mode);
            options.addOptionGroup(type);
            CommandLineParser parser = new DefaultParser();
            return parser.parse(options, args);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        var commandLine = parseArguments(args);
        if (commandLine == null) {
            System.err.println("Command line is wrong!");
        }
        if (commandLine.getArgList().size() < 2) {
            System.err.println("Too few parameters!");
        }
        String file = commandLine.getArgs()[0];
        LinkedList<String> inputFiles = (LinkedList<String>) commandLine.getArgList();
        inputFiles.remove(0);
        Sorter sorter;
        int mode = 1;
        if (commandLine.hasOption("d")) {
            mode = -1;
        }
        if (commandLine.hasOption("i")) {
            sorter = new Sorter(inputFiles, file, Integer.class, mode);
        }
        else {
            sorter = new Sorter(inputFiles, file, String.class, mode);
        }
        sorter.Sort();
    }
}