package CompositeDesignPattern;

public class FinancialDepartment implements Department {

    private Integer id;
    private String name;
  
    public FinancialDepartment(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public void printDepartmentName() {
        System.out.println(getClass().getSimpleName());
    }

}
