package hehetieba.domain;

// Generated 2015-1-30 21:05:08 by Hibernate Tools 3.4.0.CR1

/**
 * TMessagestatus generated by hbm2java
 */
public class MessageStatus implements java.io.Serializable {

	private Integer id;
	private Byte ownerApplyRead;
	private Byte tiebaApplyRead;

	public MessageStatus() {
	}

	public MessageStatus(int id) {
		this.id = id;
	}

	public MessageStatus(int id, Byte ownerApplyRead, Byte tiebaApplyRead) {
		this.id = id;
		this.ownerApplyRead = ownerApplyRead;
		this.tiebaApplyRead = tiebaApplyRead;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Byte getOwnerApplyRead() {
		return this.ownerApplyRead;
	}

	public void setOwnerApplyRead(Byte ownerApplyRead) {
		this.ownerApplyRead = ownerApplyRead;
	}

	public Byte getTiebaApplyRead() {
		return this.tiebaApplyRead;
	}

	public void setTiebaApplyRead(Byte tiebaApplyRead) {
		this.tiebaApplyRead = tiebaApplyRead;
	}

}
