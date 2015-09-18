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
		cb1=new Checkbox("��ͨ",false,cbg);
		cb2=new Checkbox("����",false,cbg);
		cb3=new Checkbox("б��",false,cbg);
		lb=new Label("   Ч����ʾ     ");
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
		if(temp.getLabel()=="��ͨ"){
			lb.setFont(new Font(name,Font.PLAIN,size));//��ͨ
		}
		if(temp.getLabel()=="����")
			lb.setFont(new Font("����",Font.BOLD,size));//�Ӵ�
		if(temp.getLabel()=="б��")
			lb.setFont(new Font(name,Font.ITALIC,size));//б��
	}

}
