package bean;

import utils.Constants;
/**
 * Created by Administrator on 15-7-21.
 */
public class DiscoNode extends Node {
    private int prime1;
    private int prime2;
    private int startSlot;

    /**
     *
     * @param prime1 素数1
     * @param prime2 素数2
     * @param startSlot 开始时间片
     */
    public DiscoNode(int prime1, int prime2, int startSlot){
        this.prime1 = prime1;
        this.prime2 = prime2;
        this.startSlot = startSlot;
        slot = new State[Constants.SLOT_NUM_DISCO_GLOBAL];

        //设置对应时间片为相互通信状态
        for(int i = 0; i < slot.length; i++){
            slot[i] = State.IDLE;
            int index = i - startSlot;
            if(index >= 0){
                if((index % prime1 == 0) || (index % prime2 == 0)){
                    slot[i] = State.BEACON;
                }
            }
        }
    }

    public int getPrime1() {
        return prime1;
    }

    public int getPrime2() {
        return prime2;
    }

    public int getStartSlot() {
        return startSlot;
    }
}
