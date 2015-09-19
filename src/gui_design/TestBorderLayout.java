package gui_design;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class TestBorderLayout extends Applet{
	Button north,south,west,east;//,center;
	TextField tf;
	//BorderLayoutֻ��ָ��5��������
	//����������5��������ʹ������Ƕ�׻�ʹ���������ֲ��ԡ�
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
		tf.addActionListener(new BtnAct());//TextAreaû��ActionListener
		
		setLayout(new BorderLayout());//����BorderLayout��������Ĭ�ϰ��������������������Ҫ���
		add(north,BorderLayout.NORTH);//�������ʱ��������
		add(south,BorderLayout.SOUTH);
		add(west,BorderLayout.WEST);
		add(east,BorderLayout.EAST);
		add(tf,BorderLayout.CENTER);//�������
	}
	
	class BtnAct implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()!=tf)
				tf.setText("������˰�ť��"+e.getActionCommand());	
		}
	}
}
