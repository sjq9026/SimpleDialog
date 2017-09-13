package com.android.sjq.simpledialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Administrator on 2017/9/7.
 */

public  abstract class BaseFragmentDialog extends DialogFragment {


    private int margin = 10;//左右边距
    private int width;//宽度
    private int height;//高度
    private float dimAmount = 0.5f;//灰度深浅
    private boolean showBottom;//是否底部显示
    private boolean outCancel = true;//是否点击外部取消
    @StyleRes
    private int animStyle;
    @LayoutRes
    protected int layoutId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layoutId = initLayoutById();
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.NiceDialog);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(layoutId, container, false);

        setLayoutContent(ViewHolder.create(view),this);
        return view;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        initParams();
    }


    private void initParams() {
        Window window = getDialog().getWindow();
        if (window != null) {
            WindowManager.LayoutParams lp = window.getAttributes();
            //调节灰色背景透明度[0-1]，默认0.5f
            lp.dimAmount = dimAmount;
            //是否在底部显示
            if (showBottom) {
                lp.gravity = Gravity.BOTTOM;
                if (animStyle == 0) {
                    animStyle = R.style.DefaultAnimation;
                }
            }

            //设置dialog宽度
            if (width == 0) {
                lp.width = Utils.getScreenWidth(getContext()) - 2 * Utils.dp2px(getContext(), margin);
            } else {
                lp.width = Utils.dp2px(getContext(), width);
            }
            //设置dialog高度
            if (height == 0) {
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            } else {
                lp.height = Utils.dp2px(getContext(), height);
            }

            //设置dialog进入、退出的动画
            window.setWindowAnimations(animStyle);
            window.setAttributes(lp);
        }
        setCancelable(outCancel);
    }

    public BaseFragmentDialog setMargin(int margin) {
        this.margin = margin;
        return this;
    }

    public BaseFragmentDialog setWidth(int width) {
        this.width = width;
        return this;
    }

    public BaseFragmentDialog setHeight(int height) {
        this.height = height;
        return this;
    }

    public BaseFragmentDialog setDimAmount(float dimAmount) {
        this.dimAmount = dimAmount;
        return this;
    }

    public BaseFragmentDialog setShowBottom(boolean showBottom) {
        this.showBottom = showBottom;
        return this;
    }

    public BaseFragmentDialog setOutCancel(boolean outCancel) {
        this.outCancel = outCancel;
        return this;
    }

    public BaseFragmentDialog setAnimStyle(@StyleRes int animStyle) {
        this.animStyle = animStyle;
        return this;
    }

    public BaseFragmentDialog show(FragmentManager manager) {
        super.show(manager, String.valueOf(System.currentTimeMillis()));
        return this;
    }



    public abstract int initLayoutById();

    public abstract void setLayoutContent(ViewHolder vh , BaseFragmentDialog dialog);


}
