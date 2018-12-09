 package live.autu.generator.common;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {
	
	private static final long serialVersionUID = -5395997221963176643L;
	
	private List<T> list;	 
	private int pageNumber;	 
	private int pageSize; 
	private int totalPage;				 
	private int totalRow;				 
	private Integer startRow;			
	
	public int getStartRow() {
		if(startRow==null) {
			startRow=pageSize*(pageNumber-1);
		}
		return startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	/**
	 * Constructor.
	 * @param list the list of paginate result
	 * @param pageNumber the page number
	 * @param pageSize the page size
	 * @param totalPage the total page of paginate
	 * @param totalRow the total row of paginate
	 */
	public Page(List<T> list, int pageNumber, int pageSize, int totalPage, int totalRow) {
		this.list = list;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
		this.totalRow = totalRow;
	}
	
	public Page() {
		
	}
	
	/**
	 * Return list of this page.
	 */
	public List<T> getList() {
		return list;
	}
	
	/**
	 * Return page number.
	 */
	public int getPageNumber() {
		return pageNumber;
	}
	
	/**
	 * Return page size.
	 */
	public int getPageSize() {
		return pageSize;
	}
	
	/**
	 * Return total page.
	 */
	public int getTotalPage() {
		return totalPage;
	}
	
	/**
	 * Return total row.
	 */
	public int getTotalRow() {
		return totalRow;
	}
	
	public boolean isFirstPage() {
		return pageNumber == 1;
	}
	
	public boolean isLastPage() {
		return pageNumber >= totalPage;
	}
	
	public String toString() {
		StringBuilder msg = new StringBuilder();
		msg.append("pageNumber : ").append(pageNumber);
		msg.append("\npageSize : ").append(pageSize);
		msg.append("\ntotalPage : ").append(totalPage);
		msg.append("\ntotalRow : ").append(totalRow);
		return msg.toString();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}
	
	
}

