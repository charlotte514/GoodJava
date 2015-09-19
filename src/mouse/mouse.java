package mouse;
import javax.swing.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;


public class mouse{
	public static void main(String[] args){
		new mouseE();
	}
}

class mouseE extends JFrame implements MouseListener{
	//private static final long serialVersionUID = 1L;
	private String[] msgs={"Java is powerful!","java is fonny"};
	private int index=0;
	private JLabel jlb=new JLabel(msgs[index],JLabel.CENTER);
	//constructor
	mouseE(){
		this.setTitle("��괦��");//this == Jframe
		this.setLayout(new FlowLayout());
		this.pack();
		this.setBackground(Color.cyan);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رճ������д��ڡ�
		
		add(jlb);
		addMouseListener(this);
		jlb.setFocusable(false);
		this.setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		index=(index==1?0:1);
		jlb.setText(msgs[index]);
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		jlb.setText("��갴�����¡�");
	}
	
	public void mouseReleased(MouseEvent arg0) {
		jlb.setText("��갴���ɿ���");
	}
	
}
