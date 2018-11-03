/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polygon.generator;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author hp
 */
public class Screen extends Applet{
    
    private Applet app;
    private int click_no;
    private boolean done;
    private JLabel label;

    private ArrayList <Point> points;
    
    Screen(JLabel label){
        
        this.label=label;
        app=this;
        done=false;
        this.click_no=0;
        
        points = new ArrayList<>();

        Color col = new Color(224,255,255);
        
        app.setBackground(col);
        app.setVisible(true);
        app.addMouseListener(new ListenForMouse());
        
        
    }
    
    public ArrayList<Point> getPoints(){
        return points;
    }    
    
    public int getN(){
        return this.click_no;
    }
    public boolean getD(){
        return this.done;
    }
    public void setD(boolean t){
        this.done=t;
    }
    
    public void clear(){
        
        this.click_no=0;
        this.done=false;
        points.clear();
        repaint();
        
    }
    
    public void drawShape(Shape s){
        
        this.points= s.getPoints();
        this.click_no=s.getNoVer();
        if(click_no>2) this.done=true;
        this.repaint();
        
    }
    
    @Override
    public void paint(Graphics g){
        
        if(done){
            
            Font font = new Font("Arial",Font.ITALIC,20);
            g.setFont(font);
            
            g.setColor(Color.BLUE);
            
            label.setText("Now you can drag and drop vertexes");
            
            Color cl= new Color(126,249,255);    
            
            
            int x1[],y1[];
            x1= new int[click_no];
            y1= new int[click_no];
            for(int i=0;i<click_no;i++){
                x1[i]=points.get(i).getX();
                y1[i]=points.get(i).getY();
                g.drawString(Integer.toString(i+1), x1[i]-4, y1[i]-4);
            }
            g.setColor(Color.WHITE);
                
            Graphics2D g2 = (Graphics2D) g;    
            g2.setStroke(new BasicStroke(2));
            g2.fillPolygon(x1,y1,click_no);
            g2.setColor(new Color(26,148,149));
            g2.drawPolygon(x1,y1,click_no);
            
            g.setColor(Color.BLUE);
            
            for(int i=0;i<click_no;i++){
                g.drawString(Integer.toString(i+1), x1[i]-4, y1[i]-4);
            }
            
        }
        
        else if(this.click_no==0){
            
            Font font = new Font("Arial",Font.ITALIC,20);
            
            g.setFont(font);
            
            g.setColor(Color.BLUE);
            
            label.setText("Click on Screen For First Point Of Polygon");
            
            
        }
        
        else if(this.click_no==1){
            
            Font font = new Font("Arial",Font.ITALIC,20);
            
            g.setFont(font);
            g.setColor(Color.BLUE);
            label.setText("Click on Screen For Second Point Of Polygon");
            
            g.setColor(new Color(26,148,149));
            
            g.fillOval(points.get(click_no-1).getX()-4,points.get(click_no-1).getY()-4-4,4,4);

            
        }
        else{
            
            Font font = new Font("Arial",Font.ITALIC,20);
            g.setFont(font);
            g.setColor(Color.BLUE);
            
            label.setText("Click on Screen For Next Point Of Polygon");

                            
            g.setColor(new Color(26,148,149));
                
            Graphics2D g2 = (Graphics2D) g;
                
            g2.setStroke(new BasicStroke(2));
            
            
            for(int i=1;i<click_no;i++){
    
                g2.drawLine(points.get(i-1).getX(), points.get(i-1).getY(), points.get(i).getX(), points.get(i).getY());
                
                
            }
            
        }
        
        
        
    }
    
    private class ListenForMouse implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            if(!done){
                
                click_no++;
                points.add(new Point(e.getX(),e.getY()));
                repaint();
            }
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
        
        
        
    }
    
}
