import java.awt.Color;
import java.awt.Graphics;
import java.util.List;


import java.awt.Rectangle;

public class Missile {
	public static final int XSPEED = 10,YSPEED = 10;
	
	public static final int WIDTH = 10;
	public static final int HIGH = 10;
	
	int x,y;
	private boolean live = true;
	private boolean good;
	
	Tank.Direction dir;//����Tank���enum�����dir������ע���Ⲣ����Tank�����dir

	private tankwar1 tc;
	
	public Missile(int x, int y, Tank.Direction dir) {//���캯����Ӧ���Ǵ�Tank�ﴫ��λ�úͷ������ֵ
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	public Missile(int x, int y, Tank.Direction dir,tankwar1 tc,boolean good) {
		this(x,y,dir);
		this.tc = tc;
		this.good = good;
	}
	

	
	public void draw(Graphics g){
		if(!live)
			tc.missiles.remove(this);
		Color c = g.getColor();
		if(good){
			g.setColor(Color.BLACK);
		}
		else
			g.setColor(Color.RED);
		g.fillOval(x, y,WIDTH,HIGH);
		g.setColor(c);
		
		move();
	}
	
	private void move(){//��Ϊ�������ˣ����Կ���ֱ������
		switch(dir){
		case L:
			x -= XSPEED;
			break;
		case LU:
			x -= XSPEED;
			y -= YSPEED;
			break;
		case R:
			x += XSPEED;
			break;
		case RU:
			x += XSPEED;
			y -= YSPEED;
		case U:
			y -= YSPEED;
			break;
		case D:
			y += YSPEED;
			break;
		case LD:
			x -= XSPEED;
			y += YSPEED;
			break;
		case RD:
			x += XSPEED;
			y += YSPEED;
			break;		
		}
		if(x < 0 ||y < 0 || x > tankwar1.WIDTH || y > tankwar1.HIGH)
			live = false;
	}
	public boolean isLive() {
		return live;
	}
	
	public Rectangle getRect(){
		return new Rectangle(x,y,WIDTH,HIGH);
	}
	public boolean hitTank(Tank t){

		if(this.live && getRect().intersects(t.getRect()) && t.isLive() && this.good!=t.isGood()){
			if(t.isGood()){
				t.setLife(t.getLife()-20);
				//if(t.getLife() != 0)
					//return false;�������ԣ�����̹��δ����������Ӧ�û�ִ�У���Ҫ���ӵ���Ҫ����
				if(t.getLife() <= 0)
					t.setLive(false);
			}
			else{
			t.setLive(false);
			}
			this.live = false;
			
			Explode e = new Explode(x,y,tc);
			tc.explodes.add(e);
			
			return true;
			}
		return false;		
	}
	public boolean hitTanks(List<Tank> tanks){
		for(int i = 0;i < tanks.size();i++){
			if(hitTank(tanks.get(i)))//�����һֱ����hitTank���Ƚϣ�ֱ�����У�hitTank������ȻҲ��ִ�У���̹�˲�δ��ʧ�ѣ�ֻ�ǲ�����
				return true;//��ʵ��Щ����Ŀǰ��δ�õ������ǣ�Ϊ�˷����������ԣ��������˼��ʲô��
		}
		return false;
	}
	
	public boolean hitWall(Wall w){
		if(this.live && this.getRect().intersects(w.getRect())){
			this.live = false;
			return true;
		}
		return false;
			
	}
}
