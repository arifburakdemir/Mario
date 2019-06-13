/*     */ package gameObject.level;
/*     */ 
/*     */ import Main.GameOver;
/*     */ import Main.StartMenu;
/*     */ import gameObject.item.Coin;
/*     */ import gameObject.item.mushroom.Mushroom;
/*     */ import gameObject.item.mushroom.MushroomBigger;
/*     */ import gameObject.lifeless.Lifeless;
/*     */ import gameObject.living.Mario;
/*     */ import gameObject.living.monster.Monster;
/*     */ import java.awt.Container;
/*     */ import java.awt.Image;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.KeyListener;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Timer;
/*     */ import java.util.TimerTask;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class Level extends JPanel
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  27 */   Coin coin = new Coin(-15, -15);
/*  28 */   MushroomBigger mushBig = new MushroomBigger();
/*  29 */   JLabel background = new JLabel("");
/*     */   StartMenu startMenu;
/*  32 */   Mario mario_mario = new Mario();
/*     */ 
/*  34 */   ArrayList<Mushroom> mushs = new ArrayList();
/*  35 */   ArrayList<Monster> Monsters = new ArrayList();
/*  36 */   ArrayList<Lifeless> Lifelesses = new ArrayList();
/*     */ 
/*  38 */   JLabel gold_count_label = new JLabel("000");
/*  39 */   JLabel gold_count_pic_label = new JLabel("");
/*  40 */   JLabel gold_x_label = new JLabel("x");
/*     */ 
/*  42 */   int goldGifCounter = 0;
/*  43 */   int gravityDelayEnd = 10;
/*  44 */   int gravityDelayStart = 3;
/*  45 */   int gravityDelay = this.gravityDelayStart;
/*     */ 
/*  47 */   boolean play = true;
/*  48 */   boolean Level2 = false;
/*  49 */   boolean finish = false;
/*     */ 
/*     */   public void gameMachine()
/*     */   {
/*  53 */     Thread generalMachine = new Thread(new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/*  58 */         Level.this.goldGif();
/*     */ 
/*  60 */         boolean shouldFall2 = true;
/*     */ 
/*  62 */         if ((Level.this.mushBig.getTop() >= Level.this.getHeight()) || (Level.this.mushBig.getLeft() < -5)) {
/*  63 */           Level.this.mushBig.setMoveable(false);
/*  64 */           Level.this.mushBig.mushroomHide();
/*     */         }
/*     */ 
/*  67 */         if (Level.this.mushBig.isMoveable()) {
/*  68 */           for (int counter2 = 0; counter2 < Level.this.Lifelesses.size(); counter2++)
/*     */           {
/*  70 */             Lifeless curBlock = (Lifeless)Level.this.Lifelesses.get(counter2);
/*  71 */             if (((Level.this.mushBig.getLeft() >= curBlock.getLeft()) && (Level.this.mushBig.getLeft() <= curBlock.getRight())) || (
/*  72 */               (Level.this.mushBig.getRight() >= curBlock.getLeft()) && 
/*  73 */               (Level.this.mushBig.getRight() <= curBlock.getRight()) && 
/*  74 */               (Level.this.mushBig.getBottom() == curBlock.getTop()))) {
/*  75 */               shouldFall2 = false;
/*     */             }
/*  77 */             if (((Level.this.mushBig.getTop() > curBlock.getTop()) && (Level.this.mushBig.getTop() < curBlock.getBottom())) || (
/*  78 */               (Level.this.mushBig.getBottom() > curBlock.getTop()) && 
/*  79 */               (Level.this.mushBig.getBottom() < curBlock.getBottom()) && (
/*  80 */               (Level.this.mushBig.getRight() == curBlock.getLeft()) || 
/*  81 */               (Level.this.mushBig.getLeft() == curBlock.getRight())))) {
/*  82 */               if (Level.this.mushBig.isLeftMoving())
/*  83 */                 Level.this.mushBig.setLeftMoving(false);
/*     */               else {
/*  85 */                 Level.this.mushBig.setLeftMoving(true);
/*     */               }
/*     */             }
/*     */           }
/*  89 */           if (shouldFall2)
/*  90 */             Level.this.mushBig.getAprc().setBounds(Level.this.mushBig.getLeft(), Level.this.mushBig.getTop() + 1, Level.this.mushBig.getWidth(), 
/*  91 */               Level.this.mushBig.getHeight());
/*     */           else {
/*  93 */             shouldFall2 = false;
/*     */           }
/*     */ 
/*  96 */           if (Level.this.mushBig.isLeftMoving())
/*  97 */             Level.this.mushBig.getAprc().setBounds(Level.this.mushBig.getLeft() - 1, Level.this.mushBig.getTop(), Level.this.mushBig.getWidth(), 
/*  98 */               Level.this.mushBig.getHeight());
/*     */           else {
/* 100 */             Level.this.mushBig.getAprc().setBounds(Level.this.mushBig.getLeft() + 1, Level.this.mushBig.getTop(), Level.this.mushBig.getWidth(), 
/* 101 */               Level.this.mushBig.getHeight());
/*     */           }
/*     */         }
/*     */ 
/* 105 */         for (int counter = 0; counter < Level.this.Monsters.size(); counter++) {
/* 106 */           Monster curMonster = (Monster)Level.this.Monsters.get(counter);
/*     */ 
/* 108 */           if (curMonster.isCanFall())
/*     */           {
/* 111 */             boolean shouldFall = true;
/*     */ 
/* 113 */             if (curMonster.getTop() >= Level.this.getHeight()) {
/* 114 */               Level.this.Monsters.remove(counter);
/*     */             }
/*     */             else
/*     */             {
/* 118 */               for (int counter2 = 0; counter2 < Level.this.Lifelesses.size(); counter2++)
/*     */               {
/* 120 */                 Lifeless curBlock = (Lifeless)Level.this.Lifelesses.get(counter2);
/*     */ 
/* 122 */                 if (Level.this.inObject(curBlock, curMonster)) {
/* 123 */                   if (curMonster.isLeftMoving())
/* 124 */                     curMonster.setLeftMoving(false);
/*     */                   else {
/* 126 */                     curMonster.setLeftMoving(true);
/*     */                   }
/*     */                 }
/* 129 */                 if (((curMonster.getLeft() >= curBlock.getLeft()) && (curMonster.getLeft() <= curBlock.getRight())) || (
/* 130 */                   (curMonster.getRight() >= curBlock.getLeft()) && 
/* 131 */                   (curMonster.getRight() <= curBlock.getRight()) && 
/* 132 */                   (curMonster.getBottom() == curBlock.getTop()))) {
/* 133 */                   shouldFall = false;
/*     */                 }
/* 135 */                 if (((curMonster.getTop() > curBlock.getTop()) && (curMonster.getTop() < curBlock.getBottom())) || (
/* 136 */                   (curMonster.getBottom() > curBlock.getTop()) && 
/* 137 */                   (curMonster.getBottom() < curBlock.getBottom()) && (
/* 138 */                   (curMonster.getRight() == curBlock.getLeft()) || 
/* 139 */                   (curMonster.getLeft() == curBlock.getRight())))) {
/* 140 */                   if (curMonster.isLeftMoving())
/* 141 */                     curMonster.setLeftMoving(false);
/*     */                   else {
/* 143 */                     curMonster.setLeftMoving(true);
/*     */                   }
/*     */                 }
/*     */               }
/* 147 */               if ((shouldFall) && (((Monster)Level.this.Monsters.get(counter)).isCanFall()))
/* 148 */                 curMonster.getAprc().setBounds(curMonster.getLeft(), curMonster.getTop() + 1, 
/* 149 */                   curMonster.getWidth(), curMonster.getHeight());
/*     */               else {
/* 151 */                 shouldFall = false;
/*     */               }
/* 153 */               if (curMonster.isCanMove()) {
/* 154 */                 if (curMonster.isLeftMoving())
/* 155 */                   curMonster.getAprc().setBounds(curMonster.getLeft() - 1, curMonster.getTop(), 
/* 156 */                     curMonster.getWidth(), curMonster.getHeight());
/*     */                 else {
/* 158 */                   curMonster.getAprc().setBounds(curMonster.getLeft() + 1, curMonster.getTop(), 
/* 159 */                     curMonster.getWidth(), curMonster.getHeight());
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/* 165 */         if (!Level.this.mario_mario.isLiving())
/*     */         {
/* 168 */           if (Level.this.mario_mario.getHealth() == -1) {
/*     */             try {
/* 170 */               Thread.sleep(900L);
/*     */             } catch (InterruptedException e) {
/* 172 */               e.printStackTrace();
/*     */             }
/*     */ 
/* 175 */             GameOver gameOver = new GameOver(Level.this.startMenu);
/* 176 */             Level.this.startMenu.setContentPane(gameOver);
/* 177 */             Level.this.startMenu.validate();
/* 178 */             gameOver.requestFocus();
/* 179 */             Level.this.play = false;
/*     */           }
/*     */           else
/*     */           {
/* 184 */             Level.this.mario_mario.setLiving(false);
/* 185 */             Level.this.play = false;
/*     */ 
/* 188 */             if (Level.this.mario_mario.getLevel().getClass().isAssignableFrom(Level2.class)) {
/* 189 */               Curtain curtain = new Curtain(Level.this.startMenu, Level.this.mario_mario.getGold(), Level.this.mario_mario.getHealth(), 2);
/* 190 */               Level.this.startMenu.setContentPane(curtain);
/* 191 */               Level.this.startMenu.validate();
/* 192 */               curtain.requestFocus();
/* 193 */               Timer levelStart = new Timer();
/* 194 */               levelStart.schedule(new TimerTask()
/*     */               {
/*     */                 public void run() {
/* 197 */                   Level2 level2 = new Level2(Level.this.startMenu, Level.this.mario_mario.getGold(), 
/* 198 */                     Level.this.mario_mario.getHealth(), false);
/* 199 */                   Level.this.startMenu.setContentPane(level2);
/* 200 */                   Level.this.startMenu.validate();
/* 201 */                   level2.requestFocus();
/*     */                 }
/*     */               }
/*     */               , 1000L);
/*     */             }
/*     */             else
/*     */             {
/* 207 */               Curtain curtain = new Curtain(Level.this.startMenu, Level.this.mario_mario.getGold(), Level.this.mario_mario.getHealth(), 1);
/* 208 */               Level.this.startMenu.setContentPane(curtain);
/* 209 */               Level.this.startMenu.validate();
/* 210 */               curtain.requestFocus();
/* 211 */               Timer levelStart = new Timer();
/* 212 */               levelStart.schedule(new TimerTask()
/*     */               {
/*     */                 public void run() {
/* 215 */                   Level1 level2 = new Level1(Level.this.startMenu, Level.this.mario_mario.getGold(), 
/* 216 */                     Level.this.mario_mario.getHealth());
/* 217 */                   Level.this.startMenu.setContentPane(level2);
/* 218 */                   Level.this.startMenu.validate();
/* 219 */                   level2.requestFocus();
/*     */                 }
/*     */               }
/*     */               , 1000L);
/*     */             }
/*     */           }
/* 224 */           return;
/*     */         }
/*     */         try {
/* 227 */           Thread.sleep(7L);
/*     */         } catch (InterruptedException ex) {
/* 229 */           Thread.currentThread().interrupt();
/*     */         }
/* 231 */         if (Level.this.Level2) {
/* 232 */           Level.this.goLevel2();
/* 233 */           Level.this.play = false;
/* 234 */           Level.this.mario_mario.setLiving(false);
/* 235 */           return;
/* 236 */         }if (Level.this.finish) {
/* 237 */           Level.this.play = false;
/* 238 */           Level.this.mario_mario.setLiving(false);
/* 239 */           Level.this.goFinish();
/*     */         }
/* 241 */         if (Level.this.play)
/* 242 */           Level.this.gameMachine();
/*     */       }
/*     */     });
/* 247 */     generalMachine.start();
/*     */   }
/*     */ 
/*     */   public void goFinish() {
/* 251 */     Win curtain = new Win(this.startMenu, this.mario_mario.getGold(), this.mario_mario.getHealth());
/* 252 */     this.startMenu.setContentPane(curtain);
/* 253 */     this.startMenu.validate();
/* 254 */     curtain.requestFocus();
/*     */ 
/* 256 */     Timer levelStart = new Timer();
/* 257 */     levelStart.schedule(new TimerTask()
/*     */     {
/*     */       public void run() {
/* 260 */         Level.this.startMenu.setContentPane(Level.this.startMenu.contentPane);
/* 261 */         Level.this.startMenu.validate();
/* 262 */         Level.this.startMenu.getContentPane().requestFocus();
/*     */       }
/*     */     }
/*     */     , 3000L);
/*     */   }
/*     */   public void goLevel2() {
/* 267 */     Curtain curtain = new Curtain(this.startMenu, this.mario_mario.getGold(), this.mario_mario.getHealth(), 2);
/* 268 */     this.startMenu.setContentPane(curtain);
/* 269 */     this.startMenu.validate();
/* 270 */     curtain.requestFocus();
/*     */ 
/* 272 */     Timer levelStart = new Timer();
/* 273 */     levelStart.schedule(new TimerTask()
/*     */     {
/*     */       public void run() {
/* 276 */         Level2 level2 = new Level2(Level.this.startMenu, Level.this.mario_mario.getGold(), Level.this.mario_mario.getHealth(), 
/* 277 */           Level.this.mario_mario.isBig());
/* 278 */         Level.this.startMenu.setContentPane(level2);
/* 279 */         Level.this.startMenu.validate();
/* 280 */         level2.requestFocus();
/*     */       }
/*     */     }
/*     */     , 1000L);
/*     */   }
/*     */ 
/*     */   public void appereance()
/*     */   {
/* 288 */     this.mushs.add(this.mushBig);
/* 289 */     add(this.coin.getAprc());
/* 290 */     add(this.mushBig.getAprc());
/*     */ 
/* 292 */     this.background.setIcon(new ImageIcon(new ImageIcon(Level1.class.getResource("/images/levels/level1_air.png"))
/* 293 */       .getImage().getScaledInstance(this.startMenu.getWidth(), getHeight(), 1)));
/* 294 */     this.background.setBounds(0, 0, this.startMenu.getWidth(), getHeight());
/* 295 */     add(this.background);
/*     */ 
/* 297 */     requestFocusInWindow();
/* 298 */     addKeyListener(new KeyListener()
/*     */     {
/*     */       public void keyTyped(KeyEvent e)
/*     */       {
/*     */       }
/*     */ 
/*     */       public void keyReleased(KeyEvent e)
/*     */       {
/* 306 */         if (e.getKeyCode() == 83) {
/* 307 */           Level.this.mario_mario.setSpeed(7);
/*     */         }
/* 309 */         if (e.getKeyCode() == 39)
/* 310 */           Level.this.mario_mario.setRightMoving(false);
/* 311 */         else if (e.getKeyCode() == 37)
/* 312 */           Level.this.mario_mario.setLeftMoving(false);
/*     */       }
/*     */ 
/*     */       public void keyPressed(KeyEvent e)
/*     */       {
/* 318 */         if (e.getKeyCode() == 83) {
/* 319 */           Level.this.mario_mario.setSpeed(4);
/*     */         }
/* 321 */         if (e.getKeyCode() == 38) {
/* 322 */           if ((!Level.this.mario_mario.isJumping()) && (!Level.this.mario_mario.isFalling()))
/* 323 */             Level.this.mario_mario.setJumping(true);
/*     */         }
/* 325 */         else if (e.getKeyCode() == 39) {
/* 326 */           Level.this.mario_mario.setLeftMoving(false);
/* 327 */           Level.this.mario_mario.setRightMoving(true);
/* 328 */         } else if (e.getKeyCode() == 37) {
/* 329 */           Level.this.mario_mario.setRightMoving(false);
/* 330 */           Level.this.mario_mario.setLeftMoving(true);
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   public void mushroomShow(String str, final int x, int y)
/*     */   {
/* 338 */     Mushroom mushroom = new Mushroom();
/* 339 */     if (str.equals("big")) {
/* 340 */       mushroom = this.mushBig;
/*     */     }
/* 342 */     final Mushroom lastMushroom = mushroom;
/* 343 */     final int checkY = y - lastMushroom.getHeight();
/*     */ 
/* 345 */     lastMushroom.getAprc().setVisible(true);
/*     */ 
/* 347 */     lastMushroom.getAprc().setBounds(x, y, lastMushroom.getWidth(), lastMushroom.getHeight());
/* 348 */     Thread showing = new Thread(new Runnable()
/*     */     {
/*     */       public void run() {
/* 351 */         while (lastMushroom.getTop() != checkY) {
/* 352 */           lastMushroom.getAprc().setBounds(x, lastMushroom.getTop() - 1, lastMushroom.getWidth(), 
/* 353 */             lastMushroom.getHeight());
/*     */           try {
/* 355 */             Thread.sleep(14L);
/*     */           }
/*     */           catch (InterruptedException e) {
/* 358 */             e.printStackTrace();
/*     */           }
/*     */         }
/* 361 */         lastMushroom.setMoveable(true);
/*     */       }
/*     */     });
/* 364 */     showing.start();
/*     */   }
/*     */ 
/*     */   public void showGold(int x, int y) {
/* 368 */     this.coin.getAprc().setBounds(x + 5, y - 20, 15, 15);
/*     */   }
/*     */ 
/*     */   public void hideGold() {
/* 372 */     this.coin.getAprc().setBounds(-15, -15, 15, 15);
/*     */   }
/*     */ 
/*     */   public boolean inObject(Lifeless lifeless, Monster monster) {
/* 376 */     int monster1X = monster.getAprc().getX();
/* 377 */     int monster1Y = monster.getAprc().getY();
/* 378 */     int monster2X = monster.getRight();
/* 379 */     int monster2Y = monster.getBottom();
/*     */ 
/* 381 */     int marioX1 = lifeless.getLeft();
/* 382 */     int marioX2 = lifeless.getRight();
/* 383 */     int marioY1 = lifeless.getTop();
/* 384 */     int marioY2 = lifeless.getBottom();
/*     */ 
/* 386 */     if (((marioX1 > monster1X) && (marioX1 < monster2X)) || ((marioX2 < monster2X) && (marioX2 > monster1X) && (
/* 387 */       ((marioY1 > monster1Y) && (marioY1 < monster2Y)) || ((marioY2 >= monster1Y) && (marioY2 <= monster2Y))))) {
/* 388 */       return true;
/*     */     }
/*     */ 
/* 391 */     return false;
/*     */   }
/*     */ 
/*     */   public void goldGif() {
/* 395 */     this.goldGifCounter += 1;
/*     */ 
/* 397 */     if (this.goldGifCounter == 5)
/* 398 */       this.gold_count_pic_label.setIcon(new ImageIcon(Level1.class.getResource("/images/items/gold_1.png")));
/* 399 */     else if (this.goldGifCounter == 10)
/* 400 */       this.gold_count_pic_label.setIcon(new ImageIcon(Level1.class.getResource("/images/items/gold_2.png")));
/* 401 */     else if (this.goldGifCounter == 20)
/* 402 */       this.gold_count_pic_label.setIcon(new ImageIcon(Level1.class.getResource("/images/items/gold_3.png")));
/* 403 */     else if (this.goldGifCounter == 30)
/* 404 */       this.gold_count_pic_label.setIcon(new ImageIcon(Level1.class.getResource("/images/items/gold_4.png")));
/* 405 */     else if (this.goldGifCounter > 40)
/* 406 */       this.goldGifCounter = 0;
/*     */   }
/*     */ 
/*     */   public void goldCountUpdate(Mario mario)
/*     */   {
/* 411 */     String gold_count_string = Integer.toString(mario.getGold());
/* 412 */     if (mario.getGold() < 10) {
/* 413 */       gold_count_string = "00" + gold_count_string;
/*     */     }
/*     */     else {
/* 416 */       gold_count_string = "0" + gold_count_string;
/*     */     }
/* 418 */     this.gold_count_label.setText(gold_count_string);
/*     */   }
/*     */ 
/*     */   public Coin getCoin() {
/* 422 */     return this.coin;
/*     */   }
/*     */ 
/*     */   public void setCoin(Coin coin) {
/* 426 */     this.coin = coin;
/*     */   }
/*     */ 
/*     */   public MushroomBigger getMushBig() {
/* 430 */     return this.mushBig;
/*     */   }
/*     */ 
/*     */   public void setMushBig(MushroomBigger mushBig) {
/* 434 */     this.mushBig = mushBig;
/*     */   }
/*     */ 
/*     */   public ArrayList<Mushroom> getMushs() {
/* 438 */     return this.mushs;
/*     */   }
/*     */ 
/*     */   public void setMushs(ArrayList<Mushroom> mushs) {
/* 442 */     this.mushs = mushs;
/*     */   }
/*     */ 
/*     */   public ArrayList<Monster> getMonsters() {
/* 446 */     return this.Monsters;
/*     */   }
/*     */ 
/*     */   public void setMonsters(ArrayList<Monster> monsters) {
/* 450 */     this.Monsters = monsters;
/*     */   }
/*     */ 
/*     */   public ArrayList<Lifeless> getLifelesses() {
/* 454 */     return this.Lifelesses;
/*     */   }
/*     */ 
/*     */   public void setLifelesses(ArrayList<Lifeless> lifelesses) {
/* 458 */     this.Lifelesses = lifelesses;
/*     */   }
/*     */ 
/*     */   public JLabel getGold_count_label() {
/* 462 */     return this.gold_count_label;
/*     */   }
/*     */ 
/*     */   public void setGold_count_label(JLabel gold_count_label) {
/* 466 */     this.gold_count_label = gold_count_label;
/*     */   }
/*     */ 
/*     */   public JLabel getGold_count_pic_label() {
/* 470 */     return this.gold_count_pic_label;
/*     */   }
/*     */ 
/*     */   public void setGold_count_pic_label(JLabel gold_count_pic_label) {
/* 474 */     this.gold_count_pic_label = gold_count_pic_label;
/*     */   }
/*     */ 
/*     */   public int getGoldGifCounter() {
/* 478 */     return this.goldGifCounter;
/*     */   }
/*     */ 
/*     */   public void setGoldGifCounter(int goldGifCounter) {
/* 482 */     this.goldGifCounter = goldGifCounter;
/*     */   }
/*     */ 
/*     */   public int getGravityDelayEnd() {
/* 486 */     return this.gravityDelayEnd;
/*     */   }
/*     */ 
/*     */   public void setGravityDelayEnd(int gravityDelayEnd) {
/* 490 */     this.gravityDelayEnd = gravityDelayEnd;
/*     */   }
/*     */ 
/*     */   public int getGravityDelayStart() {
/* 494 */     return this.gravityDelayStart;
/*     */   }
/*     */ 
/*     */   public void setGravityDelayStart(int gravityDelayStart) {
/* 498 */     this.gravityDelayStart = gravityDelayStart;
/*     */   }
/*     */ 
/*     */   public int getGravityDelay() {
/* 502 */     return this.gravityDelay;
/*     */   }
/*     */ 
/*     */   public void setGravityDelay(int gravityDelay) {
/* 506 */     this.gravityDelay = gravityDelay;
/*     */   }
/*     */ 
/*     */   public StartMenu getStartMenu() {
/* 510 */     return this.startMenu;
/*     */   }
/*     */ 
/*     */   public void setStartMenu(StartMenu startMenu) {
/* 514 */     this.startMenu = startMenu;
/*     */   }
/*     */ 
/*     */   public Mario getMario_mario() {
/* 518 */     return this.mario_mario;
/*     */   }
/*     */ 
/*     */   public void setMario_mario(Mario mario_mario) {
/* 522 */     this.mario_mario = mario_mario;
/*     */   }
/*     */ 
/*     */   public boolean isPlay() {
/* 526 */     return this.play;
/*     */   }
/*     */ 
/*     */   public void setPlay(boolean play) {
/* 530 */     this.play = play;
/*     */   }
/*     */ 
/*     */   public static long getSerialversionuid() {
/* 534 */     return 1L;
/*     */   }
/*     */ 
/*     */   public boolean isNextLevel() {
/* 538 */     return this.Level2;
/*     */   }
/*     */ 
/*     */   public void setNextLevel(boolean nextLevel) {
/* 542 */     this.Level2 = nextLevel;
/*     */   }
/*     */ 
/*     */   public void setBackground(JLabel background)
/*     */   {
/* 547 */     this.background = background;
/*     */   }
/*     */ 
/*     */   public JLabel getGold_x_label() {
/* 551 */     return this.gold_x_label;
/*     */   }
/*     */ 
/*     */   public void setGold_x_label(JLabel gold_x_label) {
/* 555 */     this.gold_x_label = gold_x_label;
/*     */   }
/*     */ 
/*     */   public boolean isLevel2() {
/* 559 */     return this.Level2;
/*     */   }
/*     */ 
/*     */   public void setLevel2(boolean level2) {
/* 563 */     this.Level2 = level2;
/*     */   }
/*     */ 
/*     */   public boolean isFinish() {
/* 567 */     return this.finish;
/*     */   }
/*     */ 
/*     */   public void setFinish(boolean finish) {
/* 571 */     this.finish = finish;
/*     */   }
/*     */ }
