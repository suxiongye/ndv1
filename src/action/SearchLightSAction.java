package action;

import bean.Node;
import bean.Point;
import bean.SearchLightSNode;
import utils.Constants;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Administrator on 15-7-21.
 */
public class SearchLightSAction {
    private Point point1;
    private Point point2;
    private SearchLightSNode node1;
    private SearchLightSNode node2;
    private Map<Point,Point> posPair;
    private int latency = -1;

    public Map<Point, Point> getPosPair() {
        return posPair;
    }

    public void setPosPair(Map<Point, Point> posPair) {
        this.posPair = posPair;
    }

    public int getLatency()
    {
        return latency;
    }

    public SearchLightSAction()
    {
        //初始化两个节点
        point1 = new Point(Constants.SCREEN_WIDTH/2 - 20,Constants.SCREEN_HEIGHT/2);
        point2 = new Point(Constants.SCREEN_WIDTH/2 + 20,Constants.SCREEN_HEIGHT/2);
        posPair = new HashMap<Point, Point>();
        posPair.put(point1, point2);

        initSearch();
    }

    private void initSearch()
    {
        Random random = new Random();
        node1 = new SearchLightSNode(Constants.SEARCHLIGHT_S_T,random.nextInt(Constants.SEARCHLIGHT_S_T));
        node2 = new SearchLightSNode(Constants.SEARCHLIGHT_S_T,random.nextInt(Constants.SEARCHLIGHT_S_T));
    }

    public void initSearch(int t)
    {
        Random random = new Random();
        node1 = new SearchLightSNode(t,random.nextInt(t));
        node2 = new SearchLightSNode(t,random.nextInt(t));
    }

    public void searchLightSDis()
    {
        latency = -1;
        for(int i = 0; i< Constants.SLOT_NUM_SS_GLOBAL;i++)
        {
            if(node1.getState(i)== Node.State.BEACON && node2.getState(i)==Node.State.BEACON){
                latency = i;
                break;
            }
        }
    }

}
