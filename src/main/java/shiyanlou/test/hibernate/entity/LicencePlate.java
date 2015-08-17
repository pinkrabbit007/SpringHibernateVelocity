package shiyanlou.test.hibernate.entity;

/**
 * 
 * @author zhangjunqiao
 * 
 */

public class LicencePlate {

	private int id_licenceplate;
	private String licencePlateNum;

	public int getId_licenceplate() {
		return id_licenceplate;
	}
	public void setId_licenceplate(int id_licenceplate) {
		this.id_licenceplate = id_licenceplate;
	}

	/* private String username; */
	/*
	 * public String getUsername() { return username; }
	 * 
	 * public void setUsername(String username) { this.username = username; }
	 */

	public String getLicencePlateNum() {
		return licencePlateNum;
	}

	public void setLicencePlateNum(String licencePlateNum) {
		this.licencePlateNum = licencePlateNum;
	}

}
