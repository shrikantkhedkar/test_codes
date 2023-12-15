package meta;
import org.json.JSONArray;
import org.json.JSONObject;


public class EmployeeDataCrud {

    public static void main(String[] args) {
        JSONArray employeeData = new JSONArray();
        employeeData.put(createEmployee("abc", "xyz", 1));
        employeeData.put(createEmployee("abc", "xyz", 2));

        System.out.println("Initial JSON Data:");
        System.out.println(employeeData.toString());

        JSONObject newEmployee = createEmployee("John", "Doe", 3);
        employeeData.put(newEmployee);

        int employeeIdToRead = 2;
        JSONObject foundEmployee = findEmployeeById(employeeData, employeeIdToRead);
        System.out.println("\nEmployee with ID " + employeeIdToRead + ":");
        System.out.println(foundEmployee != null ? foundEmployee.toString() : "Not found");

        int employeeIdToUpdate = 1;
        updateEmployee(employeeData, employeeIdToUpdate, "fname", "UpdatedFirstName");

        System.out.println("\nUpdated JSON Data:");
        System.out.println(employeeData.toString());

        int employeeIdToDelete = 3;
        deleteEmployee(employeeData, employeeIdToDelete);

        System.out.println("\nFinal JSON Data:");
        System.out.println(employeeData.toString());
    }

    private static JSONObject createEmployee(String fname, String lname, int id) {
        JSONObject employee = new JSONObject();
        employee.put("fname", fname);
        employee.put("lname", lname);
        employee.put("id", id);
        return employee;
    }

    private static JSONObject findEmployeeById(JSONArray employeeData, int id) {
        for (int i = 0; i < employeeData.length(); i++) {
            JSONObject employee = employeeData.getJSONObject(i);
            if (employee.getInt("id") == id) {
                return employee;
            }
        }
        return null;
    }

    private static void updateEmployee(JSONArray employeeData, int id, String key, String newValue) {
        for (int i = 0; i < employeeData.length(); i++) {
            JSONObject employee = employeeData.getJSONObject(i);
            if (employee.getInt("id") == id) {
                employee.put(key, newValue);
                break;
            }
        }
    }

    private static void deleteEmployee(JSONArray employeeData, int id) {
        for (int i = 0; i < employeeData.length(); i++) {
            JSONObject employee = employeeData.getJSONObject(i);
            if (employee.getInt("id") == id) {
                employeeData.remove(i);
                break;
            }
        }
    }
}
