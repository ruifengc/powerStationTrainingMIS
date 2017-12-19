package dto.scores;

public class ScoresDTO {
	private String id;
	private String user_name;
	private String unit_name;
	private String attendance_score;
	private String test_score;
	private String total_score;
	public ScoresDTO(){
		
	}
	@Override
	public String toString() {
		return "ScoresDTO [id=" + id + ", user_name=" + user_name + ", unit_name=" + unit_name + ", attendance_score="
				+ attendance_score + ", test_score=" + test_score + ", total_score=" + total_score + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUnit_name() {
		return unit_name;
	}
	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}
	public String getAttendance_score() {
		return attendance_score;
	}
	public void setAttendance_score(String attendance_score) {
		this.attendance_score = attendance_score;
	}
	public String getTest_score() {
		return test_score;
	}
	public void setTest_score(String test_score) {
		this.test_score = test_score;
	}
	public String getTotal_score() {
		return total_score;
	}
	public void setTotal_score(String total_score) {
		this.total_score = total_score;
	}
}
