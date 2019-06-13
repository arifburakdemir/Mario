/*    */ package gameObject.living.monster;
/*    */ 
/*    */ import javax.swing.JLabel;
/*    */ 
/*    */ public class FloorMonster extends Monster
/*    */ {
/*    */   public FloorMonster(int x, int y, int width)
/*    */   {
/*  8 */     setKillable(false);
/*  9 */     setCanFall(false);
/* 10 */     setCanMove(false);
/* 11 */     getAprc().setBounds(x, y - 10, width, 20);
/* 12 */     getAprc().setOpaque(true);
/*    */   }
/*    */ }
