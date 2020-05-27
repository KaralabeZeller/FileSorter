package com.sorter;

import com.sorter.util.Const;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Settings {
    public Map<String, String> directories;
    public Map<Const.Category, List<String>> conditions;
    private boolean copyOnly;
    private boolean linkBack;

    public Settings() {
        this.directories = new HashMap<>();
        this.conditions = new HashMap<>();
    }

    public void addDirectory(String name, String dir) {
        directories.put(name, dir);
        System.out.println(name + " - " + dir);
    }

    public void addCondition(String category, List<String> cond ) {
        conditions.put(Const.getCategory(category), cond);
        System.out.println(Const.getCategory(category).name() + " - " + cond);
    }

    public void setCopyOnly(boolean b) {
        this.copyOnly = b;
        System.out.println("copyOnly - " + copyOnly);
    }

    public void setLinkBack(boolean b) {
        this.linkBack = b;
        System.out.println("linkBack - " + linkBack);
    }

    public String getDownloadDir() {
        return directories.get("downloadDir");
    }
}
