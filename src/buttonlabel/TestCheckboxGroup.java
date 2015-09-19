package buttonlabel;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class TestCheckboxGroup extends Applet
			implements ItemListener{
	CheckboxGroup cbg;
	Checkbox cb1,cb2,cb3;
	Label lb;
	public void init(){
		cbg=new CheckboxGroup();
		cb1=new Checkbox("普通",false,cbg);
		cb2=new Checkbox("黑体",false,cbg);
		cb3=new Checkbox("斜体",false,cbg);
		lb=new Label("   效果显示     ");
		add(cb1);
		add(cb2);
		add(cb3);
		add(lb);
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb3.addItemListener(this);
	}
	
	public void itemStateChanged(ItemEvent e){
		Checkbox temp;
		Font oldfont=lb.getFont();
		String name=oldfont.getName();
		int size=oldfont.getSize();
		temp=(Checkbox)(e.getSource());
		if(temp.getLabel()=="普通"){
			lb.setFont(new Font(name,Font.PLAIN,size));//普通
		}
		if(temp.getLabel()=="黑体")
			lb.setFont(new Font("黑体",Font.BOLD,size));//加粗
		if(temp.getLabel()=="斜体")
			lb.setFont(new Font(name,Font.ITALIC,size));//斜体
	}

}
