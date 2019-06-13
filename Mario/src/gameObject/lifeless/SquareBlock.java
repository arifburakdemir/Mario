/*    */ package gameObject.lifeless;
/*    */ 
/*    */ import java.awt.Image;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JLabel;
/*    */ 
/*    */ public class SquareBlock extends Lifeless
/*    */ {
/*    */   public SquareBlock(int x, int y)
/*    */   {
/* 11 */     getAprc().setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/lifelesses/block_2.png")).getImage()
/* 12 */       .getScaledInstance(20, 20, 1)));
/* 13 */     getAprc().setBounds(x, y - 20, 20, 20);
/*    */   }
/*    */ }
