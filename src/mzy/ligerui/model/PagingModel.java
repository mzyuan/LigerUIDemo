package mzy.ligerui.model;

public class PagingModel {

	private int page; // 第几页
	private int rows; // 每页记录数
	
	
	public PagingModel(int page, int rows) {
		super();
		this.page = page;
		this.rows = rows;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getStart() {
		return (page-1)*rows;
	}
	
	
}
