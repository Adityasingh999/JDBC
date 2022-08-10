import org.mysql.DAO.AddressServiceImpl;
import org.mysql.DAO.DepartmentServiceImpl;
import org.mysql.DAO.EmployeeServiceImpl;
import org.mysql.models.Address;
import org.mysql.models.Department;
import org.mysql.models.Employee;
import java.util.*;

public class Main {
    private EmployeeServiceImpl employee=new EmployeeServiceImpl();
    private DepartmentServiceImpl department=new DepartmentServiceImpl();
    private AddressServiceImpl address= new AddressServiceImpl();
    public  void printEmployees() {
        List<Employee> listOfEmployees = EmployeeServiceImpl.getListOfEmployees();
        if (listOfEmployees != null) {
            for (Employee employee : listOfEmployees) {
                System.out.println(employee);
            }
        }
    }
    public  void printDepartments() {
        List<Department> listOfDepartment = DepartmentServiceImpl.getListOfDepartment();
        if(listOfDepartment != null) {
            for (Department department : listOfDepartment) {
                System.out.println(department);
            }
        }
    }
    public  void printAddress() {
        List<Address> listOfAddress = AddressServiceImpl.getListOfAddress();
        if(listOfAddress != null) {
            for (Address address1 : listOfAddress) {
                System.out.println(address1);
            }
        }
    }
    public static void main(String[] args) {

        System.out.println("Main Program");
        //EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        //employeeService.UpdateEmployee(1,"abhinav",24,"hyderabad");
        /*AddressServiceImpl addressService=new AddressServiceImpl();
        Address address1=new Address();
        address1.setId(1);
        address1.setAddress("hyd");
        addressService.deleteAddress(address1);*/
        new Main().printEmployees();
        new Main().printDepartments();
        new Main().printAddress();

    }





}
