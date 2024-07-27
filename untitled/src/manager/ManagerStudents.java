package manager;

import View.Students;

import java.util.ArrayList;

public class ManagerStudents implements IManager<Students> {
    private ArrayList<Students> list = new ArrayList<>();
    ;

    @Override
    public void add(Students students) {
        this.list.add(students);
    }

    @Override
    public void remove(int id) {
        int index = FindById(id);
        list.remove(index);

    }

    @Override
    public void edit(int id, Students students) {
        int index = FindById(id);
        list.set(index, students);
    }

    @Override
    public ArrayList<Students> FindByName(String name) {
        ArrayList<Students> result = new ArrayList<>();
        for (Students students : list) {
            if (students.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(students);
            }
        }
        return result;
    }

    @Override
    public int FindById(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }


    public ArrayList<Students> FindByScoreNear(double score) {
        double scoreNear = 4;
        ArrayList<Students> result = new ArrayList<>();
        for(Students student : list) {
            double studentScore =student.getScore();
            if(Math.abs(studentScore - score) <= scoreNear) {
                result.add(student);
            }

        }
        return result;
    }


    public  ArrayList<Students> FindByAgeNear(int age) {
        double AgeNear = 4;
        ArrayList<Students> result = new ArrayList<>();
        for(Students student : list) {
            double studentAge =student.getAge();
            if(Math.abs(studentAge - age) <= AgeNear) {
                result.add(student);
            }

        }
        return result;
    }

    @Override
    public ArrayList<Students> FindAll() {
        return this.list;
    }
}
