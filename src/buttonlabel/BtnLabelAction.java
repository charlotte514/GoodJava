package buttonlabel;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class BtnLabelAction extends Applet implements ActionListener{

	Label prompt;
	Button btn;
	public void init(){
		prompt=new Label("HELLO THE YOUNG");
		btn=new Button("CLICK HERE");
		prompt.setBounds(100,100,500,300);
		prompt.setForeground(Color.red);
		prompt.setFont(new Font("楷体",Font.BOLD,12));
		
		add(prompt);
		add(btn);
		btn.addActionListener(this);//该对象本身。监听他。
	}
	
	public void actionPerformed(ActionEvent e){//重载
		if(e.getActionCommand()=="CLICK HERE"){
			if(prompt.getText()=="HELLO THE YOUNG")
				prompt.setText("BYE BYE THE YOUNG");
			else
				prompt.setText("HELLO THE YOUNG");
		}
	
	
	}
}