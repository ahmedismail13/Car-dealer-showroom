/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarDealer;

import java.util.ArrayList;

/**
 *
 * @author Ahmed
 */
public class CalendarTable extends javax.swing.JFrame {

    /**
     * Creates new form CalendarTable
     */
    public CalendarTable() {
        initComponents();
        int demArr[]={0,1,2,3,4};
        int leadArr[] = {1,2,3};
        double demProb[] = {0.05,0.28,0.37,0.2,0.1};
        double leadProb[] = {0.55,0.35,0.1};
        ArrayList<Double> demCumProb = new ArrayList<>();
        ArrayList<Double> leadCumProb = new ArrayList<>();
        ArrayList<Day> days = new ArrayList<>();
        
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
        for(int i =0;i<10;i++)
        {
            jTable1.getModel().setValueAt(days.get(i).getDayNum()+1, i, 0);
            jTable1.getModel().setValueAt(days.get(i).getDemand(), i, 1);
            jTable1.getModel().setValueAt(days.get(i).getLeadTime(), i,2);
            jTable1.getModel().setValueAt(days.get(i).getStorageBegin(), i, 3);
            jTable1.getModel().setValueAt(days.get(i).getStorageEnd(), i, 4);
            jTable1.getModel().setValueAt(days.get(i).getShowroomBegin(), i, 5);
            jTable1.getModel().setValueAt(days.get(i).getShowroomEnd(), i, 6);
            jTable1.getModel().setValueAt(days.get(i).getShortage(), i, 7);
            jTable1.getModel().setValueAt(i ==0?days.get(i).getOrderSize():days.get(i).getOrderSize() == days.get(i-1).getOrderSize()?0:days.get(i).getOrderSize(), i, 8);
            jTable1.getModel().setValueAt(days.get(i).getTimeTillOrderReceived()>=0?days.get(i).getTimeTillOrderReceived():0, i, 9);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Day", "Demand", "Lead Time", "Storage Begin", "Storage End", "Showroom Begin", "Showroom End", "Shortage", "Order Size", "Time To Receive Order"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 956, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CalendarTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalendarTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalendarTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalendarTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalendarTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
