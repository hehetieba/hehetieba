package hehetieba.domain;

// Generated 2015-1-30 21:05:08 by Hibernate Tools 3.4.0.CR1

/**
 * TUserTieba generated by hbm2java
 */
public class UserTieba implements java.io.Serializable {

	private Integer id;
	private Tieba Tieba;
	private User User;
	private Integer points;
	private Byte enabled;
	private Byte type;

	public UserTieba() {
	}

	public UserTieba(int id) {
		this.id = id;
	}

	public UserTieba(int id, Tieba Tieba, User User, Integer points,
			Byte enabled, Byte type) {
		this.id = id;
		this.Tieba = Tieba;
		this.User = User;
		this.points = points;
		this.enabled = enabled;
		this.type = type;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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

	public Integer getPoints() {
		return this.points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Byte getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Byte enabled) {
		this.enabled = enabled;
	}

	public Byte getType() {
		return this.type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

}
