package com.dma.linechartexample;

import com.github.mikephil.charting.formatter.ValueFormatter;

import java.text.DecimalFormat;

public class MyYAxisValueFormatter extends ValueFormatter {

    private final DecimalFormat mFormat;

    public MyYAxisValueFormatter() {
        mFormat = new DecimalFormat("###,###,###,##0.0");
    }

    @Override
    public String getFormattedValue(float value) {
        return mFormat.format(value);
    }

}
