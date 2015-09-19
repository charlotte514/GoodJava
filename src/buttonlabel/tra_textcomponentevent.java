package buttonlabel;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class tra_textcomponentevent extends Applet
			implements ActionListener,TextListener{
	TextField tf;
	TextArea ta;
	public void init(){
		tf=new TextField(45);
		ta=new TextArea(5,45);
		tf.setBackground(Color.BLUE);
		tf.setEchoChar('*');
		tf.setFont(new Font("¿¬Ìå",Font.BOLD,12));
		add(tf);
		add(ta);
		tf.addActionListener(this);
		tf.addTextListener(this);
	}
	
	public void textValueChanged(TextEvent e){
		if(e.getSource()==tf){
			ta.setText(((TextField)e.getSource()).getText());
		}
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==tf){
			ta.setText(" ");
		}
	}

}
