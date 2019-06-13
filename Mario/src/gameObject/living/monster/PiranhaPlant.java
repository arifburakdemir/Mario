/*    */ package gameObject.living.monster;
/*    */ 
/*    */ import gameObject.level.Level;
/*    */ import gameObject.lifeless.Pippe;
/*    */ import java.awt.Image;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JLabel;
/*    */ 
/*    */ public class PiranhaPlant extends Monster
/*    */ {
/*    */   public PiranhaPlant(Pippe pippe, final Level level)
/*    */   {
/* 14 */     int x = pippe.getLeft();
/* 15 */     int y = pippe.getTop();
/*    */ 
/* 17 */     setCanFall(false);
/* 18 */     setCanMove(false);
/* 19 */     setKillable(false);
/* 20 */     getAprc().setBounds(x + 5, y + 20, 30, 30);
/* 21 */     getAprc()
/* 22 */       .setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/monsters/pirhana_planet.png"))
/* 23 */       .getImage().getScaledInstance(25, 30, 1)));
/*    */ 
/* 25 */     Thread upAndDown = new Thread(new Runnable()
/*    */     {
/*    */       public void run() {
/* 28 */         int moveCount = 0;
/* 29 */         boolean moveD = true;
/* 30 */         int moveLimit = 35;
/* 31 */         while (level.isPlay()) {
/* 32 */           moveCount++;
/* 33 */           if (moveCount == 50) {
/* 34 */             moveCount = 0;
/* 35 */             if (moveD)
/* 36 */               moveD = false;
/*    */             else
/* 38 */               moveD = true;
/*    */             try
/*    */             {
/* 41 */               Thread.sleep(2500L);
/*    */             }
/*    */             catch (InterruptedException e) {
/* 44 */               e.printStackTrace();
/*    */             }
/*    */           }
/* 47 */           else if (moveD) {
/* 48 */             PiranhaPlant.this.getAprc().setBounds(PiranhaPlant.this.getLeft(), PiranhaPlant.this.getTop() - 1, PiranhaPlant.this.getWidth(), PiranhaPlant.this.getHeight());
/*    */           } else {
/* 50 */             PiranhaPlant.this.getAprc().setBounds(PiranhaPlant.this.getLeft(), PiranhaPlant.this.getTop() + 1, PiranhaPlant.this.getWidth(), PiranhaPlant.this.getHeight());
/*    */           }
/*    */           try
/*    */           {
/* 54 */             Thread.sleep(13L);
/*    */           }
/*    */           catch (InterruptedException e) {
/* 57 */             e.printStackTrace();
/*    */           }
/*    */         }
/*    */       }
/*    */     });
/* 63 */     upAndDown.start();
/*    */   }
/*    */ }
