package responce;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class ResponceToMouce extends Applet
			implements MouseListener,MouseMotionListener{
	public void init(){
		this.addMouseListener(this);//将此Applet注册给鼠标事件和事件处理者
		//让监听者监听和处理发生在此Applet页面上的事件
		this.addMouseMotionListener(this);
	}
	
	public void mouseClicked(MouseEvent e){
		if(e.getClickCount()==1)//计算点击次数
			showStatus("您在("+e.getX()+","+e.getY()+")处点击了鼠标！");
		else if(e.getClickCount()==2)
			showStatus("您在("+e.getX()+","+e.getY()+")处双击了鼠标！");
	}
	
	public void mouseEntered(MouseEvent e){
		showStatus("Warnings@~@,鼠标进入Applet");
	}
	public void mouseExited(MouseEvent e){
		showStatus("Safe@~@,鼠标离开Applet");
	}
	public void mousePressed(MouseEvent e){
		showStatus("@~@您按下了鼠标～");
	}
	public void mouseReleased(MouseEvent e){
		showStatus("@~@您放开了鼠标～");
	}
	public void mouseMoved(MouseEvent e){
		showStatus("Warnings@~@,鼠标进入Applet!!SIR,坐标("+e.getX()+","+e.getY()+")");
	}
	public void mouseDragged(MouseEvent e){
		showStatus("您拖动了鼠标。");
	}

}
