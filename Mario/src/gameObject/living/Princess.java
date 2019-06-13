/*    */ package gameObject.living;
/*    */ 
/*    */ import gameObject.lifeless.Lifeless;
/*    */ import java.awt.Image;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JLabel;
/*    */ 
/*    */ public class Princess extends Lifeless
/*    */ {
/*    */   public Princess(int x, int y)
/*    */   {
/* 13 */     getAprc().setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/levels/princess.png"))
/* 14 */       .getImage().getScaledInstance(25, 50, 1)));
/* 15 */     getAprc().setBounds(x, y - 50, 25, 50);
/*    */   }
/*    */ }
