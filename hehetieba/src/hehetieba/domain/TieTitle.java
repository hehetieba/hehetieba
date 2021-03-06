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
	private Tieba tieba;
	private User user;
	private Date lastPostTime;
	private String title;
	private Byte top;
	private Byte jiajing;
	private Integer maxFloor;
	private Date createDate;
	private String lastPostUserName;
	private Set replies = new HashSet();
	private Set ties = new HashSet();
	
	/*派生属性*/
	private Integer replyCount;

	public TieTitle() {
	}
	
	public TieTitle(String title) {
		this.title = title;
	}

	public TieTitle(Integer id, Date lastPostTime, Date createDate) {
		this.id = id;
		this.lastPostTime = lastPostTime;
		this.createDate = createDate;
	}

	public TieTitle(Integer id, Tieba tieba, User user, Date lastPostTime,
			String title, Byte top, Byte jiajing, Integer maxFloor,
			Date createDate, String lastPostUserName, Set replies, Set ties,
			Integer replyCount) {
		super();
		this.id = id;
		this.tieba = tieba;
		this.user = user;
		this.lastPostTime = lastPostTime;
		this.title = title;
		this.top = top;
		this.jiajing = jiajing;
		this.maxFloor = maxFloor;
		this.createDate = createDate;
		this.lastPostUserName = lastPostUserName;
		this.replies = replies;
		this.ties = ties;
		this.replyCount = replyCount;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Tieba getTieba() {
		return this.tieba;
	}

	public void setTieba(Tieba Tieba) {
		this.tieba = Tieba;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User User) {
		this.user = User;
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

	public Set getReplies() {
		return replies;
	}

	public void setReplies(Set replies) {
		this.replies = replies;
	}

	public Set getTies() {
		return ties;
	}

	public void setTies(Set ties) {
		this.ties = ties;
	}

	public Integer getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}
	
	

}
