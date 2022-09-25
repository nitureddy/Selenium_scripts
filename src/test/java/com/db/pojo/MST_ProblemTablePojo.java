package com.db.pojo;

public class MST_ProblemTablePojo {
	private int id;
	private String name;

	public MST_ProblemTablePojo() {
		super();//it is used to retrive data from the data dase
	}

	public MST_ProblemTablePojo(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MST_ProblemTablePojo [id=" + id + ", name=" + name + "]";
	}
	public String insertProblem() {
		String statement = "INSERT INTO SR_DEV.mst_problem (id,name) VALUES ("+id+", ' "+name+" ');";
		return statement;
	}
	
	

}
