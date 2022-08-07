package VIEW;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout.Group;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import DAO.Data;
import DB.DBConnection;
import MODEL.QLSV_Model;
import MODEL.sinhvien;
import MODEL.tinh;
import controller.QLSV_controller;

import java.sql.*;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSpinner;

public class view extends JFrame {

	private JPanel contentPane;
    

	public JTextField textField_msv;
	public JTable table;
	public JTextField textField_id;
	public JTextField textField_hoTen;
	public JTextField textField_ngaySinh;
	public JTextField textField_gt1;
	public JTextField textField_gt2;
	public JTextField textField_gt3;

	public ButtonGroup btn_gioitinh;

	public JComboBox comboBox_quequan_1;

	public JRadioButton radiobutton_nam;

	public JRadioButton radiobutton_nu;

	public JComboBox comboBox_quequan;


	public QLSV_Model model;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view frame = new view();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	public view() throws Exception {
		this.model = new QLSV_Model();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1415, 805);
		
		ActionListener action = new QLSV_controller(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setBackground(Color.ORANGE);
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnNewMenu);
		
		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(action);
		menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnNewMenu.add(menuOpen);
		
		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(action);
		menuSave.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnNewMenu.add(menuSave);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(action);
		menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnNewMenu.add(menuExit);
		
		JMenu menuAbout = new JMenu("About");
		menuAbout.addActionListener(action);
		menuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menuAbout);
		
		JMenuItem menuAboutMe = new JMenuItem("About me");
		menuAboutMe.addActionListener(action);
		menuAboutMe.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuAbout.add(menuAboutMe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_quequan = new JLabel("Quê Quán");
		label_quequan.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_quequan.setBounds(1051, 157, 99, 53);
		contentPane.add(label_quequan);
		
		JLabel label_msv = new JLabel("Mã Sinh Viên");
		label_msv.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_msv.setBounds(1051, 220, 123, 53);
		contentPane.add(label_msv);
		
		textField_msv = new JTextField();
		textField_msv.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_msv.setColumns(10);
		textField_msv.setBounds(1184, 223, 207, 47);
		contentPane.add(textField_msv);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.addActionListener(action);
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnTim.setBounds(1083, 303, 91, 43);
		contentPane.add(btnTim);
		
		
		Connection conn = DBConnection.CreateConnection();
	    comboBox_quequan = new JComboBox();
		
		List<tinh> listTinh = Data.province(conn);
		comboBox_quequan.addItem("");
		for (tinh t : listTinh) {
			comboBox_quequan.addItem(t.getTen_tinh());
			
		}
		comboBox_quequan.setFont(new Font("Tahoma", Font.PLAIN, 19));
		comboBox_quequan.setBounds(1184, 160, 207, 47);
		contentPane.add(comboBox_quequan);
		
		JLabel label_msv_1 = new JLabel("Danh Sách Sinh Viên");
		label_msv_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_msv_1.setBounds(357, 54, 188, 53);
		contentPane.add(label_msv_1);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 19));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Sinh Viên", "Họ Tên", "Quê Quán", "Ngày Sinh", "Giới Tính", "Giải Tích 1", "Giải Tích 2", "Giải Tích 3"
			}
		));

		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(28, 102, 958, 273);
		contentPane.add(scrollPane);
		
		JLabel label_msv_1_1 = new JLabel("Thông Tin Sinh Viên ");
		label_msv_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_msv_1_1.setBounds(626, 385, 238, 53);
		contentPane.add(label_msv_1_1);
		
		JLabel label_id = new JLabel("Mã Sinh Viên");
		label_id.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_id.setBounds(20, 448, 123, 53);
		contentPane.add(label_id);
		
		textField_id = new JTextField();
		textField_id.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_id.setColumns(10);
		textField_id.setBounds(159, 451, 221, 47);
		contentPane.add(textField_id);
		
		JLabel label_hoten = new JLabel("Họ Tên");
		label_hoten.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_hoten.setBounds(20, 511, 123, 53);
		contentPane.add(label_hoten);
		
		textField_hoTen = new JTextField();
		textField_hoTen.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_hoTen.setColumns(10);
		textField_hoTen.setBounds(159, 514, 221, 47);
		contentPane.add(textField_hoTen);
		
		JLabel label_queQuan = new JLabel("Quê Quán");
		label_queQuan.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_queQuan.setBounds(20, 570, 123, 53);
		contentPane.add(label_queQuan);
		
		JLabel label_ngáyinh = new JLabel("Ngày Sinh");
		label_ngáyinh.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_ngáyinh.setBounds(20, 627, 123, 53);
		contentPane.add(label_ngáyinh);
		
		textField_ngaySinh = new JTextField();
		textField_ngaySinh.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_ngaySinh.setColumns(10);
		textField_ngaySinh.setBounds(159, 630, 221, 47);
		contentPane.add(textField_ngaySinh);
		
	    comboBox_quequan_1 = new JComboBox();
	    
		comboBox_quequan_1.addItem("");
		for (tinh t : listTinh) {
			comboBox_quequan_1.addItem(t.getTen_tinh());
			
		}
		comboBox_quequan_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		comboBox_quequan_1.setBounds(159, 573, 221, 47);
		contentPane.add(comboBox_quequan_1);
		
		JLabel label_gioitinh = new JLabel("Giới Tính");
		label_gioitinh.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_gioitinh.setBounds(538, 448, 123, 53);
		contentPane.add(label_gioitinh);
		
		radiobutton_nam = new JRadioButton("Nam");
		radiobutton_nam.setFont(new Font("Tahoma", Font.PLAIN, 19));
		radiobutton_nam.setBounds(684, 464, 103, 21);
		contentPane.add(radiobutton_nam);
		
		radiobutton_nu = new JRadioButton("Nữ");
		radiobutton_nu.setFont(new Font("Tahoma", Font.PLAIN, 19));
		radiobutton_nu.setBounds(817, 464, 103, 21);
		contentPane.add(radiobutton_nu);
		
	    btn_gioitinh = new ButtonGroup();
	    btn_gioitinh.add(radiobutton_nam);
	    btn_gioitinh.add(radiobutton_nu);
		
		JLabel label_gt1 = new JLabel("Giải Tích 1");
		label_gt1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_gt1.setBounds(538, 511, 123, 53);
		contentPane.add(label_gt1);
		
		textField_gt1 = new JTextField();
		textField_gt1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_gt1.setColumns(10);
		textField_gt1.setBounds(686, 514, 221, 47);
		contentPane.add(textField_gt1);
		
		JLabel label_gt2 = new JLabel("Giải Tích 2");
		label_gt2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_gt2.setBounds(538, 570, 123, 53);
		contentPane.add(label_gt2);
		
		textField_gt2 = new JTextField();
		textField_gt2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_gt2.setColumns(10);
		textField_gt2.setBounds(686, 573, 221, 47);
		contentPane.add(textField_gt2);
		
		JLabel label_gt3 = new JLabel("Giải Tích 3");
		label_gt3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_gt3.setBounds(538, 627, 123, 53);
		contentPane.add(label_gt3);
		
		textField_gt3 = new JTextField();
		textField_gt3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_gt3.setColumns(10);
		textField_gt3.setBounds(686, 630, 221, 47);
		contentPane.add(textField_gt3);
		
		JButton btnThem = new JButton("Thêm");		
		btnThem.addActionListener(action);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnThem.setBounds(1034, 516, 140, 43);
		contentPane.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");	
		btnXoa.addActionListener(action);	
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnXoa.setBounds(1236, 516, 134, 43);
		contentPane.add(btnXoa);
		
		JButton btnCapNhat = new JButton("Cập Nhật");
		btnCapNhat.addActionListener(action);
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnCapNhat.setBounds(1034, 575, 140, 43);
		contentPane.add(btnCapNhat);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setForeground(Color.BLUE);
		btnLuu.setBackground(Color.WHITE);
		btnLuu.addActionListener(action);
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnLuu.setBounds(1236, 575, 134, 43);
		contentPane.add(btnLuu);
		
		JButton btnHuyBo = new JButton("Hủy Bỏ");
		btnHuyBo.setForeground(Color.RED);
		btnHuyBo.addActionListener(action);
		btnHuyBo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnHuyBo.setBounds(1140, 632, 140, 43);
		contentPane.add(btnHuyBo);
		
		JButton btnHuyTim = new JButton("Hủy Tìm");
		btnHuyTim.addActionListener(action);
		btnHuyTim.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnHuyTim.setBounds(1217, 303, 117, 43);
		contentPane.add(btnHuyTim);
		
		JLabel label_msv_1_2 = new JLabel("Quản Lý Sinh Viên");
		label_msv_1_2.setBackground(Color.WHITE);
		label_msv_1_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_msv_1_2.setBounds(626, -4, 188, 53);
		contentPane.add(label_msv_1_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLUE);
		separator_1.setBounds(28, 50, 1363, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBackground(Color.BLUE);
		separator_1_1.setBounds(28, 388, 1363, 2);
		contentPane.add(separator_1_1);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBackground(Color.BLUE);
		separator_1_2.setBounds(28, 704, 1363, 2);
		contentPane.add(separator_1_2);
		
		JLabel label_msv_1_3 = new JLabel("Tìm Kiếm Sinh Viên");
		label_msv_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_msv_1_3.setBounds(1123, 65, 198, 53);
		contentPane.add(label_msv_1_3);
		
		
		this.setVisible(true);
	}



	public void xoaForm() {
		
		textField_id.setText("");
		textField_hoTen.setText("");
//		textField_msv.setText("");
		textField_ngaySinh.setText("");
		textField_gt1.setText("");
		textField_gt2.setText("");
		textField_gt3.setText("");
		comboBox_quequan_1.setSelectedIndex(-1);
		btn_gioitinh.clearSelection();
		
	}
    
	
	public void themSinhVienVaoTable(sinhvien sv) throws Exception {
		Connection conn = DBConnection.CreateConnection();
    	DefaultTableModel model_table = (DefaultTableModel) table.getModel();
    		
			model_table.addRow(new Object[] {
				    
			        sv.getMasinhvien()+"",
			        sv.getTensinhvien()+"",
			        Data.tenTinhbyID(sv.getId_tinh()+1,conn)+"",
			        sv.getDate().getDate() + "/" + (sv.getDate().getMonth() + 1) + "/"+ (sv.getDate().getYear() + 1900),
			        (sv.isGioitinh()?"Nam":"Nữ"),
			        sv.getGiaitich1()+"",
			        sv.getGiaitich2()+"",
			        sv.getGiaitich3()+"",
				
			        });
		
    }


	
	public void themHoacCapNhatSV(sinhvien sv) throws Exception {
		Connection conn = DBConnection.CreateConnection();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if(!this.model.ktraTonTai(sv)) {
		    this.model.insert(sv);
		   
		   this.themSinhVienVaoTable(sv);
		}else {
			this.model.update(sv);
			int soLuongDong = model_table.getRowCount();
			for(int i = 0; i< soLuongDong;i++) {
				String id = model_table.getValueAt(i, 0)+"";
				if(id.equals(sv.getMasinhvien()+"")) {
					model_table.setValueAt(sv.getMasinhvien()+"", i, 0);
					model_table.setValueAt(sv.getTensinhvien()+"", i, 1);
					model_table.setValueAt(Data.tenTinhbyID(sv.getId_tinh()+1,conn)+"", i, 2);
					model_table.setValueAt(sv.getDate().getDate() + "/" + (sv.getDate().getMonth() + 1) + "/"+ (sv.getDate().getYear() + 1900), i, 3);
					model_table.setValueAt(sv.isGioitinh()?"Nam":"Nữ", i, 4);
					model_table.setValueAt(sv.getGiaitich1()+"", i, 5);
					model_table.setValueAt(sv.getGiaitich2()+"", i, 6);
					model_table.setValueAt(sv.getGiaitich3()+"", i, 7);
				}
			}
		}
	}

   

    public sinhvien getThiSinhDangChon() throws Exception {
    	Connection conn = DBConnection.CreateConnection();
    	DefaultTableModel model_table = (DefaultTableModel) table.getModel();
	    int i_row = table.getSelectedRow();
	    
	    int maSinhVien = Integer.valueOf(model_table.getValueAt(i_row, 0)+"");
    	
		String tenSinhVien = model_table.getValueAt(i_row, 1)+"";
		
		String tentinh = model_table.getValueAt(i_row, 2)+"";
		int id_tinh = Data.idTinhbyTenTinh(tentinh, conn);
		String s_ngaySinh = model_table.getValueAt(i_row, 3)+"";
		
		Date ngaySinh = new Date(s_ngaySinh);
		
		String textGioiTinh = model_table.getValueAt(i_row, 4)+"";
		
        boolean gioitinh = textGioiTinh.equals("Nam");
        
		float giaitich1 = Float.valueOf(model_table.getValueAt(i_row, 5)+"");  
		float giaitich2 = Float.valueOf(model_table.getValueAt(i_row, 6)+"");
		float giaitich3 = Float.valueOf(model_table.getValueAt(i_row, 7)+"");
		
		sinhvien sv = new sinhvien(maSinhVien, tenSinhVien, id_tinh, ngaySinh, gioitinh, giaitich1, giaitich2, giaitich3);
		return sv;
    }

	public void hienthiThongTinSV() throws Exception {
		Connection conn = DBConnection.CreateConnection();
		sinhvien sv = getThiSinhDangChon();
		String tentinh = Data.tenTinhbyID(sv.getId_tinh(),conn);
		this.textField_id.setText(sv.getMasinhvien()+"");
		this.textField_hoTen.setText(sv.getTensinhvien()+"");
		this.comboBox_quequan_1.setSelectedItem(tentinh+"");
		String s_ngaySinh = sv.getDate().getDate() + "/" + (sv.getDate().getMonth() + 1) + "/"+ (sv.getDate().getYear() + 1900);
		this.textField_ngaySinh.setText(s_ngaySinh+"");
		if(sv.isGioitinh()) {
			radiobutton_nam.setSelected(true);
		}else {
			radiobutton_nu.setSelected(true);
		}
		this.textField_gt1.setText(sv.getGiaitich1()+"");
		this.textField_gt2.setText(sv.getGiaitich2()+"");
		this.textField_gt3.setText(sv.getGiaitich3()+"");
				
		
	}


	public void thucHienXoa() throws Exception {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa dòng đã chọn ");
	    if(luaChon == JOptionPane.YES_OPTION) {
	    	sinhvien sv = getThiSinhDangChon();
	    	this.model.delete(sv);
	    	model_table.removeRow(i_row);
	    }
		
	}
	public void thucHienThemSinhVien() {
		int maSinhVien = Integer.valueOf(this.textField_id.getText());
		String tenSinhVien = this.textField_hoTen.getText()+"";
		
		int id_tinh = this.comboBox_quequan_1.getSelectedIndex()-1;
		
		
		Date ngaySinh = new Date(this.textField_ngaySinh.getText());
		
        boolean gioitinh = true;
        
        if(this.radiobutton_nam.isSelected()) {
        	gioitinh = true;
        }else if(this.radiobutton_nu.isSelected()){
			gioitinh = false;
		}
        		     
		float giaitich1 = Float.valueOf(this.textField_gt1.getText());  
		float giaitich2 = Float.valueOf(this.textField_gt2.getText());
		float giaitich3 = Float.valueOf(this.textField_gt3.getText());
		sinhvien sv = new sinhvien(maSinhVien, tenSinhVien, id_tinh, ngaySinh, gioitinh, giaitich1, giaitich2, giaitich3);
		
        try {
			this.themHoacCapNhatSV(sv);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	
	public void thucHienTim() throws Exception {
		
		Connection conn = DBConnection.CreateConnection();
		// goi ham huy tim kiem 
		this.thucHienTaiLaiDuLieu();
		
		
		// thuc hien tim kiem 
		int id_tinh = this.comboBox_quequan.getSelectedIndex();
		String maSVCanTimKiem = this.textField_msv.getText();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();
		
		Set<Integer> idSinhVienCanXoa = new TreeSet<Integer>();
		
		if(id_tinh >= 0 ) {
			String tinhDaChon = Data.tenTinhbyID(id_tinh,conn)+"";
			for(int i = 0 ; i < soLuongDong; i++ ) {
				String tenTinh = model_table.getValueAt(i, 2) +"";
				String id = model_table.getValueAt(i, 0)+"";
				if(!tenTinh.equals(tinhDaChon)) {
					idSinhVienCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		
		if(maSVCanTimKiem.length() > 0) {
			for(int i = 0 ; i < soLuongDong; i++ ) {
				String id = model_table.getValueAt(i, 0)+"";
				if(!id.equals(maSVCanTimKiem)) {
					idSinhVienCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		// Xoa nhung hang ko dc tim kiem 
		for (Integer idCanXoa : idSinhVienCanXoa) {
			soLuongDong = model_table.getRowCount();
			for(int i = 0; i < soLuongDong; i++) {
				String idTrongTable = model_table.getValueAt(i, 0)+"";
				
				if(idTrongTable.equals(idCanXoa.toString())) {
					try {
						model_table.removeRow(i);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
			
		}	
		
	}

	
	public void thucHienTaiLaiDuLieu() throws Exception {
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			if(soLuongDong==0)
				break;
			else
				try {
					model_table.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		for (sinhvien sv : this.model.getDsSinhVien()) {
			this.themSinhVienVaoTable(sv);
		}
	}

	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this, "Phần mềm quản lý thí sinh 1.0!");
	}

	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(
			    this,
			    "Bạn có muốn thoải khỏi chương trình?",
			    "Exit",
			    JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}


	
	public void saveMySQL() throws Exception {
		Connection conn = DBConnection.CreateConnection();
		String sql1 = "Delete from sinhvien";
		PreparedStatement ptmt1 = conn.prepareStatement(sql1);
		ptmt1.executeUpdate();
		
		
		for (sinhvien sv : this.model.getDsSinhVien()) {
			String sql = "Insert into sinhvien(masinhvien,tensinhvien,id_tinh,date,gioitinh,giaitich1,giaitich2,giaitich3) value(?,?,?,?,?,?,?,?)";
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, sv.getMasinhvien());
			ptmt.setString(2, sv.getTensinhvien());
			ptmt.setInt(3, sv.getId_tinh());
			ptmt.setString(4,sv.getDate().getDate() + "/" + (sv.getDate().getMonth() + 1) + "/"+ (sv.getDate().getYear() + 1900));
			ptmt.setBoolean(5, sv.isGioitinh());
			ptmt.setFloat(6, sv.getGiaitich1());
			ptmt.setFloat(7, sv.getGiaitich2());
			ptmt.setFloat(8, sv.getGiaitich3());
			
			ptmt.executeUpdate();
			
			
		}
		
		conn.close();
		
		
	}
	public void OpenMySQL() throws Exception {
		ArrayList<sinhvien> dssinhvien = new ArrayList<sinhvien>();
		Connection conn = DBConnection.CreateConnection();
		String sql = "Select * from sinhvien";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();
		sinhvien sv = new sinhvien();
		while(rs.next()) {
			sv.setMasinhvien(rs.getInt(1));
			sv.setTensinhvien(rs.getString(2));
			sv.setId_tinh(rs.getInt(3));
			sv.setDate(new Date(rs.getString(4)));
			sv.setGioitinh(rs.getBoolean(5));
			sv.setGiaitich1(rs.getFloat(6));
			sv.setGiaitich2(rs.getFloat(7));
			sv.setGiaitich3(rs.getFloat(8));
			dssinhvien.add(sv);
			
		}
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			if(soLuongDong==0)
				break;
			else
				try {
					model_table.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		for (sinhvien sinhvien : dssinhvien) {
	    	DefaultTableModel model_table = (DefaultTableModel) table.getModel();
	    		
				model_table.addRow(new Object[] {
					    
				        sinhvien.getMasinhvien()+"",
				        sinhvien.getTensinhvien()+"",
				        Data.tenTinhbyID(sinhvien.getId_tinh()+1,conn)+"",
				        sinhvien.getDate().getDate() + "/" + (sinhvien.getDate().getMonth() + 1) + "/"+ (sinhvien.getDate().getYear() + 1900),
				        (sinhvien.isGioitinh()?"Nam":"Nữ"),
				        sinhvien.getGiaitich1()+"",
				        sinhvien.getGiaitich2()+"",
				        sinhvien.getGiaitich3()+"",
					
				        });
			
			
		}
		
	}
}
