package springrestful_example.model;

public class Director {
	private Integer Directors_Id_PK;
	private String First_Name;
	private String Last_Name;

	public Director() {
		super();
	}

	public Director(Integer directors_Id_PK) {
		super();
		Directors_Id_PK = directors_Id_PK;
	}

	public Integer getDirectors_Id_PK() {
		return Directors_Id_PK;
	}

	public void setDirectors_Id_PK(Integer directors_Id_PK) {
		Directors_Id_PK = directors_Id_PK;
	}

	public String getFirst_Name() {
		return First_Name;
	}

	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}

	public String getLast_Name() {
		return Last_Name;
	}

	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}

}
