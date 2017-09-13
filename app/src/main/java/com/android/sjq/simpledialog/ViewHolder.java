package com.android.sjq.simpledialog;

import android.util.SparseArray;
import android.view.View;

/**
 * Created by Administrator on 2017/9/7.
 */

public class ViewHolder {
    private SparseArray<View> views;
    private View contentView;

    public ViewHolder(View view) {
        this.views = new SparseArray<>();
        this.contentView = view;
    }


    public static ViewHolder create(View view) {
        return new ViewHolder(view);
    }


    public <T extends View> T getViewById(int viewId) {
        View view = views.get(viewId);
        if(view == null){
            view = contentView.findViewById(viewId);
            views.put(viewId,view);
        }
        return (T)view;

    }


}
