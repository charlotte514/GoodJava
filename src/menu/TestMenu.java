package menu;
import java.awt.*;
import java.awt.event.*;

public class TestMenu {//�����ڹ��캯��������Լ���

	public static void main(String[] args) {
		MyMenuFrame mf=new MyMenuFrame();
	}
}
class MyMenuFrame extends Frame{
	MenuBar m_MenuBar;//����˵���
	Menu menuFile,menuEdit,sub_Edit_Font;//����˵��sub��ͷ����
	/**
	 * �˵����ڲ˵����ϣ��˵�����Ϊ�˵���ĵ�����
	 */
	MenuItem mi_File_Open,mi_File_Close,mi_File_Exit;//File�еĲ˵����
	MenuItem mi_Edit_Cut,mi_Edit_Copy,mi_Edit_Paste;//Edit�еĲ˵�����
	CheckboxMenuItem mi_Font_Style,mi_Font_Size;
	//���϶���ѡ��ʽ�˵����
	
	PopupMenu popM;//���嵯��ʽ�˵���
	MenuItem pi_Left,pi_Center,pi_Right;//���嵯��ʽ�˵������
	
	TextArea ta;
	String ta_Font_Name;
	int ta_Font_Style,new_Style,ta_Font_Size,new_Size;
	
	MyMenuFrame(){//constructor
		super("ӵ�в˵��Ĵ��ڡ�");//���ø��๹�졣
		
		ta=new TextArea("\n\n\n\t\t\tĿǰû��ִ�в˵�ָ��",5,30);
		//�ϣ�String + row + columns
		ta.addMouseListener(new HandleMouse());//��TextArea������Ӧ���
		add(ta,BorderLayout.CENTER);//����ı��������ı������롣
		
		m_MenuBar=new MenuBar();//�����˵�����
		
		menuFile=new Menu("�ļ�");
		mi_File_Open=new MenuItem("��");//MenuItem��Menu����
		mi_File_Close=new MenuItem("�ر�");
		mi_File_Exit=new MenuItem("�˳�");
		mi_File_Open.setShortcut(new MenuShortcut(KeyEvent.VK_O));
		//��һ�����ÿ�ݼ���
		mi_File_Open.addActionListener(new HandleAct());
		mi_File_Close.addActionListener(new HandleAct());
		mi_File_Exit.addActionListener(new HandleAct());
		menuFile.add(mi_File_Open);
		menuFile.add(mi_File_Close);
		menuFile.addSeparator();//��һ������ֽ���
		menuFile.add(mi_File_Exit);
		m_MenuBar.add(menuFile);
		
		menuEdit=new Menu("�༭");
		mi_Edit_Cut=new MenuItem("����");
		mi_Edit_Copy=new MenuItem("����");
		mi_Edit_Paste=new MenuItem("ճ��");
		sub_Edit_Font=new Menu("����");//�����Ӳ˵���
		mi_Font_Size=new CheckboxMenuItem("������");//ѡ��˵��Ĭ�ϲ�ѡ��
		mi_Font_Style=new CheckboxMenuItem("����");
		mi_Edit_Copy.addActionListener(new HandleAct());
		mi_Edit_Cut.addActionListener(new HandleAct());
		mi_Edit_Paste.addActionListener(new HandleAct());
		mi_Font_Style.addItemListener(new HandleItem1());
		mi_Font_Size.addItemListener(new HandleItem2());
		menuEdit.add(mi_Edit_Copy);
		menuEdit.add(mi_Edit_Cut);
		menuEdit.add(mi_Edit_Paste);
		menuEdit.addSeparator();
		sub_Edit_Font.add(mi_Font_Style);
		sub_Edit_Font.add(mi_Font_Size);
		menuEdit.add(sub_Edit_Font);
		m_MenuBar.add(menuEdit);
		
		this.setMenuBar(m_MenuBar);//thisָ����ҳ�档
		
		popM=new PopupMenu();
		pi_Left=new MenuItem("�����");
		pi_Left.addActionListener(new HandleAct());
		popM.add(pi_Left);
		pi_Center=new MenuItem("����");
		pi_Center.addActionListener(new HandleAct());
		popM.add(pi_Center);
		pi_Right=new MenuItem("�Ҷ���");
		pi_Right.addActionListener(new HandleAct());
		popM.add(pi_Right);
		ta.add(popM);//����Text��ʹ��popMenu
		
		addWindowListener(new HandleClose());
		setSize(400,200);//necessary
		setVisible(true);//necessary
		ta_Font_Name=(ta.getFont()).getName();
		ta_Font_Style=(ta.getFont()).getStyle();
		ta_Font_Size=(ta.getFont()).getSize();
		ta.setEditable(false);
		new_Style=ta_Font_Style;
		new_Size=ta_Font_Size;
	}
	
	//inn_class==HandleAct
	class HandleAct implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand()=="�˳�"){
				dispose();
				System.exit(0);	
			}
			else
				ta.setText("\n\n\n\t\t\tִ�в˵����"+e.getActionCommand());
		}
	}//end of HandleAct()
	
	//inn_class==HandleMouse
	class HandleMouse extends MouseAdapter{//�̳вü�������
		public void mouseReleased(MouseEvent e){//����ɿ����������˵�
			if(e.isPopupTrigger()){//����ǵ����˵��¼�
				popM.show((Component)e.getSource(), e.getX(), e.getY());
			}
		}
	}
	//inn_class==HandleItem1
	class HandleItem1 implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if(((CheckboxMenuItem)e.getSource()).getState()){//��ѡ��
				new_Style=Font.BOLD;//int
				ta.setText("\n\n\n\t\t\tyou have chosed the BOLD.");
				ta.setFont(new Font(ta_Font_Name,new_Style,new_Size));
			}else{
				new_Style=ta_Font_Style;
				ta.setFont(new Font(ta_Font_Name,ta_Font_Style,ta_Font_Size));
			}	
		}
	}//end of HandleItem1
	
	//inn_class==HandleItem2
	class HandleItem2 implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if(((CheckboxMenuItem)e.getSource()).getState()){
				new_Size=ta_Font_Size*2;
				ta.setText("\n\n\n\t\t\tyou have chosed bigger Font");
				ta.setFont(new Font(ta_Font_Name,new_Style,new_Size));
			}else{
				new_Size=ta_Font_Size;
				ta.setFont(new Font(ta_Font_Name,new_Style,new_Size));
			}	
		}
	}//end of HandleItem2
	
	//inn_class==HandleClose
	class HandleClose extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			dispose();
			System.exit(0);
			}
	}
}