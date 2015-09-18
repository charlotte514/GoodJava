package buttonlabel;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class TestList extends Applet
			implements ActionListener,ItemListener{
	List mylist;
	Label result;
	
	public void init(){
		result=new Label("请双击选项：");
		//result.setVisible(true);
		mylist=new List(4,true);
		mylist.add("北京");
		mylist.add("上海");
		mylist.add("广州");
		mylist.add("南京");
		mylist.add("西安");
		add(mylist);
		add(result);
		mylist.addItemListener(this);
		mylist.addActionListener(this);
	}
	/**
	 * actionPerformed
	 */
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==mylist){//List是object子类,mylist是事件源
			result.setText("您双击了选项："+" "+e.getActionCommand());
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
		 * getItemSelectable事件源，即产生事件的ItemSelectable对象
		 * getItem返回受事件影响的项（对象），是个Object
		 * 都需要强转，
		 */
		if(e.getItemSelectable() instanceof List){
			temp=(List)(e.getItemSelectable());
			sList=temp.getSelectedItems();
			for(int i=0;i<sList.length;i++)
				mgr=mgr+sList[i]+" ";//字符串粘连
			showStatus(mgr);//将字符串显示在状态条
		}
	}

}
