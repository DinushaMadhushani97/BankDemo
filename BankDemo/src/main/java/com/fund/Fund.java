package com.fund;

public class Fund {
    private int id;
    private String name;
    private String accNo;
    private String branch;
    private String amount;
    private String message;
    
    
   
    public Fund(int id, String name, String accNo, String branch, String amount, String message){
	this.id = id;
	this.name = name;
	this.accNo = accNo;
	this.branch = branch;
	this.amount = amount;
	this.message = message;
	
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



	public String getAccNo() {
		return accNo;
	}



	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}



	public String getBranch() {
		return branch;
	}



	public void setBranch(String branch) {
		this.branch = branch;
	}



	public String getAmount() {
		return amount;
	}



	public void setAmount(String amount) {
		this.amount = amount;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}


	
    
}  

	    