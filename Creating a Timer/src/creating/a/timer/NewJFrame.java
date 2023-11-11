package creating.a.timer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NewJFrame extends javax.swing.JFrame {
    
    private int remTime = 720;
    private boolean isRunning = false;
    
    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        
        initComponents();
       
        GAME_TIMER_CLOCK.setText(calculateTime(remTime));
        
        startCurrentTime();
    }
    
    private String calculateTime(int remTime) {
        int h = remTime / 3600;
        int m = (remTime % 3600) / 60;
        int s = remTime % 60;
        
        return String.format("%02d:%02d:%02d", h,m,s);
    }
    
    private void startCurrentTime() {
        Thread currTime = new Thread(()-> {
            while (true) { //it loops forever since we do not need to pause it
                try {
                    Thread.sleep(1000);
                    setCurrentTime();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        currTime.setDaemon(true); //enables it as daemon thread to keep it as a background thread
        currTime.start();
    }
    
    private void setCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        String currTime = sdf.format(new Date());
        ACTUAL_TIMER_CLOCK.setText(currTime);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Home1ButtonIncrease = new javax.swing.JButton();
        Home2ButtonDecrease = new javax.swing.JButton();
        HomeDisplay = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Visitor1ButtonIncrement = new javax.swing.JButton();
        Visitor2ButtonDecrement = new javax.swing.JButton();
        VisitorDisplay = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        GAME_TIMER = new javax.swing.JLabel();
        GAME_TIMER_CLOCK = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        ACTUAL_TIMER = new javax.swing.JLabel();
        ACTUAL_TIMER_CLOCK = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        StopTimerButton = new javax.swing.JButton();
        ResumeTimerButton = new javax.swing.JButton();
        ResetTimerButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 48)); // NOI18N
        jLabel1.setText("HOME");

        Home1ButtonIncrease.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        Home1ButtonIncrease.setText("+");
        Home1ButtonIncrease.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Home1ButtonIncreaseMouseClicked(evt);
            }
        });
        Home1ButtonIncrease.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Home1ButtonIncreaseActionPerformed(evt);
            }
        });

        Home2ButtonDecrease.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        Home2ButtonDecrease.setText("-");
        Home2ButtonDecrease.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Home2ButtonDecreaseMouseClicked(evt);
            }
        });
        Home2ButtonDecrease.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Home2ButtonDecreaseActionPerformed(evt);
            }
        });

        HomeDisplay.setFont(new java.awt.Font("Tahoma", 0, 60)); // NOI18N
        HomeDisplay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        HomeDisplay.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel1)
                        .addGap(0, 190, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Home1ButtonIncrease, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Home2ButtonDecrease, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(HomeDisplay)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Home1ButtonIncrease, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Home2ButtonDecrease, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(HomeDisplay))
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 48)); // NOI18N
        jLabel2.setText("VISITOR");

        Visitor1ButtonIncrement.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        Visitor1ButtonIncrement.setText("+");
        Visitor1ButtonIncrement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Visitor1ButtonIncrementMouseClicked(evt);
            }
        });
        Visitor1ButtonIncrement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Visitor1ButtonIncrementActionPerformed(evt);
            }
        });

        Visitor2ButtonDecrement.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        Visitor2ButtonDecrement.setText("-");
        Visitor2ButtonDecrement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Visitor2ButtonDecrementMouseClicked(evt);
            }
        });
        Visitor2ButtonDecrement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Visitor2ButtonDecrementActionPerformed(evt);
            }
        });

        VisitorDisplay.setFont(new java.awt.Font("Tahoma", 0, 60)); // NOI18N
        VisitorDisplay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        VisitorDisplay.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel2)
                        .addGap(0, 190, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Visitor1ButtonIncrement, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Visitor2ButtonDecrement, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(VisitorDisplay)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Visitor1ButtonIncrement, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Visitor2ButtonDecrement, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(VisitorDisplay))
                .addContainerGap())
        );

        GAME_TIMER.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        GAME_TIMER.setText("GAME TIMER");

        GAME_TIMER_CLOCK.setBackground(new java.awt.Color(30, 35, 30));
        GAME_TIMER_CLOCK.setFont(new java.awt.Font("Segoe UI", 0, 50)); // NOI18N
        GAME_TIMER_CLOCK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GAME_TIMER_CLOCK.setText("00:00:00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GAME_TIMER, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(GAME_TIMER_CLOCK, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(GAME_TIMER, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(GAME_TIMER_CLOCK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        ACTUAL_TIMER.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        ACTUAL_TIMER.setText("ACTUAL TIMER");

        ACTUAL_TIMER_CLOCK.setBackground(new java.awt.Color(30, 35, 30));
        ACTUAL_TIMER_CLOCK.setFont(new java.awt.Font("Segoe UI", 0, 50)); // NOI18N
        ACTUAL_TIMER_CLOCK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ACTUAL_TIMER_CLOCK.setText("00:00:00");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ACTUAL_TIMER)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ACTUAL_TIMER_CLOCK, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ACTUAL_TIMER_CLOCK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ACTUAL_TIMER, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        StopTimerButton.setText("STOP");
        StopTimerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StopTimerButtonMouseClicked(evt);
            }
        });

        ResumeTimerButton.setText("RESUME");
        ResumeTimerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResumeTimerButtonMouseClicked(evt);
            }
        });

        ResetTimerButton.setText("RESET");
        ResetTimerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResetTimerButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StopTimerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ResumeTimerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ResetTimerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(StopTimerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ResumeTimerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ResetTimerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void Home1ButtonIncreaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Home1ButtonIncreaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Home1ButtonIncreaseActionPerformed

    private void Home2ButtonDecreaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Home2ButtonDecreaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Home2ButtonDecreaseActionPerformed

    private void Visitor1ButtonIncrementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Visitor1ButtonIncrementActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Visitor1ButtonIncrementActionPerformed

    private void Visitor2ButtonDecrementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Visitor2ButtonDecrementActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Visitor2ButtonDecrementActionPerformed

    private void Home1ButtonIncreaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Home1ButtonIncreaseMouseClicked
        // TODO add your handling code here:
        int value = Integer.valueOf(HomeDisplay.getText());
        value++;
        HomeDisplay.setText(String.valueOf(value));
    }//GEN-LAST:event_Home1ButtonIncreaseMouseClicked

    private void Visitor1ButtonIncrementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Visitor1ButtonIncrementMouseClicked
        // TODO add your handling code here:
        int value = Integer.valueOf(VisitorDisplay.getText());
        value++;
        VisitorDisplay.setText(String.valueOf(value));
    }//GEN-LAST:event_Visitor1ButtonIncrementMouseClicked

    private void Visitor2ButtonDecrementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Visitor2ButtonDecrementMouseClicked
        // TODO add your handling code here:
        int value = Integer.valueOf(VisitorDisplay.getText());
        if (value > 0) {
            value--;
            VisitorDisplay.setText(String.valueOf(value));
        }
    }//GEN-LAST:event_Visitor2ButtonDecrementMouseClicked

    private void Home2ButtonDecreaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Home2ButtonDecreaseMouseClicked
        // TODO add your handling code here:
        int value = Integer.valueOf(HomeDisplay.getText());
        if (value > 0) {
            value--;
            HomeDisplay.setText(String.valueOf(value));
        }
    }//GEN-LAST:event_Home2ButtonDecreaseMouseClicked

    
    private void ResetTimerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetTimerButtonMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_ResetTimerButtonMouseClicked

    private void StopTimerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StopTimerButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_StopTimerButtonMouseClicked

    private void ResumeTimerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResumeTimerButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ResumeTimerButtonMouseClicked

    
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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            NewJFrame scrboard = new NewJFrame();
            scrboard.setVisible(true);
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ACTUAL_TIMER;
    private javax.swing.JLabel ACTUAL_TIMER_CLOCK;
    private javax.swing.JLabel GAME_TIMER;
    private javax.swing.JLabel GAME_TIMER_CLOCK;
    private javax.swing.JButton Home1ButtonIncrease;
    private javax.swing.JButton Home2ButtonDecrease;
    private javax.swing.JTextField HomeDisplay;
    private javax.swing.JButton ResetTimerButton;
    private javax.swing.JButton ResumeTimerButton;
    private javax.swing.JButton StopTimerButton;
    private javax.swing.JButton Visitor1ButtonIncrement;
    private javax.swing.JButton Visitor2ButtonDecrement;
    private javax.swing.JTextField VisitorDisplay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables

}
