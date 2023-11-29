package model;

import java.util.ArrayList;

public class ProvinceList {
	private ArrayList<Province> list;

	public ProvinceList() {
		list = new ArrayList<Province>();
		String[] provinceNameList = getProvinceNameList();
		for(int i = 1; i < provinceNameList.length; i++) {
			list.add(new Province(provinceNameList[i]));
		}	
	}

	public ProvinceList(ArrayList<Province> list) {
		this.list = list;
	}

	public ArrayList<Province> getList() {
		return list;
	}

	public void setList(ArrayList<Province> list) {
		this.list = list;
	}
	
	public static String[] getProvinceNameList() {
		String[] provinceNameList = {
				"An Giang", 
				"Bà Rịa – Vũng Tàu", 
				"Bạc Liêu", 
				"Bắc Giang", 
				"Bắc Kạn", 
				"Bắc Ninh", 
				"Bến Tre", 
				"Bình Dương", 
				"Bình Định", 
				"Bình Phước", 
				"Bình Thuận", 
				"Cà Mau", 
				"Cao Bằng", 
				"Cần Thơ", 
				"Đà Nẵng", 
				"Đắk Lắk", 
				"Đắk Nông", 
				"Điện Biên", 
				"Đồng Nai", 
				"Đồng Tháp", 
				"Gia Lai", 
				"Hà Giang", 
				"Hà Nam", 
				"Hà Nội", 
				"Hà Tĩnh", 
				"Hải Dương", 
				"Hải Phòng", 
				"Hậu Giang", 
				"Hòa Bình", 
				"Thành phố Hồ Chí Minh", 
				"Hưng Yên", 
				"Khánh Hòa", 
				"Kiên Giang", 
				"Kon Tum", 
				"Lai Châu", 
				"Lạng Sơn", 
				"Lào Cai", 
				"Lâm Đồng", 
				"Long An", 
				"Nam Định", 
				"Nghệ An", 
				"Ninh Bình", 
				"Ninh Thuận", 
				"Phú Thọ", 
				"Phú Yên", 
				"Quảng Bình", 
				"Quảng Nam", 
				"Quảng Ngãi", 
				"Quảng Ninh", 
				"Quảng Trị", 
				"Sóc Trăng", 
				"Sơn La", 
				"Tây Ninh", 
				"Thái Bình", 
				"Thái Nguyên", 
				"Thanh Hóa", 
				"Thừa Thiên Huế", 
				"Tiền Giang", 
				"Trà Vinh", 
				"Tuyên Quang", 
				"Vĩnh Long", 
				"Vĩnh Phúc", 
				"Yên Bái", 
		};
		return provinceNameList;
	}
	
	public int getIndexOf(Province province) {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getName().equals(province.getName())) return i;
		}
		return -1;
	}
}
