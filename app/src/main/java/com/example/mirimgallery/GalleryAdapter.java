package com.example.mirimgallery;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VerifiedInputEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GalleryAdapter extends BaseAdapter {
    int[] imgRes = {R.drawable.poster01, R.drawable.poster02, R.drawable.poster03, R.drawable.poster04, R.drawable.poster05,
            R.drawable.poster06,R.drawable.poster07,R.drawable.poster08,R.drawable.poster09,R.drawable.poster10,
            R.drawable.poster11,R.drawable.poster12,R.drawable.poster13,R.drawable.poster14,R.drawable.poster15,
            R.drawable.poster16, R.drawable.poster01, R.drawable.poster02, R.drawable.poster03, R.drawable.poster04
    };
    Context context;
    ImageView imgvMain;
    String[] posterTitles = {"스파이더맨", "백두산", "Eclipse", "라라랜드", "반도", "기생충", "레미제라블",
            "위대한 쇼맨", "SKYSCRAPER", "신과 함께", "친절한 금자씨", "A Hard Day", "라붐",
            "유콜잇러브", "Brave Heart", "포레스트 검프", "스파이더맨", "백두산", "Eclipse", "라라랜드"
    };

    public GalleryAdapter(Context context, ImageView imgvMain){
        this.context = context;
        this.imgvMain = imgvMain;
    }

    @Override
    public int getCount() {
        return imgRes.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imgv = new ImageView(context);
        imgv.setLayoutParams(new Gallery.LayoutParams(200, 300));
        imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imgv.setPadding(5, 5, 5, 5);
        imgv.setImageResource(imgRes[position]);
        final View toastView = View.inflate(context, R.layout.toast, null);
        final TextView textTile = toastView.findViewById(R.id.text_title);

        final int pos = position;
        imgv.setOnTouchListener(new View.OnTouchListener(){
           @Override
           public boolean onTouch(View v, MotionEvent event) {
               imgvMain.setScaleType(ImageView.ScaleType.FIT_CENTER);
               imgvMain.setImageResource(imgRes[pos]);
               Toast toast = new Toast(context);
               textTile.setText(posterTitles[pos]);
               toast.setView(toastView);
               toast.show();
               return false;
           }
        });

        return imgv;
    }
}
