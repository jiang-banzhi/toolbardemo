package com.banzhi.toolbardemo;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.support.v4.view.ActionProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/5/26 0026.
 */

public class CustomActionProvider extends ActionProvider {

    /**
     * Creates a new instance.
     *
     * @param context Context for accessing resources.
     */
    public CustomActionProvider(Context context) {
        super(context);
    }

    TextView mTitle;
    ImageView mIcon;

    @Override
    public View onCreateActionView() {
        //读取support下Toolbar/ActionBar的高度，为了让这个Menu高和宽和系统的menu达到一致
        int size = getContext().getResources().getDimensionPixelSize(
                android.support.design.R.dimen.abc_action_bar_default_height_material);

        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(size, size);
        View view = LayoutInflater.from(getContext())
                .inflate(R.layout.layout_menu_provider, null, false);
        view.setLayoutParams(layoutParams);
        mTitle = view.findViewById(R.id.tv_title);
        mIcon = view.findViewById(R.id.iv_image);
        view.setOnClickListener(mOnClickListener);
        return view;
    }

    public void setIcon(@DrawableRes int resId) {
        mIcon.setImageResource(resId);
    }

    public void setText(@StringRes int resId) {
        mTitle.setText(resId);
    }

    public void setText(CharSequence text) {
        mTitle.setText(text);
    }

    View.OnClickListener mOnClickListener;

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }
}
