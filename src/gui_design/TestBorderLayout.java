package gui_design;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class TestBorderLayout extends Applet{
	Button north,south,west,east;//,center;
	TextField tf;
	//BorderLayout只能指定5个区域布置
	//如果组件超过5个，必须使用容器嵌套或使用其他布局策略。
	public void init(){
		north=new Button("North");
		south=new Button("South");
		west=new Button("West");
		east=new Button("East");
		//center=new Button("Center");
		tf=new TextField(45);
		north.addActionListener(new BtnAct());
		south.addActionListener(new BtnAct());
		west.addActionListener(new BtnAct());
		east.addActionListener(new BtnAct());
		tf.addActionListener(new BtnAct());//TextArea没有ActionListener
		
		setLayout(new BorderLayout());//设置BorderLayout布局器，默认安置五个组件，超过五个需要组合
		add(north,BorderLayout.NORTH);//加入组件时分配区域。
		add(south,BorderLayout.SOUTH);
		add(west,BorderLayout.WEST);
		add(east,BorderLayout.EAST);
		add(tf,BorderLayout.CENTER);//区域最大。
	}
	
	class BtnAct implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()!=tf)
				tf.setText("您点击了按钮："+e.getActionCommand());	
		}
	}
}
