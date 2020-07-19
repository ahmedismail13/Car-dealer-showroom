package CarDealer;

import java.util.ArrayList;


public class Calendar {

    int demArr[]={0,1,2,3,4};
    int leadArr[] = {1,2,3};
    double demProb[] = {0.05,0.28,0.37,0.2,0.1};
    double leadProb[] = {0.55,0.35,0.1};
    ArrayList<Double> demCumProb = new ArrayList<>();
    ArrayList<Double> leadCumProb = new ArrayList<>();
    ArrayList<Day> days = new ArrayList<>();
    
    public Calendar() {
        
        
        demCumProb.add((double)demProb[0]);
        leadCumProb.add((double)leadProb[0]);
        for(int i =1;i<demArr.length;i++)
        {
            demCumProb.add(demCumProb.get(i-1)+demProb[i]);
        }
        for(int i =1;i<leadArr.length;i++)
        {
            leadCumProb.add(leadCumProb.get(i-1)+leadProb[i]);
        }
        
        for(int i =0;i<10;i++)
        {
            int randDemand = (int)(Math.random()*100+1);
            int randLead = (int)(Math.random()*100+1);
            
            int demand=-1,leadTime=-1;
            
            if(randDemand>= 1 && randDemand <=5)
            {
                demand = demArr[0];
            }
            else if(randDemand>=6&&randDemand<=33)
            {
                demand = demArr[1];
            }
            else if(randDemand>=34&&randDemand<=70)
            {
                demand = demArr[2];
            }
            else if(randDemand>=71&&randDemand<=90)
            {
                demand = demArr[3];
            }
            else if(randDemand>=91&&randDemand<=100)
            {
                demand = demArr[4];
            }
            
            
            if(randLead>=1&& randLead<=55)
            {
                leadTime = leadArr[0];
            }
            else if(randLead>=56&&randLead<=90)
            {
                leadTime = leadArr[1];
            }
            else if(randLead>=90&&randLead<=100)
            {
                leadTime = leadArr[2];
            }
            
            int dayNum;
            int storageBegin;
            int storageEnd;
            int showroomBegin;
            int showroomEnd;
            int shortage;
            boolean isOrdered;
            boolean makingOrder;
            int orderSize;
            int timeTillOrderReceived;
            
            if(i==0)
            {
                storageBegin =2;
                showroomBegin=4;
                if(storageBegin >=demand)
                {
                    storageEnd= storageBegin-demand;
                    showroomEnd = showroomBegin;
                    shortage =0;
                }  
                else
                {
                    storageEnd= storageBegin-demand;
                    if(showroomBegin>(storageEnd*-1))
                    {
                        showroomEnd = showroomBegin+storageEnd;
                        shortage =0;
                    }   
                    else
                    {
                        showroomEnd = showroomBegin+storageEnd;
                        shortage = -1*showroomEnd;
                        showroomEnd=0;
                    }
                    storageEnd=0;
                }
                isOrdered=true;
                makingOrder = true;
                orderSize =5;
                timeTillOrderReceived=2;
                leadTime = 2;
            }
            else
            {
                if(days.get(i-1).getTimeTillOrderReceived()==0)
                {
                    int x=days.get(i-1).getOrderSize();
                    storageBegin =days.get(i-1).getStorageEnd();
                    showroomBegin=days.get(i-1).getShowroomEnd();
                    shortage = days.get(i-1).getShortage();
                    while(shortage>0)
                    {
                        shortage--;
                        x--;
                    }
                    while(showroomBegin<=3 && x>0)
                    {
                        showroomBegin++;
                        x--;
                    }
                    while(x>0)
                    {
                        storageBegin++;
                        x--;
                    }     
                }
                else
                {
                    storageBegin =days.get(i-1).getStorageEnd();
                    showroomBegin=days.get(i-1).getShowroomEnd();
                }
                if(storageBegin >=demand)
                {
                    storageEnd= storageBegin-demand;
                    showroomEnd = showroomBegin;
                    shortage =0;
                }  
                else
                {
                    storageEnd= storageBegin-demand;
                    if(showroomBegin>(storageEnd*-1))
                    {
                        showroomEnd = showroomBegin+storageEnd;
                        shortage =0;
                    }   
                    else
                    {
                        showroomEnd = showroomBegin+storageEnd;
                        shortage = -1*showroomEnd;
                        showroomEnd=0;
                    }
                    storageEnd=0;
                }
                if(days.get(i-1).getTimeTillOrderReceived()>0)
                    isOrdered = true;
                else
                    isOrdered = false;
                
                if(storageEnd<=2 && isOrdered == false)
                {
                    makingOrder = true;
                    orderSize = 12 - (showroomEnd+storageEnd);
                    timeTillOrderReceived = leadTime;
                }
                else
                {
                    makingOrder=false;
                    orderSize =days.get(i-1).getOrderSize();
                    timeTillOrderReceived = days.get(i-1).getTimeTillOrderReceived()-1;
                } 
            }
            Day d = new Day(i,demand,leadTime,storageBegin,storageEnd,showroomBegin,showroomEnd,shortage,isOrdered,makingOrder,orderSize,timeTillOrderReceived);
            days.add(d);
        }
              
    }

    public int[] getDemArr() {
        return demArr;
    }

    public int[] getLeadArr() {
        return leadArr;
    }

    public double[] getDemProb() {
        return demProb;
    }

    public double[] getLeadProb() {
        return leadProb;
    }

    public ArrayList<Double> getDemCumProb() {
        return demCumProb;
    }

    public ArrayList<Double> getLeadCumProb() {
        return leadCumProb;
    }

    public ArrayList<Day> getDays() {
        return days;
    }
    
    
}
