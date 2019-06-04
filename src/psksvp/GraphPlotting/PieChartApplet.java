package psksvp.GraphPlotting;

/**
 * Created by psksvp on 18/02/2016.
 */
public class PieChartApplet extends GraphPlottingApplet
{
    private float[] scaledData = null;
    private String[] labels = null;
    private int[] colors = null;

    public PieChartApplet(int appletWidth, int appletHeight)
    {
        super(appletWidth, appletHeight, 20);
    }

    /**
     *
     * @param data
     * @param label
     */
    public void setData(float[] data, String[] label, int[] colors)
    {
        scaledData = new float[data.length];
        for(int i = 0; i < data.length; i++)
        {
            scaledData[i] = map(data[i], 0, 100, 0, 360);
        }
        labels = label;
        this.colors = colors;
        this.redraw();
    }


    public void draw()
    {
        if(null != scaledData)
        {
            background(200);
            textAlign(LEFT, CENTER);
            textSize(12);
            float centerX = width / 2;
            float centerY = height / 2;
            float startAngle = 0;
            float ly = 5;
            for(int i = 0; i < scaledData.length; i++)
            {
                //float fillColor = 255 - map(i, 0, scaledData.length, 0, 255);
                //fill(fillColor);
                if(null != colors)
                    fill(colors[i]);
                else
                    fill(random(255), random(255), random(255));
                float endAngle =  startAngle + radians(scaledData[i]);
                arc(centerX, centerY,
                    (float)getViewRect().getWidth(), (float)getViewRect().getHeight(),
                    startAngle, endAngle);
                startAngle = endAngle;
                if(null != labels)
                {
                    ellipse(5, ly, 10, 10);
                    fill(0);
                    text(labels[i], 15, ly);
                    ly = ly + 15;
                }
            }
        }
        else
        {
            super.draw();
        }
    }
}
