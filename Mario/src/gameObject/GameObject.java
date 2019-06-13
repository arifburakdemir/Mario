/*    */ package gameObject;
/*    */ 
/*    */ import javax.swing.JLabel;
/*    */ 
/*    */ public class GameObject
/*    */ {
/*  6 */   JLabel aprc = new JLabel();
/*    */   int top;
/*    */   int bottom;
/*    */   int left;
/*    */   int right;
/*    */   int width;
/*    */   int height;
/* 13 */   boolean gravity = true;
/*    */ 
/*    */   public boolean isGravity()
/*    */   {
/* 20 */     return this.gravity;
/*    */   }
/*    */ 
/*    */   public void setGravity(boolean gravity) {
/* 24 */     this.gravity = gravity;
/*    */   }
/*    */   public JLabel getAprc() {
/* 27 */     return this.aprc;
/*    */   }
/*    */   public void setAprc(JLabel aprc) {
/* 30 */     this.aprc = aprc;
/*    */   }
/*    */   public int getTop() {
/* 33 */     return this.top = getAprc().getY();
/*    */   }
/*    */   public void setTop(int top) {
/* 36 */     this.top = top;
/*    */   }
/*    */   public int getBottom() {
/* 39 */     return this.bottom = getAprc().getY() + getHeight();
/*    */   }
/*    */   public void setBottom(int bottom) {
/* 42 */     this.bottom = bottom;
/*    */   }
/*    */   public int getLeft() {
/* 45 */     return this.left = getAprc().getX();
/*    */   }
/*    */   public void setLeft(int left) {
/* 48 */     this.left = left;
/*    */   }
/*    */   public int getRight() {
/* 51 */     return this.right = getAprc().getX() + getWidth();
/*    */   }
/*    */   public void setRight(int right) {
/* 54 */     this.right = right;
/*    */   }
/*    */   public int getWidth() {
/* 57 */     return this.width = this.aprc.getWidth();
/*    */   }
/*    */   public void setWidth(int width) {
/* 60 */     this.width = width;
/*    */   }
/*    */   public int getHeight() {
/* 63 */     return this.height = this.aprc.getHeight();
/*    */   }
/*    */   public void setHeight(int height) {
/* 66 */     this.height = height;
/*    */   }
/*    */ }
