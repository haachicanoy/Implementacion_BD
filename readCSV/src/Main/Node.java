package Main;

import java.util.List;

public class Node {

	String type;
	List<String> tablesInput;
	List<String> parameters;
	String tableNameOutput;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<String> getTablesInput() {
		return tablesInput;
	}
	public void setTablesInput(List<String> tablesInput) {
		this.tablesInput = tablesInput;
	}
	public List<String> getParameters() {
		return parameters;
	}
	public void setParameters(List<String> parameters) {
		this.parameters = parameters;
	}
	public String getTableNameOutput() {
		return tableNameOutput;
	}
	public void setTableNameOutput(String tableNameOutput) {
		this.tableNameOutput = tableNameOutput;
	}
	
	
}
