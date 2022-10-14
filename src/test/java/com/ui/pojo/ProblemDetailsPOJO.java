/**
 * 
 */
package com.ui.pojo;

/**
 * @author Jatin
 *
 */
public class ProblemDetailsPOJO {
	private String problem;
	private String remark;

	public ProblemDetailsPOJO(String problem, String remark) {
		super();
		this.problem = problem;
		this.remark = remark;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "ProblemDetailsPOJO [problem=" + problem + ", remark=" + remark + "]";
	}

}
