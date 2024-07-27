package manager;

import View.Schools;
import View.Students;


import java.util.ArrayList;

public class ManagerSchools implements IManager<Schools>{
    private ArrayList<Schools> list = new ArrayList<>();
    @Override
    public void add(Schools schools) {
        this.list.add(schools);
    }

    @Override
    public void remove(int id) {
        int index = FindById(id);
        list.remove(index);
    }

    @Override
    public void edit(int id, Schools schools) {
        int index = FindById(id);
        list.set(index, schools);
    }

    @Override
    public ArrayList<Schools> FindByName(String name) {
        ArrayList<Schools> result = new ArrayList<>();
        for (Schools schools : list) {
            if (schools.getNameSchool().toLowerCase().contains(name.toLowerCase())) {
                result.add(schools);
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


    @Override
    public ArrayList<Schools> FindAll() {
        return this.list;
    }
}
