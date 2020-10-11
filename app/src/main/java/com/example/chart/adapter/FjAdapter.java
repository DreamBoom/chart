package com.example.chart.adapter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;

import com.example.chart.R;
import com.example.chart.bean.FjBean;
import com.example.chart.utils.ActivityUtils;

import java.util.List;


public class FjAdapter extends CommonAdapter<FjBean> {
    private Activity act;

    public FjAdapter(Activity act, List<FjBean> data, int layoutId) {
        super(act, data, layoutId);
        this.act = act;
    }

    @Override
    public void convert(ViewHolder holder, FjBean data, int position) {
        holder.setText(R.id.fj, data.getName());
        holder.getView(R.id.fj).setOnClickListener(v -> {
            if (!TextUtils.isEmpty(data.getUrl())) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                Uri contentUrl = Uri.parse(data.getUrl());
                intent.setData(contentUrl);
                act.startActivity(Intent.createChooser(intent, "请选择浏览器"));
            }
        });

    }
}
