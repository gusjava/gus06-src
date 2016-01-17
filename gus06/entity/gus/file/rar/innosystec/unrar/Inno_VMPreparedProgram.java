package gus06.entity.gus.file.rar.innosystec.unrar;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Inno_VMPreparedProgram 
{
	private List<Inno_VMPreparedCommand> Cmd  = new ArrayList<Inno_VMPreparedCommand>();
	private List<Inno_VMPreparedCommand> AltCmd  =new ArrayList<Inno_VMPreparedCommand>();
	private int CmdCount;

	private Vector<Byte> GlobalData = new Vector<Byte>();
	private Vector<Byte> StaticData = new Vector<Byte>(); // static data contained in DB operators
	private int InitR[] = new int[7];

	private int FilteredDataOffset;
	private int FilteredDataSize;
	
	public Inno_VMPreparedProgram() 
	{
		AltCmd=null;
	}

	public List<Inno_VMPreparedCommand> getAltCmd() {
		return AltCmd;
	}

	public void setAltCmd(List<Inno_VMPreparedCommand> altCmd) {
		AltCmd = altCmd;
	}

	public List<Inno_VMPreparedCommand> getCmd() {
		return Cmd;
	}

	public void setCmd(List<Inno_VMPreparedCommand> cmd) {
		Cmd = cmd;
	}

	public int getCmdCount() {
		return CmdCount;
	}

	public void setCmdCount(int cmdCount) {
		CmdCount = cmdCount;
	}

	public int getFilteredDataOffset() {
		return FilteredDataOffset;
	}

	public void setFilteredDataOffset(int filteredDataOffset) {
		FilteredDataOffset = filteredDataOffset;
	}

	public int getFilteredDataSize() {
		return FilteredDataSize;
	}

	public void setFilteredDataSize(int filteredDataSize) {
		FilteredDataSize = filteredDataSize;
	}

	public Vector<Byte> getGlobalData() {
		return GlobalData;
	}

	public void setGlobalData(Vector<Byte> globalData) {
		GlobalData = globalData;
	}

	public int[] getInitR() {
		return InitR;
	}

	public void setInitR(int[] initR) {
		InitR = initR;
	}

	public Vector<Byte> getStaticData() {
		return StaticData;
	}

	public void setStaticData(Vector<Byte> staticData) {
		StaticData = staticData;
	}
	
	
}