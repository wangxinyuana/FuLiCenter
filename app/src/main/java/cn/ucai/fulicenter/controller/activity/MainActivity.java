package cn.ucai.fulicenter.controller.activity;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import android.view.View;

import android.widget.RadioButton;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.ucai.fulicenter.R;
import cn.ucai.fulicenter.application.FuLiCenterApplication;
import cn.ucai.fulicenter.controller.fragment.BoutiqueFragment;
import cn.ucai.fulicenter.controller.fragment.NewGoodsFragment;
import cn.ucai.fulicenter.controller.fragment.PersonalFragment;
import cn.ucai.fulicenter.view.MFGT;


public class MainActivity extends AppCompatActivity {

    int index, currentIndex = 0;//之前被选中的和当前选中的
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

    Fragment[] mFragment = new Fragment[5];
    NewGoodsFragment mNewGoodsFragment;
    BoutiqueFragment mBoutiqueFragment;
    PersonalFragment mPersonalFragment;

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

        mNewGoodsFragment = new NewGoodsFragment();
        mBoutiqueFragment = new BoutiqueFragment();
        mPersonalFragment = new PersonalFragment();
        // mCategoryFragment=new CategoryFragment();

        mFragment[0] = mNewGoodsFragment;
        mFragment[1] = mBoutiqueFragment;
        mFragment[4] = mPersonalFragment;
        getSupportFragmentManager().beginTransaction()
                .add(R.id.layout_container, mNewGoodsFragment)
                .add(R.id.layout_container, mBoutiqueFragment)
                //.add(R.id.layout_container,mCategoryFragment)
                .show(mNewGoodsFragment)

                .hide(mBoutiqueFragment)
                //  .hide(mCategoryFragment)
                .commit();


    }

    public void onCheckedChange(View view) {
        switch (view.getId()) {
            case R.id.layout_newGoods:
                index = 0;
                break;
            case R.id.layout_boutique:
                index = 1;
                break;
            case R.id.layout_category:
                index = 2;
                break;
            case R.id.layout_cart:
                index = 3;
                break;
            case R.id.layout_personal_center:
                if (FuLiCenterApplication.getUser() == null) {
                    MFGT.gotoLogin(this);
                } else {
                    index = 4;
                }
                break;
        }
        if (index != currentIndex) {
            setFragment();
            setRadioStatus();
        }

    }

    private void setFragment() {
     /*   getSupportFragmentManager().beginTransaction()
        .add(R.id.layout_container,mFragment[index])
                .show(mFragment[index])
                .hide(mFragment[currentIndex])
                .commit();*/
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment fragment = mFragment[index];
        if (!fragment.isAdded()) {
            ft.add(R.id.layout_container, mFragment[index]);
        }
        ft.show(mFragment[index])
                .hide(mFragment[currentIndex])
                .commit();
    }

    private void setRadioStatus() {
        for (int i = 0; i < rbs.length; i++) {
            if (index != i) {
                rbs[i].setChecked(false);

            } else {
                rbs[i].setChecked(true);
            }
        }
        currentIndex = index;
    }

    @Override
    protected void onResume() {
        //L.Te(TAG,"onResume,currentIndex="+currentIndex+",index="+index);
        if(index==4 && FuLiCenterApplication.getUser()==null){
            index=0;
            setFragment();
            setRadioStatus();

        }
        super.onResume();
    }



}
