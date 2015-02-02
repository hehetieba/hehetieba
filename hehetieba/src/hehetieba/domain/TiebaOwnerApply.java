package hehetieba.domain;

// Generated 2015-1-30 21:05:08 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * TTiebaownerapply generated by hbm2java
 */
public class TiebaOwnerApply implements java.io.Serializable {

	private Integer id;
	private Integer userId;
	private Integer tiebaId;
	private String tiebaName;
	private Byte handleStatus;
	private Date applyDate;

	public TiebaOwnerApply() {
	}

	public TiebaOwnerApply(Integer id, Integer userId, Date applyDate) {
		this.id = id;
		this.userId = userId;
		this.applyDate = applyDate;
	}

	public TiebaOwnerApply(Integer id, Integer userId, Integer tiebaId,
			String tiebaName, Byte handleStatus, Date applyDate) {
		this.id = id;
		this.userId = userId;
		this.tiebaId = tiebaId;
		this.tiebaName = tiebaName;
		this.handleStatus = handleStatus;
		this.applyDate = applyDate;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getTiebaId() {
		return this.tiebaId;
	}

	public void setTiebaId(Integer tiebaId) {
		this.tiebaId = tiebaId;
	}

	public String getTiebaName() {
		return this.tiebaName;
	}

	public void setTiebaName(String tiebaName) {
		this.tiebaName = tiebaName;
	}

	public Byte getHandleStatus() {
		return this.handleStatus;
	}

	public void setHandleStatus(Byte handleStatus) {
		this.handleStatus = handleStatus;
	}

	public Date getApplyDate() {
		return this.applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

}
