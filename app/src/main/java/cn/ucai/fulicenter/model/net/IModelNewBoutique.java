package cn.ucai.fulicenter.model.net;

import android.content.Context;

import cn.ucai.fulicenter.model.bean.CategoryChildBean;
import cn.ucai.fulicenter.model.bean.BoutiqueBean;
import cn.ucai.fulicenter.model.utils.OkHttpUtils;


/**
 * Created by Administrator on 2017/1/11 0011.
 */

public interface IModelNewBoutique {


    void downData(Context context, OkHttpUtils.OnCompleteListener<BoutiqueBean[]> Listener);
}
