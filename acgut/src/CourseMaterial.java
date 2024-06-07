import java.util.ArrayList;
import java.util.List;

class CourseMaterial {
    private String courseName;
    private List<String> materials;

    public CourseMaterial(String courseName) {
        this.courseName = courseName;
        this.materials = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void addMaterial(String material) {
        materials.add(material);
    }

    public List<String> getMaterials() {
        return materials;
    }
}
