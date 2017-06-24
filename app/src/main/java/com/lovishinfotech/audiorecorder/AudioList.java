package com.lovishinfotech.audiorecorder;

import android.app.Activity;

/**
 * Created by Chethan on 6/23/2017.
 */

public class AudioList extends Activity {

    /*private File root;
    private ArrayList<File> fileList = new ArrayList<File>();
    private LinearLayout view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audiolist);

        view = (LinearLayout) findViewById(R.id.view);
        root = new File(Environment.getExternalStorageDirectory()
                .getAbsolutePath());
        getfile(root);

        for (int i = 0; i < fileList.size(); i++) {
            TextView textView = new TextView(this);
            textView.setText(fileList.get(i).getName());
            if (fileList.get(i).isDirectory()) {
                textView.setTextColor(Color.parseColor("#FF0000"));
            }
            view.addView(textView);
        }

    }

    public ArrayList<File> getfile(File dir) {
        File listFile[] = dir.listFiles();
        if (listFile != null && listFile.length > 0) {
            for (int i = 0; i < listFile.length; i++) {

                if (listFile[i].getName().endsWith(".wav")) {
                        fileList.add(listFile[i]);
                    }
                }


        }
        return fileList;
    }

*/
}

