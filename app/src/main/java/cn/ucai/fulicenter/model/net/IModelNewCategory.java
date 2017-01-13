package cn.ucai.fulicenter.model.net;

import android.content.Context;

import cn.ucai.fulicenter.model.bean.CategoryChildBean;
import cn.ucai.fulicenter.model.bean.CategoryGroupBean;


/**
 * Created by Administrator on 2017/1/11 0011.
 */

public interface IModelNewCategory {
    void downData(Context context, OnCompleteListener<CategoryGroupBean[]>listener);
    void downDate(Context context, int parentId, OnCompleteListener<CategoryChildBean[]>listener);
}
