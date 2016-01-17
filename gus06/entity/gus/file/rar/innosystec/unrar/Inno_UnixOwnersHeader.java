package gus06.entity.gus.file.rar.innosystec.unrar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Inno_UnixOwnersHeader extends Inno_SubBlockHeader 
{
	private Log logger = LogFactory.getLog(Inno_UnixOwnersHeader.class);
	private int ownerNameSize;
	private int groupNameSize;
	private String owner;
	private String group;
	
	public  Inno_UnixOwnersHeader(Inno_SubBlockHeader sb, byte[] uoHeader)
	{
		super(sb);
		int pos = 0;
		ownerNameSize = Inno_Raw.readShortLittleEndian(uoHeader, pos)&0xFFFF;
		pos+=2;
		groupNameSize = Inno_Raw.readShortLittleEndian(uoHeader, pos)&0xFFFF;
		pos+=2;
		if(pos+ownerNameSize<uoHeader.length){
			byte[] ownerBuffer = new byte[ownerNameSize];
			System.arraycopy(uoHeader, pos, ownerBuffer, 0, ownerNameSize);
			owner = new String(ownerBuffer);
		}
		pos+=ownerNameSize;
		if(pos+groupNameSize<uoHeader.length){
			byte[] groupBuffer = new byte[groupNameSize];
			System.arraycopy(uoHeader, pos, groupBuffer, 0, groupNameSize);
			group = new String(groupBuffer);
		}
	}
	
	public String getGroup() {return group;}
	public void setGroup(String group) {this.group = group;}
	
	public int getGroupNameSize() {return groupNameSize;}
	public void setGroupNameSize(int groupNameSize) {this.groupNameSize = groupNameSize;}
	
	public String getOwner() {return owner;}
	public void setOwner(String owner) {this.owner = owner;}
	
	public int getOwnerNameSize(){return ownerNameSize;}
	public void setOwnerNameSize(int ownerNameSize) {this.ownerNameSize = ownerNameSize;}
	
	public void print()
	{
		super.print();
		logger.info("ownerNameSize: "+ownerNameSize);
		logger.info("owner: "+owner);
		logger.info("groupNameSize: "+groupNameSize);
		logger.info("group: "+group);
	}
}