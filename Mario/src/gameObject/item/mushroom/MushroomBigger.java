/*    */ package gameObject.item.mushroom;
/*    */ 
/*    */ import java.awt.Image;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JLabel;
/*    */ 
/*    */ public class MushroomBigger extends Mushroom
/*    */ {
/*    */   public MushroomBigger()
/*    */   {
/* 12 */     getAprc().setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/items/mushroom.png")).getImage()
/* 13 */       .getScaledInstance(25, 25, 1)));
/* 14 */     getAprc().setBounds(-25, -25, 25, 25);
/*    */   }
/*    */ }

