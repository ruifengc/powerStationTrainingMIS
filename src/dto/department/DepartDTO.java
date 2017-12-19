package dto.department;

public class DepartDTO {
	private String unit_id;
	private String up_unit_id;
	private String unit_name;

	
	public DepartDTO(){
		
	}

	public String getUnit_id() {
		return unit_id;
	}

	public void setUnit_id(String unit_id) {
		this.unit_id = unit_id;
	}

	public String getUp_unit_id() {
		return up_unit_id;
	}

	public void setUp_unit_id(String up_unit_id) {
		this.up_unit_id = up_unit_id;
	}


	public String getUnit_name() {
		return unit_name;
	}

	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}
	
}
