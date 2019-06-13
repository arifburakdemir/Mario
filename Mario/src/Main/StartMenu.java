/*     */ package Main;
/*     */ 
/*     */ import gameObject.level.Curtain;
/*     */ import gameObject.level.Level1;
/*     */ import java.awt.Color;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.Font;
/*     */ import java.awt.Image;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.util.Timer;
/*     */ import java.util.TimerTask;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.border.EmptyBorder;
/*     */ 
/*     */ public class StartMenu extends JFrame
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public JPanel contentPane;
/*  29 */   StartMenu startMenu = this;
/*     */ 
/*     */   public static void main(String[] args) {
/*  32 */     EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/*     */         try {
/*  35 */           StartMenu frame = new StartMenu();
/*  36 */           frame.setVisible(true);
/*     */         } catch (Exception e) {
/*  38 */           e.printStackTrace();
/*     */         }
/*     */       } } );
/*     */   }
/*     */ 
/*     */   public void MenuGuider() {
/*  44 */     Thread guider = new Thread(new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/*     */         try {
/*  49 */           Thread.sleep(10L);
/*     */         } catch (InterruptedException e) {
/*  51 */           e.printStackTrace();
/*     */         }
/*  53 */         StartMenu.this.MenuGuider();
/*     */       }
/*     */     });
/*  56 */     guider.start();
/*     */   }
/*     */ 
/*     */   public StartMenu()
/*     */   {
/*  63 */     setResizable(false);
/*  64 */     setDefaultCloseOperation(3);
/*  65 */     setBounds(100, 100, 610, 432);
/*     */ 
/*  67 */     this.contentPane = new JPanel();
/*  68 */     this.contentPane.setBackground(Color.CYAN);
/*  69 */     this.contentPane.setOpaque(true);
/*  70 */     this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
/*  71 */     setContentPane(this.contentPane);
/*  72 */     this.contentPane.setLayout(null);
/*     */ 
/*  75 */     JButton btnNewButton = new JButton("START GAME");
/*  76 */     btnNewButton.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e) {
/*  79 */         Curtain curtain = new Curtain(StartMenu.this.startMenu, 0, 3, 1);
/*  80 */         StartMenu.this.setContentPane(curtain);
/*  81 */         StartMenu.this.validate();
/*  82 */         curtain.requestFocus();
/*     */ 
/*  84 */         Timer levelStart = new Timer();
/*  85 */         levelStart.schedule(new TimerTask()
/*     */         {
/*     */           public void run() {
/*  88 */             Level1 level2 = new Level1(StartMenu.this.startMenu, 0, 3);
/*  89 */             StartMenu.this.setContentPane(level2);
/*  90 */             StartMenu.this.validate();
/*  91 */             level2.requestFocus();
/*     */           }
/*     */         }
/*     */         , 1000L);
/*     */       }
/*     */     });
/*  96 */     btnNewButton.setBounds(246, 155, 117, 29);
/*  97 */     this.contentPane.add(btnNewButton);
/*     */ 
/*  99 */     JLabel lblSuperMario = new JLabel("SUPER MARIO");
/* 100 */     lblSuperMario.setFont(new Font("Lucida Grande", 1, 30));
/* 101 */     lblSuperMario.setBounds(199, 22, 211, 45);
/* 102 */     this.contentPane.add(lblSuperMario);
/*     */ 
/* 104 */     JLabel lblNewLabel = new JLabel("");
/* 105 */     lblNewLabel.setIcon(new ImageIcon(new ImageIcon(StartMenu.class.getResource("/images/levels/startMenu.png")).getImage().getScaledInstance(610, 410, 1)));
/* 106 */     lblNewLabel.setBounds(0, 0, 610, 410);
/* 107 */     this.contentPane.add(lblNewLabel);
/*     */   }
/*     */ }
