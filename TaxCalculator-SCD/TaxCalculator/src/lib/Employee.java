package lib ;

import java.time.LocalDate ;

import java.util.ArrayList ;

import java.util.List ;

public class Employee {

	private String employeeId ;

	private String firstName ;

	private String lastName ;

	private String idNumber ;

	private String address;
	
	private LocalDate dateJoined ;

	private boolean isForeigner ;

	private boolean isMale ;
	
	private int monthlySalary ;

	private int otherMonthlyIncome ;

	private int annualDeductible ;
	
	private String spouseName ;

	private String spouseIdNumber ;

	private List<String> childNames ;

	private List<String> childIdNumbers ;
	
	public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, LocalDate dateJoined, boolean isForeigner, boolean isMale) {

		this.employeeId = employeeId ;

		this.firstName = firstName ;

		this.lastName = lastName ;

		this.idNumber = idNumber ;

		this.address = address ;

		this.dateJoined = dateJoined ;

		this.isForeigner = isForeigner ;

		this.isMale = isMale ;
		
		childNames = new ArrayList<>() ;

		childIdNumbers = new ArrayList<>() ;
	}
	
	public void setMonthlySalary(int grade) {	
		if (grade == 1) {
			monthlySalary = 3000000 ;
		}else if (grade == 2) {
			monthlySalary = 5000000 ;
		}else if (grade == 3) {
			monthlySalary = 7000000 ;
		}
		
		if (isForeigner) {
			monthlySalary *= 1.5 ;
		}
	}
	
	public void setAnnualDeductible(int deductible) {	

		this.annualDeductible = deductible ;

	}
	
	public void setAdditionalIncome(int income) {	

		this.otherMonthlyIncome = income ;

	}
	
	public void setSpouse(String spouseName, String spouseIdNumber) {

		this.spouseName = spouseName ;

		this.spouseIdNumber = spouseIdNumber ;

	}
	
	public void addChild(String childName, String childIdNumber) {

		childNames.add(childName) ;

		childIdNumbers.add(childIdNumber) ;

	}

	
	public int getAnnualIncomeTax() {

		LocalDate currentDate = LocalDate.now() ;

		int monthsWorked = 0 ;
		
		if (currentDate.getYear() == dateJoined.getYear()) {

			monthsWorked = currentDate.getMonthValue() - dateJoined.getMonthValue() ;

		} else if (currentDate.getYear() > dateJoined.getYear()) {

			monthsWorked = currentDate.getMonthValue() + (12 - dateJoined.getMonthValue()) ;
			
		}
		
		return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthsWorked, annualDeductible, spouseIdNumber == null || spouseIdNumber.isEmpty(), childIdNumbers.size()) ;

	}
	
}
