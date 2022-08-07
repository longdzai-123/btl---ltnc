package MODEL;

import java.util.ArrayList;

public class QLSV_Model {

	private ArrayList<sinhvien> dsSinhVien;
	private String luaChon;

	public QLSV_Model() {
		this.dsSinhVien = new ArrayList<sinhvien>();
		this.luaChon = "";
	}

	public QLSV_Model(ArrayList<sinhvien> dsSinhVien) {

		this.dsSinhVien = dsSinhVien;
	}

	public ArrayList<sinhvien> getDsSinhVien() {
		return dsSinhVien;
	}

	public void setDsSinhVien(ArrayList<sinhvien> dsSinhVien) {
		this.dsSinhVien = dsSinhVien;
	}

	public void insert(sinhvien sinhvien) {
		this.dsSinhVien.add(sinhvien);
	}

	public void delete(sinhvien sinhvien) {
		this.dsSinhVien.remove(sinhvien);
	}
	public void update(sinhvien sinhvien) {
		this.dsSinhVien.remove(sinhvien);
		this.dsSinhVien.add(sinhvien);
	}

	public String getLuaChon() {
		return luaChon;
	}

	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}

	public boolean ktraTonTai(sinhvien sv) {
		for (sinhvien sinhVien : dsSinhVien) {
			if(sinhVien.getMasinhvien()==sv.getMasinhvien()) {
				return true;
			}			
		}
		return false;
	}
	
	
}
