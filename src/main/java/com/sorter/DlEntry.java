package com.sorter;

import com.sorter.util.Const;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.sorter.util.Const.Category.APP;
import static com.sorter.util.Const.Category.OTHER;

public class DlEntry {

    private Categorizer categorizer;

    private File root;
    private List<File> files;

    private Const.Category category;
    private boolean isFile;

    public DlEntry(String root, Settings settings) {
        this.root = new File(root);
        this.category = OTHER;
        categorizer = new Categorizer(settings);
        checkFile();

        fillFiles();
        setCategory(settings);

    }

    private void checkFile() {
        if(!root.exists())
            System.err.println(root + " does not exist");
        if(root.isFile())
            setFile(true);
        else
            setFile(false);

    }

    private void fillFiles() {
        if(root.isDirectory()) {
            files = Arrays.asList(root.listFiles());
        }
    }


    public void setCategory(Settings settings) {
        this.category = categorizer.categorize(root.getName());
    }

    public String getRoot() {
        return root.getName();
    }

    public String getCategory() {
        return category.name();
    }

    private void setFile(boolean b) {
        this.isFile = b;
    }
}

