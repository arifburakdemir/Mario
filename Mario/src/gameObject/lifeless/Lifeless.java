/*    */ package gameObject.lifeless;
/*    */ 
/*    */ import gameObject.GameObject;
/*    */ 
/*    */ public class Lifeless extends GameObject
/*    */ {
/* 18 */   boolean breakable = true;
/*    */ 
/*    */   public boolean isBreakable()
/*    */   {
/* 11 */     return this.breakable;
/*    */   }
/*    */ 
/*    */   public void setBreakable(boolean breakable) {
/* 15 */     this.breakable = breakable;
/*    */   }
/*    */ }
