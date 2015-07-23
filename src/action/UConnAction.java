package action;

import bean.Node;
import bean.Point;
import bean.UConnNode;
import utils.Constants;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Administrator on 15-7-21.
 */
public class UConnAction {
    private Point point1;
    private Point point2;

    private UConnNode node1;
    private UConnNode node2;

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

    public UConnAction()
    {
        //初始化两个节点
        point1 = new Point(Constants.SCREEN_WIDTH/2 - 20,Constants.SCREEN_HEIGHT/2);
        point2 = new Point(Constants.SCREEN_WIDTH/2 + 20,Constants.SCREEN_HEIGHT/2);
        posPair = new HashMap<Point, Point>();
        posPair.put(point1, point2);
        initUConn();
    }

    /**
     * 初始化素数
     */
    private void initUConn()
    {
        Random random = new Random();
        node1 = new UConnNode(Constants.UCONN_PRIME,random.nextInt(Constants.UCONN_PRIME));
        node2 = new UConnNode(Constants.UCONN_PRIME,random.nextInt(Constants.UCONN_PRIME));
    }

    /**
     * 初始化素数
     * @param prime 对应的素数
     */
    public void initUConn(int prime)
    {
        Random random = new Random();
        node1 = new UConnNode(prime,random.nextInt(prime));
        node2 = new UConnNode(prime,random.nextInt(prime));
    }

    /**
     * 邻居发现
     */
    public void uConnDis()
    {
        long sumSlots = node1.getPrime()*node2.getPrime();
        for(int i = 0; i<sumSlots; i++)
        {
            if(node1.getState(i)== Node.State.BEACON && node2.getState(i) == Node.State.BEACON)
            {
                latency = i;
                break;
            }
        }
    }

}
