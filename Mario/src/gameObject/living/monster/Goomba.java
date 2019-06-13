/*    */ package gameObject.living.monster;
/*    */ 
/*    */ import java.awt.Image;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JLabel;
/*    */ 
/*    */ public class Goomba extends Monster
/*    */ {
/*    */   public Goomba(int x, int y)
/*    */   {
/* 10 */     setKillable(true);
/* 11 */     setCanMove(true);
/* 12 */     setCanFall(true);
/* 13 */     getAprc().setBounds(x, y - 20, 30, 20);
/* 14 */     getAprc().setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/monsters/goomba.png")).getImage()
/* 15 */       .getScaledInstance(30, 20, 1)));
/*    */   }
/*    */ }
