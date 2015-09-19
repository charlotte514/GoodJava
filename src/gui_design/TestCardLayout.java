package gui_design;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class TestCardLayout extends Applet{
	CardLayout Mycard=new CardLayout();//����CardLayout���ֹ���������
	Button btn1=new Button("��һ����ť");
	Button btn2=new Button("�ڶ�����ť");
	Button btn3=new Button("��������ť");
	Button btn4=new Button("���ĸ���ť");
	Button btn5=new Button("�������ť");
	
	public void init(){
		setLayout(Mycard);
		add("��һҳ",btn1);//�����ַ������֣��Ժ��ʹ�ø����ֵ������
		add("�ڶ�ҳ",btn2);
		add("����ҳ",btn3);
		add("����ҳ",btn4);
		add("����ҳ",btn5);
		btn1.addMouseListener(new MouseMoveCard(Mycard,this));
		btn2.addMouseListener(new MouseMoveCard(Mycard,this));
		btn3.addMouseListener(new MouseMoveCard(Mycard,this));
		btn4.addMouseListener(new MouseMoveCard(Mycard,this));
		btn5.addMouseListener(new MouseMoveCard(Mycard,this));
	}
	class MouseMoveCard extends MouseAdapter{
		CardLayout cl;
		Applet m_parent;
		public MouseMoveCard(CardLayout mycard, TestCardLayout testCardLayout) {
			cl=mycard;
			m_parent=testCardLayout;
		}
		
		public void mouseClicked(MouseEvent e){
			if(e.getModifiers()==InputEvent.BUTTON1_MASK)//������¼��з��ذ�������
				cl.next(m_parent);//flips to the next card of this specified container
			else
				cl.previous(m_parent);
			}
		}
}
