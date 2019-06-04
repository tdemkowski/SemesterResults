package psksvp.GraphPlotting;

import java.awt.Rectangle;

/**
 * Created by psksvp on 18/02/2016.
 */
public class GraphPlottingApplet extends processing.core.PApplet
{
    private Rectangle viewRect;
    private int appletWidth, appletHeight;

    public GraphPlottingApplet(int appletWidth, int appletHeight, int margin)
    {
        this.appletHeight = appletHeight;
        this.appletWidth = appletWidth;
        viewRect = new Rectangle(margin, margin, appletWidth - (margin * 2), appletHeight - (margin * 2));
        this.init();
    }

    public void setup()
    {
        this.size(this.appletWidth, this.appletHeight);
        //noLoop();
    }

    public void draw()
    {
        background(255);
        fill(0, 0, 200);
        textAlign(CENTER, CENTER);
        textSize(30);
        text("No data", width/2, height/2);
    }

    public Rectangle getViewRect()
    {
        return viewRect;
    }

}
