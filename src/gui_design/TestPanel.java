package gui_design;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class TestPanel extends Applet
			implements ActionListener,ContainerListener{
	
	Panel p1,p2,p3;
	Label prompt1,prompt2,prompt3;
	Button btn;
	//默认流布局，顺序排列。
	public void init(){
		p1=new Panel();
		p1.setBackground(Color.gray);
		p2=new Panel();
		p2.setBackground(Color.red);
		p3=new Panel();
		p3.setBackground(Color.cyan);
		prompt1=new Label("i am in panel one");
		prompt2=new Label("i am in panel two");
		prompt3=new Label("i am in panel three");
		btn=new Button("in Panel3");
		p1.add(prompt1);
		p2.add(prompt2);
		p3.add(prompt3);
		p3.add(btn);
		p1.add(p3);//put p3 in p1;
		add(p1);//put p1&&p2 in Applet Container
		add(p2);
		btn.addActionListener(this);//括号内为处理事件的对象，该对象的类需要实现接口。
		p1.addContainerListener(this);
		
		
	}

	@Override
	public void componentAdded(ContainerEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentRemoved(ContainerEvent arg0) {
		// TODO Auto-generated method stub
		showStatus("您移去了第三个Panel。");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn){//e.getsource()返回事件源对象。
			p1.remove(p3);
		}
		
	}
	

}
