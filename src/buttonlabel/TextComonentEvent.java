package buttonlabel;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.math.*;
public class TextComonentEvent extends Applet 
				implements TextListener,ActionListener {
	TextArea ta;
	TextField tf;
	public void init(){
		ta=new TextArea(5,45);
		tf=new TextField(45);
		tf.setBackground(Color.red);
		try{
			tf.setCursor(Cursor.getSystemCustomCursor("E:\\����\\Examples\\1.cur"));
			ta.setCursor(Cursor.getSystemCustomCursor("E:\\����\\Examples\\1.cur"));
		}catch(Exception e){}
		tf.setText("The Num��"+(int)Math.random()*100+" ");
		tf.setFont(new Font("����",Font.BOLD,12));
		tf.setEditable(false);
//		ta.setActionCommand("ta");
		add(tf);
		add(ta);
		ta.addTextListener(this);
	}
	
	public void actionPerformed(ActionEvent e){//ActionListener�ӿڱ���ʵ��
		if(e.getSource()==tf){
			ta.setText("");
		}
	}
	public void textValueChanged(TextEvent e){//TextListener�ӿڱ���ʵ�֡�
		if(e.getSource()==ta){
			ta.setText(((TextArea)e.getSource()).getText());//ǿת��
		}
	}

}
