/*     */ package gameObject.living;

/*     */
/*     */ import gameObject.GameObject;
/*     */ import gameObject.item.mushroom.Mushroom;
/*     */ import gameObject.item.mushroom.MushroomBigger;
/*     */ import gameObject.level.Level;
/*     */ import gameObject.level.Level2;
/*     */ import gameObject.lifeless.Block;
/*     */ import gameObject.lifeless.GoldBlock;
/*     */ import gameObject.lifeless.Lifeless;
/*     */ import gameObject.lifeless.MushroomBlock;
/*     */ import gameObject.living.monster.Monster;
/*     */ import java.awt.Image;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Timer;
/*     */ import java.util.TimerTask;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JLabel;

/*     */
/*     */ public class Mario extends LivingObject
/*     */ {
	/*     */ Level level;
	/* 23 */ int gold = 0;
	/* 24 */ boolean big = false;
	/*     */
	/* 26 */ int health = 3;
	/*     */
	/* 28 */ Mario mario = this;
	/*     */
	/* 30 */ int bigMarioHeight = 40;
	/* 31 */ int smallMarioHeight = 30;
	/* 32 */ int marioWidth = 25;
	/* 33 */ int speed = 7;
	/*     */
	/* 35 */ boolean ghost = false;

	/*     */
	/*     */ public Mario()
	/*     */ {
		/* 39 */ this.health = 3;
		/* 40 */ getAprc().setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/mario/mario-stay.png"))
				/* 41 */ .getImage().getScaledInstance(25, this.smallMarioHeight, 1)));
		/* 42 */ getAprc().setBounds(0, 219, 25, this.smallMarioHeight);
		/*     */ }

	/*     */
	/*     */ public void smalling() {
		/* 46 */ getAprc().setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/mario/mario-stay.png"))
				/* 47 */ .getImage().getScaledInstance(25, this.smallMarioHeight, 1)));
		/* 48 */ getAprc().setBounds(getLeft(), getTop(), 25, this.smallMarioHeight);
		/* 49 */ this.big = false;
		/*     */ }

	/*     */
	/*     */ public void growing() {
		/* 53 */ this.big = true;
		/* 54 */ getAprc().setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/mario/mario-stay.png"))
				/* 55 */ .getImage().getScaledInstance(25, this.bigMarioHeight, 1)));
		/* 56 */ getAprc().setBounds(getLeft(), getTop() - 15, 25, this.bigMarioHeight);
		/*     */ }

	/*     */
	/*     */ public void marioMoves()
	/*     */ {
		/* 61 */ damageListener();
		/* 62 */ leftRightMoving();
		/* 63 */ gravityJumpMove();
		/*     */ }

	/*     */
	/*     */ public void gravityJumpMove()
	/*     */ {
		/* 74 */ Thread gravityJumpMove = new Thread(new Runnable()
		/*     */ {
			/*     */ public void run()
			/*     */ {
				/* 82 */ while (Mario.this.mario.isLiving())
				/*     */ {
					/* 84 */ if (!Mario.this.isJumping())
					/*     */ {
						/* 87 */ if (!Mario.this.isFalling()) {
							/* 88 */ Mario.this.setFalling(true);
							/* 89 */ for (int counter = 0; counter < Mario.this.level.getLifelesses()
									.size(); counter++) {
								/* 90 */ Lifeless currentBlock = (Lifeless) Mario.this.level.getLifelesses()
										.get(counter);
								/* 91 */ if ((currentBlock.getTop() >= Mario.this.getBottom()) &&
										/* 92 */ (Mario.this.inBlock(currentBlock, Mario.this.mario))) {
									/* 93 */ Mario.this.setFalling(false);
									/* 94 */ break;
									/*     */ }
								/*     */
								/*     */ }
							/*     */
							/*     */ }
							/*     */ else
						/*     */ {
							/* 106 */ if (Mario.this.getFallingCount() == 0) {
								/* 107 */ Mario.this.gravityDelay = Mario.this.gravityDelayEnd;
								/*     */ }
							/* 109 */ Mario.this.setFallingCount(Mario.this.getFallingCount() + 1);
							/* 110 */ if (Mario.this.getFallingCount() < 10) /* 111 */ Mario.this.gravityDelay -= 1;
							/*     */ else {
								/* 113 */ Mario.this.gravityDelay = (Mario.this.gravityDelayStart - 2);
								/*     */ }
							/*     */
							/* 116 */ Mario.this.getAprc()
									.setIcon(new ImageIcon(/* 117 */ new ImageIcon(
											getClass().getResource("/images/mario/mario-jump.png")).getImage()
													/* 118 */ .getScaledInstance(Mario.this.getWidth(),
															Mario.this.getHeight(), 1)));
							/*     */
							/* 122 */ for (int counter = 0; counter < Mario.this.level.getLifelesses()
									.size(); counter++) {
								/* 123 */ Lifeless currentBlock = (Lifeless) Mario.this.level.getLifelesses()
										.get(counter);
								/* 124 */ if (Mario.this.inBlock(currentBlock, Mario.this.mario)) {
									/* 125 */ Mario.this.setFalling(false);
									/* 126 */ Mario.this.setFallingCount(0);
									/* 127 */ Mario.this.gravityDelay = Mario.this.gravityDelayStart;
									/* 128 */ break;
									/*     */ }
								/*     */ }
							/* 131 */ if (Mario.this.isFalling()) {
								/* 132 */ Mario.this.getAprc().setBounds(Mario.this.getLeft(), Mario.this.getTop() + 1,
										Mario.this.getWidth(), Mario.this.getHeight());
								/*     */ }
							/*     */
							/*     */ }
						/*     */
						/*     */ }
						/*     */ else
					/*     */ {
						/* 140 */ int checkPoint = Mario.this.getTop();
						/*     */
						/* 145 */ for (int counter = 0; counter < Mario.this.level.getLifelesses().size(); counter++) {
							/* 146 */ Lifeless currentBlock = (Lifeless) Mario.this.level.getLifelesses().get(counter);
							/*     */
							/* 149 */ if ((checkPoint == currentBlock.getBottom()) &&
									/* 150 */ (Mario.this.inBlockJump(currentBlock, Mario.this.mario))) {
								/* 151 */ Mario.this.setJumping(false);
								/* 152 */ Mario.this.setFirstJumping(true);
								/* 153 */ Mario.this.setFalling(true);
								/*     */
								/* 156 */ if (!currentBlock.getClass().isAssignableFrom(Block.class))
								/*     */ {
									/* 160 */ if (currentBlock.getClass().isAssignableFrom(GoldBlock.class)) {
										/* 161 */ GoldBlock goldBlock = (GoldBlock) currentBlock;
										/* 162 */ goldBlock.action(Mario.this.mario, Mario.this.level);
										/*     */ }
										/* 166 */ else
										if (currentBlock.getClass().isAssignableFrom(MushroomBlock.class)) {
										/* 167 */ MushroomBlock mushroomBlock = (MushroomBlock) currentBlock;
										/* 168 */ mushroomBlock.action(Mario.this.level);
										/*     */ }
									/*     */ }
								/* 170 */ if ((!currentBlock.isBreakable()) ||
										/* 171 */ (!Mario.this.isBig()))
									break;
								/* 172 */ currentBlock.getAprc().setBounds(0, 0, 0, 0);
								/*     */
								/* 175 */ break;
								/*     */ }
							/*     */
							/*     */ }
						/*     */
						/* 182 */ if (Mario.this.isJumping()) {
							/* 183 */ if (Mario.this.isFirstJumping()) {
								/* 184 */ Mario.this.getAprc()
										.setIcon(new ImageIcon(/* 185 */ new ImageIcon(
												getClass().getResource("/images/mario/mario-jump.png")).getImage()
														/* 186 */ .getScaledInstance(Mario.this.getWidth(),
																Mario.this.getHeight(), 1)));
								/* 187 */ Mario.this.setJumpingCount(0);
								/* 188 */ Mario.this.setFirstJumping(false);
								/*     */ }
							/* 190 */ if ((Mario.this.getJumpingCount() > Mario.this.getJumpingLimit() - 10) &&
									/* 191 */ (Mario.this.gravityDelay < Mario.this.gravityDelayEnd)) {
								/* 192 */ Mario.this.gravityDelay += 1;
								/*     */ }
							/*     */
							/* 195 */ if (Mario.this.getJumpingCount() <= Mario.this.getJumpingLimit()) {
								/* 196 */ Mario.this.incJumpingCount();
								/* 197 */ Mario.this.getAprc().setBounds(Mario.this.getLeft(), Mario.this.getTop() - 1,
										Mario.this.getWidth(), Mario.this.getHeight());
								/* 198 */ } else if (Mario.this.getJumpingCount() <= Mario.this.getJumpingLimit() + 1) {
								/* 199 */ Mario.this.incJumpingCount();
								/*     */ }
								/*     */ else {
								/* 202 */ Mario.this.setJumping(false);
								/* 203 */ Mario.this.setFirstJumping(true);
								/* 204 */ Mario.this.setFalling(true);
								/*     */ }
							/*     */ }
						/*     */ }
					/*     */ try
					/*     */ {
						/* 210 */ Thread.sleep(Mario.this.gravityDelay);
						/*     */ } catch (InterruptedException ex) {
						/* 212 */ Thread.currentThread().interrupt();
						/*     */ }
					/*     */ }
				/*     */ }
			/*     */ });
		/* 218 */ gravityJumpMove.start();
		/*     */ }

	/*     */
	/*     */ public void damageListener()
	/*     */ {
		/* 227 */ Thread damageListener = new Thread(new Runnable()
		/*     */ {
			/*     */ public void run()
			/*     */ {
				/* 232 */ while (Mario.this.mario.isLiving())
				/*     */ {
					/* 236 */ if (Mario.this.mario.getRight() == ((Lifeless) Mario.this.level.getLifelesses()
							.get(Mario.this.level.getLifelesses().size() - 1)).getLeft()) {
						/* 237 */ if (Mario.this.level.getClass().isAssignableFrom(Level2.class))
							/* 238 */ Mario.this.level.setFinish(true);
						/*     */ else {
							/* 240 */ Mario.this.level.setNextLevel(true);
							/*     */ }
						/*     */
						/*     */ }
					/*     */
					/* 248 */ for (int counter = 0; counter < Mario.this.level.getMushs().size(); counter++)
					/*     */ {
						/* 250 */ if ((((Mushroom) Mario.this.level.getMushs().get(counter)).getClass()
								.isAssignableFrom(MushroomBigger.class)) &&
								/* 251 */ (Mario.this.inObject((GameObject) Mario.this.level.getMushs().get(counter),
										Mario.this.mario))) {
							/* 252 */ if (!Mario.this.mario.big) {
								/* 253 */ Mario.this.mario.growing();
								/*     */ }
							/* 255 */ ((Mushroom) Mario.this.level.getMushs().get(counter)).mushroomHide();
							/*     */ }
						/*     */
						/*     */ }
					/*     */
					/* 260 */ if (!Mario.this.ghost)
					/*     */ {
						/* 264 */ for (int counter = 0; counter < Mario.this.level.getMonsters().size(); counter++) {
							/* 265 */ Monster currentMonster = (Monster) Mario.this.level.getMonsters().get(counter);
							/*     */
							/* 268 */ if ((Mario.this.inTopObject(currentMonster, Mario.this.mario))
									&& (Mario.this.isFalling())) {
								/* 269 */ Mario.this.setJumping(true);
								/* 270 */ if (currentMonster.isKillable()) {
									/* 271 */ ((Monster) Mario.this.level.getMonsters().get(counter)).getAprc()
											.setBounds(0, 0, 0, 0);
									/* 272 */ Mario.this.level.getMonsters().remove(currentMonster);
									/* 273 */ counter--;
									/*     */ }
									/*     */ else {
									/* 276 */ Mario.this.mario.setLiving(false);
									/*     */ try {
										/* 278 */ Thread.sleep(900L);
										/*     */ } catch (InterruptedException e) {
										/* 280 */ e.printStackTrace();
										/*     */ }
									/*     */
									/*     */ }
								/*     */
								/*     */ }
								/* 287 */ else if (Mario.this.inObject(currentMonster, Mario.this.mario)) {
								/* 288 */ System.out.println(counter  + "OLDUGU MONSTER");
								/* 288 */ System.out.println(currentMonster.getWidth() + "OLDUGU MONSTER");

								/* 308 */ try
								/*     */ {
									/* 308 */ Thread.sleep(70L);
									/*     */ } catch (InterruptedException e) {
									/* 310 */ e.printStackTrace();
									/*     */ }

								/* 289 */ if (!Mario.this.isBig()) {
									/* 290 */ Mario.this.mario.setLiving(false);
									/* 291 */ Mario.this.mario.setHealth(Mario.this.mario.getHealth() - 1);
									/*     */ } else {
									/* 293 */ Mario.this.ghost = true;
									/* 294 */ Timer ghostCancel = new Timer();
									/* 295 */ ghostCancel.schedule(new TimerTask()
									/*     */ {
										/*     */ public void run() {
											/* 298 */ Mario.this.ghost = false;
											/*     */ }
										/*     */ }
										/*     */ , 2000L);
									/* 301 */ Mario.this.smalling();
									/*     */ }
								/*     */ }
							/*     */ }
						/*     */ }
					/*     */ try
					/*     */ {
						/* 308 */ Thread.sleep(7L);
						/*     */ } catch (InterruptedException e) {
						/* 310 */ e.printStackTrace();
						/*     */ }
					/*     */ }
				/*     */ }
			/*     */ });
		/* 316 */ damageListener.start();
		/*     */ }

	/*     */
	/*     */ public void leftRightMoving()
	/*     */ {
		/* 325 */ Thread leftMove = new Thread(new Runnable()
		/*     */ {
			/*     */ public void run()
			/*     */ {
				/* 329 */ while (Mario.this.mario.isLiving())
				/*     */ {
					/* 332 */ if (Mario.this.isLeftMoving())
					/*     */ {
						/* 334 */ int checkPoint = Mario.this.getLeft();
						/* 335 */ boolean moveLeft = true;
						/*     */
						/* 338 */ if (checkPoint == 0) {
							/* 339 */ moveLeft = false;
							/*     */ }
							/*     */ else
						/*     */ {
							/* 343 */ for (int counter = 0; counter < Mario.this.level.getLifelesses()
									.size(); counter++) {
								/* 344 */ Lifeless currentBlock = (Lifeless) Mario.this.level.getLifelesses()
										.get(counter);
								/* 345 */ if ((Mario.this.getBottom() > currentBlock.getTop())
										&& (Mario.this.getTop() < currentBlock.getBottom()) &&
										/* 346 */ (checkPoint == currentBlock.getRight())) {
									/* 347 */ moveLeft = false;
									/* 348 */ break;
									/*     */ }
								/*     */ }
							/*     */
							/* 352 */ if (moveLeft) {
								/* 353 */ Mario.this.getAprc().setBounds(Mario.this.getLeft() - 1, Mario.this.getTop(),
										Mario.this.getWidth(), Mario.this.getHeight());
								/*     */ }
							/*     */
							/*     */ }
						/*     */
						/* 359 */ if ((!Mario.this.isFalling()) &&
								/* 360 */ (!Mario.this.isJumping()) && (!Mario.this.isFalling())) {
							/* 361 */ Mario.this.incWalkingCount();
							/*     */
							/* 363 */ if (Mario.this.getWalkingCount() < 10) /* 364 */ Mario.this.getAprc()
									.setIcon(new ImageIcon(/* 365 */ new ImageIcon(
											getClass().getResource("/images/mario/mario-walk-L-0.png"))
													/* 366 */ .getImage().getScaledInstance(Mario.this.getWidth(),
															Mario.this.getHeight(), /* 367 */ 1)));
							/* 368 */ else
								if (Mario.this.getWalkingCount() < 20) /* 369 */ Mario.this.getAprc()
										.setIcon(new ImageIcon(/* 370 */ new ImageIcon(
												getClass().getResource("/images/mario/mario-walk-L-1.png"))
														/* 371 */ .getImage().getScaledInstance(Mario.this.getWidth(),
																Mario.this.getHeight(), /* 372 */ 1)));
							/* 373 */ else if (Mario.this.getWalkingCount() < 30) /* 374 */ Mario.this.getAprc()
									.setIcon(new ImageIcon(/* 375 */ new ImageIcon(
											getClass().getResource("/images/mario/mario-walk-L-2.png"))
													/* 376 */ .getImage().getScaledInstance(Mario.this.getWidth(),
															Mario.this.getHeight(), /* 377 */ 1)));
							/*     */ else {
								/* 379 */ Mario.this.setWalkingCount(0);
								/*     */ }
							/*     */
							/*     */ }
						/*     */
						/*     */ }
						/* 385 */ else if (Mario.this.isRightMoving()) {
						/* 386 */ int checkPoint = Mario.this.getRight();
						/* 387 */ boolean moveRight = true;
						/*     */
						/* 391 */ for (int counter = 0; counter < Mario.this.level.getLifelesses().size(); counter++) {
							/* 392 */ Lifeless currentBlock = (Lifeless) Mario.this.level.getLifelesses().get(counter);
							/* 393 */ if ((Mario.this.getBottom() > currentBlock.getTop())
									&& (Mario.this.getTop() < currentBlock.getBottom()) &&
									/* 394 */ (checkPoint == currentBlock.getLeft())) {
								/* 395 */ moveRight = false;
								/* 396 */ break;
								/*     */ }
							/*     */
							/*     */ }
						/*     */
						/* 401 */ if (moveRight) {
							/* 402 */ if (Mario.this.getRight() == 250) {
								/* 403 */ for (int counter = 0; counter < Mario.this.level.getLifelesses()
										.size(); counter++) {
									/* 404 */ JLabel currB = ((Lifeless) Mario.this.level.getLifelesses().get(counter))
											.getAprc();
									/* 405 */ currB.setBounds(currB.getX() - 1, currB.getY(), currB.getWidth(),
											/* 406 */ currB.getHeight());
									/*     */ }
								/* 408 */ for (int counter = 0; counter < Mario.this.level.getMonsters()
										.size(); counter++) {
									/* 409 */ JLabel currB = ((Monster) Mario.this.level.getMonsters().get(counter))
											.getAprc();
									/* 410 */ currB.setBounds(currB.getX() - 1, currB.getY(), currB.getWidth(),
											/* 411 */ currB.getHeight());
									/*     */ }
								/*     */ } else {
								/* 414 */ Mario.this.getAprc().setBounds(Mario.this.getLeft() + 1, Mario.this.getTop(),
										Mario.this.getWidth(), Mario.this.getHeight());
								/*     */ }
							/*     */
							/*     */ }
						/*     */
						/* 420 */ if ((!Mario.this.isFalling()) &&
								/* 421 */ (!Mario.this.isJumping()) && (!Mario.this.isFalling())) {
							/* 422 */ Mario.this.incWalkingCount();
							/* 423 */ if (Mario.this.getWalkingCount() < 10) /* 424 */ Mario.this.getAprc()
									.setIcon(new ImageIcon(/* 425 */ new ImageIcon(
											getClass().getResource("/images/mario/mario-walk-R-0.png"))
													/* 426 */ .getImage().getScaledInstance(Mario.this.getWidth(),
															Mario.this.getHeight(), /* 427 */ 1)));
							/* 428 */ else
								if (Mario.this.getWalkingCount() < 20) /* 429 */ Mario.this.getAprc()
										.setIcon(new ImageIcon(/* 430 */ new ImageIcon(
												getClass().getResource("/images/mario/mario-walk-R-1.png"))
														/* 431 */ .getImage().getScaledInstance(Mario.this.getWidth(),
																Mario.this.getHeight(), /* 432 */ 1)));
							/* 433 */ else if (Mario.this.getWalkingCount() < 30) /* 434 */ Mario.this.getAprc()
									.setIcon(new ImageIcon(/* 435 */ new ImageIcon(
											getClass().getResource("/images/mario/mario-walk-R-2.png"))
													/* 436 */ .getImage().getScaledInstance(Mario.this.getWidth(),
															Mario.this.getHeight(), /* 437 */ 1)));
							/*     */ else {
								/* 439 */ Mario.this.setWalkingCount(0);
								/*     */ }
							/*     */
							/*     */ }
						/*     */
						/*     */ }
						/* 447 */ else if ((!Mario.this.isFalling()) && (!Mario.this.isJumping())) {
						/* 448 */ Mario.this.getAprc()
								.setIcon(/* 449 */ new ImageIcon(
										new ImageIcon(getClass().getResource("/images/mario/mario-stay.png"))
												/* 450 */ .getImage()
												.getScaledInstance(Mario.this.getWidth(), Mario.this.getHeight(), 1)));
						/*     */ }
					/*     */ try
					/*     */ {
						/* 454 */ Thread.sleep(Mario.this.speed);
						/*     */ } catch (InterruptedException ex) {
						/* 456 */ Thread.currentThread().interrupt();
						/*     */ }
					/*     */ }
				/*     */ }
			/*     */ });
		/* 462 */ leftMove.start();
		/*     */ }

	/*     */
	/*     */ public boolean inBlock(Lifeless block, Mario mario_mairo) {
		/* 466 */ int inBlock1X = block.getLeft();
		/* 467 */ int inBlock1Y = block.getTop();
		/* 468 */ int inBlock2X = block.getRight();
		/*     */
		/* 470 */ int marioX1 = this.mario.getLeft();
		/* 471 */ int marioX2 = this.mario.getRight();
		/* 472 */ int marioY2 = this.mario.getBottom();
		/*     */
		/* 474 */ if (mario_mairo.getWidth() < block.getWidth()) {
			/* 475 */ if (((marioX1 > inBlock1X) && (marioX1 < inBlock2X))
					|| ((marioX2 < inBlock2X) && (marioX2 > inBlock1X) &&
							/* 476 */ (marioY2 == inBlock1Y))) {
				/* 477 */ return true;
				/*     */ }
			/*     */
			/*     */ }
			/* 481 */ else
			if (((marioX1 < inBlock1X) && (marioX2 > inBlock1X)) || ((marioX1 < inBlock2X) && (marioX2 > inBlock2X) &&
					/* 482 */ (marioY2 == inBlock1Y))) {
			/* 483 */ return true;
			/*     */ }
		/*     */
		/* 487 */ return false;
		/*     */ }

	/*     */
	/*     */ public boolean inBlockJump(Lifeless block, Mario mario_mairo) {
		/* 491 */ int inBlock1X = block.getLeft();
		/* 492 */ int inBlock2X = block.getRight();
		/* 493 */ int inBlock2Y = block.getBottom();
		/*     */
		/* 495 */ int marioX1 = this.mario.getLeft();
		/* 496 */ int marioY1 = this.mario.getTop();
		/* 497 */ int marioX2 = this.mario.getRight();
		/*     */
		/* 499 */ if (mario_mairo.getWidth() < block.getWidth()) {
			/* 500 */ if (((marioX1 > inBlock1X) && (marioX1 < inBlock2X))
					|| ((marioX2 < inBlock2X) && (marioX2 > inBlock1X) &&
							/* 501 */ (marioY1 == inBlock2Y))) {
				/* 502 */ return true;
				/*     */ }
			/*     */
			/*     */ }
			/* 506 */ else
			if (((marioX1 < inBlock1X) && (marioX2 > inBlock1X)) || ((marioX1 < inBlock2X) && (marioX2 > inBlock2X) &&
					/* 507 */ (marioY1 == inBlock2Y))) {
			/* 508 */ return true;
			/*     */ }
		/*     */
		/* 512 */ return false;
		/*     */ }

	/*     */
	/*     */ public boolean inObject(GameObject monster, Mario mario) {
		/* 516 */ int monster1X = monster.getAprc().getX();
		/* 517 */ int monster1Y = monster.getAprc().getY();
		/* 518 */ int monster2X = monster.getRight();
		/* 519 */ int monster2Y = monster.getBottom();
		/*     */
		/* 521 */ int marioX1 = getLeft();
		/* 522 */ int marioX2 = getRight();
		/* 523 */ int marioY1 = getTop();
		/* 524 */ int marioY2 = getBottom();
		/*     */
		/* 526 */ if (((marioX1 >= monster1X) && (marioX1 <= monster2X))
				|| ((marioX2 <= monster2X) && (marioX2 >= monster1X) && (
				/* 527 */ ((marioY1 > monster1Y) && (marioY1 < monster2Y))
						|| ((marioY2 >= monster1Y) && (marioY2 <= monster2Y))))) {
			/* 528 */ return true;
			/*     */ }
		/*     */
		/* 531 */ return false;
		/*     */ }

	/*     */
	/*     */ public boolean inTopObject(GameObject monster, Mario mario) {
		/* 535 */ int monster1X = monster.getAprc().getX();
		/* 536 */ int monster1Y = monster.getAprc().getY();
		/* 537 */ int monster2X = monster.getRight();
		/*     */
		/* 539 */ int marioX1 = getLeft();
		/* 540 */ int marioX2 = getRight();
		/* 541 */ int marioY2 = getBottom();
		/*     */
		/* 543 */ if (((marioX1 >= monster1X) && (marioX1 <= monster2X))
				|| ((marioX2 <= monster2X) && (marioX2 >= monster1X) && (
				/* 544 */ (marioY2 == monster1Y) || ((marioY2 > monster1Y) && (marioY2 - 10 <= monster1Y))))) {
			/* 545 */ return true;
			/*     */ }
		/*     */
		/* 548 */ return false;
		/*     */ }

	/*     */
	/*     */ public int getHealth() {
		/* 552 */ return this.health;
		/*     */ }

	/*     */
	/*     */ public void setHealth(int health) {
		/* 556 */ this.health = health;
		/*     */ }

	/*     */
	/*     */ public void incJumpingCount() {
		/* 560 */ this.jumpingCount += 1;
		/*     */ }

	/*     */
	/*     */ public void incWalkingCount() {
		/* 564 */ this.walkingCount += 1;
		/*     */ }

	/*     */
	/*     */ public boolean isBig() {
		/* 568 */ return this.big;
		/*     */ }

	/*     */
	/*     */ public void setBig(boolean big) {
		/* 572 */ this.big = big;
		/*     */ }

	/*     */
	/*     */ public void incGold() {
		/* 576 */ this.gold += 1;
		/*     */ }

	/*     */
	/*     */ public int getGold() {
		/* 580 */ return this.gold;
		/*     */ }

	/*     */
	/*     */ public void setGold(int gold) {
		/* 584 */ this.gold = gold;
		/*     */ }

	/*     */
	/*     */ public Level getLevel() {
		/* 588 */ return this.level;
		/*     */ }

	/*     */
	/*     */ public void setLevel(Level level) {
		/* 592 */ this.level = level;
		/*     */ }

	/*     */
	/*     */ public Mario getMario() {
		/* 596 */ return this.mario;
		/*     */ }

	/*     */
	/*     */ public void setMario(Mario mario) {
		/* 600 */ this.mario = mario;
		/*     */ }

	/*     */
	/*     */ public int getBigMarioHeight() {
		/* 604 */ return this.bigMarioHeight;
		/*     */ }

	/*     */
	/*     */ public void setBigMarioHeight(int bigMarioHeight) {
		/* 608 */ this.bigMarioHeight = bigMarioHeight;
		/*     */ }

	/*     */
	/*     */ public int getSmallMarioHeight() {
		/* 612 */ return this.smallMarioHeight;
		/*     */ }

	/*     */
	/*     */ public void setSmallMarioHeight(int smallMarioHeight) {
		/* 616 */ this.smallMarioHeight = smallMarioHeight;
		/*     */ }

	/*     */
	/*     */ public int getMarioWidth() {
		/* 620 */ return this.marioWidth;
		/*     */ }

	/*     */
	/*     */ public void setMarioWidth(int marioWidth) {
		/* 624 */ this.marioWidth = marioWidth;
		/*     */ }

	/*     */
	/*     */ public int getSpeed() {
		/* 628 */ return this.speed;
		/*     */ }

	/*     */
	/*     */ public void setSpeed(int speed) {
		/* 632 */ this.speed = speed;
		/*     */ }

	/*     */
	/*     */ public boolean isGhost() {
		/* 636 */ return this.ghost;
		/*     */ }

	/*     */
	/*     */ public void setGhost(boolean ghost) {
		/* 640 */ this.ghost = ghost;
		/*     */ }
	/*     */ }
