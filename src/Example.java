import java.awt.*; 
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.*;

public class Example extends JFrame {
     JPanel p1;
     JPanel p2;
     Label l1=new Label("x");
     Label l2=new Label("y");
     Label l3=new Label("너비");
     Label l4=new Label("높이");
     
     TextField tf1=new TextField(3);
     TextField tf2=new TextField(3);
     TextField tf3=new TextField(3);
     TextField tf4=new TextField(3);
     
     JButton bt1 = new JButton("새로열기");
     JButton bt2 = new JButton("불러오기");
     JButton bt3 = new JButton("저장");
   

     MyDraw area;

 public Example(){
	setSize(1000,700);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	p1 = new JPanel();
	p1.setLayout(new GridLayout(5,2,75,75));
	p1.add(l1);
	p1.add(tf1);
	p1.add(l2);
	p1.add(tf2);
	p1.add(l3);
	p1.add(tf3);
	p1.add(l4);
	p1.add(tf4);
	p2 = new JPanel();
	p2.add(bt1);
	p2.add(bt2);
	p2.add(bt3);
    add(p2, BorderLayout.NORTH);
	add(p1, BorderLayout.WEST);
	p1.setBackground(Color.WHITE);
	area = new MyDraw();
	add(area, BorderLayout.CENTER);
	setVisible(true);
 }

  class FileTypeFliter extends FileFilter{
	 private final String extension;
	 private final String description;
 
 class MyDraw extends JPanel {
	 Point start=null, end=null; 
	 public MyDraw() {
	 MyMouseListener listener = new MyMouseListener(); 
	 addMouseListener(listener); 
	 addMouseMotionListener(listener); 
	 }
	 class MyMouseListener extends MouseAdapter { 
	 public void mousePressed(MouseEvent e) {
	 start = e.getPoint(); 
	 }
	 public void mouseDragged(MouseEvent e) {
	 end = e.getPoint(); 
	 repaint();
	 }
	 }

	 public void paintComponent(Graphics g) {
	 super.paintComponent(g);
	 if(start == null) 
	 return;
	 g.setColor(Color.GRAY); 
	 int x = Math.min(start.x, end.x);
	 int y = Math.min(start.y, end.y);
	 int width = Math.abs(start.x - end.x);
	 int height = Math.abs(start.y - end.y);
	 g.fillRect(x, y, width, height);
 }
 }
 
 public static void main(String[] args){
	 new Example();
 }
}