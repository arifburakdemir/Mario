/*    */ package gameObject.lifeless;
/*    */ 
/*    */ import java.awt.Image;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JLabel;
/*    */ 
/*    */ public class Castle extends Lifeless
/*    */ {
/*    */   public Castle(int x, int y)
/*    */   {
/* 10 */     getAprc().setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/levels/castle.png")).getImage()
/* 11 */       .getScaledInstance(150, 150, 1)));
/* 12 */     getAprc().setBounds(x, y - 150, 150, 150);
/*    */   }
/*    */ }
