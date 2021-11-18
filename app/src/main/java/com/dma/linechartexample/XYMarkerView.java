
package com.dma.linechartexample;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.widget.TextView;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;

import java.text.DecimalFormat;

@SuppressLint("ViewConstructor")
public class XYMarkerView extends MarkerView {

    private final TextView txtDate, txtReading;
    private final ValueFormatter xAxisValueFormatter;

    private final DecimalFormat format;

    public XYMarkerView(Context context, ValueFormatter xAxisValueFormatter) {
        super(context, R.layout.custom_marker_view);

        this.xAxisValueFormatter = xAxisValueFormatter;
        txtDate = findViewById(R.id.txtDate);
        txtReading = findViewById(R.id.txtReading);
        format = new DecimalFormat("###");
    }

    // runs every time the MarkerView is redrawn, can be used to update the
    // content (user-interface)
    @Override
    public void refreshContent(Entry e, Highlight highlight) {

        txtDate.setText(String.format("Date: %s", format.format(e.getX())));
        txtReading.setText(String.format("Value: %s", xAxisValueFormatter.getFormattedValue(e.getY())));

        super.refreshContent(e, highlight);
    }

    @Override
    public MPPointF getOffset() {
        return new MPPointF(-(getWidth() / 2), -getHeight());
    }
}
