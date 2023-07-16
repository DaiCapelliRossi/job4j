package ru.job4j.cache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DirFileCache extends AbstractCache<String, String> {
    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(cachingDir + key));
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : lines) {
            stringBuilder.append(s).append("\n");
        }

        return stringBuilder.toString();
    }

}
