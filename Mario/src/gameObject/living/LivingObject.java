/*     */ package gameObject.living;
/*     */ 
/*     */ import gameObject.GameObject;
/*     */ 
/*     */ public class LivingObject extends GameObject
/*     */ {
/*   7 */   int gravityDelayEnd = 10;
/*   8 */   int gravityDelayStart = 3;
/*   9 */   int gravityDelay = this.gravityDelayStart;
/*     */ 
/*  12 */   boolean canFall = true;
/*  13 */   boolean killable = true;
/*  14 */   boolean canMove = true;
/*     */ 
/*  16 */   boolean rightMoving = false;
/*  17 */   boolean leftMoving = false;
/*  18 */   boolean falling = false;
/*  19 */   boolean jumping = false;
/*  20 */   boolean firstJumping = true;
/*     */ 
/*  22 */   boolean living = true;
/*     */ 
/*  24 */   int walkingCount = 0;
/*  25 */   int jumpingCount = 0;
/*  26 */   int jumpingLimit = 80;
/*     */ 
/* 126 */   int fallingCount = 0;
/*     */ 
/*     */   public boolean isLiving()
/*     */   {
/*  31 */     return this.living;
/*     */   }
/*     */   public void setLiving(boolean living) {
/*  34 */     this.living = living;
/*     */   }
/*     */   public boolean isKillable() {
/*  37 */     return this.killable;
/*     */   }
/*     */   public void setKillable(boolean killable) {
/*  40 */     this.killable = killable;
/*     */   }
/*     */   public boolean isCanFall() {
/*  43 */     return this.canFall;
/*     */   }
/*     */   public void setCanFall(boolean canFall) {
/*  46 */     this.canFall = canFall;
/*     */   }
/*     */   public boolean isRightMoving() {
/*  49 */     return this.rightMoving;
/*     */   }
/*     */   public void setRightMoving(boolean rightMoving) {
/*  52 */     this.rightMoving = rightMoving;
/*     */   }
/*     */   public boolean isLeftMoving() {
/*  55 */     return this.leftMoving;
/*     */   }
/*     */   public void setLeftMoving(boolean leftMoving) {
/*  58 */     this.leftMoving = leftMoving;
/*     */   }
/*     */   public boolean isFalling() {
/*  61 */     return this.falling;
/*     */   }
/*     */   public void setFalling(boolean falling) {
/*  64 */     this.falling = falling;
/*     */   }
/*     */   public boolean isJumping() {
/*  67 */     return this.jumping;
/*     */   }
/*     */   public void setJumping(boolean jumping) {
/*  70 */     this.jumping = jumping;
/*     */   }
/*     */   public boolean isFirstJumping() {
/*  73 */     return this.firstJumping;
/*     */   }
/*     */   public void setFirstJumping(boolean firstJumping) {
/*  76 */     this.firstJumping = firstJumping;
/*     */   }
/*     */   public int getWalkingCount() {
/*  79 */     return this.walkingCount;
/*     */   }
/*     */   public void setWalkingCount(int walkingCount) {
/*  82 */     this.walkingCount = walkingCount;
/*     */   }
/*     */   public int getJumpingCount() {
/*  85 */     return this.jumpingCount;
/*     */   }
/*     */   public void setJumpingCount(int jumpingCount) {
/*  88 */     this.jumpingCount = jumpingCount;
/*     */   }
/*     */   public int getJumpingLimit() {
/*  91 */     return this.jumpingLimit;
/*     */   }
/*     */   public void setJumpingLimit(int jumpingLimit) {
/*  94 */     this.jumpingLimit = jumpingLimit;
/*     */   }
/*     */   public int getFallingCount() {
/*  97 */     return this.fallingCount;
/*     */   }
/*     */   public void setFallingCount(int fallingCount) {
/* 100 */     this.fallingCount = fallingCount;
/*     */   }
/*     */   public int getGravityDelayEnd() {
/* 103 */     return this.gravityDelayEnd;
/*     */   }
/*     */   public void setGravityDelayEnd(int gravityDelayEnd) {
/* 106 */     this.gravityDelayEnd = gravityDelayEnd;
/*     */   }
/*     */   public int getGravityDelayStart() {
/* 109 */     return this.gravityDelayStart;
/*     */   }
/*     */   public void setGravityDelayStart(int gravityDelayStart) {
/* 112 */     this.gravityDelayStart = gravityDelayStart;
/*     */   }
/*     */   public int getGravityDelay() {
/* 115 */     return this.gravityDelay;
/*     */   }
/*     */   public void setGravityDelay(int gravityDelay) {
/* 118 */     this.gravityDelay = gravityDelay;
/*     */   }
/*     */   public boolean isCanMove() {
/* 121 */     return this.canMove;
/*     */   }
/*     */   public void setCanMove(boolean canMove) {
/* 124 */     this.canMove = canMove;
/*     */   }
/*     */ }
