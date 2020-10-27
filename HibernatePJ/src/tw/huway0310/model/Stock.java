package tw.huway0310.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STOCK")
public class Stock {

	private int stockId;
	private String stockname;
	private String stockCode;
	private Set<StockTransaction> stockTransaction=new HashSet<StockTransaction>();
	
	
	@Id
	@Column(name = "STOCKID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	
	@Column(name = "stockname")
	public String getStockname() {
		return stockname;
	}
	public void setStockname(String stockname) {
		this.stockname = stockname;
	}
	
	@Column(name = "stockcode")
	public String getStockCode() {
		return stockCode;
	}
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	

	
	public Stock(int stockId) {
		super();
		this.stockId = stockId;
	}
	
	
	public Stock() {
		// TODO Auto-generated constructor stub
	}
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "stock",cascade = CascadeType.ALL)
	public Set<StockTransaction> getStockTransaction() {
		return stockTransaction;
	}
	
	
	public void setStockTransaction(Set<StockTransaction> stockTransaction) {
		this.stockTransaction = stockTransaction;
	}
	
	
	
	
}
