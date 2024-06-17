package app.bmwcar.wallpapers.Activites;


import android.app.Activity;
import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import app.bmwcar.wallpapers.Adapters.WallpaperAdapter;
import app.bmwcar.wallpapers.R;


public class Splash extends Activity {

    RecyclerView recycler;
    WallpaperAdapter adapter;
    List<String> itemList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        if (getActionBar() != null) {
            getActionBar().hide();
        }

        recycler = findViewById(R.id.recycler);
        setupList();
        recycler.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new WallpaperAdapter(this, itemList);
        recycler.setAdapter(adapter);

    }

    private void setupList() {
        for (int i = 1; i <= 32; i++) {
            itemList.add("https://firebasestorage.googleapis.com/v0/b/logoiq.appspot.com/o/bmw%2F" + i + ".jpg?alt=media&token=6a0128df-ec6c-4b21-9725-f9df56a12aaf");
        }
        Collections.shuffle(itemList);

    }
//bmwcar

}

