package responce;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;


public class TestCanvas extends Applet{
	CanvasDraw cd;
	public void init(){
		cd=new CanvasDraw(new Dimension(200,180),this);
		cd.setBackground(Color.pink);
		add(cd);
		cd.requestFocus();	
	}
}

class CanvasDraw extends Canvas{//public 属性的类应该单独在一个文件里。
	Applet myParent;
	boolean md_Flag=false;
	int startX=0;
	int startY=0,currentX=0,currentY=0;
	StringBuffer sb=new StringBuffer();
	public CanvasDraw(Dimension dimension, TestCanvas testCanvas) {
		// TODO Auto-generated constructor stub
		myParent=testCanvas;
		setSize(dimension);
		setBackground(Color.gray);
		addKeyListener(new KeyEventProcess());
		addMouseListener(new mouseAdapt());
		addMouseMotionListener(new MouseMotionAdapt());
	}
	/**
	 * methods
	 * @author Administrator
	 *
	 */
	void setStart(int x,int y){
		startX=x;
		startY=y;
	}
	
	void setCurrent(int x,int y){
		currentX=x;
		currentY=y;
	}
	
	void setMouseDragged(boolean b){
		md_Flag=b;
	}
	
	void showMsg(String s){
		myParent.showStatus(s);
	}
	
	void clearAll(){
		startX=0;
		startY=0;
		currentX=0;
		currentY=0;
		repaint();
	}//methods end
	
	public void paint(Graphics g){
		g.drawString("("+currentX+","+currentY+")", 10, 20);//左上角写字
		if(md_Flag)
			g.drawLine(startX, startY, currentX, currentY);
	}
	
	class KeyEventProcess implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {	
		}
		@Override
		public void keyReleased(KeyEvent e) {
		}
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			char ch=e.getKeyChar();
			if(ch=='c'){
				sb.setLength(0);
				clearAll();}else
					sb.append(ch);
			showMsg("击键："+sb.toString());//sb==stringbuffer
				}
		}		
	
	/**
	 * 鼠标裁剪
	 * @author Administrator
	 *
	 */
	
	class mouseAdapt extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()==1)
				showMsg("您在("+e.getX()+","+e.getY()+")处单击。");
			if(e.getClickCount()==2)
				showMsg("您在("+e.getX()+","+e.getY()+")处双击。");
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			showMsg("您进入了画布");
		}
		@Override
		public void mouseExited(MouseEvent e) {
			showMsg("您离开了画布");
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			setStart(e.getX(),e.getY());
			showMsg("您开始画线");
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			if((startX!=currentX)&&(startY!=currentY))
				showMsg("您画出了一条直线");
		}
	}//end of MouseAdapt
	/**
	 * 鼠标移动
	 * @author Administrator
	 *
	 */
	class MouseMotionAdapt extends MouseMotionAdapter{
		public void mouseMoved(MouseEvent e){
			setCurrent(e.getX(),e.getY());
			setMouseDragged(false);
			repaint(10,0,60,30);//刷新只在画布左上角
		}
		
		public void mouseDragged(MouseEvent e){
			setCurrent(e.getX(),e.getY());
			setMouseDragged(true);
			repaint();//重新调用paint()方法
		}
	}//end of MouseMotionAdapt
}//end of CanvasDraw