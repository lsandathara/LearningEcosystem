package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

class Relativelayout extends View {
    public Relativelayout(Context context) {
        this(context, null);
    }

    public Relativelayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Relativelayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
