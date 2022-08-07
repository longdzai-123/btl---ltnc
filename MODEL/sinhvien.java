package MODEL;

import java.util.Date;

public class sinhvien {
     private int masinhvien;
     private String tensinhvien;
     private int id_tinh;
     private Date date;
     private boolean gioitinh;
     private Float giaitich1;
     private Float giaitich2;
     private Float giaitich3;
     
      
     
     
	public sinhvien() {
		
	}
	public sinhvien(int masinhvien, String tensinhvien, int id_tinh, Date date, boolean gioitinh, Float giaitich1,
			Float giaitich2, Float giaitich3) {

		this.masinhvien = masinhvien;
		this.tensinhvien = tensinhvien;
		this.id_tinh = id_tinh;
		this.date = date;
		this.gioitinh = gioitinh;
		this.giaitich1 = giaitich1;
		this.giaitich2 = giaitich2;
		this.giaitich3 = giaitich3;
	}
	public int getMasinhvien() {
		return masinhvien;
	}
	public void setMasinhvien(int masinhvien) {
		this.masinhvien = masinhvien;
	}
	public String getTensinhvien() {
		return tensinhvien;
	}
	public void setTensinhvien(String tensinhvien) {
		this.tensinhvien = tensinhvien;
	}
	public int getId_tinh() {
		return id_tinh;
	}
	public void setId_tinh(int id_tinh) {
		this.id_tinh = id_tinh;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(boolean gioitinh) {
		this.gioitinh = gioitinh;
	}
	public Float getGiaitich1() {
		return giaitich1;
	}
	public void setGiaitich1(Float giaitich1) {
		this.giaitich1 = giaitich1;
	}
	public Float getGiaitich2() {
		return giaitich2;
	}
	public void setGiaitich2(Float giaitich2) {
		this.giaitich2 = giaitich2;
	}
	public Float getGiaitich3() {
		return giaitich3;
	}
	public void setGiaitich3(Float giaitich3) {
		this.giaitich3 = giaitich3;
	}
	@Override
	public String toString() {
		return "sinhvien [masinhvien=" + masinhvien + ", tensinhvien=" + tensinhvien + ", id_tinh=" + id_tinh
				+ ", date=" + date + ", gioitinh=" + gioitinh + ", giaitich1=" + giaitich1 + ", giaitich2=" + giaitich2
				+ ", giaitich3=" + giaitich3 + "]";
	}
	
     
     
     
     
     
     
	
	
}
