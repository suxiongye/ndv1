package bean;

import utils.Constants;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Administrator on 15-7-21.
 */
public class SearchLightRNode extends Node {
    private int t;//位移间隔
    private int startSlot;//开始时间片

    /**
     * 初始化节点
     * @param t 位移的间隔
     * @param startSlot 开始时间片
     */
    public SearchLightRNode(int t,int startSlot)
    {
        this.t = t;
        this.startSlot = startSlot;
        slot = new State[Constants.SLOT_NUM_SR_GLOBAL];

        //初试化节点
        for(int i = 0; i<slot.length; i++)
        {
            slot[i] = State.IDLE;
        }
        //设置激活时间片
        Set<Integer> probeIndexSet = new HashSet<Integer>();
        Random random = new Random();
        for(int i = 0; i <=(Constants.SLOT_NUM_SR_GLOBAL-startSlot) / t; i++){
            int probe = 0;
            if( (i % (t / 2)) == 0){
                probeIndexSet.clear();
                probe = 0;
            }
            do {
                probe = random.nextInt(t/2)+1;
            }while (probeIndexSet.contains(probe));
            probeIndexSet.add(probe);
            if(i != (Constants.SLOT_NUM_SR_GLOBAL - startSlot) / t){
                for(int j = 0; j < t; j++){
                    if(j == 0){
                        slot[i*t+j+startSlot] = State.BEACON;
                    }else if(j == probe){
                        slot[i*t+j+startSlot] = State.BEACON;
                    }
                }
            }else{
                for(int j = 0; j < (Constants.SLOT_NUM_SR_GLOBAL-startSlot) % t; j++){
                    if(j == 0){
                        slot[i*t+j+startSlot] = State.BEACON;
                    }else if(j == probe) {
                        slot[i*t+j+startSlot] = State.BEACON;
                        break;
                    }
                }
            }
        }
    }
    public int getT(){
        return t;
    }
    public int getStartSlot(){
        return startSlot;
    }
}
