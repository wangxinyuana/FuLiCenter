package cn.ucai.fulicenter.controller.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.ucai.fulicenter.R;
import cn.ucai.fulicenter.controller.fragment.NewGoodsFragment;

public class MainActivity extends AppCompatActivity {
    int index, currentIndex;
    // RadioButton rbNewGoods, rbBoutique, rbCategory, rbCart, rbPersonal;
    RadioButton[] rbs = new RadioButton[5];
    @BindView(R.id.layout_newGoods)
    RadioButton layoutNewGoods;
    @BindView(R.id.layout_boutique)
    RadioButton layoutBoutique;
    @BindView(R.id.layout_category)
    RadioButton layoutCategory;
    @BindView(R.id.layout_cart)
    RadioButton layoutCart;
    @BindView(R.id.layout_personal_center)
    RadioButton layoutPersonalCenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //rbNewGoods = (RadioButton) findViewById(R.id.layout_newGoods);
        // rbBoutique = (RadioButton) findViewById(R.id.layout_boutique);
        //rbCategory = (RadioButton) findViewById(R.id.layout_category);
        //rbCart = (RadioButton) findViewById(R.id.layout_cart);
        //rbPersonal = (RadioButton) findViewById(R.id.layout_personal_center);
        rbs[0] = layoutNewGoods;
        rbs[1] = layoutBoutique;
        rbs[2] = layoutCategory;
        rbs[3] = layoutCart;
        rbs[4] = layoutPersonalCenter;
        getSupportFragmentManager().beginTransaction()
                .add(R.id.layout_goods, new NewGoodsFragment()).commit();

    }
    public void onCheckedChanged(View view){
        switch (view.getId()){
            case R.id.layout_newGoods:
                index = 0;
                break;
            case R.id.layout_boutique:
                index = 1;
                break;
            case R.id.layout_category:
                index = 3;
                break;
            case R.id.layout_personal_center:
                index = 4;
                break;
        }
        if(index!=currentIndex){
            for(int i=0;i<rbs.length;i++){
                if(index !=i){
                    rbs[i].setChecked(false);
                }else{
                    rbs[i].setChecked(true);
                }
            }
            currentIndex=index;
        }
    }
}
