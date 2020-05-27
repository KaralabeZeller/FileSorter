package com.sorter;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lister {

    private Settings settings;
    private List<String> files;
    private List<DlEntry> categorized;


    public Lister(Settings settings) {
        this.settings = settings;

        files = list();
        Collections.sort(files);

        categorize();
        print();
    }

    private void categorize() {
        categorized = new ArrayList<>();
        files.forEach(f->categorized.add(new DlEntry(f, settings)));
    }


    public List<String> list() {

        Set<String> fileSet = Stream.of(new File(settings.getDownloadDir()).listFiles())
                .map(File::getPath)
                .collect(Collectors.toSet());

        return new ArrayList<String>(fileSet);
    }

    public void print() {

        categorized.forEach(file-> {
            if (file.getRoot().length() > 80) {
                System.out.printf("%-80s : %5s%n", file.getRoot().substring(0, 80), file.getCategory());
            } else {
                System.out.printf("%-80s : %5s%n", file.getRoot(), file.getCategory());
            }
        });
    }
}
