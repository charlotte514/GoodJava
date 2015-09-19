package menu;
import java.awt.*;
import java.awt.event.*;

public class TestMenu {//不能在构造函数里调用自己。

	public static void main(String[] args) {
		MyMenuFrame mf=new MyMenuFrame();
	}
}
class MyMenuFrame extends Frame{
	MenuBar m_MenuBar;//定义菜单条
	Menu menuFile,menuEdit,sub_Edit_Font;//定义菜单项，sub开头二级
	/**
	 * 菜单项在菜单条上，菜单子项为菜单项的弹出项
	 */
	MenuItem mi_File_Open,mi_File_Close,mi_File_Exit;//File中的菜单子项。
	MenuItem mi_Edit_Cut,mi_Edit_Copy,mi_Edit_Paste;//Edit中的菜单子项
	CheckboxMenuItem mi_Font_Style,mi_Font_Size;
	//以上定义选择式菜单子项。
	
	PopupMenu popM;//定义弹出式菜单。
	MenuItem pi_Left,pi_Center,pi_Right;//定义弹出式菜单的子项。
	
	TextArea ta;
	String ta_Font_Name;
	int ta_Font_Style,new_Style,ta_Font_Size,new_Size;
	
	MyMenuFrame(){//constructor
		super("拥有菜单的窗口。");//调用父类构造。
		
		ta=new TextArea("\n\n\n\t\t\t目前没有执行菜单指令",5,30);
		//上，String + row + columns
		ta.addMouseListener(new HandleMouse());//在TextArea区域响应鼠标
		add(ta,BorderLayout.CENTER);//添加文本，并将文本置中央。
		
		m_MenuBar=new MenuBar();//创建菜单条。
		
		menuFile=new Menu("文件");
		mi_File_Open=new MenuItem("打开");//MenuItem是Menu子类
		mi_File_Close=new MenuItem("关闭");
		mi_File_Exit=new MenuItem("退出");
		mi_File_Open.setShortcut(new MenuShortcut(KeyEvent.VK_O));
		//上一行设置快捷键。
		mi_File_Open.addActionListener(new HandleAct());
		mi_File_Close.addActionListener(new HandleAct());
		mi_File_Exit.addActionListener(new HandleAct());
		menuFile.add(mi_File_Open);
		menuFile.add(mi_File_Close);
		menuFile.addSeparator();//加一条横向分界线
		menuFile.add(mi_File_Exit);
		m_MenuBar.add(menuFile);
		
		menuEdit=new Menu("编辑");
		mi_Edit_Cut=new MenuItem("剪切");
		mi_Edit_Copy=new MenuItem("复制");
		mi_Edit_Paste=new MenuItem("粘贴");
		sub_Edit_Font=new Menu("字体");//创建子菜单项
		mi_Font_Size=new CheckboxMenuItem("大字体");//选择菜单项，默认不选中
		mi_Font_Style=new CheckboxMenuItem("粗体");
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
		
		this.setMenuBar(m_MenuBar);//this指代此页面。
		
		popM=new PopupMenu();
		pi_Left=new MenuItem("左对齐");
		pi_Left.addActionListener(new HandleAct());
		popM.add(pi_Left);
		pi_Center=new MenuItem("居中");
		pi_Center.addActionListener(new HandleAct());
		popM.add(pi_Center);
		pi_Right=new MenuItem("右对齐");
		pi_Right.addActionListener(new HandleAct());
		popM.add(pi_Right);
		ta.add(popM);//仅在Text内使用popMenu
		
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
			if(e.getActionCommand()=="退出"){
				dispose();
				System.exit(0);	
			}
			else
				ta.setText("\n\n\n\t\t\t执行菜单命令："+e.getActionCommand());
		}
	}//end of HandleAct()
	
	//inn_class==HandleMouse
	class HandleMouse extends MouseAdapter{//继承裁剪抽象类
		public void mouseReleased(MouseEvent e){//鼠标松开按键弹出菜单
			if(e.isPopupTrigger()){//如果是弹出菜单事件
				popM.show((Component)e.getSource(), e.getX(), e.getY());
			}
		}
	}
	//inn_class==HandleItem1
	class HandleItem1 implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if(((CheckboxMenuItem)e.getSource()).getState()){//被选中
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