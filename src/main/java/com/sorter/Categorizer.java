package com.sorter;

import com.sorter.util.Const;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

import static com.sorter.util.Const.Category.OTHER;

public class Categorizer {

    private Settings settings;

    public Categorizer(Settings settings) {
        this.settings = settings;
    }

    public Const.Category categorize(String fileName) {
        Map<Const.Category, Long> matches = new HashMap<>();

        settings.conditions.forEach((cat, cond)-> {
            matches.put(cat, cond.stream().filter(con-> Pattern.compile(con.toUpperCase()).matcher(fileName.toUpperCase()).find()).count());
            });

        long maxMatches = Long.valueOf(0);
        Const.Category cat = OTHER;

        for(Const.Category categ : matches.keySet()) {
            if(matches.get(categ) > maxMatches) {
                maxMatches = matches.get(categ);
                cat = categ;
            }
        }
        return cat;
    }

}
