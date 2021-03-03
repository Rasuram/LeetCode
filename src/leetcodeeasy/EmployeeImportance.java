package leetcodeeasy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* You are given a data structure of employee information, which includes the employee's unique id, their importance value and their direct subordinates' id.
For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. They have importance value 15, 10 and 5, respectively.
* Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []].
* Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.
Now given the employee information of a company, and an employee id, you need to return the total importance value of this employee and all their subordinates.
*
*
* */
public class EmployeeImportance {
    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    ;

    public int getImportance(List<Employee> employees, int id) {

        int sum = 0;
        Employee e = getSubOrdinates(employees, id);
        Queue<Employee> q = new LinkedList<>();
        q.add(e);
        while (!q.isEmpty()) {
            Employee sub = q.poll();
            sum += sub.importance;
            List<Integer> s = sub.subordinates;
            int n = s.size();
            for (int i = 0; i < n; i++) {
                q.add(getSubOrdinates(employees, s.get(i)));
            }

        }
        return sum;
    }

    public Employee getSubOrdinates(List<Employee> employees, int id) {
        Employee importance = null;
        for (Employee e : employees) {
            if (e.id == id) {
                importance = e;
                break;
            }
        }
        return importance;
    }

    public static void main(String[] args) {
       // [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]],1
        EmployeeImportance e = new EmployeeImportance();
        Employee e1 = new Employee();
        e1.id = 1;
        e1.importance = 5;
        e1.subordinates = Arrays.asList(2, 3);

        Employee e2 = new Employee();
        e2.id = 2;
        e2.importance = 3;
        e2.subordinates = new ArrayList<>();

        Employee e3 = new Employee();
        e3.id = 3;
        e3.importance = 3;
        e3.subordinates = new ArrayList<>();
        System.out.println(e.getImportance(Arrays.asList(e1, e2, e3), 1));
    }
}
