package action;

import bean.BirthdayNode;
import bean.DiscoNode;
import bean.Node;
import bean.Point;
import utils.Constants;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Administrator on 15-7-21.
 */
public class DiscoAction {

    private Point point1;
    private Point point2;

    private DiscoNode node1;
    private DiscoNode node2;

    private Map<Point,Point> posPair;



    private int latency = -1;



    public Map<Point, Point> getPosPair() {
        return posPair;
    }
    public void setPosPair(Map<Point, Point> posPair) {
        this.posPair = posPair;
    }
    public void setLatency(int latency)
    {
        this.latency = latency;
    }
    public int getLatency()
    {
        return latency;
    }
    public DiscoAction()
    {

        posPair = new HashMap<Point, Point>();
        point1 = new Point(Constants.SCREEN_WIDTH/2 - 20,Constants.SCREEN_HEIGHT/2);
        point2 = new Point(Constants.SCREEN_WIDTH/2 + 20,Constants.SCREEN_HEIGHT/2);
        posPair.put(point1, point2);
        initDis();
    }

    public void initDis()
    {
        Random random = new Random();
        //设置参数（两个质数，开始时间）
        int i = random.nextInt(Constants.DISCO_PRIME2);
        node1 = new DiscoNode(Constants.DISCO_PRIME1,Constants.DISCO_PRIME2,i);
        i = random.nextInt(Constants.DISCO_PRIME2);
        node2 = new DiscoNode(Constants.DISCO_PRIME1,Constants.DISCO_PRIME2,i);
    }

    public void initDis(int prime1,int prime2)
    {
        Random random = new Random();
        //设置参数（两个质数，开始时间）
        int i = random.nextInt(prime1);
        node1 = new DiscoNode(prime1,prime2,i);
        i = random.nextInt(prime2);
        node2 = new DiscoNode(prime1,prime2,i);
    }

    public void discoDis()
    {
        latency = -1;
        for(int i = 0; i<Constants.SLOT_NUM_DISCO_GLOBAL;i++){
            if ((node1.getState(i) == Node.State.BEACON)&&(node2.getState(i) == Node.State.BEACON))
            {
                latency = i;
                break;
            }
        }
    }
}
