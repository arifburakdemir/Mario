/*    */ package gameObject.lifeless;
/*    */ 
/*    */ import java.awt.Image;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JLabel;
/*    */ 
/*    */ public class Floor extends Lifeless
/*    */ {
/*    */   public Floor(int x, int y)
/*    */   {
/*  9 */     getAprc().setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/levels/level1_ground.png")).getImage()
/* 10 */       .getScaledInstance(580, 50, 1)));
/* 11 */     getAprc().setBounds(x, y - 50, 580, 50);
/*    */   }
/*    */ 
/*    */   public void level2Floor() {
/* 15 */     getAprc().setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/levels/level2_ground.png")).getImage()
/* 16 */       .getScaledInstance(580, 50, 1)));
/*    */   }
/*    */ }
