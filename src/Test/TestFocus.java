package Test;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class TestFocus extends Applet{
	TextField operand1,operand2,result3;
	CheckboxGroup select;
	Checkbox add,min,plu,div;
	Button cal,re;
	TextArea Coder;
	/**
	 * 初始化
	 * 
	 */
	public void init(){
		operand1=new TextField("0",10);
		operand2=new TextField("0",10);
		result3=new TextField(10);
		cal=new Button("计算");
		re=new Button("重置");
		Coder=new TextArea(5,20);
		select=new CheckboxGroup();
		add=new Checkbox("加",true,select);
		min=new Checkbox("减",false,select);
		plu=new Checkbox("乘",false,select);
		div=new Checkbox("除",false,select);
		add(operand1);add(operand2);add(result3);
		add(cal);add(re);add(Coder);
		add(add);add(min);add(plu);add(div);
		operand1.addFocusListener(new HandleFocus());
		operand2.addFocusListener(new HandleFocus());
		cal.addActionListener(new ButtonAct());
		re.addActionListener(new ButtonAct());
	}
	
	class HandleFocus implements FocusListener{

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			int operand;
			TextField tf=(TextField)(e.getSource());
			operand=Integer.parseInt(tf.getText());
			if(operand<0||operand>=100){
				tf.requestFocus();//请求焦点。
				tf.setText("0");}
		}
		
	}
	
	class ButtonAct implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int op1,op2,op3;
			if(e.getSource()==re){//是重置
				operand1.setText("0");
				operand2.setText("0");
				result3.setText(" ");
				operand1.requestFocus();
				add.setState(true);
			}else{//是计算符
				if(!operand1.hasFocus()&&!operand2.hasFocus()){
					op1=Integer.parseInt(operand1.getText());
					op2=Integer.parseInt(operand2.getText());
					if(add.getState())
						op3=op1+op2;
					else if(min.getState())
						op3=op1-op2;
					else if(plu.getState())
						op3=op1*op2;
					else
						op3=op1/op2;
					result3.setText(Integer.toString(op3));
					Coder.append(Integer.toString(op3)+"\n");
				}else{
					cal.setForeground(Color.red);
					cal.setBackground(Color.BLACK);
					
				}
				
			}
		}
	}
}