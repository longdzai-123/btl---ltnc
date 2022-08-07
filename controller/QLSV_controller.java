package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import VIEW.view;

public class QLSV_controller implements ActionListener {
	public view view;

	public QLSV_controller(view view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String cm = e.getActionCommand();
		JOptionPane.showMessageDialog(view, "Bạn vừa nhấn vào:" + cm);
		if (cm.equals("Thêm")) {
			this.view.xoaForm();
			this.view.model.setLuaChon("Thêm");

		} else if (cm.equals("Lưu")) {
			try {
				this.view.thucHienThemSinhVien();

			} catch (Exception e2) {
				e2.printStackTrace();
			}

		} else if (cm.equals("Cập Nhật")) {
			try {
				this.view.hienthiThongTinSV();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (cm.equals("Xóa")) {
			try {
				this.view.thucHienXoa();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		} else if (cm.equals("Hủy Bỏ")) {
			this.view.xoaForm();

		} else if (cm.equals("Tìm")) {
			try {
				this.view.thucHienTim();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (cm.equals("Hủy tìm")) {
			try {
				this.view.thucHienTaiLaiDuLieu();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (cm.equals("About Me")) {
			this.view.hienThiAbout();

		} else if (cm.equals("Exit")) {
			this.view.thoatKhoiChuongTrinh();
		} else if (cm.equals("Save")) {
			try {
				this.view.saveMySQL();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (cm.equals("Open")) {
			try {
				this.view.OpenMySQL();
			} catch (Exception e1) {

				e1.printStackTrace();
			}
		}

	}
}
