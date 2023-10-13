package CompositeDesignPattern;

public class SalesDepartment implements Department {

    private Integer id;
    private String name;

    public SalesDepartment(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public void printDepartmentName() {
        System.out.println(getClass().getSimpleName());
    }

}
