//���İ汾��û�п����Լ���̹�ˣ��԰ɣ�
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class tankwar1 extends Frame{

	public static final int WIDTH = 800;
	public static final int HIGH = 600;
	private Random r = new Random();

	Tank myTank = new Tank(200,200,true,Tank.Direction.STOP,this);	
	
	List<Missile> missiles= new ArrayList<Missile>();
	List<Explode> explodes = new ArrayList<Explode>();
	List<Tank> tanks = new ArrayList<Tank>();
	List<Blood> bloods = new ArrayList<Blood>();
	
	Wall w1 = new Wall(300,200,30,200,this);
	Wall w2 = new Wall(300,100,200,30,this);
	
	Image offScreenImage = null;

	public void update(Graphics g){
		if(offScreenImage == null){
			offScreenImage = this.createImage(WIDTH,HIGH);//�����˻����Ĵ�С
		}
		Graphics goffScreen = offScreenImage.getGraphics();
		Color c = goffScreen.getColor();
		goffScreen.setColor(Color.GREEN);
		goffScreen.fillRect(0, 0, WIDTH, HIGH);
		goffScreen.setColor(c);
		paint(goffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
		
}

//��һ�����ƶ���̹�ˣ�����һ��Բ	
	public void paint(Graphics g) {
		g.drawString("Missiles counts:"+missiles.size(), 60, 60);
		g.drawString("Explodes counts:"+explodes.size(),60 , 75);
		g.drawString("Tanks counts:"+tanks.size(),60 , 90);
		g.drawString("Life value:"+myTank.getLife(), 60, 105);
		
		for(int i = 0;i<missiles.size();i++){
			Missile m = missiles.get(i);
			m.hitTanks(tanks);
			m.hitTank(myTank);
			m.hitWall(w1);
			m.hitWall(w2);
			m.draw(g);
		}
		
		for(int i = 0;i<explodes.size();i++){
			Explode e = explodes.get(i);
			e.draw(g);
		}
		
		for(int i = 0;i<tanks.size();i++){
			Tank t = tanks.get(i);
			t.collidesWithWall(w1);
			t.collidesWithWall(w2);
			t.collidesWithTank(tanks);
			t.draw(g);
		}
		
		if(r.nextInt(200)>198)
			bloods.add(new Blood(this));
		
		for(int i= 0;i < bloods.size();i++){
			Blood blood = bloods.get(i);
			myTank.eatBlood(blood);
			
			blood.draw(g);
		}
		
		myTank.collidesWithWall(w1);
		myTank.collidesWithWall(w2);
		myTank.draw(g);//���̿��Ƶ�������myTank����Ϊ���õ���myTank��draw����������
		w1.draw(g);
		w2.draw(g);
		
	}


//��ʼ�ĳ����ܣ�������
	public void launchFrame(){
		for(int i = 0;i<10;i++)
			tanks.add(new Tank(300+50*i,300,false,Tank.Direction.D,this));
		this.setLocation(200,200);
		this.setSize(WIDTH,HIGH);
		setTitle("Tankwar");
		setResizable(false);
		setBackground(Color.GREEN);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
	}});
		this.addKeyListener(new keyMoniter());
		this.setVisible(true);
		new Thread(new paintThread()).start();
	}
	

//������
	public static void main(String[] args){
		tankwar1 tank = new tankwar1();
		tank.launchFrame();
	}
	
//���ö��̣߳���һ��ʱ���ػ�һ�Σ��Ը�����ʾ
	private class paintThread implements Runnable{
		public void run(){
			while(true){
			repaint();
			try{ Thread.sleep(50);
			}
			catch(InterruptedException e){}
			}
		}

	}
	
//���ּ��ӵģ�����д����������
	private class keyMoniter extends KeyAdapter{
		//�ü��̿������߷���
		public void keyPressed(KeyEvent e){//���̰��£�����
			myTank.keyPressed(e);
		}
		public void keyReleased(KeyEvent e) {//�����ɿ���ͣ�£�����ͦ�õ�
			myTank.keyReleased(e);
		}
	}
}

