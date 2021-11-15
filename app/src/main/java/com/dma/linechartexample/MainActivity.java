package com.dma.linechartexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LineChart mLineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLineChart = (LineChart) findViewById(R.id.line_chart);

        //for line MPAndroid
        LineDataSet lineDataSet = new LineDataSet(dataValue1(), "Line for Usage Data");
        LineDataSet lineDataSet1 = new LineDataSet(dataValue2(), "Line for Reading Data");
        lineDataSet1.setColors(Color.parseColor("#339399"));
        lineDataSet.setColors(Color.parseColor("#2AA256"));
        lineDataSet.setCircleColor(Color.parseColor("#2AA256"));
        lineDataSet1.setCircleColor(Color.parseColor("#339399"));
        lineDataSet.setCircleRadius(4);
        lineDataSet1.setCircleRadius(4);
        lineDataSet.setDrawFilled(true);
        lineDataSet.setDrawValues(false);


        //custom color
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.usage_data_color);
        lineDataSet1.setFillDrawable(drawable);

        Drawable drawable1 = ContextCompat.getDrawable(this, R.drawable.reading_data_color);
        lineDataSet.setFillDrawable(drawable1);

        lineDataSet1.setDrawFilled(true);
        //lineDataSet1.setFillColor(Color.GREEN);
        lineDataSet1.setDrawValues(false);
        lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet);
        dataSets.add(lineDataSet1);

        LineData data = new LineData(dataSets);
        mLineChart.getAxisRight().setEnabled(false);
        mLineChart.setData(data);
        mLineChart.invalidate();

        Description description = new Description();
        description.setText("");
        mLineChart.setDescription(description);


        ValueFormatter xAxisFormatter = new MyXAxisValueFormatter();

        XAxis xAxis = mLineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(true);
        xAxis.setValueFormatter(xAxisFormatter);

        ValueFormatter custom = new MyYAxisValueFormatter();
        YAxis leftAxis = mLineChart.getAxisLeft();
        leftAxis.setValueFormatter(custom);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);

        XYMarkerView mv = new XYMarkerView(this, xAxisFormatter);
        mv.setChartView(mLineChart); // For bounds control
        mLineChart.setMarker(mv); // Set the marker to the chart
    }

    private ArrayList<Entry> dataValue1(){
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(1,11));
        dataVals.add(new Entry(2,31));
        dataVals.add(new Entry(3,62));
        dataVals.add(new Entry(4,80));
        dataVals.add(new Entry(5,117));
        dataVals.add(new Entry(6,251));
        dataVals.add(new Entry(7,383));
        dataVals.add(new Entry(8,484));
        dataVals.add(new Entry(9,507));
        dataVals.add(new Entry(10,527));
        dataVals.add(new Entry(11,605));
        dataVals.add(new Entry(12,678));
        dataVals.add(new Entry(13,837));
        dataVals.add(new Entry(14,1005));
        dataVals.add(new Entry(15,1112));
        dataVals.add(new Entry(16,1182));
        dataVals.add(new Entry(17,1335));
        dataVals.add(new Entry(18,1503));

        return dataVals;
    }

    private ArrayList<Entry> dataValue2(){
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(1,666));
        dataVals.add(new Entry(2,686));
        dataVals.add(new Entry(3,717));
        dataVals.add(new Entry(4,735));
        dataVals.add(new Entry(5,772));
        dataVals.add(new Entry(6,906));
        dataVals.add(new Entry(7,1038));
        dataVals.add(new Entry(8,1138));
        dataVals.add(new Entry(9,1162));
        dataVals.add(new Entry(10,1182));
        dataVals.add(new Entry(11,1260));
        dataVals.add(new Entry(12,1333));
        dataVals.add(new Entry(13,1491));
        dataVals.add(new Entry(14,1660));
        dataVals.add(new Entry(15,1767));
        dataVals.add(new Entry(16,1837));
        dataVals.add(new Entry(17,1990));
        dataVals.add(new Entry(18,2157));

        return dataVals;
    }
}