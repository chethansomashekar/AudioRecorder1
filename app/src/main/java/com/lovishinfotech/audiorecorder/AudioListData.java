/*
package com.lovishinfotech.audiorecorder;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;

import java.io.File;
import java.util.ArrayList;

*/
/**
 * Created by Chethan on 6/23/2017.
 *//*


public class AudioListData extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audiolist);


       // final ListView lv = (ListView) findViewById(R.id.audioList);

    }

    private ArrayList<AudioData> getData() {
        ArrayList<AudioData> spacecrafts = new ArrayList<>();
        //TARGET FOLDER
        File downloadsFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);

        AudioData audioData;

        if (downloadsFolder.exists()) {
            //GET ALL FILES IN DOWNLOAD FOLDER
            File[] files = downloadsFolder.listFiles();

            //LOOP THRU THOSE FILES GETTING NAME AND URI
            for (int i = 0; i < files.length; i++) {
                File file = files[i];

                audioData = new AudioData();
                audioData.setName(file.getName());


                spacecrafts.add(audioData);
            }
        }
        return spacecrafts;

    }
}
*/
