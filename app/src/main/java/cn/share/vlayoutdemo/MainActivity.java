package cn.share.vlayoutdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.OnePlusNLayoutHelper;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.share.vlayoutdemo.adapter.OneToNAdapter;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_list)
    RecyclerView rvList;

    private ArrayList<String> goodSrc = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        VirtualLayoutManager layoutManager = new VirtualLayoutManager(this);
        rvList.setLayoutManager(layoutManager);
//        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
//        rvList.setRecycledViewPool(viewPool);
//        viewPool.setMaxRecycledViews(0, 20);

        DelegateAdapter adapters = new DelegateAdapter(layoutManager, false);

        initOnePlusData();
        OnePlusNLayoutHelper helper3 = new OnePlusNLayoutHelper(20);
        helper3.setBgColor(Color.WHITE);
        helper3.setColWeights(new float[]{38f});
        helper3.setRowWeight(55f);
//        helper3.setMargin(10, 20, 10, 20);
//        helper3.setPadding(10, 10, 10, 10);
        adapters.addAdapter(new OneToNAdapter(this,goodSrc, helper3));
        rvList.setAdapter(adapters);
    }

    private void initOnePlusData() {
        goodSrc.add("http://file.17gwx.com/sqkb/element/2018/04/08/806925ac988a9b118b.jpg");
        goodSrc.add("http://file.17gwx.com/sqkb/element/2018/04/08/592375ac9df48c0d7e.jpg");
        goodSrc.add("http://file.17gwx.com/sqkb/element/2018/04/08/935985ac986197d37f.jpeg");
        goodSrc.add("http://file.17gwx.com/sqkb/element/2017/12/25/873915a40f33db8d55.jpg");
    }
}