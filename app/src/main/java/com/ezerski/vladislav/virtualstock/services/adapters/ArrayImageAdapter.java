package com.ezerski.vladislav.virtualstock.services.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.ezerski.vladislav.virtualstock.services.MapReturner;
import com.ezerski.vladislav.virtualstock.services.storage.MapStorage;

public class ArrayImageAdapter<T> extends ArrayAdapter<T> {
    private Context context;

    public ArrayImageAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = context;
    }

    @Override
    public int getCount() {
        return MapStorage.VERTICAL_SIZE * MapStorage.HORIZONTAL_SIZE;
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

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
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

}
