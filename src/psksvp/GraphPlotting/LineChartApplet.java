package psksvp.GraphPlotting;

/**
 * Created by psksvp on 18/02/2016.
 */
public class LineChartApplet extends GraphPlottingApplet
{
    private java.util.ArrayList<Float[]> data = new java.util.ArrayList<Float[]>();
    private java.util.ArrayList<String> labels = new java.util.ArrayList<String>();

    public LineChartApplet(int appletWidth, int appletHeight)
    {
        super(appletWidth, appletHeight, 20);
    }

    public void clearAll()
    {
        data.clear();
    }

    public void addData(float[] rawData, String label)
    {
        Float[] aSerie = new Float[rawData.length];
        for(int i = 0; i < rawData.length; i++)
        {
            aSerie[i] = map(rawData[i],
                            0f, 100f,
                            (float)getViewRect().getY(),
                            (float)getViewRect().getHeight());
            aSerie[i] = height - aSerie[i];
        }
        data.add(aSerie);
        labels.add(label);
        redraw();
    }

    public void draw()
    {
        textAlign(CENTER, CENTER);
        rect((float)getViewRect().getX(),
             (float)getViewRect().getX(),
             (float)getViewRect().getWidth(),
             (float)getViewRect().getHeight());
        for(int i = 0; i < data.size(); i++)
        {
            stroke(random(255), random(255), random(255));
            strokeWeight(3);
            drawSerie(data.get(i));
        }
    }

    private void drawSerie(Float[] s)
    {
        float gapX = (float)getViewRect().getWidth() / (s.length - 1);
        float px = (float)getViewRect().getX();
        float py = s[0];

        for(int i = 1; i < s.length; i++)
        {
            line(px, py, px + gapX, s[i]);
            px = px + gapX;
            py = s[i];
        }
    }
}
