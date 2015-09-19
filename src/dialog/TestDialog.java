package dialog;
import java.awt.*;
import java.awt.event.*;

public class TestDialog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyDialogFrame();
	}
}

//����MyDialogFrame
class MyDialogFrame extends Frame{
	TextField tf;//��ʼ��ʾ������
	Button btn1;
	Button btn2;
	MyDialogFrame(){//����
		super("ʹ�öԻ���");//���ø����ʼ���������ǰ��
		tf=new TextField("\t\t��ʼԭ��",25);//��ʼ��ʾ������
		tf.setEditable(false);
		btn1=new Button(" ���� ");
		btn2=new Button(" ���԰�ť  ");
		setLayout(new FlowLayout());
		add(tf);add(btn1);add(btn2);
		btn1.addActionListener(new HandleAct());
		btn2.addComponentListener(new HandleComp());//��������¼�
		this.addWindowListener(new HandleClose());//����ر�����
		this.setVisible(true);
		this.setSize(250,100);
	}
	//inn_class==HandleAct
	class HandleAct implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand()==" ���� "){//��Ҫ�������ĸ���ť�������
				btn2.setVisible(false);
				btn1.setLabel(" ��ʾ ");;
			}else{
				btn2.setVisible(true);
				btn1.setLabel(" ���� ");//ActionCommand�õ���ǩ
				/**
				 * getSource�õ������¼�Դ�����getActionCommand�õ����Ǳ�ǩ��
					�磺Button bt=new Button("buttons");
      ��getSource�õ����Ƕ���bt ����getActionCommand�õ�����:buttons
				 */
			}
		}
	}//end of HandleAct
	
	//inn_class==HandleComp
	class HandleComp extends ComponentAdapter{
		public void componentHidden(ComponentEvent e){
			tf.setText("�������������");
		}
		public void componentShown(ComponentEvent e){
			tf.setText("���������ʾ�����ˡ�");
		}
	}//end of HandleComp
	
	//inn_class==HandleClose
	class HandleClose extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			Frame mf=(Frame)(e.getSource());//ǿת������
			ConfirmDig confirm=new ConfirmDig(mf);
			if(confirm.ans){//click yes
				mf.dispose();
				System.exit(0);
			}
		}
	}
}//end of MyDialogFrame

class ConfirmDig implements ActionListener{
	Dialog dlg;
	Label lb=new Label("�Ƿ�رմ���");
	Button btnY=new Button("	YES		");
	Button btnN=new Button("	NO		");
	Panel p1=new Panel();
	Panel p2=new Panel();
	boolean ans;
	ConfirmDig(){}//�չ���
	ConfirmDig(Frame own){
		btnY.addActionListener(this);
		btnN.addActionListener(this);
		dlg=new Dialog(own,"ȷ�϶Ի���",true);//Frame parent String title Modual
		p1.add(lb);
		p2.add(btnY);p2.add(btnN);
		dlg.add(p1, BorderLayout.NORTH);
		dlg.add(p2, BorderLayout.SOUTH);
		dlg.setSize(300, 200);
		dlg.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		dlg.dispose();//���۰��ĸ����رնԻ���
		if(e.getActionCommand()=="	YES		"){
			ans=true;
		}
		else
			ans=false;
	}//end of actionPerformed
}//end of ConfirmDig
