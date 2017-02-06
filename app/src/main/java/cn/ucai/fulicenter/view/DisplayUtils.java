package cn.ucai.fulicenter.view;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import cn.ucai.fulicenter.R;

/**
 * Created by Administrator on 2017/1/20.
 */

public class DisplayUtils {
    public static void initBack(Activity activity){
        activity.finish();
    }
    public static void initBackWithTitle(final Activity activity,String title){
        TextView textView=(TextView) activity.findViewById(R.id.backClickArea);
        textView.setText(title);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initBack(activity);
            }
        });
    }


}
