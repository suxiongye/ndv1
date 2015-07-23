package action;

import bean.BirthdayNode;
import bean.Node;
import bean.Point;
import utils.Constants;

import java.util.*;

/**
 * Created by Administrator on 15-7-21.
 */
public class BirthdayAction {

    //记录节点(用于判断发送状态)
    private ArrayList<BirthdayNode> nodeList;
    //记录位置（用于画图）
    private ArrayList<Point> pointList;
    //记录节点和位置对（用于获取对应位置的节点）
    private Map<BirthdayNode, Point> nodePointPairs;
    //记录已经连接的节点对
    private Map<Point,Point> posPair;
    //记录延时
    private int latency = -1;
    //结点个数
    private int nodeNum = 0;

    public void setLatency(int latency)
    {
        this.latency = latency;
    }
    public int getLatency()
    {
        return this.latency;
    }
    public void setNodeNum(int nodeNum)
    {
        this.nodeNum = nodeNum;
    }

    public int getNodeNum()
    {
        return nodeNum;
    }

    public BirthdayAction(int nodeNum)
    {
        //初始化
        this.nodeNum = nodeNum;
        nodeList = new ArrayList<BirthdayNode>();
        pointList = new ArrayList<Point>();
        nodePointPairs = new HashMap<BirthdayNode, Point>();

        //撒节点
        pointList = getRandomPosList(nodeNum);

        for(Point point : pointList)
        {
            BirthdayNode node = new BirthdayNode(nodeNum);
            nodeList.add(node);
            nodePointPairs.put(node,point);
        }
    }

    /**
     * 根据节点数目获得屏幕上的随机位置列表
     * @param num 节点个数
     * @return 随机位置(位置无重复)的列表
     */
    private ArrayList<Point> getRandomPosList(int num) {
        int x = 0;
        int y = 0;
        int xPos[] = new int[Constants.SCREEN_WIDTH];
        int yPos[] = new int[Constants.SCREEN_HEIGHT];

        Random mRand = new Random();
        ArrayList<Point> ranPoints = new ArrayList<Point>();

        for (int i = 0; i < num;) {
            //随机一个点坐标
            x = mRand.nextInt(Constants.SCREEN_WIDTH);
            y = mRand.nextInt(Constants.SCREEN_HEIGHT);
            //判断点坐标是否已经存在

            if (xPos[x]!=0 && yPos[y]!=0)
            {
                //若已存在，则不做任何操作
            }
            else
            {
                //若不存在则储存
                xPos[x] = 1;
                yPos[y] = 1;
                ranPoints.add(new Point(x,y));
                i++;

            }
        }
        return ranPoints;
    }

    /**
     * 判断i时刻只有一个在发送
     * @param i 传入时间片
     * @return 返回发送节点
     */
    private BirthdayNode isOnlyOneSend(int i)
    {
        //若节点列表为空则返回null
        if(nodeList == null && nodeList.isEmpty())
        {
            return  null;
        }

        BirthdayNode node = null;

        for(BirthdayNode n : nodeList)
        {
            //若发现节点处于发送状态
            if(n.getState(i) == Node.State.SEND)
            {
                //记录
                if(node == null)
                {
                    node = n;
                }
                //若冲突，则返回null
                else {
                    return null;
                }
            }
        }
        return node;
    }


    /**
     * 返回已发现的节点对
     */
    public void birthdayDis()
    {
        //距离对
        posPair = new HashMap<Point, Point>();
        //节点和距离集合
        Set<Map.Entry<BirthdayNode,Point>>entrySet = nodePointPairs.entrySet();
        latency = -1;
        boolean flag = true;

        //遍历所有时间片
        for(int i = 0; i<Constants.SLOT_NUM_BIR_N;i++)
        {
            BirthdayNode onlyOneSend = isOnlyOneSend(i);
            //若发现一个发送节点
            if(onlyOneSend != null){
                Point startPoint = nodePointPairs.get(onlyOneSend);
                for(Map.Entry<BirthdayNode,Point>entry:entrySet)
                {
                    BirthdayNode node = (BirthdayNode)entry.getKey();
                    if(node.getState(i) == Node.State.LISTEN)
                    {
                        posPair.put(startPoint,entry.getValue());
                        //记录第一次发现时间
                        if (flag){
                            latency = i;
                            flag = false;
                        }
                    }
                }
            }
        }
    }

    public Map<Point,Point> getPosPair()
    {
        return posPair;
    }

    @Override
    public String toString() {
        String info = "";
        info += latency;
        return info;
    }
}
