package bean;

/**
 * Created by Administrator on 15-7-21.
 */
public class UConnNode extends Node {
    private int prime;
    private int startSlot;

    /**
     *
     * @param prime
     * @param startSlot
     */
    public UConnNode(int prime, int startSlot){
        this.prime = prime;
        this.startSlot = startSlot;

        //初始化时间片
        int sumSlots = prime * prime;
        slot = new State[sumSlots];

        //设置激活状态
        for(int i = 0; i < slot.length; i++){
            slot[i] = State.IDLE;
            int index = i - startSlot;
            if(index >= 0){
                //设置第一行
                if((index % prime == 0) || (index < (prime+1) / 2)){
                    slot[i] = State.BEACON;
                }
            }
        }
    }

    public int getPrime(){
        return prime;
    }
    public int getStartSlot(){
        return startSlot;
    }
}
