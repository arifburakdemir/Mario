/*    */ package Main;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ public class GameOver extends JPanel
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 12 */   GameOver gameOver = this;
/*    */ 
/* 14 */   public GameOver(final StartMenu startMenu) { setBackground(Color.BLACK);
/* 15 */     setLayout(null);
/*    */ 
/* 17 */     Thread waitForStartMenu = new Thread(new Runnable()
/*    */     {
/*    */       public void run()
/*    */       {
/*    */         try {
/* 22 */           Thread.sleep(1000L);
/*    */         } catch (InterruptedException e) {
/* 24 */           e.printStackTrace();
/*    */         }
/* 26 */         startMenu.setContentPane(startMenu.contentPane);
/* 27 */         startMenu.validate();
/* 28 */         startMenu.contentPane.requestFocus();
/*    */       }
/*    */     });
/* 31 */     waitForStartMenu.start();
/* 32 */     JLabel lblNewLabel = new JLabel("");
/* 33 */     lblNewLabel.setIcon(new ImageIcon(GameOver.class.getResource("/images/levels/gameover.png")));
/* 34 */     lblNewLabel.setBounds(91, 73, 268, 154);
/* 35 */     add(lblNewLabel);
/*    */   }
/*    */ }
