package com.zhangke.pulltorefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by ZhangKe on 2016/8/17.
 */
public class PullToRefreshView extends LinearLayout {

    private Context context;

    private View header;
    private ProgressBar progressBar;
    private ImageView arrow;
    private TextView description;
    private TextView updateAt;

    private ListView listView;

    public PullToRefreshView(Context context, AttributeSet attrs){
        super(context,attrs);
        this.context=context;
        header= LayoutInflater.from(context).inflate(R.layout.pull_to_refresh,null);
        progressBar=(ProgressBar) header.findViewById(R.id.progress_bar);
        arrow=(ImageView) header.findViewById(R.id.arrow);
        description=(TextView) header.findViewById(R.id.description);
        updateAt=(TextView) header.findViewById(R.id.updated_at);

        setOrientation(VERTICAL);
        addView(header, 0);
    }

    //此方法应该是绘制界面时调用，启动时调用两次，屏幕由熄屏启动时调用一次。
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        for(int i=0;i<getChildCount();i++){
            try{
                listView=(ListView)getChildAt(i);

            }catch(Exception e){
                Log.e("TAG","onLayout->getChildAt->Exception:"+getChildAt(i).toString());
            }
        }
    }
}
