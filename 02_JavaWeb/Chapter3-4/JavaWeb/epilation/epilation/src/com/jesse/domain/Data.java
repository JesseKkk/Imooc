package com.jesse.domain;

public class Data implements Comparable<Data> {
	private String dataId;
	private String dataName;
	private String categoryName;
	private String dataDate;
	private String dataPic;
	private String remarks;
	
	public Data() {
		
	}
	
	public Data(String dataId, String dataName, String categoryName, String dataDate, String dataPic, String remarks) {
		super();
		this.dataId = dataId;
		this.dataName = dataName;
		this.categoryName = categoryName;
		this.dataDate = dataDate;
		this.dataPic = dataPic;
		this.remarks = remarks;
	}

	public String getDataId() {
		return dataId;
	}
	public void setDataId(String dataId) {
		this.dataId = dataId;
	}
	public String getDataName() {
		return dataName;
	}
	public void setDataName(String dataName) {
		this.dataName = dataName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDataDate() {
		return dataDate;
	}
	public void setDataDate(String dataDate) {
		this.dataDate = dataDate;
	}
	public String getDataPic() {
		return dataPic;
	}
	public void setDataPic(String dataPic) {
		this.dataPic = dataPic;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj.getClass() == Data.class) {
			Data data = (Data)obj;
			return (data.getDataId().equals(this.getDataId()));
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Data [dataId=" + dataId + ", dataName=" + dataName + ", categoryName=" + categoryName + ", dataDate="
				+ dataDate + ", dataPic=" + dataPic + ", remarks=" + remarks + "]";
	}

	@Override
	public int compareTo(Data o) {
		return this.getDataId().compareTo(o.getDataId());
	}
	
}
