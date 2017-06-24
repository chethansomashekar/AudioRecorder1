package com.lovishinfotech.audiorecorder;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Chethan on 6/24/2017.
 */

public class SecondActivity  extends Activity {


   /* CustomerAdapter customerAdapter;
    private ArrayList<File> fileList = new ArrayList<>();
    ArrayList<File> arr2;
    ListView listView;

    @SuppressLint("SdCardPath")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audiolist);
        ArrayList<File> arr1 = GetFiles(Environment.getExternalStorageDirectory()+AudioRecorder.getPath());
        customerAdapter = new CustomerAdapter(this, 0, arr1);
        listView = (ListView) findViewById(R.id.audioist);
        listView.setAdapter(customerAdapter);
    }

    private ArrayList<File> GetFiles(String path) {
        arr2 = new ArrayList<>();
        File file = new File(path);
        File[] allfiles = file.listFiles();
        if (allfiles != null && allfiles.length > 0) {
            for (int i = 0; i < allfiles.length; i++) {

                if (allfiles[i].getName().endsWith(".wav")) {

                    arr2.add(allfiles[i]);
                }
            }



        }

        return arr2;
    }*/
   ListView musiclist;
    Cursor musiccursor;
    int music_column_index;
    int count;
    MediaPlayer mMediaPlayer;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audiolist);
        init_phone_music_grid();
    }

    private void init_phone_music_grid() {
        System.gc();
        String[] proj = { MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.DISPLAY_NAME,
                MediaStore.Video.Media.SIZE };
        musiccursor = managedQuery(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                proj, null, null, null);
        count = musiccursor.getCount();
        musiclist = (ListView) findViewById(R.id.audioist);
        musiclist.setAdapter(new MusicAdapter(getApplicationContext()));

        musiclist.setOnItemClickListener(musicgridlistener);
        mMediaPlayer = new MediaPlayer();
    }

    private AdapterView.OnItemClickListener musicgridlistener = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position,
                                long id) {
            System.gc();
            music_column_index = musiccursor
                    .getColumnIndexOrThrow(MediaStore.Audio.Media.DATA);
            musiccursor.moveToPosition(position);
            String filename = musiccursor.getString(music_column_index);

            try {
                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.reset();
                }
                mMediaPlayer.setDataSource(filename);
                mMediaPlayer.prepare();
                mMediaPlayer.start();
            } catch (Exception e) {

            }
        }
    };

    public class MusicAdapter extends BaseAdapter {
        private Context mContext;

        public MusicAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return count;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            System.gc();
            TextView tv = new TextView(mContext.getApplicationContext());
            String id = null;
            if (convertView == null) {
                music_column_index = musiccursor
                        .getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME);
                musiccursor.moveToPosition(position);
                id = musiccursor.getString(music_column_index);
                music_column_index = musiccursor
                        .getColumnIndexOrThrow(MediaStore.Audio.Media.SIZE);
                musiccursor.moveToPosition(position);
                id += " Size(KB):" + musiccursor.getString(music_column_index);
                tv.setText(id);
            } else
                tv = (TextView) convertView;
            return tv;
        }
    }
}

