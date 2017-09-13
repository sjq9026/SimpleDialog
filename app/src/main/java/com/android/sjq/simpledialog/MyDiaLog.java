package com.android.sjq.simpledialog;

import android.support.annotation.LayoutRes;

/**
 * Created by Administrator on 2017/9/7.
 */

public class MyDiaLog extends BaseFragmentDialog {
    OnContentLayoutEventChangedListener listener;

    @Override
    public int initLayoutById() {
        return layoutId;
    }

    @Override
    public void setLayoutContent(ViewHolder vh,BaseFragmentDialog dialog) {
        listener.OnContentLayoutEventChanged(vh,dialog);
    }


    public MyDiaLog setLayoutId(@LayoutRes int layoutId) {
        this.layoutId = layoutId;
        return this;
    }


    public MyDiaLog setOnContentLayoutEventChangedListener(OnContentLayoutEventChangedListener listener){
        this.listener = listener;
        return this;
    }
}
