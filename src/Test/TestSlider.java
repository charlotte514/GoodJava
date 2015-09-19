package Test;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
/**
 * 滚动条
 * @author Administrator
 *
 */
public class TestSlider extends Applet 
				implements AdjustmentListener{
	Scrollbar mySlider;
	TextField sliderValue;
	
	public void init(){
		setLayout(new BorderLayout());
		mySlider=new Scrollbar(
				Scrollbar.HORIZONTAL,0,1,0,Integer.MAX_VALUE);
		//1-水平放置，2-初始位置，3-滑块大小，4-滚动槽代表最小数据，5-滚动槽代表最大数据
		mySlider.setUnitIncrement(10);
		mySlider.setBlockIncrement(50);
		add(mySlider,BorderLayout.SOUTH);//布局底部
		mySlider.addAdjustmentListener(this);
		sliderValue=new TextField(10);
		add(sliderValue,BorderLayout.CENTER);
	}
	
	public void adjustmentValueChanged(AdjustmentEvent e){
		int value;
		Scrollbar scroll;
		scroll=(Scrollbar)(e.getSource());
		value=scroll.getValue();
		sliderValue.setText(Integer.toString(value));
		sliderValue.setBackground(new Color(value));
	}

}
