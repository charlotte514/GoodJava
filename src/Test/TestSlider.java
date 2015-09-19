package Test;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
/**
 * ������
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
		//1-ˮƽ���ã�2-��ʼλ�ã�3-�����С��4-�����۴�����С���ݣ�5-�����۴����������
		mySlider.setUnitIncrement(10);
		mySlider.setBlockIncrement(50);
		add(mySlider,BorderLayout.SOUTH);//���ֵײ�
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
