package psksvp.GraphPlotting;

/**
 * Created by psksvp on 18/02/2016.
 */
public class BarChartApplet extends GraphPlottingApplet
{
    private float[] scaledData = null;
    private String[] labels = null;
    private int[] colors = null;

    public BarChartApplet(int appletWidth, int appletHeight)
    {
        super(appletWidth, appletHeight, 20);
    }

    public void setData(float[] data, String[] label, int[] colors)
    {
        scaledData = new float[data.length];
        for(int i = 0; i < data.length; i++)
        {
            if(0f == data[i])
                scaledData[i] = 0;
            else
            {
                scaledData[i] = map(data[i], 0f, 100f,
                        (float) getViewRect().getY(),
                        (float) getViewRect().getHeight());

                scaledData[i] = height - scaledData[i];
            }
        }
        this.labels = label;
        this.colors = colors;
        this.redraw();
    }

    public void draw()
    {
        if(null != scaledData)
        {
            background(200);
            fill(255);
            rect((float)getViewRect().getX(),
                    (float)getViewRect().getX(),
                    (float)getViewRect().getWidth(),
                    (float)getViewRect().getHeight());
            textAlign(CENTER, CENTER);
            textSize(12);
            float gapX = (float)getViewRect().getWidth() / scaledData.length;
            float px = (float)getViewRect().getX();
            for(int i = 0; i < scaledData.length; i++)
            {
                if(null != colors)
                    fill(colors[i]);
                else
                    fill(random(255), random(255), random(255));


                float py = scaledData[i];
                if(0f != scaledData[i])
                    rect(px, py, gapX, (float)getViewRect().getHeight() - py);
                if(null != labels)
                {
                    fill(0);
                    text(labels[i], px + gapX / 2, (float)getViewRect().getHeight() + 5);
                }
                px = px + gapX;
            }
        }
        else
        {
            super.draw();
        }
    }
}
