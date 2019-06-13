/*    */ package gameObject.item;
/*    */ 
/*    */ import java.awt.Image;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JLabel;
/*    */ 
/*    */ public class Coin extends Item
/*    */ {
/*    */   public Coin(int x, int y)
/*    */   {
/* 10 */     getAprc().setBounds(x, y, 15, 15);
/* 11 */     getAprc().setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/items/gold_4.png")).getImage()
/* 12 */       .getScaledInstance(15, 15, 1)));
/*    */   }
/*    */ }
