package com.test.myviewpager2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class EmployeeFragmentStateAdapter extends FragmentStateAdapter {

    private List<Employee> employees;


    public EmployeeFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);

        this.employees = this.intDatas();
    }

    private List<Employee> intDatas()  {
        Employee emp1 = new Employee("こんちは", "はれ", "デザイナー");
        Employee emp2 = new Employee("Elizabeth Johnson", "elizabethjohnson@example.com", "Project Manager");
        Employee emp3 = new Employee("Catherine Johnson", "catherinejohnson@example.com", "President of Sales");

        List<Employee> list = new ArrayList<Employee>();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        return list;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Employee employee = this.employees.get(position);
        return new EmployeePageFragment(employee);
    }


    @Override
    public int getItemCount() {
        return this.employees.size();
    }
}