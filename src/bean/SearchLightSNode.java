package bean;

import utils.Constants;

/**
 * Created by Administrator on 15-7-21.
 */
public class SearchLightSNode extends Node {
    private int t;//位移间隔
    private int startSlot;//开始时间片

    /**
     * 初始化节点
     * @param t 位移的间隔
     * @param startSlot 开始时间片
     */
    public SearchLightSNode(int t, int startSlot){
        this.t = t;
        this.startSlot = startSlot;
        slot = new State[Constants.SLOT_NUM_SS_GLOBAL];
        for(int i = 0; i < slot.length; i++){
            slot[i] = State.IDLE;
        }

        for(int i = 0; i <= (Constants.SLOT_NUM_SS_GLOBAL-startSlot) / t; i++){
            if(i != (Constants.SLOT_NUM_SS_GLOBAL-startSlot) / t){
                for(int j = 0; j < t; j++){
                    if(j == 0){
                        slot[i*t+j+startSlot] = State.BEACON;
                    }else if(j == (i%(t/2)+1)) {
                        slot[i*t+j+startSlot] = State.BEACON;
                        break;
                    }
                }
            } else{
                for(int j = 0; j < (Constants.SLOT_NUM_SS_GLOBAL-startSlot) % t; j++){
                    if(j == 0){
                        slot[i*t+j+startSlot] = State.BEACON;
                    }else if(j == (i%(t/2)+1)) {
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
