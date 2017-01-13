package cn.ucai.fulicenter.controller.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.ucai.fulicenter.R;
import cn.ucai.fulicenter.application.I;
import cn.ucai.fulicenter.controller.adapter.GoodsAdapter;
import cn.ucai.fulicenter.model.bean.NewGoodsBean;
import cn.ucai.fulicenter.model.net.IModelNewGoods;
import cn.ucai.fulicenter.model.net.ModelNewGoods;
import cn.ucai.fulicenter.model.utils.ConvertUtils;
import cn.ucai.fulicenter.model.utils.OkHttpUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewGoodsFragment extends Fragment {

    GridLayoutManager gm;
    @BindView(R.id.tvRefreshHint)
    TextView tvRefreshHint;
    @BindView(R.id.rvNewGoods)
    RecyclerView rvNewGoods;
    @BindView(R.id.srl)
    SwipeRefreshLayout srl;

    GoodsAdapter mAdapter;
    ArrayList<NewGoodsBean> mList = new ArrayList<>();
    IModelNewGoods modelNewGoods;
    int pageId = 1;

    public NewGoodsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_goods, container, false);
        ButterKnife.bind(this, view);
        initView();
        modelNewGoods = new ModelNewGoods();
        initData(pageId);
        setListener();
        return view;
    }

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
    }

    private void setListener() {
        setPullDownListener();
        setPullUpListener();
    }

    private void setPullUpListener() {
        rvNewGoods.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int lastPosition = gm.findLastVisibleItemPosition();
                if (newState == RecyclerView.SCROLL_STATE_IDLE && mAdapter.isMore() && lastPosition == mAdapter.getItemCount() - 1) {
                    pageId++;
                    initData(pageId);
                }
            }
        });
    }


    private void setPullDownListener() {
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                srl.setRefreshing(true);
                tvRefreshHint.setVisibility(View.VISIBLE);
                pageId = 1;
                initData(I.ACTION_PULL_DOWN);
            }
        });
    }

    private void initData(final int action) {
        modelNewGoods.downData(getContext(), I.CAT_ID, pageId,
                new OkHttpUtils.OnCompleteListener<NewGoodsBean[]>() {
                    @Override
                    public void onSuccess(NewGoodsBean[] result) {
                        srl.setRefreshing(false);
                        tvRefreshHint.setVisibility(View.GONE);
                        mAdapter.setMore(result != null && result.length > 0);
                        if (!mAdapter.isMore()) {
                            if (action == I.ACTION_PULL_DOWN) {
                                mAdapter.setFooter("无更多数据");
                            }
                            return;
                        }
                        mAdapter.setFooter("加载更多数据");
                        ArrayList<NewGoodsBean> list = ConvertUtils.array2List(result);
                        switch (action) {
                            case I.ACTION_DOWNLOAD:
                                mAdapter.initData(list);
                                break;
                            case I.ACTION_PULL_DOWN:
                                mAdapter.initData(list);
                                srl.setRefreshing(false);
                                tvRefreshHint.setVisibility(View.GONE);
                                mAdapter.initData(list);
                                break;
                            case I.ACTION_PULL_UP:
                                mAdapter.addData(list);
                                break;
                        }
               /* mList.addAll(list);
                mAdapter.initData(list);*/

                    }

                    @Override
                    public void onError(String error) {

                    }
                });
    }

    private void initView() {
        srl.setColorSchemeColors(
                getResources().getColor(R.color.google_blue),
                getResources().getColor(R.color.google_green),
                getResources().getColor(R.color.google_yellow),
                getResources().getColor(R.color.google_red));
        gm = new GridLayoutManager(getContext(), I.COLUM_NUM);
        rvNewGoods.setLayoutManager(gm);
        rvNewGoods.setHasFixedSize(true);
        // rvNewGoods.addItemDecoration(new SpaceItemDecoration(20));
        mAdapter = new GoodsAdapter(getContext(), mList);
        rvNewGoods.setAdapter(mAdapter);

    }

}
