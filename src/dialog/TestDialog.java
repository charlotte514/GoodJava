package dialog;
import java.awt.*;
import java.awt.event.*;

public class TestDialog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyDialogFrame();
	}
}

//定义MyDialogFrame
class MyDialogFrame extends Frame{
	TextField tf;//初始显示与列数
	Button btn1;
	Button btn2;
	MyDialogFrame(){//构造
		super("使用对话框");//调用父类初始化必须放最前。
		tf=new TextField("\t\t初始原画",25);//初始显示与列数
		tf.setEditable(false);
		btn1=new Button(" 隐藏 ");
		btn2=new Button(" 测试按钮  ");
		setLayout(new FlowLayout());
		add(tf);add(btn1);add(btn2);
		btn1.addActionListener(new HandleAct());
		btn2.addComponentListener(new HandleComp());//监听组件事件
		this.addWindowListener(new HandleClose());//处理关闭问题
		this.setVisible(true);
		this.setSize(250,100);
	}
	//inn_class==HandleAct
	class HandleAct implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand()==" 隐藏 "){//需要区分是哪个按钮被点击。
				btn2.setVisible(false);
				btn1.setLabel(" 显示 ");;
			}else{
				btn2.setVisible(true);
				btn1.setLabel(" 隐藏 ");//ActionCommand得到标签
				/**
				 * getSource得到的是事件源对象而getActionCommand得到的是标签。
					如：Button bt=new Button("buttons");
      用getSource得到的是对象bt 而用getActionCommand得到的是:buttons
				 */
			}
		}
	}//end of HandleAct
	
	//inn_class==HandleComp
	class HandleComp extends ComponentAdapter{
		public void componentHidden(ComponentEvent e){
			tf.setText("调试组件被隐藏");
		}
		public void componentShown(ComponentEvent e){
			tf.setText("调试组件显示出来了。");
		}
	}//end of HandleComp
	
	//inn_class==HandleClose
	class HandleClose extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			Frame mf=(Frame)(e.getSource());//强转获得组件
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
	Label lb=new Label("是否关闭窗口");
	Button btnY=new Button("	YES		");
	Button btnN=new Button("	NO		");
	Panel p1=new Panel();
	Panel p2=new Panel();
	boolean ans;
	ConfirmDig(){}//空构造
	ConfirmDig(Frame own){
		btnY.addActionListener(this);
		btnN.addActionListener(this);
		dlg=new Dialog(own,"确认对话框",true);//Frame parent String title Modual
		p1.add(lb);
		p2.add(btnY);p2.add(btnN);
		dlg.add(p1, BorderLayout.NORTH);
		dlg.add(p2, BorderLayout.SOUTH);
		dlg.setSize(300, 200);
		dlg.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		dlg.dispose();//无论按哪个，关闭对话框
		if(e.getActionCommand()=="	YES		"){
			ans=true;
		}
		else
			ans=false;
	}//end of actionPerformed
}//end of ConfirmDig
