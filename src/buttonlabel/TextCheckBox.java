package buttonlabel;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class TextCheckBox extends Applet
			implements ActionListener,ItemListener,MouseListener{
	Checkbox ckb;
	Button btn;
	TextField tf;
	File file;
	RandomAccessFile raf;
	FileInputStream in;
	public void init(){
		ckb=new Checkbox("����ɫ��");
		btn=new Button("Ч��");
		tf=new TextField(45);
		ckb.setLabel("ckb");
		tf.setText("Other Color:");
		file=new File("Demo");
		if(!file.isDirectory())
			file.mkdir();
		try {
			raf=new RandomAccessFile(new File(file,"Recoder.txt"),"rw");
//			in =new FileInputStream(new File(file,"recoder.txt"));
		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		add(ckb);
		add(btn);
		add(tf);
		tf.addActionListener(this);
		tf.addMouseListener(this);
		ckb.addItemListener(this);
	}
	
	public void mouseClicked(MouseEvent e){
		
			if((e.getSource()==tf)&&(tf.getText().equals("Other Color:"))){
				tf.setText(" ");
			}
	}
	public void itemStateChanged(ItemEvent e){
		Checkbox temp;
		if(e.getItemSelectable() instanceof Checkbox){
			/**
			 * instanceof�жϷ���ֵ�Ƿ�Ϊ���ʵ��
			 * getItemSelectable()���ص���ʵ����ItemSelectable�ӿڵ�ʵ����
			 * ��Ҫת��Ϊ�����Ķ��󣬼��޸ýӿڵĶ���
			 */
			temp=(Checkbox)(e.getItemSelectable());
			if(temp.getLabel()=="ckb"){
				if(temp.getState())
				btn.setBackground(Color.cyan);
				else
					btn.setBackground(Color.yellow);}
			}

	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==tf){
//			byte[] buf=new byte[(int)(tf.getText().length())];
			String str1=tf.getText();
//			buf=str1.getBytes();
			long StringLength=str1.length();
			try {
				btn.setBackground(Color.darkGray);
				raf.seek(StringLength);
				raf.writeBytes(str1);
				tf.setText(" ");
				
			} catch (IOException e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}catch (Exception e2){}
		}
		try {
			raf.close();
		} catch (IOException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}