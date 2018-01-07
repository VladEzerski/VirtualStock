package com.ezerski.vladislav.virtualstock.services.adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.ezerski.vladislav.virtualstock.services.MapReturner;


public class ImageAdapter extends BaseAdapter {
    private Context context;

    public ImageAdapter(Context cont) {
        context = cont;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(90, 90));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(new MapReturner().provideImageId(position));
        return imageView;
    }

    public void rewrite(){
        this.notifyDataSetChanged();
    }
}
