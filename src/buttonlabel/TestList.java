package buttonlabel;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class TestList extends Applet
			implements ActionListener,ItemListener{
	List mylist;
	Label result;
	
	public void init(){
		result=new Label("��˫��ѡ�");
		//result.setVisible(true);
		mylist=new List(4,true);
		mylist.add("����");
		mylist.add("�Ϻ�");
		mylist.add("����");
		mylist.add("�Ͼ�");
		mylist.add("����");
		add(mylist);
		add(result);
		mylist.addItemListener(this);
		mylist.addActionListener(this);
	}
	/**
	 * actionPerformed
	 */
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==mylist){//List��object����,mylist���¼�Դ
			result.setText("��˫����ѡ�"+" "+e.getActionCommand());
			//result.setVisible(true);
		}
	}
	/**
	 * itemStateChanged
	 */
	
	public void itemStateChanged(ItemEvent e){
		List temp;
		String[] sList;
		String mgr=new String("");
		/**
		 * getItemSelectable�¼�Դ���������¼���ItemSelectable����
		 * getItem�������¼�Ӱ�������󣩣��Ǹ�Object
		 * ����Ҫǿת��
		 */
		if(e.getItemSelectable() instanceof List){
			temp=(List)(e.getItemSelectable());
			sList=temp.getSelectedItems();
			for(int i=0;i<sList.length;i++)
				mgr=mgr+sList[i]+" ";//�ַ���ճ��
			showStatus(mgr);//���ַ�����ʾ��״̬��
		}
	}

}
