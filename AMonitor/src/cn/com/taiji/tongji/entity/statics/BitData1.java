package cn.com.taiji.tongji.entity.statics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.taiji.common.entity.BaseEntity;

@Entity
@Table(name = "data1")
public class BitData1 extends BaseEntity{
	private int id;
	private String ReId;
	private String rsrp;//RSRP
	private String rsrq;//RSRQ
	private String rssinr;
	private String txByte;
	private String rxByte;
	private String netType;
	private String pci;//PCI
	private String ci;//ECI
	private String enodbId;//EnodbID
	private String cellId;//Cell-id
	private String tac;//TAC
	private String timeStamp;
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReId() {
		return ReId;
	}
	public void setReId(String reId) {
		ReId = reId;
	}
	@Column(name="RSRP")
	public String getRsrp() {
		return rsrp;
	}
	public void setRsrp(String rsrp) {
		this.rsrp = rsrp;
	}
	@Column(name="RSRQ")
	public String getRsrq() {
		return rsrq;
	}
	public void setRsrq(String rsrq) {
		this.rsrq = rsrq;
	}
	@Column(name="RSSINR")
	public String getRssinr() {
		return rssinr;
	}
	public void setRssinr(String rssinr) {
		this.rssinr = rssinr;
	}
	@Column(name="TxByte")
	public String getTxByte() {
		return txByte;
	}
	public void setTxByte(String txByte) {
		this.txByte = txByte;
	}
	@Column(name="RxByte")
	public String getRxByte() {
		return rxByte;
	}
	public void setRxByte(String rxByte) {
		this.rxByte = rxByte;
	}
	@Column(name="NetType")
	public String getNetType() {
		return netType;
	}
	public void setNetType(String netType) {
		this.netType = netType;
	}
	@Column(name="PCI")
	public String getPci() {
		return pci;
	}
	public void setPci(String pci) {
		this.pci = pci;
	}
	@Column(name="CI")
	public String getCi() {
		return ci;
	}
	public void setCi(String ci) {
		this.ci = ci;
	}
	@Column(name="ENODBID")
	public String getEnodbId() {
		return enodbId;
	}
	public void setEnodbId(String enodbId) {
		this.enodbId = enodbId;
	}
	@Column(name="CELLID")
	public String getCellId() {
		return cellId;
	}
	public void setCellId(String cellId) {
		this.cellId = cellId;
	}
	@Column(name="TAC")
	public String getTac() {
		return tac;
	}
	public void setTac(String tac) {
		this.tac = tac;
	}
	@Column(name="Time")
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

}
