package db;

public class GenerateID {
    public static Long groupId = 0L;
    public static Long studentId = 0L;
    public static Long genGroupId(){ return ++groupId; }
    public static Long genStudent(){ return ++studentId; }
}
