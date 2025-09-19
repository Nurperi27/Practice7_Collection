package dao.daoimpl;

import dao.GenericDaoCrud;
import db.Database;
import models.Group;
import service.GenericServiceCrud;
import service.impl.GroupServiceImpl;

import java.util.Comparator;
import java.util.List;

public class GroupDaoImpl implements GenericDaoCrud <Group, Long, String> {
    //private final Database = new Database(); //if Database isn't STATIC in package 'db'

    @Override
    public void add(Group group) {
        Database.groupList.add(group);
    }

    @Override
    public List<Group> getAll() {
        return Database.groupList;
    }

    @Override
    public Group getById(Long id) {
       try {
           for (Group group1 : Database.groupList) {
               if (group1.getIdGroup().equals(id)) {
                   return group1;
               }
           }
           throw new RuntimeException("Group not found!");
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
        return null;
    }

    @Override
    public String updateById(Long id, Group group) {
        try {
            for (Group group2 : Database.groupList) {
                if (group2.getIdGroup().equals(id)) {
                    group2.setGroupName(group.getGroupName());
                    group2.setInstructorName(group.getInstructorName());
                    group2.setDate(group.getDate());
                    return "Group success updated!";
                }
            }
            throw new RuntimeException("Group not found");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    @Override
    public String deleteById(Long id) {
        try {
            for (Group group3 : Database.groupList) {
                if (group3.getIdGroup().equals(id)) {
                    Database.groupList.remove(group3);
                    return "Group removed!";
                }
            }
            throw new RuntimeException("Group not found!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void sortByName(String s) {
        if("a".equalsIgnoreCase(s)) {
            Database.groupList.sort(Comparator.comparing(Group::getGroupName));
        } else if ("z".equalsIgnoreCase(s)) {
            Database.groupList.sort(Comparator.comparing(Group::getGroupName).reversed());
        }
        Database.groupList.forEach(System.out::println);
    }
}
