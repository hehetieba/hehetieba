package hehetieba.domain;

// Generated 2015-1-30 21:05:08 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * TTieba generated by hbm2java
 */
public class Tieba implements java.io.Serializable {

	private Integer id;
	private String tiebaName;
	private String headImg;
	private String bgImg;
	private String intruduction;
	private Byte enabled;
	private Set UserTiebas = new HashSet();
	private Set Tietitles = new HashSet();

	public Tieba() {
	}

	public Tieba(int id) {
		this.id = id;
	}

	public Tieba(int id, String tiebaName, String headImg, String bgImg,
			String intruduction, Byte enabled, Set TUserTiebas,
			Set TTietitles) {
		this.id = id;
		this.tiebaName = tiebaName;
		this.headImg = headImg;
		this.bgImg = bgImg;
		this.intruduction = intruduction;
		this.enabled = enabled;
		this.UserTiebas = TUserTiebas;
		this.Tietitles = TTietitles;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTiebaName() {
		return this.tiebaName;
	}

	public void setTiebaName(String tiebaName) {
		this.tiebaName = tiebaName;
	}

	public String getHeadImg() {
		return this.headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public String getBgImg() {
		return this.bgImg;
	}

	public void setBgImg(String bgImg) {
		this.bgImg = bgImg;
	}

	public String getIntruduction() {
		return this.intruduction;
	}

	public void setIntruduction(String intruduction) {
		this.intruduction = intruduction;
	}

	public Byte getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Byte enabled) {
		this.enabled = enabled;
	}

	public Set getTUserTiebas() {
		return this.UserTiebas;
	}

	public void setTUserTiebas(Set TUserTiebas) {
		this.UserTiebas = TUserTiebas;
	}

	public Set getTTietitles() {
		return this.Tietitles;
	}

	public void setTTietitles(Set TTietitles) {
		this.Tietitles = TTietitles;
	}

}
