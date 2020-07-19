package CarDealer;

import java.util.ArrayList;


public class CarDealerSimulations {

    
    
    public static void main(String args[])
    {
        ArrayList<Day> tempDays = new ArrayList<>();
        ArrayList<Double> totalAvgInvEnd = new ArrayList<>();
        ArrayList<Double> totalAvgShowEnd = new ArrayList<>();
        ArrayList<Double> totalShortageProb = new ArrayList<>();
        Calendar c = new Calendar();
        tempDays = c.getDays();
        int n = 30;
        
        for(int i =0;i<n;i++)
        {
            double avgShowEnd=0,avgInvEnd=0;
            double countShortage=0;
            for(int j =0;j<10;j++)
            {
                avgShowEnd+=tempDays.get(j).getShowroomEnd();
                avgInvEnd+=tempDays.get(j).getStorageEnd();
                if(tempDays.get(j).getShortage()>0)
                {
                    countShortage++;
                }
            }
            countShortage/=10;
            avgInvEnd/=10;
            avgShowEnd/=10;
            totalAvgInvEnd.add(avgInvEnd);
            totalAvgShowEnd.add(avgShowEnd);
            totalShortageProb.add(countShortage);
        }
        double avgShowEnd=0,avgInvEnd=0;
        double countShortage=0;
        for(int i =0;i<n;i++)
        {
            avgShowEnd+=totalAvgShowEnd.get(i);
            avgInvEnd+=totalAvgInvEnd.get(i);
            countShortage+=totalShortageProb.get(i);
        }
        avgInvEnd/=n;
        avgShowEnd/=n;
        countShortage/=n;
        System.out.println("avgInvEnd= "+avgInvEnd);
        System.out.println("avgShowEnd= "+avgShowEnd);
        System.out.println("countShortage= "+countShortage);
        
        
    }
}
