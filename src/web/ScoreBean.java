package web;

public class ScoreBean {
	private String name;
	private int kor;
	private int eng;
	private int math;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getTotal(int kor, int eng, int math) {
		int total = kor+eng+math;
		return total;
	}
	public double getAvg(int kor, int eng, int math) {
		double avg = (kor+eng+math)/3;
		return avg;
	}
	public String getGrade(double avg) {
		String grade="";
		if(avg>90){
			grade="A";
		}else if(avg>80){
			grade="B";
		}else if(avg>70){
			grade="C";
		}else{
			grade="F";
		}
		return grade;
	}
}
