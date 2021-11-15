package com.dma.linechartexample;

import com.github.mikephil.charting.formatter.ValueFormatter;

import java.text.DecimalFormat;

public class MyXAxisValueFormatter extends ValueFormatter {

    private final DecimalFormat mFormat;

    public MyXAxisValueFormatter() {
        mFormat = new DecimalFormat("###,###,###,##0");
    }

    @Override
    public String getFormattedValue(float value) {
        return mFormat.format(value);
    }

}
