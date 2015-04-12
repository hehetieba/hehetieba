package hehetieba.dto;


public class TiebaDto {
	private Integer id;
	private String tiebaName;
	private String headImg;
	private String bgImg;
	private String intruduction;
	private Byte enabled;
	// 派生属性
	private Integer memberCount;
	private Integer tieCount;
	
	public TiebaDto(Integer id, String tiebaName, String headImg, String bgImg,
			String intruduction, Byte enabled, Integer memberCount,
			Integer tieCount) {
		super();
		this.id = id;
		this.tiebaName = tiebaName;
		this.headImg = headImg;
		this.bgImg = bgImg;
		this.intruduction = intruduction;
		this.enabled = enabled;
		this.memberCount = memberCount;
		this.tieCount = tieCount;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTiebaName() {
		return tiebaName;
	}
	public void setTiebaName(String tiebaName) {
		this.tiebaName = tiebaName;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public String getBgImg() {
		return bgImg;
	}
	public void setBgImg(String bgImg) {
		this.bgImg = bgImg;
	}
	public String getIntruduction() {
		return intruduction;
	}
	public void setIntruduction(String intruduction) {
		this.intruduction = intruduction;
	}
	public Byte getEnabled() {
		return enabled;
	}
	public void setEnabled(Byte enabled) {
		this.enabled = enabled;
	}
	public Integer getMemberCount() {
		return memberCount;
	}
	public void setMemberCount(Integer memberCount) {
		this.memberCount = memberCount;
	}
	public Integer getTieCount() {
		return tieCount;
	}
	public void setTieCount(Integer tieCount) {
		this.tieCount = tieCount;
	}
}
