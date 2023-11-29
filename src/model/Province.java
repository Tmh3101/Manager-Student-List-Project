package model;

import java.io.Serializable;
import java.util.Objects;

public class Province implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;
	
	public Province() {
		name = new String();
	}

	public Province(String name) {
		this.name = name;
	}
	
	public Province(Province provice) {
		name = provice.name;
	}
	
	public Province(int i) {
		name = ProvinceList.getProvinceNameList()[i];
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Province other = (Province) obj;
		return name.equals(other.name);
	}

	@Override
	public String toString() {
		return name;
	}
	
}
