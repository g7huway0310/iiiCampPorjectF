package tw.huway0310.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "STOCKTRANSCATION")
public class StockTransaction {
	private int stocktrsactionsid;
	private int tradvolume;
	private int stockid;
	private Stock stock;

	@Id
	@Column(name = "STOCKTRANSID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getStocktrsactionsid() {
		return stocktrsactionsid;
	}

	public void setStocktrsactionsid(int stocktrsactionsid) {
		this.stocktrsactionsid = stocktrsactionsid;
	}

	@Column(name = "TRADEVOLUME")
	public int getTradvolume() {
		return tradvolume;
	}

	public void setTradvolume(int tradvolume) {
		this.tradvolume = tradvolume;
	}

	//忽略該欄位
	@Transient //要選javax.persistence.Transient
	public int getStockid() {
		return stockid;
	}

	public void setStockid(int stockid) {
		this.stockid = stockid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STOCKID")
	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

}
