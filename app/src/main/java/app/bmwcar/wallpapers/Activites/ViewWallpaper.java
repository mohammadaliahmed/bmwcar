package app.bmwcar.wallpapers.Activites;

import android.app.Activity;
import android.app.DownloadManager;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

import java.io.IOException;

import app.bmwcar.wallpapers.R;
import app.bmwcar.wallpapers.Utils.ApplicationClass;
import app.bmwcar.wallpapers.Utils.CommonUtils;


public class ViewWallpaper extends Activity {
    ImageView image;
    String url;

    LinearLayout download,home,lock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_wallpaper);

        getActionBar().hide();
        image=findViewById(R.id.image);
        url=getIntent().getStringExtra("url");
        Glide.with(this).load(url).into(image);
        download=findViewById(R.id.download);
        home=findViewById(R.id.home);
        lock=findViewById(R.id.lock);

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(url);
                DownloadManager downloadManager = (DownloadManager) ApplicationClass.getInstance().getApplicationContext().getSystemService(DOWNLOAD_SERVICE);
                DownloadManager.Request request = new DownloadManager.Request(uri);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "" + System.currentTimeMillis() + ".jpg");
                downloadManager.enqueue(request);
                CommonUtils.showToast("Saved to gallery");
            }
        });

        lock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Glide.with(ViewWallpaper.this)
                        .asBitmap()
                        .load(url)
                        .into(new CustomTarget<Bitmap>() {
                            @RequiresApi(api = Build.VERSION_CODES.N)
                            @Override
                            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                                WallpaperManager wallpaperManager = WallpaperManager.getInstance(ViewWallpaper.this);
                                try {

                                    wallpaperManager.setBitmap(resource, null, true, WallpaperManager.FLAG_LOCK);
                                    CommonUtils.showToast("Wallpaper set on lockscreen");

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }

                            @Override
                            public void onLoadCleared(@Nullable Drawable placeholder) {
                            }
                        });
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Glide.with(ViewWallpaper.this)
                        .asBitmap()
                        .load(url)
                        .into(new CustomTarget<Bitmap>() {
                            @RequiresApi(api = Build.VERSION_CODES.N)
                            @Override
                            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                                WallpaperManager wallpaperManager = WallpaperManager.getInstance(ViewWallpaper.this);
                                try {
                                    wallpaperManager.setBitmap(resource, null, true, WallpaperManager.FLAG_SYSTEM);
                                    CommonUtils.showToast("Wallpaper set on home screen");

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }

                            @Override
                            public void onLoadCleared(@Nullable Drawable placeholder) {
                            }
                        });
            }
        });

    }



}