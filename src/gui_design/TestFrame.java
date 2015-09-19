package gui_design;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class TestFrame {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame();
	}
}

/**
 * myFrame()
 **/
class MyFrame extends Frame{
	Button btn;
	MyFrame(){
		btn=new Button("�ر�");
		setLayout(new FlowLayout());//��Frameʹ�������֡�
		add(btn);
		btn.addActionListener(new HandleAct(this));//�ڲ��ദ��
		addWindowListener(new HandleWin());//��Ӵ��������
		setSize(300,200);
		setTitle("my first window");
		setVisible(true);
	}
	
	/**
	 * HandleAct
	 */
	class HandleAct implements ActionListener{
		Frame my_frame;
		HandleAct(Frame f){
			my_frame=f;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btn){
				my_frame.dispose();
				System.exit(0);
			}
		}
		
	}
	
	/**
	 * HandleWin
	 */
	class HandleWin extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			(e.getWindow()).dispose();
			System.exit(0);
		}
	}
}//end of TestFrame
