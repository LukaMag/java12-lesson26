package CLASSWORK26;


import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileServise {
        private static final Path pathRecords = Paths.get("dataBase.json");
        private static final Gson gson = new Gson();

        public static Database[] readFile(){
            String jsonTracks;
            try {
                jsonTracks = Files.readString(pathRecords);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return gson.fromJson(jsonTracks, Database[].class);
        }
    }
