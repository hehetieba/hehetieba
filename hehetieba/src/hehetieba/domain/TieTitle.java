package hehetieba.domain;

// Generated 2015-1-30 21:05:08 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TTietitle generated by hbm2java
 */
public class TieTitle implements java.io.Serializable {

	private Integer id;
	private Tieba Tieba;
	private User User;
	private Date lastPostTime;
	private String title;
	private Byte top;
	private Byte jiajing;
	private Integer maxFloor;
	private Date createDate;
	private String lastPostUserName;
	private Set Replies = new HashSet();
	private Set Ties = new HashSet();

	public TieTitle() {
	}

	public TieTitle(int id, Date lastPostTime, Date createDate) {
		this.id = id;
		this.lastPostTime = lastPostTime;
		this.createDate = createDate;
	}

	public TieTitle(int id, Tieba Tieba, User User, Date lastPostTime,
			String title, Byte top, Byte jiajing, Integer maxFloor,
			Date createDate, String lastPostUserName, Set TReplies, Set TTies) {
		this.id = id;
		this.Tieba = Tieba;
		this.User = User;
		this.lastPostTime = lastPostTime;
		this.title = title;
		this.top = top;
		this.jiajing = jiajing;
		this.maxFloor = maxFloor;
		this.createDate = createDate;
		this.lastPostUserName = lastPostUserName;
		this.Replies = TReplies;
		this.Ties = TTies;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Tieba getTieba() {
		return this.Tieba;
	}

	public void setTieba(Tieba Tieba) {
		this.Tieba = Tieba;
	}

	public User getUser() {
		return this.User;
	}

	public void setUser(User User) {
		this.User = User;
	}

	public Date getLastPostTime() {
		return this.lastPostTime;
	}

	public void setLastPostTime(Date lastPostTime) {
		this.lastPostTime = lastPostTime;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Byte getTop() {
		return this.top;
	}

	public void setTop(Byte top) {
		this.top = top;
	}

	public Byte getJiajing() {
		return this.jiajing;
	}

	public void setJiajing(Byte jiajing) {
		this.jiajing = jiajing;
	}

	public Integer getMaxFloor() {
		return this.maxFloor;
	}

	public void setMaxFloor(Integer maxFloor) {
		this.maxFloor = maxFloor;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getLastPostUserName() {
		return this.lastPostUserName;
	}

	public void setLastPostUserName(String lastPostUserName) {
		this.lastPostUserName = lastPostUserName;
	}

	public Set getTReplies() {
		return this.Replies;
	}

	public void setTReplies(Set TReplies) {
		this.Replies = TReplies;
	}

	public Set getTTies() {
		return this.Ties;
	}

	public void setTTies(Set TTies) {
		this.Ties = TTies;
	}

}
