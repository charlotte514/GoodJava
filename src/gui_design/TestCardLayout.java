package gui_design;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class TestCardLayout extends Applet{
	CardLayout Mycard=new CardLayout();//创建CardLayout布局管理器对象
	Button btn1=new Button("第一个按钮");
	Button btn2=new Button("第二个按钮");
	Button btn3=new Button("第三个按钮");
	Button btn4=new Button("第四个按钮");
	Button btn5=new Button("第五个按钮");
	
	public void init(){
		setLayout(Mycard);
		add("第一页",btn1);//分配字符串名字，稍后可使用该名字调用组件
		add("第二页",btn2);
		add("第三页",btn3);
		add("第四页",btn4);
		add("第五页",btn5);
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
			if(e.getModifiers()==InputEvent.BUTTON1_MASK)//在鼠标事件中返回按键代码
				cl.next(m_parent);//flips to the next card of this specified container
			else
				cl.previous(m_parent);
			}
		}
}
