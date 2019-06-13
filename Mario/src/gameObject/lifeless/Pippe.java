/*    */ package gameObject.lifeless;
/*    */ 
/*    */ import java.awt.Image;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JLabel;
/*    */ 
/*    */ public class Pippe extends Lifeless
/*    */ {
/*    */   boolean enterable;
/*    */ 
/*    */   public Pippe(int x, int y)
/*    */   {
/* 12 */     getAprc().setBounds(x, y - 78, 40, 78);
/* 13 */     getAprc().setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/lifelesses/pipe.png")).getImage()
/* 14 */       .getScaledInstance(40, 78, 1)));
/*    */   }
/*    */ }
