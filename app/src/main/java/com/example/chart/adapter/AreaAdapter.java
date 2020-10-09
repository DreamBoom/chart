package com.example.chart.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;

import com.example.chart.R;
import com.example.chart.bean.AreaBean;

import java.util.List;

public class AreaAdapter extends CommonAdapter<AreaBean.ResultBean.ListBean> {
    private Activity act;

    public AreaAdapter(Activity act, List<AreaBean.ResultBean.ListBean> data, int layoutId) {
        super(act, data, layoutId);
        this.act = act;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void convert(ViewHolder holder, AreaBean.ResultBean.ListBean data) {
        holder.setText(R.id.name,data.getAreaName());
    }
}

