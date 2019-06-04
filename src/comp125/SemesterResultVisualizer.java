package comp125;

import psksvp.GraphPlotting.BarChartApplet;
import psksvp.GraphPlotting.LineChartApplet;
import psksvp.GraphPlotting.PieChartApplet;

import javax.swing.*;
import java.awt.*;

/**
 * Created by psksvp on 14/03/2016.
 */
public class SemesterResultVisualizer
{
    private JFrame frameWnd;
    //private LineChartApplet lineChart = new LineChartApplet(400, 200);
    private PieChartApplet pieChart = new PieChartApplet(250, 250);
    private BarChartApplet barChart = new BarChartApplet(250, 250);
    private BarChartApplet barFreqChart = new BarChartApplet(250, 250);

    public SemesterResultVisualizer(SemesterResult sr)
    {
        frameWnd = new JFrame("Marks Visualization");
        frameWnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameWnd.setLayout(new GridLayout(3, 1));
        frameWnd.setVisible(true);
        //frameWnd.add(lineChart);
        frameWnd.add(pieChart);
        frameWnd.add(barChart);
        frameWnd.add(barFreqChart);

        float[] resultData = new float[sr.getMarks().length];
        if(null != resultData)
        {
            float sum = 0f;
            for (int i = 0; i < resultData.length; i++)
            {
                resultData[i] = (float) sr.getMark(i);
                sum = sum + resultData[i];
            }

            float[] pieData = new float[resultData.length];
            for (int i = 0; i < resultData.length; i++)
                pieData[i] = (resultData[i] * 100) / sum;

            int[] colors = new int[pieData.length];
            
            colors[0] = pieChart.color(255, 0, 0);
    		colors[1] = pieChart.color(0, 255, 0);
    		colors[2] = pieChart.color(0, 0, 255);
    		colors[3] = pieChart.color(240, 240, 80);

            pieChart.setData(pieData, sr.getGrades(), colors);
            barChart.setData(resultData, sr.getGrades(), colors);

            ////////
            String[] possibleGrades = {"F", "P", "Cr", "D", "HD"};
            float[] gradeFreqData = new float[possibleGrades.length];
            for(int i = 0; i < possibleGrades.length; i++)
                gradeFreqData[i] = sr.count(possibleGrades[i]) * 25f;

            int[] freqColors = new int[possibleGrades.length];
            for (int i = 0; i < freqColors.length; i++)
                freqColors[i] = barFreqChart.color(pieChart.random(255), pieChart.random(255), pieChart.random(255));
            barFreqChart.setData(gradeFreqData, possibleGrades, freqColors);
        }


        frameWnd.pack();
        frameWnd.setResizable(false);

    }
}
