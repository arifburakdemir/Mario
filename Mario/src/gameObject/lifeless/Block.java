/*    */ package gameObject.lifeless;
/*    */ 
/*    */ import java.awt.Image;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JLabel;
/*    */ 
/*    */ public class Block extends Lifeless
/*    */ {
/*    */   public Block(int x, int y)
/*    */   {
/* 11 */     getAprc().setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/lifelesses/blcok_1.png")).getImage()
/* 12 */       .getScaledInstance(28, 28, 1)));
/* 13 */     getAprc().setBounds(x, y - 28, 28, 28);
/*    */   }
/*    */ 
/*    */   public void darkBlock() {
/* 17 */     getAprc().setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/lifelesses/block_3.png")).getImage()
/* 18 */       .getScaledInstance(28, 28, 1)));
/*    */   }
/*    */ }
