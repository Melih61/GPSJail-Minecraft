package de.maleh.gpsjail.commands;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NameHistory {
    private String name;

    private Long time;

    public NameHistory(String name, Long time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return this.name;
    }

    public Long getTime() {
        return this.time;
    }

    public String toString() {
        String s = "§6" + getName();
        if (getTime() != null) {
            s = String.valueOf(s) + "§6" + new Date(getTime().longValue());
        } else {
            s = String.valueOf(s) + "7Original";
        }
        return s;
    }

    public static List<NameHistory> getNameHistory(String uuid) {
        try {
            URL url = new URL("https://api.mojang.com/user/profiles/" + uuid + "/names");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String inputLine;
            while ((inputLine = reader.readLine()) != null)
                stringBuilder.append(inputLine);
            reader.close();
            String content = stringBuilder.toString();
            List<NameHistory> historys = new ArrayList<>();
            JsonArray jsonArray = (new JsonParser()).parse(content).getAsJsonArray();
            for (int i = 0; i < jsonArray.size(); i++) {
                NameHistory history;
                JsonObject object = jsonArray.get(i).getAsJsonObject();
                String name = object.get("name").getAsString();
                if (object.get("changedToAt") != null) {
                    Long changedAt = Long.valueOf(object.get("changeToAt").getAsLong());
                    history = new NameHistory(name, changedAt);
                } else {
                    history = new NameHistory(name, null);
                }
                historys.add(history);
            }
            if (historys.size() == 0)
                return null;
            return historys;
        } catch (Exception ex) {
            return null;
        }
    }
}
