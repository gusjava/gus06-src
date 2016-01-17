package gus06.entity.gus.lookandfeel.uimanager.init1;

import gus06.framework.*;

public class EntityImpl implements Entity {

	public String creationDate() {return "20140729";}

	private Service customize;

	public EntityImpl() throws Exception
	{
		customize = Outside.service(this,"gus.lookandfeel.uimanager.customize");
	
		customize.v("Button.font",		"font#SansSerif plain 12");
		customize.v("CheckBox.font",		"font#SansSerif plain 14");
		customize.v("Label.font",		"font#SansSerif plain 12");
		customize.v("Menu.font",		"font#SansSerif plain 12");
		customize.v("MenuItem.font",		"font#SansSerif plain 12");
		customize.v("List.font",		"font#SansSerif plain 12");
		customize.v("RadioButton.font",		"font#SansSerif plain 14");
		customize.v("RadioButtonMenuItem.font",	"font#SansSerif plain 12");
		customize.v("TabbedPane.font",		"font#SansSerif plain 12");
		customize.v("TitledBorder.font",	"font#SansSerif bold 16");
		customize.v("ToggleButton.font",	"font#SansSerif plain 12");
		customize.v("ToolTip.font",		"font#SansSerif plain 15");
	}
}
