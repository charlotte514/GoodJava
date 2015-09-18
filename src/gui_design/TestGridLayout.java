package gui_design;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class TestGridLayout extends Applet{
	public void init(){
		setLayout(new GridLayout(5,6));//按顺序，从左到右，从上到下。
		for(int i=0;i<31;i++){
			if(Math.random()>0.5)
				add(new Button(Integer.toString(i)));
			else
				add(new Label());
		}
	}
}
