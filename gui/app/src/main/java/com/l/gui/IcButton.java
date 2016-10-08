package com.l.gui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.widget.Button;

public class IcButton extends Button {

    public IcButton(final Context context) {
        super(context, null, R.attr.icButtonStyle);
    }

    public IcButton(final Context context, final AttributeSet attrs) {
        super(context, attrs, R.attr.icButtonStyle);
        init(attrs, R.attr.icButtonStyle);
    }

    public IcButton(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, R.attr.icButtonStyle);
        init(attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public IcButton(final Context context, final AttributeSet attrs, final int defStyleAttr, final int defStyleRes) {
        super(context, attrs, R.attr.icButtonStyle, defStyleRes);
        init(attrs, defStyleAttr);
    }

    private void init(final AttributeSet attrs, final int defStyleAttr) {
        final TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs,
                R.styleable.IcButtonStyle, defStyleAttr, 0);
        try {
            final AppCompatDrawableManager drawableManager = AppCompatDrawableManager.get();
            int id;
            Drawable rightIcon = a.getDrawableIfKnown(R.styleable.IcButtonStyle_rightIcon),
                    topIcon = a.getDrawableIfKnown(R.styleable.IcButtonStyle_topIcon),
                    botIcon = a.getDrawableIfKnown(R.styleable.IcButtonStyle_botIcon),
                    leftIcon = a.getDrawableIfKnown(R.styleable.IcButtonStyle_leftIcon);

            id = a.getResourceId(R.styleable.IcButtonStyle_rightIcon, -1);
            if (id != -1) {
                rightIcon = drawableManager.getDrawable(getContext(), id);
            }
            id = a.getResourceId(R.styleable.IcButtonStyle_topIcon, -1);
            if (id != -1) {
                topIcon = drawableManager.getDrawable(getContext(), id);
            }
            id = a.getResourceId(R.styleable.IcButtonStyle_botIcon, -1);
            if (id != -1) {
                botIcon = drawableManager.getDrawable(getContext(), id);
            }
            id = a.getResourceId(R.styleable.IcButtonStyle_leftIcon, -1);
            if (id != -1) {
                leftIcon = drawableManager.getDrawable(getContext(), id);
            }
            setCompoundDrawablesWithIntrinsicBounds(leftIcon, topIcon, rightIcon, botIcon);
        } finally {
            a.recycle();
        }
    }
}
