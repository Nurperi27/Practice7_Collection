package service.impl;
import dao.GenericDaoCrud;
import dao.daoimpl.GroupDaoImpl;
import db.Database;
import models.Group;
import service.GenericServiceCrud;
import java.util.Comparator;
import java.util.List;

public class GroupServiceImpl implements GenericServiceCrud <Group, Long, String> {
    private final GenericDaoCrud<Group, Long, String> genericDaoCrud = new GroupDaoImpl();
    @Override
    public void add(Group group) {
        genericDaoCrud.add(group);
        System.out.println("Group added!");
    }

    @Override
    public List<Group> getAll() {
        return genericDaoCrud.getAll();
    }

    @Override
    public Group getById(Long id) {
        return genericDaoCrud.getById(id);
    }

    @Override
    public String updateById(Long id, Group group) {
        genericDaoCrud.updateById(id,group );
        return "";
    }

    @Override
    public String deleteById(Long id) {
       genericDaoCrud.deleteById(id);
        return "";
    }

    @Override
    public void sortByName(String s) {
        genericDaoCrud.sortByName(s);
    }
}
