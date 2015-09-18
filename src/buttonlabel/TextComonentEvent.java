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
			tf.setCursor(Cursor.getSystemCustomCursor("E:\\开发\\Examples\\1.cur"));
			ta.setCursor(Cursor.getSystemCustomCursor("E:\\开发\\Examples\\1.cur"));
		}catch(Exception e){}
		tf.setText("The Num："+(int)Math.random()*100+" ");
		tf.setFont(new Font("楷体",Font.BOLD,12));
		tf.setEditable(false);
//		ta.setActionCommand("ta");
		add(tf);
		add(ta);
		ta.addTextListener(this);
	}
	
	public void actionPerformed(ActionEvent e){//ActionListener接口必须实现
		if(e.getSource()==tf){
			ta.setText("");
		}
	}
	public void textValueChanged(TextEvent e){//TextListener接口必须实现。
		if(e.getSource()==ta){
			ta.setText(((TextArea)e.getSource()).getText());//强转。
		}
	}

}
