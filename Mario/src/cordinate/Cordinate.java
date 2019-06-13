/*    */ package cordinate;
/*    */ 
/*    */ import gameObject.GameObject;
/*    */ 
/*    */ public class Cordinate
/*    */ {
/*    */   int x;
/*    */   int y;
/*    */   int maxX;
/*    */   int maxY;
/*    */ 
/*    */   public Cordinate(int maxX, int maxY)
/*    */   {
/* 15 */     this.maxX = maxX;
/* 16 */     this.maxY = maxY;
/*    */   }
/*    */   public int bottomOfGameObject(GameObject gameObject, int y) {
/* 19 */     return gameObject.getBottom() + y;
/*    */   }
/*    */   public int topOfGameObject(GameObject gameObject, int y) {
/* 22 */     return gameObject.getTop() - y;
/*    */   }
/*    */   public int rightOfGameObject(GameObject gameObject, int x) {
/* 25 */     return gameObject.getRight() + x;
/*    */   }
/*    */   public int leftOfGameObject(GameObject gameObject, int x) {
/* 28 */     return gameObject.getLeft() + x;
/*    */   }
/*    */ 
/*    */   public int fromBottom(int y) {
/* 32 */     return this.maxY - y;
/*    */   }
/*    */   public int fromTop(int y) {
/* 35 */     return y;
/*    */   }
/*    */   public int fromLeft(int x) {
/* 38 */     return x;
/*    */   }
/*    */   public int fromright(int x) {
/* 41 */     return this.maxX - x;
/*    */   }
/*    */ 
/*    */   public int getX() {
/* 45 */     return this.x;
/*    */   }
/*    */ 
/*    */   public void setX(int x) {
/* 49 */     this.x = x;
/*    */   }
/*    */ 
/*    */   public int getY() {
/* 53 */     return this.y;
/*    */   }
/*    */ 
/*    */   public void setY(int y) {
/* 57 */     this.y = y;
/*    */   }
/*    */ 
/*    */   public int getMaxX() {
/* 61 */     return this.maxX;
/*    */   }
/*    */ 
/*    */   public void setMaxX(int maxX) {
/* 65 */     this.maxX = maxX;
/*    */   }
/*    */ 
/*    */   public int getMaxY() {
/* 69 */     return this.maxY;
/*    */   }
/*    */ 
/*    */   public void setMaxY(int maxY) {
/* 73 */     this.maxY = maxY;
/*    */   }
/*    */ }
