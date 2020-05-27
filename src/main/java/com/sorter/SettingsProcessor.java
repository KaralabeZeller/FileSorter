package com.sorter;

import org.json.simple.JSONObject;

import java.util.List;

public class SettingsProcessor {

    public static Settings process(JSONObject settingsJson) {
        Settings settings = new Settings();

        // Get  top level properties
        settings.setCopyOnly((boolean)settingsJson.get("copyOnly"));
        settings.setLinkBack((boolean)settingsJson.get("linkBack"));

        settings.addDirectory("downloadDir", settingsJson.get("downloadDir").toString());

        // Get the target directories
        JSONObject targetDirs = (JSONObject) settingsJson.get("targetDirs");
        settings.addDirectory("movie", targetDirs.get("movie").toString());
        settings.addDirectory("show" , targetDirs.get("show"). toString());
        settings.addDirectory("music", targetDirs.get("music").toString());

        // Get the conditions
        JSONObject conditions = (JSONObject) settingsJson.get("conditions");
        settings.addCondition("movie", (List<String>) conditions.get("movie"));
        settings.addCondition("show" , (List<String>)conditions.get("show"));
        settings.addCondition("music", (List<String>)conditions.get("music"));
        settings.addCondition("app" ,  (List<String>)conditions.get("app"));
        settings.addCondition("text",  (List<String>)conditions.get("text"));



        return settings;
    }

}
