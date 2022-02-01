package com.example.app.network;

import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;

import com.google.gson.Gson;
import com.example.app.R;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AnnounceEntry {
    private static final String TAG = AnnounceEntry.class.getSimpleName();

    public final String title;
    public final Uri dynamicUrl;
    public final String url;
    public final String content;

    public AnnounceEntry(String title, String dynamicUrl, String url, String content) {
        this.title = title;
        this.dynamicUrl = Uri.parse(dynamicUrl);
        this.url = url;
        this.content = content;
    }

    public static List<AnnounceEntry> initAnnounceEntryList (Resources resources) {
        InputStream inputStream = resources.openRawResource(R.raw.announces_list);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            int pointer;
            while ((pointer = reader.read(buffer)) != -1) {
                writer.write(buffer, 0 , pointer);
            }
        } catch (IOException exception){
            Log.e(TAG, "Hubo un error al momento de leer y escribir el archivo JSON", exception);
        } finally {
            try {
                inputStream.close();
            } catch (IOException exception) {
                Log.e(TAG, "Hubo un error al cerrar el input stream", exception);
            }
        }

        String jsonAnnouncesString = writer.toString();
        Gson gson = new Gson();
        Type announceListType = new TypeToken<ArrayList<AnnounceEntry>>(){
        }.getType();

        return gson.fromJson(jsonAnnouncesString, announceListType);
    }
}