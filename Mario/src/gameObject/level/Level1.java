/*     */ package gameObject.level;
/*     */ 
/*     */ import Main.StartMenu;
/*     */ import cordinate.Cordinate;
/*     */ import gameObject.lifeless.Block;
/*     */ import gameObject.lifeless.Castle;
/*     */ import gameObject.lifeless.Floor;
/*     */ import gameObject.lifeless.GoldBlock;
/*     */ import gameObject.lifeless.MushroomBlock;
/*     */ import gameObject.lifeless.Pippe;
/*     */ import gameObject.lifeless.SquareBlock;
/*     */ import gameObject.living.Mario;
/*     */ import gameObject.living.monster.FloorMonster;
/*     */ import gameObject.living.monster.Goomba;
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JLabel;
/*     */ 
/*     */ public class Level1 extends Level
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  24 */   Level1 level1 = this;
/*     */ 
/*     */   public Level1(StartMenu startMenu, int gold, int health)
/*     */   {
/*  29 */     this.mario_mario.setLevel(this.level1);
/*  30 */     this.startMenu = startMenu;
/*     */ 
/*  32 */     setLayout(null);
/*  33 */     setBounds(0, 0, 5000, startMenu.getContentPane().getHeight());
/*  34 */     setFocusable(true);
/*     */ 
/*  36 */     Cordinate cor = new Cordinate(this.startMenu.getContentPane().getWidth(), this.startMenu.getContentPane().getHeight());
/*     */ 
/*  39 */     this.mario_mario.setGold(gold);
/*  40 */     this.mario_mario.setHealth(health);
/*     */ 
/*  42 */     this.startMenu = startMenu;
/*     */ 
/*  44 */     goldCountUpdate(this.mario_mario);
/*     */ 
/*  46 */     add(this.mario_mario.getAprc());
/*     */ 
/*  48 */     this.gold_count_label.setBounds(53, 21, 25, 16);
/*  49 */     add(this.gold_count_label);
/*     */ 
/*  51 */     this.gold_count_pic_label.setIcon(new ImageIcon(Level1.class.getResource("/images/items/gold_1.png")));
/*  52 */     this.gold_count_pic_label.setBounds(26, 21, 15, 16);
/*  53 */     add(this.gold_count_pic_label);
/*     */ 
/*  55 */     this.gold_x_label.setBounds(40, 21, 15, 16);
/*  56 */     add(this.gold_x_label);
/*     */ 
/*  58 */     goldCountUpdate(this.mario_mario);
/*     */ 
/*  60 */     this.gold_count_label.setForeground(Color.WHITE);
/*  61 */     this.gold_x_label.setForeground(Color.WHITE);
/*     */ 
/*  63 */     Floor floor = new Floor(0, cor.getMaxY());
/*  64 */     this.Lifelesses.add(floor);
/*  65 */     add(floor.getAprc());
/*     */ 
/*  68 */     Block block0 = new Block(100, cor.topOfGameObject(floor, 50));
/*  69 */     this.Lifelesses.add(block0);
/*  70 */     add(block0.getAprc());
/*     */ 
/*  72 */     Block block1 = new Block(cor.rightOfGameObject(block0, 0), cor.topOfGameObject(floor, 50));
/*  73 */     this.Lifelesses.add(block1);
/*  74 */     add(block1.getAprc());
/*     */ 
/*  76 */     Block block2 = new Block(cor.rightOfGameObject(block1, 0), cor.topOfGameObject(floor, 50));
/*  77 */     this.Lifelesses.add(block2);
/*  78 */     add(block2.getAprc());
/*     */ 
/*  80 */     MushroomBlock block3 = new MushroomBlock(cor.rightOfGameObject(block0, 0), cor.topOfGameObject(block2, 50));
/*  81 */     this.Lifelesses.add(block3);
/*  82 */     add(block3.getAprc());
/*     */ 
/*  84 */     GoldBlock block4 = new GoldBlock(cor.rightOfGameObject(block0, 0), cor.topOfGameObject(block3, 50), 3);
/*  85 */     this.Lifelesses.add(block4);
/*  86 */     add(block4.getAprc());
/*     */ 
/*  88 */     Pippe block6 = new Pippe(cor.rightOfGameObject(block2, 100), cor.topOfGameObject(floor, 0));
/*  89 */     this.Lifelesses.add(block6);
/*  90 */     add(block6.getAprc());
/*     */ 
/*  92 */     Pippe block7 = new Pippe(cor.rightOfGameObject(block6, 150), cor.topOfGameObject(floor, 0));
/*  93 */     this.Lifelesses.add(block7);
/*  94 */     add(block7.getAprc());
/*     */ 
/*  97 */     Floor floor2 = new Floor(cor.rightOfGameObject(floor, 100), cor.getMaxY());
/*  98 */     this.Lifelesses.add(floor2);
/*  99 */     add(floor2.getAprc());
/*     */ 
/* 101 */     Block block8 = new Block(cor.leftOfGameObject(floor2, 100), cor.topOfGameObject(floor, 50));
/* 102 */     this.Lifelesses.add(block8);
/* 103 */     add(block8.getAprc());
/*     */ 
/* 105 */     Block block9 = new Block(cor.rightOfGameObject(block8, 0), cor.topOfGameObject(block8, 50));
/* 106 */     this.Lifelesses.add(block9);
/* 107 */     add(block9.getAprc());
/*     */ 
/* 109 */     GoldBlock goldBlock = new GoldBlock(cor.rightOfGameObject(block9, 0), cor.topOfGameObject(block9, 50), 5);
/* 110 */     this.Lifelesses.add(goldBlock);
/* 111 */     add(goldBlock.getAprc());
/*     */ 
/* 113 */     Block block10 = new Block(cor.rightOfGameObject(block9, 0), cor.topOfGameObject(block8, 50));
/* 114 */     this.Lifelesses.add(block10);
/* 115 */     add(block10.getAprc());
/*     */ 
/* 117 */     GoldBlock goldBlock1 = new GoldBlock(cor.rightOfGameObject(goldBlock, 0), cor.bottomOfGameObject(goldBlock, 0), 5);
/* 118 */     this.Lifelesses.add(goldBlock1);
/* 119 */     add(goldBlock1.getAprc());
/*     */ 
/* 121 */     Block block11 = new Block(cor.rightOfGameObject(block10, 0), cor.topOfGameObject(block8, 50));
/* 122 */     this.Lifelesses.add(block11);
/* 123 */     add(block11.getAprc());
/*     */ 
/* 125 */     Pippe block12 = new Pippe(cor.rightOfGameObject(block11, 50), cor.topOfGameObject(floor2, 0));
/* 126 */     this.Lifelesses.add(block12);
/* 127 */     add(block12.getAprc());
/*     */ 
/* 129 */     Pippe block13 = new Pippe(cor.rightOfGameObject(block12, 150), cor.topOfGameObject(floor2, 0));
/* 130 */     this.Lifelesses.add(block13);
/* 131 */     add(block13.getAprc());
/*     */ 
/* 135 */     Floor floor3 = new Floor(cor.rightOfGameObject(floor2, 100), cor.getMaxY());
/* 136 */     this.Lifelesses.add(floor3);
/* 137 */     add(floor3.getAprc());
/*     */ 
/* 139 */     SquareBlock Sblock = new SquareBlock(cor.leftOfGameObject(floor3, 20), cor.topOfGameObject(floor, 0));
/* 140 */     this.Lifelesses.add(Sblock);
/* 141 */     add(Sblock.getAprc());
/*     */ 
/* 143 */     SquareBlock Sblock1 = new SquareBlock(cor.rightOfGameObject(Sblock, 0), cor.topOfGameObject(floor, 0));
/* 144 */     this.Lifelesses.add(Sblock1);
/* 145 */     add(Sblock1.getAprc());
/*     */ 
/* 147 */     SquareBlock Sblock2 = new SquareBlock(cor.rightOfGameObject(Sblock, 0), cor.topOfGameObject(Sblock1, 0));
/* 148 */     this.Lifelesses.add(Sblock2);
/* 149 */     add(Sblock2.getAprc());
/*     */ 
/* 151 */     SquareBlock Sblock4 = new SquareBlock(cor.rightOfGameObject(Sblock2, 0), cor.topOfGameObject(Sblock2, 0));
/* 152 */     this.Lifelesses.add(Sblock4);
/* 153 */     add(Sblock4.getAprc());
/*     */ 
/* 155 */     SquareBlock Sblock5 = new SquareBlock(cor.rightOfGameObject(Sblock2, 0), cor.topOfGameObject(Sblock1, 0));
/* 156 */     this.Lifelesses.add(Sblock5);
/* 157 */     add(Sblock5.getAprc());
/*     */ 
/* 159 */     SquareBlock Sblock3 = new SquareBlock(cor.rightOfGameObject(Sblock2, 0), cor.topOfGameObject(floor, 0));
/* 160 */     this.Lifelesses.add(Sblock3);
/* 161 */     add(Sblock3.getAprc());
/*     */ 
/* 163 */     SquareBlock Sblock6 = new SquareBlock(cor.rightOfGameObject(Sblock3, 0), cor.topOfGameObject(floor, 0));
/* 164 */     this.Lifelesses.add(Sblock6);
/* 165 */     add(Sblock6.getAprc());
/*     */ 
/* 167 */     SquareBlock Sblock7 = new SquareBlock(cor.rightOfGameObject(Sblock6, 0), cor.topOfGameObject(floor, 0));
/* 168 */     this.Lifelesses.add(Sblock7);
/* 169 */     add(Sblock7.getAprc());
/*     */ 
/* 171 */     SquareBlock Sblock8 = new SquareBlock(cor.rightOfGameObject(Sblock3, 0), cor.topOfGameObject(Sblock3, 0));
/* 172 */     this.Lifelesses.add(Sblock8);
/* 173 */     add(Sblock8.getAprc());
/*     */ 
/* 175 */     Block block100 = new Block(cor.rightOfGameObject(Sblock7, 150), cor.topOfGameObject(floor2, 50));
/* 176 */     this.Lifelesses.add(block100);
/* 177 */     add(block100.getAprc());
/*     */ 
/* 179 */     Block block101 = new Block(cor.rightOfGameObject(block100, 0), cor.topOfGameObject(floor2, 50));
/* 180 */     this.Lifelesses.add(block101);
/* 181 */     add(block101.getAprc());
/*     */ 
/* 183 */     GoldBlock goldBlock100 = new GoldBlock(cor.rightOfGameObject(block101, 0), cor.topOfGameObject(floor3, 50), 20);
/* 184 */     this.Lifelesses.add(goldBlock100);
/* 185 */     add(goldBlock100.getAprc());
/*     */ 
/* 187 */     Pippe pippe1 = new Pippe(cor.rightOfGameObject(goldBlock100, 0), cor.topOfGameObject(floor3, 0));
/* 188 */     this.Lifelesses.add(pippe1);
/* 189 */     add(pippe1.getAprc());
/*     */ 
/* 192 */     Floor floor4 = new Floor(cor.rightOfGameObject(floor3, 0), cor.getMaxY());
/* 193 */     this.Lifelesses.add(floor4);
/* 194 */     add(floor4.getAprc());
/*     */ 
/* 196 */     SquareBlock Sblock9 = new SquareBlock(cor.rightOfGameObject(pippe1, 200), cor.topOfGameObject(floor3, 0));
/* 197 */     this.Lifelesses.add(Sblock9);
/* 198 */     add(Sblock9.getAprc());
/*     */ 
/* 200 */     SquareBlock Sblock10 = new SquareBlock(cor.rightOfGameObject(Sblock9, 0), cor.topOfGameObject(floor3, 0));
/* 201 */     this.Lifelesses.add(Sblock10);
/* 202 */     add(Sblock10.getAprc());
/*     */ 
/* 204 */     SquareBlock Sblock11 = new SquareBlock(cor.rightOfGameObject(Sblock10, 0), cor.topOfGameObject(floor3, 0));
/* 205 */     this.Lifelesses.add(Sblock11);
/* 206 */     add(Sblock11.getAprc());
/*     */ 
/* 208 */     SquareBlock Sblock12 = new SquareBlock(cor.rightOfGameObject(Sblock11, 0), cor.topOfGameObject(floor3, 0));
/* 209 */     this.Lifelesses.add(Sblock12);
/* 210 */     add(Sblock12.getAprc());
/*     */ 
/* 212 */     SquareBlock Sblock13 = new SquareBlock(cor.rightOfGameObject(Sblock12, 0), cor.topOfGameObject(floor3, 0));
/* 213 */     this.Lifelesses.add(Sblock13);
/* 214 */     add(Sblock13.getAprc());
/*     */ 
/* 216 */     SquareBlock Sblock14 = new SquareBlock(cor.rightOfGameObject(Sblock13, 0), cor.topOfGameObject(floor3, 0));
/* 217 */     this.Lifelesses.add(Sblock14);
/* 218 */     add(Sblock14.getAprc());
/*     */ 
/* 220 */     SquareBlock Sblock15 = new SquareBlock(cor.rightOfGameObject(Sblock9, 0), cor.topOfGameObject(Sblock9, 0));
/* 221 */     this.Lifelesses.add(Sblock15);
/* 222 */     add(Sblock15.getAprc());
/*     */ 
/* 224 */     SquareBlock Sblock16 = new SquareBlock(cor.rightOfGameObject(Sblock15, 0), cor.topOfGameObject(Sblock9, 0));
/* 225 */     this.Lifelesses.add(Sblock16);
/* 226 */     add(Sblock16.getAprc());
/*     */ 
/* 228 */     SquareBlock Sblock17 = new SquareBlock(cor.rightOfGameObject(Sblock16, 0), cor.topOfGameObject(Sblock9, 0));
/* 229 */     this.Lifelesses.add(Sblock17);
/* 230 */     add(Sblock17.getAprc());
/*     */ 
/* 232 */     SquareBlock Sblock18 = new SquareBlock(cor.rightOfGameObject(Sblock17, 0), cor.topOfGameObject(Sblock9, 0));
/* 233 */     this.Lifelesses.add(Sblock18);
/* 234 */     add(Sblock18.getAprc());
/*     */ 
/* 236 */     SquareBlock Sblock19 = new SquareBlock(cor.rightOfGameObject(Sblock18, 0), cor.topOfGameObject(Sblock9, 0));
/* 237 */     this.Lifelesses.add(Sblock19);
/* 238 */     add(Sblock19.getAprc());
/*     */ 
/* 240 */     SquareBlock Sblock20 = new SquareBlock(cor.rightOfGameObject(Sblock10, 0), cor.topOfGameObject(Sblock15, 0));
/* 241 */     this.Lifelesses.add(Sblock20);
/* 242 */     add(Sblock20.getAprc());
/*     */ 
/* 244 */     SquareBlock Sblock21 = new SquareBlock(cor.rightOfGameObject(Sblock20, 0), cor.topOfGameObject(Sblock15, 0));
/* 245 */     this.Lifelesses.add(Sblock21);
/* 246 */     add(Sblock21.getAprc());
/*     */ 
/* 248 */     SquareBlock Sblock22 = new SquareBlock(cor.rightOfGameObject(Sblock21, 0), cor.topOfGameObject(Sblock15, 0));
/* 249 */     this.Lifelesses.add(Sblock22);
/* 250 */     add(Sblock22.getAprc());
/*     */ 
/* 252 */     SquareBlock Sblock23 = new SquareBlock(cor.rightOfGameObject(Sblock22, 0), cor.topOfGameObject(Sblock15, 0));
/* 253 */     this.Lifelesses.add(Sblock23);
/* 254 */     add(Sblock23.getAprc());
/*     */ 
/* 256 */     SquareBlock Sblock24 = new SquareBlock(cor.rightOfGameObject(Sblock20, 0), cor.topOfGameObject(Sblock20, 0));
/* 257 */     this.Lifelesses.add(Sblock24);
/* 258 */     add(Sblock24.getAprc());
/*     */ 
/* 260 */     SquareBlock Sblock25 = new SquareBlock(cor.rightOfGameObject(Sblock24, 0), cor.topOfGameObject(Sblock20, 0));
/* 261 */     this.Lifelesses.add(Sblock25);
/* 262 */     add(Sblock25.getAprc());
/*     */ 
/* 264 */     SquareBlock Sblock26 = new SquareBlock(cor.rightOfGameObject(Sblock25, 0), cor.topOfGameObject(Sblock20, 0));
/* 265 */     this.Lifelesses.add(Sblock26);
/* 266 */     add(Sblock26.getAprc());
/*     */ 
/* 268 */     SquareBlock Sblock27 = new SquareBlock(cor.rightOfGameObject(Sblock24, 0), cor.topOfGameObject(Sblock25, 0));
/* 269 */     this.Lifelesses.add(Sblock27);
/* 270 */     add(Sblock27.getAprc());
/*     */ 
/* 272 */     SquareBlock Sblock28 = new SquareBlock(cor.rightOfGameObject(Sblock27, 0), cor.topOfGameObject(Sblock25, 0));
/* 273 */     this.Lifelesses.add(Sblock28);
/* 274 */     add(Sblock28.getAprc());
/*     */ 
/* 276 */     SquareBlock Sblock29 = new SquareBlock(cor.rightOfGameObject(Sblock27, 0), cor.topOfGameObject(Sblock27, 0));
/* 277 */     this.Lifelesses.add(Sblock29);
/* 278 */     add(Sblock29.getAprc());
/*     */ 
/* 281 */     Castle castle = new Castle(cor.rightOfGameObject(Sblock29, 100), cor.topOfGameObject(floor3, 0));
/* 282 */     this.Lifelesses.add(castle);
/* 283 */     add(castle.getAprc());
/*     */ 
/* 289 */     FloorMonster floorMonster = new FloorMonster(0, cor.bottomOfGameObject(floor, 0), getWidth());
/* 290 */     //this.Monsters.add(floorMonster);
/* 291 */     add(floorMonster.getAprc());
/*     */ 
/* 293 */     Goomba goomba = new Goomba(cor.rightOfGameObject(block6, 10), cor.topOfGameObject(floor, 0));
/* 294 */     this.Monsters.add(goomba);
/* 295 */     add(goomba.getAprc());
/*     */ 
/* 297 */     Goomba goomba2 = new Goomba(cor.rightOfGameObject(block12, 10), cor.topOfGameObject(floor, 0));
/* 298 */     this.Monsters.add(goomba2);
/* 299 */     add(goomba2.getAprc());
/*     */ 
/* 301 */     Goomba goomba3 = new Goomba(cor.rightOfGameObject(Sblock7, 10), cor.topOfGameObject(floor3, 0));
/* 302 */     this.Monsters.add(goomba3);
/* 303 */     add(goomba3.getAprc());
/*     */ 
/* 306 */     appereance();
/*     */ 
/* 308 */     gameMachine();
/* 309 */     this.mario_mario.marioMoves();
/*     */   }
/*     */ }

