/*     */ package gameObject.level;
/*     */ 
/*     */ import Main.StartMenu;
/*     */ import cordinate.Cordinate;
/*     */ import gameObject.GameObject;
/*     */ import gameObject.item.Coin;
/*     */ import gameObject.item.mushroom.MushroomBigger;
/*     */ import gameObject.lifeless.Block;
/*     */ import gameObject.lifeless.Floor;
/*     */ import gameObject.lifeless.GoldBlock;
/*     */ import gameObject.lifeless.Pippe;
/*     */ import gameObject.living.Mario;
/*     */ import gameObject.living.Princess;
/*     */ import gameObject.living.monster.FloorMonster;
/*     */ import gameObject.living.monster.Goomba;
/*     */ import gameObject.living.monster.PiranhaPlant;
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JLabel;
/*     */ 
/*     */ public class Level2 extends Level
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  22 */   Level2 level2 = this;
/*     */ 
/*     */   public Level2(StartMenu startMenu, int gold, int health, boolean big)
/*     */   {
/*  26 */     this.mario_mario.setLevel(this.level2);
/*  27 */     if (big) {
/*  28 */       this.mario_mario.growing();
/*     */     }
/*  30 */     this.startMenu = startMenu;
/*  31 */     setLayout(null);
/*  32 */     setBounds(0, 0, 5000, startMenu.getContentPane().getHeight());
/*  33 */     setFocusable(true);
/*     */ 
/*  35 */     Cordinate cor = new Cordinate(this.startMenu.getContentPane().getWidth(), 
/*  36 */       this.startMenu.getContentPane().getHeight());
/*     */ 
/*  38 */     this.mario_mario.getAprc().setBounds(50, 50, this.mario_mario.getWidth(), this.mario_mario.getHeight());
/*  39 */     this.mario_mario.setGold(gold);
/*  40 */     this.mario_mario.setHealth(health);
/*     */ 
/*  42 */     this.gold_count_label.setBounds(53, 21, 25, 16);
/*  43 */     add(this.gold_count_label);
/*     */ 
/*  45 */     this.gold_count_pic_label.setIcon(new ImageIcon(Level1.class.getResource("/images/items/gold_1.png")));
/*  46 */     this.gold_count_pic_label.setBounds(26, 21, 15, 16);
/*  47 */     add(this.gold_count_pic_label);
/*     */ 
/*  49 */     this.gold_x_label.setBounds(40, 21, 15, 16);
/*  50 */     add(this.gold_x_label);
/*     */ 
/*  52 */     add(this.coin.getAprc());
/*  53 */     add(this.mushBig.getAprc());
/*     */ 
/*  55 */     this.gold_count_label.setForeground(Color.WHITE);
/*  56 */     this.gold_x_label.setForeground(Color.WHITE);
/*  57 */     goldCountUpdate(this.mario_mario);
/*     */ 
/*  59 */     Floor floor = new Floor(0, cor.getMaxY());
/*  60 */     floor.level2Floor();
/*  61 */     this.Lifelesses.add(floor);
/*  62 */     add(floor.getAprc());
/*     */ 
/*  64 */     Floor floor2 = new Floor(cor.rightOfGameObject(floor, 0), cor.bottomOfGameObject(floor, 0));
/*  65 */     floor2.level2Floor();
/*  66 */     this.Lifelesses.add(floor2);
/*  67 */     add(floor2.getAprc());
/*     */ 
/*  69 */     Floor floor3 = new Floor(cor.rightOfGameObject(floor2, 0), cor.bottomOfGameObject(floor, 0));
/*  70 */     floor3.level2Floor();
/*  71 */     this.Lifelesses.add(floor3);
/*  72 */     add(floor3.getAprc());
/*     */ 
/*  74 */     FloorMonster floorMonster = new FloorMonster(0, cor.getMaxY() - 5, getWidth());
/*  75 */     this.Monsters.add(floorMonster);
/*  76 */     add(floorMonster.getAprc());
/*     */ 
/*  78 */     for (int counter = 0; counter < 4; counter++) {
/*  79 */       if (counter != 0) {
/*  80 */         GoldBlock goldBlock = new GoldBlock(cor.rightOfGameObject((GameObject)this.Lifelesses.get(this.Lifelesses.size() - 1), 0), 
/*  81 */           cor.bottomOfGameObject((GameObject)this.Lifelesses.get(this.Lifelesses.size() - 1), 0), 5);
/*  82 */         this.Lifelesses.add(goldBlock);
/*  83 */         add(goldBlock.getAprc());
/*     */       }
/*     */       else {
/*  86 */         GoldBlock goldBlock = new GoldBlock(200, 300, 5);
/*  87 */         this.Lifelesses.add(goldBlock);
/*  88 */         add(goldBlock.getAprc());
/*     */       }
/*     */     }
/*     */ 
/*  92 */     for (int counter = 0; counter < 14; counter++) {
/*  93 */       if (counter != 0) {
/*  94 */         Block block = new Block(cor.leftOfGameObject((GameObject)this.Lifelesses.get(this.Lifelesses.size() - 1), 0), 
/*  95 */           cor.bottomOfGameObject((GameObject)this.Lifelesses.get(this.Lifelesses.size() - 1), 25));
/*  96 */         block.darkBlock();
/*  97 */         this.Lifelesses.add(block);
/*  98 */         add(block.getAprc());
/*     */       } else {
/* 100 */         Block block = new Block(0, 33);
/* 101 */         block.darkBlock();
/* 102 */         this.Lifelesses.add(block);
/* 103 */         add(block.getAprc());
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 108 */     for (int counter = 0; counter < 70; counter++) {
/* 109 */       if (counter != 0) {
/* 110 */         Block block = new Block(cor.rightOfGameObject((GameObject)this.Lifelesses.get(this.Lifelesses.size() - 1), 0), 
/* 111 */           cor.bottomOfGameObject((GameObject)this.Lifelesses.get(this.Lifelesses.size() - 1), 0));
/* 112 */         block.darkBlock();
/* 113 */         this.Lifelesses.add(block);
/* 114 */         add(block.getAprc());
/*     */       } else {
/* 116 */         Block block = new Block(60, 33);
/* 117 */         block.darkBlock();
/* 118 */         this.Lifelesses.add(block);
/* 119 */         add(block.getAprc());
/*     */       }
/*     */     }
/*     */ 
/* 123 */     for (int counter2 = 0; counter2 < 2; counter2++) {
/* 124 */       for (int counter = 0; counter < 2; counter++) {
/* 125 */         if (counter != 0) {
/* 126 */           Block block = new Block(cor.leftOfGameObject((GameObject)this.Lifelesses.get(this.Lifelesses.size() - 1), 0), 
/* 127 */             cor.bottomOfGameObject((GameObject)this.Lifelesses.get(this.Lifelesses.size() - 1), 25));
/* 128 */           block.darkBlock();
/* 129 */           this.Lifelesses.add(block);
/* 130 */           add(block.getAprc());
/*     */         } else {
/* 132 */           Block block = new Block(400 + counter2 * 210, 335);
/* 133 */           block.darkBlock();
/* 134 */           this.Lifelesses.add(block);
/* 135 */           add(block.getAprc());
/*     */         }
/*     */       }
/*     */ 
/* 139 */       for (int counter = 0; counter < 3; counter++) {
/* 140 */         if (counter != 0) {
/* 141 */           Block block = new Block(cor.leftOfGameObject((GameObject)this.Lifelesses.get(this.Lifelesses.size() - 1), 0), 
/* 142 */             cor.bottomOfGameObject((GameObject)this.Lifelesses.get(this.Lifelesses.size() - 1), 25));
/* 143 */           block.darkBlock();
/* 144 */           this.Lifelesses.add(block);
/* 145 */           add(block.getAprc());
/*     */         } else {
/* 147 */           Block block = new Block(470 + counter2 * 210, 310);
/* 148 */           block.darkBlock();
/* 149 */           this.Lifelesses.add(block);
/* 150 */           add(block.getAprc());
/*     */         }
/*     */       }
/*     */ 
/* 154 */       for (int counter = 0; counter < 4; counter++) {
/* 155 */         if (counter != 0) {
/* 156 */           Block block = new Block(cor.leftOfGameObject((GameObject)this.Lifelesses.get(this.Lifelesses.size() - 1), 0), 
/* 157 */             cor.bottomOfGameObject((GameObject)this.Lifelesses.get(this.Lifelesses.size() - 1), 25));
/* 158 */           block.darkBlock();
/* 159 */           this.Lifelesses.add(block);
/* 160 */           add(block.getAprc());
/*     */         } else {
/* 162 */           Block block = new Block(540 + counter2 * 210, 285);
/* 163 */           block.darkBlock();
/* 164 */           this.Lifelesses.add(block);
/* 165 */           add(block.getAprc());
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 171 */     Pippe pippe = new Pippe(cor.rightOfGameObject((GameObject)this.Lifelesses.get(this.Lifelesses.size() - 1), 200), 
/* 172 */       cor.topOfGameObject(floor, 0));
/* 173 */     this.Lifelesses.add(pippe);
/* 174 */     add(pippe.getAprc());
/*     */ 
/* 176 */     Goomba goomba1 = new Goomba(cor.rightOfGameObject(pippe, -150), cor.topOfGameObject(floor, 0));
/* 177 */     this.Monsters.add(goomba1);
/* 178 */     add(goomba1.getAprc());
/*     */ 
/* 180 */     PiranhaPlant piranhaPlant = new PiranhaPlant(pippe, this);
/* 181 */     this.Monsters.add(piranhaPlant);
/* 182 */     add(piranhaPlant.getAprc());
/*     */ 
/* 186 */     for (int counter = 0; counter < 5; counter++) {
/* 187 */       if (counter != 0) {
/* 188 */         Block block = new Block(cor.rightOfGameObject((GameObject)this.Lifelesses.get(this.Lifelesses.size() - 1), 0), 
/* 189 */           cor.bottomOfGameObject((GameObject)this.Lifelesses.get(this.Lifelesses.size() - 1), 0));
/* 190 */         block.darkBlock();
/* 191 */         this.Lifelesses.add(block);
/* 192 */         add(block.getAprc());
/*     */       } else {
/* 194 */         Block block = new Block(cor.rightOfGameObject((GameObject)this.Lifelesses.get(this.Lifelesses.size() - 1), 100), 
/* 195 */           cor.topOfGameObject(floor3, 70));
/* 196 */         block.darkBlock();
/* 197 */         this.Lifelesses.add(block);
/* 198 */         add(block.getAprc());
/*     */       }
/*     */     }
/*     */ 
/* 202 */     for (int counter = 0; counter < 5; counter++) {
/* 203 */       if (counter != 0) {
/* 204 */         Block block = new Block(cor.rightOfGameObject((GameObject)this.Lifelesses.get(this.Lifelesses.size() - 1), 0), 
/* 205 */           cor.bottomOfGameObject((GameObject)this.Lifelesses.get(this.Lifelesses.size() - 1), 0));
/* 206 */         block.darkBlock();
/* 207 */         this.Lifelesses.add(block);
/* 208 */         add(block.getAprc());
/*     */       } else {
/* 210 */         Block block = new Block(cor.rightOfGameObject((GameObject)this.Lifelesses.get(this.Lifelesses.size() - 5), 0), 
/* 211 */           cor.topOfGameObject((GameObject)this.Lifelesses.get(this.Lifelesses.size() - 1), 50));
/* 212 */         block.darkBlock();
/* 213 */         this.Lifelesses.add(block);
/* 214 */         add(block.getAprc());
/*     */       }
/*     */     }
/* 217 */     for (int counter = 0; counter < 5; counter++) {
/* 218 */       if (counter != 0) {
/* 219 */         GoldBlock block = new GoldBlock(cor.rightOfGameObject((GameObject)this.Lifelesses.get(this.Lifelesses.size() - 1), 0), 
/* 220 */           cor.bottomOfGameObject((GameObject)this.Lifelesses.get(this.Lifelesses.size() - 1), 0), 6);
/* 221 */         this.Lifelesses.add(block);
/* 222 */         add(block.getAprc());
/*     */       } else {
/* 224 */         Block block = new Block(cor.rightOfGameObject((GameObject)this.Lifelesses.get(this.Lifelesses.size() - 5), 0), 
/* 225 */           cor.topOfGameObject((GameObject)this.Lifelesses.get(this.Lifelesses.size() - 1), 50));
/* 226 */         block.darkBlock();
/* 227 */         this.Lifelesses.add(block);
/* 228 */         add(block.getAprc());
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 234 */     for (int counter = 0; counter < 6; counter++) {
/* 235 */       Pippe pippe2 = new Pippe(cor.rightOfGameObject((GameObject)this.Lifelesses.get(this.Lifelesses.size() - 1), 10), 
/* 236 */         cor.topOfGameObject(floor, 0));
/* 237 */       this.Lifelesses.add(pippe2);
/* 238 */       add(pippe2.getAprc());
/*     */ 
/* 240 */       PiranhaPlant piranhaPlant2 = new PiranhaPlant(pippe2, this);
/* 241 */       this.Monsters.add(piranhaPlant2);
/* 242 */       add(piranhaPlant2.getAprc());
/*     */     }
/*     */ 
/* 246 */     Block block = new Block(cor.rightOfGameObject((GameObject)this.Lifelesses.get(this.Lifelesses.size() - 3), 0), 
/* 247 */       cor.topOfGameObject((GameObject)this.Lifelesses.get(this.Lifelesses.size() - 3), 50));
/* 248 */     block.darkBlock();
/* 249 */     this.Lifelesses.add(block);
/* 250 */     add(block.getAprc());
/*     */ 
/* 254 */     Block block1 = new Block(cor.rightOfGameObject((GameObject)this.Lifelesses.get(this.Lifelesses.size() - 1), 0), 
/* 255 */       cor.topOfGameObject((GameObject)this.Lifelesses.get(this.Lifelesses.size() - 1), 50));
/* 256 */     block1.darkBlock();
/* 257 */     this.Lifelesses.add(block1);
/* 258 */     add(block1.getAprc());
/*     */ 
/* 262 */     Block block2 = new Block(cor.rightOfGameObject((GameObject)this.Lifelesses.get(this.Lifelesses.size() - 1), 0), 
/* 263 */       cor.bottomOfGameObject((GameObject)this.Lifelesses.get(this.Lifelesses.size() - 1), 0));
/* 264 */     block2.darkBlock();
/* 265 */     this.Lifelesses.add(block2);
/* 266 */     add(block2.getAprc());
/*     */ 
/* 270 */     Block block3 = new Block(cor.rightOfGameObject((GameObject)this.Lifelesses.get(this.Lifelesses.size() - 1), 50), 
/* 271 */       cor.bottomOfGameObject((GameObject)this.Lifelesses.get(this.Lifelesses.size() - 1), -50));
/* 272 */     block3.darkBlock();
/* 273 */     this.Lifelesses.add(block3);
/* 274 */     add(block3.getAprc());
/*     */ 
/* 278 */     Floor block4 = new Floor(cor.rightOfGameObject(floor3, 300), 
/* 279 */       cor.bottomOfGameObject(floor3, 0));
/* 280 */     block4.level2Floor();
/* 281 */     this.Lifelesses.add(block4);
/* 282 */     add(block4.getAprc());
/*     */ 
/* 285 */     Princess princess = new Princess(cor.rightOfGameObject((GameObject)this.Lifelesses.get(this.Lifelesses.size() - 1), -100), cor.topOfGameObject(floor3, 0));
/* 286 */     this.Lifelesses.add(princess);
/* 287 */     add(princess.getAprc());
/*     */ 
/* 295 */     add(this.mario_mario.getAprc());
/*     */ 
/* 297 */     gameMachine();
/* 298 */     appereance();
/*     */ 
/* 300 */     this.background.setIcon(null);
/* 301 */     this.background.setBackground(Color.BLACK);
/* 302 */     this.background.setOpaque(true);
/*     */ 
/* 304 */     this.mario_mario.marioMoves();
/*     */   }
/*     */ }
