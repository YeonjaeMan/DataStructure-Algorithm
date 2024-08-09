package DataStructure.TreeAndGraph.Project;

import java.util.LinkedList;

// 회사에 여러개의 프로젝트가 있는데 어떤 프로젝트들은 특정 프로젝트가 완료되어야만 진행할 수 있는 프로젝트가 있다.
// 프로젝트의 목록과 각 프로젝트간 의존여부를 넘겨주면 의존도에 입각한 프로젝트의 진행순서를 반환하는 함수를 구현하시오.
public class Project {
    private String name;
    private LinkedList<Project> dependencies;
    private boolean marked;

    public Project(String name) {
        this.name = name;
        this.marked = false;
        this.dependencies = new LinkedList<>();
    }

    public void addDependency(Project project) {
        if(!dependencies.contains(project)) {
            dependencies.add(project);
        }
    }

    public LinkedList<Project> getDependencies() {
        return this.dependencies;
    }

    public String getName() {
        return this.name;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public boolean getMarked() {
        return this.marked;
    }
}
