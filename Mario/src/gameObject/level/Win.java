/*    */ package gameObject.level;
/*    */ 
/*    */ import Main.StartMenu;
/*    */ import java.awt.Color;
/*    */ import java.awt.Image;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ public class Win extends JPanel
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */ 
/*    */   public Win(StartMenu startMenu, int gold, int health)
/*    */   {
/* 21 */     setBackground(Color.BLACK);
/* 22 */     setLayout(null);
/* 23 */     setBounds(100, 100, 610, 432);
/*    */ 
/* 25 */     JLabel mario_image = new JLabel("New label");
/*    */ 
/* 27 */     mario_image.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/mario/mario-stay.png"))
/* 28 */       .getImage().getScaledInstance(61, 89, 1)));
/* 29 */     mario_image.setBounds(257, 156, 61, 89);
/* 30 */     add(mario_image);
/*    */ 
/* 32 */     JLabel lblX = new JLabel("x");
/* 33 */     lblX.setForeground(Color.WHITE);
/* 34 */     lblX.setBounds(330, 192, 8, 16);
/* 35 */     add(lblX);
/*    */ 
/* 37 */     JLabel health_label = new JLabel("3");
/* 38 */     health_label.setText(health  + "");
/* 39 */     health_label.setForeground(Color.WHITE);
/* 40 */     health_label.setBounds(350, 192, 17, 16);
/* 41 */     add(health_label);
/*    */ 
/* 43 */     JLabel level_label = new JLabel("YOU WIN!");
/* 44 */     level_label.setForeground(Color.WHITE);
/* 45 */     level_label.setBounds(277, 128, 61, 16);
/* 46 */     add(level_label);
/*    */ 
/* 48 */     JLabel gold_label = new JLabel("0");
/* 49 */     gold_label.setText(gold  + "");
/* 50 */     gold_label.setForeground(Color.WHITE);
/* 51 */     gold_label.setBounds(320, 259, 17, 16);
/* 52 */     add(gold_label);
/*    */ 
/* 54 */     JLabel gold_image = new JLabel("New label");
/*    */ 
/* 56 */     gold_image.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/items/gold_4.png")).getImage()
/* 57 */       .getScaledInstance(20, 20, 1)));
/* 58 */     gold_image.setBounds(288, 257, 20, 20);
/* 59 */     add(gold_image);
/*    */   }
/*    */ }
