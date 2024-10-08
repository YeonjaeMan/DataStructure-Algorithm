package DataStructure.TreeAndGraph.Project;

public class ProjectTest {
    public static void main(String[] args) {
        String[] projects = {"a", "b", "c", "d", "e", "f", "g"};
        String[][] dependencies = {{"f", "a"}, {"f", "b"}, {"f", "c"}, {"b", "a"}, {"c", "a"}, {"a", "e"}, {"b", "e"}, {"d", "g"}};
        ProjectManager pm = new ProjectManager(projects, dependencies);
        Project[] ps = pm.buildOrder();
        for(Project p : ps) {
            if(p != null) {
                System.out.print(p.getName() + " ");
            }
        }
    }
}
