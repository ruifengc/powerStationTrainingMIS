package dto.training;

public class TrainingDTO {
	private String train_plan_id;
	private String train_plan_name;
	private String train_plan_type;
	private String train_plan_year;
	private String is_finish;
	public TrainingDTO(){
		
	}
	public String getTrain_plan_id() {
		return train_plan_id;
	}
	public void setTrain_plan_id(String train_plan_id) {
		this.train_plan_id = train_plan_id;
	}
	public String getTrain_plan_name() {
		return train_plan_name;
	}
	public void setTrain_plan_name(String train_plan_name) {
		this.train_plan_name = train_plan_name;
	}
	public String getTrain_plan_type() {
		return train_plan_type;
	}
	public void setTrain_plan_type(String train_plan_type) {
		this.train_plan_type = train_plan_type;
	}
	public String getTrain_plan_year() {
		return train_plan_year;
	}
	public void setTrain_plan_year(String train_plan_year) {
		this.train_plan_year = train_plan_year;
	}
	public String getIs_finish() {
		return is_finish;
	}
	public void setIs_finish(String is_finish) {
		this.is_finish = is_finish;
	}
	
}
