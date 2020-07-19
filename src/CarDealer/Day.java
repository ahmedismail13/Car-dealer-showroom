package CarDealer;

public class Day {
    
    int dayNum;
    int demand;
    int leadTime;
    int storageBegin;
    int storageEnd;
    int showroomBegin;
    int showroomEnd;
    int shortage;
    boolean isOrdered;
    boolean makingOrder;
    int orderSize;
    int timeTillOrderReceived;

    public Day(int dayNum, int demand, int leadTime, int storageBegin, int storageEnd, int showroomBegin, int showroomEnd, int shortage, boolean isOrdered, boolean makingOrder, int orderSize, int timeTillOrderReceived) {
        this.dayNum = dayNum;
        this.demand = demand;
        this.leadTime = leadTime;
        this.storageBegin = storageBegin;
        this.storageEnd = storageEnd;
        this.showroomBegin = showroomBegin;
        this.showroomEnd = showroomEnd;
        this.shortage = shortage;
        this.isOrdered = isOrdered;
        this.makingOrder = makingOrder;
        this.orderSize = orderSize;
        this.timeTillOrderReceived = timeTillOrderReceived;
    }

    public boolean isIsOrdered() {
        return isOrdered;
    }

    public boolean isMakingOrder() {
        return makingOrder;
    }

    public int getDayNum() {
        return dayNum;
    }

    public int getDemand() {
        return demand;
    }

    public int getLeadTime() {
        return leadTime;
    }

    public int getStorageBegin() {
        return storageBegin;
    }

    public int getStorageEnd() {
        return storageEnd;
    }

    public int getShowroomBegin() {
        return showroomBegin;
    }

    public int getShowroomEnd() {
        return showroomEnd;
    }

    public int getShortage() {
        return shortage;
    }

    public int getOrderSize() {
        return orderSize;
    }

    public int getTimeTillOrderReceived() {
        return timeTillOrderReceived;
    }

    @Override
    public String toString() {
        return demand + " " + leadTime + " " + storageBegin + " " + storageEnd + " " + showroomBegin + " " + showroomEnd + " " + shortage + " " + isOrdered + " " + makingOrder + " " + orderSize + " " + timeTillOrderReceived;
    }
    
}
