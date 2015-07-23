package bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import utils.Constants;

/**
 * Created by Administrator on 15-7-21.
 * 生日算法节点
 */
public class BirthdayNode extends Node
{
    private double pListen;//监听概率
    private double pTrans;//传输信号概率

    public double getPListen() {
        return pListen;
    }

    public void setPListen(double pListen) {
        this.pListen = pListen;
    }

    public double getPTrans() {
        return pTrans;
    }

    public void setPTrans(double pTrans) {
        this.pTrans = pTrans;
    }

    /**
     * 构造生日节点
     * @param nodeNumber 节点个数
     *
     */
    public BirthdayNode(int nodeNumber) {
        super();
        //设置传输概率和监听概率（默认激活状态不是传输就是监听）
        pTrans = 1.0 / nodeNumber;
        pListen = 1.0 - pTrans;

        //初始化时间片
        slot = new State[Constants.SLOT_NUM_BIR_N];
        for(int i = 0; i < slot.length; i++){
            slot[i] = State.IDLE;
        }

        //选出对应时间片进行激活
        List<Integer> indexList = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < Constants.SLOT_NUM_BIR_K;){
            int index = random.nextInt(Constants.SLOT_NUM_BIR_N);
            if(!indexList.contains(index)){
                indexList.add(index);
                i++;
            }
        }

        //设置激活节点状态
        for(Integer i : indexList){
            slot[i] = randomState(pListen);
        }
        //清空变量
        indexList.clear();
        indexList = null;
    }

    /**
     * 获得随机状态
     * @param pListen 监听概率
     * @return 随机状态
     */
    public State randomState(double pListen){
        Random r = new Random();
        int value = r.nextInt(100);
        int tmpListen = (int) (pListen * 100);
        int tmpTrans = 100 - tmpListen;
        if(value < tmpListen) {
            return State.SEND;
        } else {
            return State.LISTEN;
        }

    }

}
