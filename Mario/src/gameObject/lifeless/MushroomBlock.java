/*    */ package gameObject.lifeless;
/*    */ 
/*    */ import gameObject.level.Level;
/*    */ import java.awt.Image;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JLabel;
/*    */ 
/*    */ public class MushroomBlock extends Lifeless
/*    */ {
/* 11 */   boolean hasMusroom = true;
/* 12 */   boolean bigMush = true;
/* 13 */   boolean fireMush = false;
/* 14 */   boolean healthMush = false;
/*    */ 
/*    */   public MushroomBlock(int x, int y) {
/* 17 */     this.breakable = false;
/* 18 */     getAprc().setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/lifelesses/gold_block.png")).getImage()
/* 19 */       .getScaledInstance(28, 28, 1)));
/* 20 */     getAprc().setBounds(x, y - 28, 28, 28);
/*    */   }
/*    */ 
/*    */   public void action(Level level)
/*    */   {
/* 26 */     if (this.bigMush) {
/* 27 */       level.mushroomShow("big", getLeft(), getTop());
/* 28 */       this.bigMush = false;
/* 29 */     } else if (this.fireMush) {
/* 30 */       level.mushroomShow("fire", getLeft(), getTop());
/* 31 */     } else if (this.healthMush) {
/* 32 */       level.mushroomShow("health", getLeft(), getTop());
/*    */     }
/* 34 */     getAprc().setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/lifelesses/gold_block_finished.png")).getImage()
/* 35 */       .getScaledInstance(28, 28, 1)));
/*    */   }
/*    */ 
/*    */   public boolean isBigMush() {
/* 39 */     return this.bigMush;
/*    */   }
/*    */   public void setBigMush(boolean bigMush) {
/* 42 */     this.bigMush = bigMush;
/*    */   }
/*    */   public boolean isFireMush() {
/* 45 */     return this.fireMush;
/*    */   }
/*    */   public void setFireMush(boolean fireMush) {
/* 48 */     this.fireMush = fireMush;
/*    */   }
/*    */   public boolean isHealthMush() {
/* 51 */     return this.healthMush;
/*    */   }
/*    */   public void setHealthMush(boolean healthMush) {
/* 54 */     this.healthMush = healthMush;
/*    */   }
/*    */   public boolean isHasMusroom() {
/* 57 */     return this.hasMusroom;
/*    */   }
/*    */ 
/*    */   public void setHasMusroom(boolean hasMusroom) {
/* 61 */     this.hasMusroom = hasMusroom;
/*    */   }
/*    */ }
