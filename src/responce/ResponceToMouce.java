package responce;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class ResponceToMouce extends Applet
			implements MouseListener,MouseMotionListener{
	public void init(){
		this.addMouseListener(this);//����Appletע�������¼����¼�������
		//�ü����߼����ʹ������ڴ�Appletҳ���ϵ��¼�
		this.addMouseMotionListener(this);
	}
	
	public void mouseClicked(MouseEvent e){
		if(e.getClickCount()==1)//����������
			showStatus("����("+e.getX()+","+e.getY()+")���������꣡");
		else if(e.getClickCount()==2)
			showStatus("����("+e.getX()+","+e.getY()+")��˫������꣡");
	}
	
	public void mouseEntered(MouseEvent e){
		showStatus("Warnings@~@,������Applet");
	}
	public void mouseExited(MouseEvent e){
		showStatus("Safe@~@,����뿪Applet");
	}
	public void mousePressed(MouseEvent e){
		showStatus("@~@����������ꡫ");
	}
	public void mouseReleased(MouseEvent e){
		showStatus("@~@���ſ�����ꡫ");
	}
	public void mouseMoved(MouseEvent e){
		showStatus("Warnings@~@,������Applet!!SIR,����("+e.getX()+","+e.getY()+")");
	}
	public void mouseDragged(MouseEvent e){
		showStatus("���϶�����ꡣ");
	}

}
