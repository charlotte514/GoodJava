package Test;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

import Test.TestInnerClass.TextAct;

public class TestInnerClass extends Applet{//处理事件的类才需要接口。
	//有接口的类必须直接实现接口规定的抽象方法。
	//
	TextField text1,text2,result3;
	Button cal,re;
	Checkbox add,min,plu,div;
	CheckboxGroup select;
	
	public void init(){
		text1=new TextField(10);
		text2=new TextField(10);
		result3=new TextField(10);
		cal=new Button("计算");
		re=new Button("重置");
		select=new CheckboxGroup();
		add=new Checkbox("加",true,select);
		min=new Checkbox("减",false,select);
		plu=new Checkbox("乘",false,select);
		div=new Checkbox("除",false,select);
		add(add);add(min);add(plu);add(div);
		add(cal);add(re);
		add(text1);add(text2);add(result3);
		text1.addActionListener(new TextAct());
		text2.addActionListener(new TextAct());
		cal.addActionListener(new ButtonAct());//注册给内部类处理
		re.addActionListener(new ButtonAct());//注册给内部类的新对象处理
	}	
	class TextAct implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		TextField tf;
		int operand;
		tf=(TextField)(e.getSource());
		operand=Integer.parseInt(tf.getText());//操作数
		if(operand<0||operand>=100)
			tf.setText("数据越界");
	}
	}

	 class ButtonAct implements ActionListener {
		 public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int op1,op2,op3;
		if(e.getSource()==cal){
			op1=Integer.parseInt(text1.getText());
			op2=Integer.parseInt(text2.getText());
			if(min.getState())
				op3=op1-op2;
			else if(plu.getState())
				op3=op1*op2;
			else if(div.getState())
				op3=op1/op2;
			else
				op3=op1+op2;
			result3.setText(Integer.toString(op3));
		}else{
			text1.setText(" ");
			text2.setText(" ");
			result3.setText(" ");}

		 }
	 }//end of ButtonAct


}
