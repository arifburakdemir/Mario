/*    */ package gameObject.lifeless;
/*    */ 
/*    */ import gameObject.level.Level;
/*    */ import gameObject.living.Mario;
/*    */ import java.awt.Image;
/*    */ import java.util.Timer;
/*    */ import java.util.TimerTask;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JLabel;
/*    */ 
/*    */ public class GoldBlock extends Lifeless
/*    */ {
/*    */   int gold;
/*    */ 
/*    */   public GoldBlock(int x, int y, int gold)
/*    */   {
/* 17 */     this.breakable = false;
/* 18 */     getAprc().setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/lifelesses/gold_block.png")).getImage()
/* 19 */       .getScaledInstance(28, 28, 1)));
/* 20 */     getAprc().setBounds(x, y - 28, 28, 28);
/* 21 */     this.gold = gold;
/*    */   }
/*    */ 
/*    */   public void finishedGoldBlock() {
/* 25 */     getAprc().setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/lifelesses/gold_block_finished.png")).getImage()
/* 26 */       .getScaledInstance(28, 28, 1)));
/* 27 */     getAprc().setBounds(getLeft(), getTop(), 28, 28);
/*    */   }
/*    */ 
/*    */   public void action(Mario mario, final Level level) {
/* 31 */     if (getGold() != 0)
/*    */     {
/* 33 */       reduceGold();
/* 34 */       mario.incGold();
/* 35 */       level.goldCountUpdate(mario);
/* 36 */       level.showGold(getLeft(), getTop());
/*    */ 
/* 38 */       Timer hideGold = new Timer();
/*    */ 
/* 40 */       hideGold.schedule(new TimerTask()
/*    */       {
/*    */         public void run() {
/* 43 */           level.hideGold();
/*    */         }
/*    */       }
/*    */       , 200L);
/*    */ 
/* 47 */       if (getGold() == 0)
/* 48 */         finishedGoldBlock();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void reduceGold()
/*    */   {
/* 54 */     this.gold -= 1;
/*    */   }
/*    */   public int getGold() {
/* 57 */     return this.gold;
/*    */   }
/*    */   public void setGold(int gold) {
/* 60 */     this.gold = gold;
/*    */   }
/*    */ }
