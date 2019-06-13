/*    */ package gameObject.item.mushroom;
/*    */ 
/*    */ import gameObject.item.Item;
/*    */ import javax.swing.JLabel;
/*    */ 
/*    */ public class Mushroom extends Item
/*    */ {
/*  8 */   boolean leftMoving = true;
/*  9 */   boolean moveable = false;
/*    */ 
/*    */   public void mushroomHide() {
/* 12 */     getAprc().setVisible(false);
/* 13 */     getAprc().setBounds(-30, -30, 25, 25);
/* 14 */     this.moveable = false;
/*    */   }
/*    */ 
/*    */   public boolean isMoveable() {
/* 18 */     return this.moveable;
/*    */   }
/*    */ 
/*    */   public void setMoveable(boolean moveable) {
/* 22 */     this.moveable = moveable;
/*    */   }
/*    */ 
/*    */   public boolean isLeftMoving() {
/* 26 */     return this.leftMoving;
/*    */   }
/*    */ 
/*    */   public void setLeftMoving(boolean leftMoving) {
/* 30 */     this.leftMoving = leftMoving;
/*    */   }
/*    */ }
