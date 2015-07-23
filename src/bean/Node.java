package bean;

import java.util.UUID;

/**
 * Created by Administrator on 15-7-20.
 */
public abstract class Node {
    /**
     * 节点状态
     * IDLE 空闲
     * LISTEN 监听
     * SEND 发送信号
     * BEACON 相互通信
     */
    public enum State{
        IDLE,
        LISTEN,
        SEND,
        BEACON
    }
    private String id;//节点标识号
    protected State[] slot;//时间节点，存储各个时间节点的状态

    public Node() {
        id = UUID.randomUUID().toString();
    }


    public State getState(int i) {
        return slot[i];
    }
    public void setState(int i, State state){
        slot[i] = state;
    }

    public String getId() {
        return id;
    }
    public State[] getSlot() {
        return slot;
    }


    public void setSlot(State[] slot) {
        this.slot = slot;
    }
}
