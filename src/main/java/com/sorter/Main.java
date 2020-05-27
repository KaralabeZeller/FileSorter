package com.sorter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if(args.length == 0)
            info();

        File settingsFile = checkSettings(args[0]);
        JSONObject settingsJson = parseSettings(settingsFile);
        Settings settings = SettingsProcessor.process(settingsJson);

        new Lister(settings);
    }

    private static JSONObject parseSettings(File settingsFile) {
        JSONParser parser = new JSONParser();
        Object obj = null;
        try {
            obj = parser.parse(new FileReader(settingsFile));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = (JSONObject) obj;

        return jsonObject;
    }

    private static File checkSettings(String file) {
        try {
            FileReader fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return new File(file);
    }

    private static void info() {
        System.out.println("Usage: java -jar sorter.java <settings.json>");
        System.exit(1);
    }
}
