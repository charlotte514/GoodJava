package buttonlabel;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
/**
 * 
 * �����б�
 * @author Administrator
 *
 */
public class TestChoice extends Applet
			implements ItemListener{
	Choice size;
	Label lb;
	public void init(){
		size = new Choice();
		size.add("10");
		size.add("11");
		size.add("18");
		add(size);
		lb=new Label("Ч��");
		add(lb);
		size.addItemListener(this);
	}
	
	public void itemStateChanged(ItemEvent e){
		Choice temp;
		Font oldf;
		String s;
		int si;
		if(e.getItemSelectable() instanceof Choice){//�����Ƿ�Ϊ����ʵ��
			oldf=lb.getFont();
			temp=(Choice)(e.getItemSelectable());//ǿתΪ�������¼�Դ����
			s=temp.getSelectedItem();
			si=Integer.parseInt(s);
			lb.setFont(new Font(oldf.getName(),oldf.getStyle(),si));
		}
	}

}
