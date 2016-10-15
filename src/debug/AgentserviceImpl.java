package debug;

import java.io.FileInputStream;
import java.util.List;

import com.JES.model.Agentupstudent;
import com.JES.model.Student;

public interface AgentserviceImpl {
	public List<Student> searchStudents(String type, String value);
	public boolean addStudent(Student student);
	public boolean upPhoto(FileInputStream input,Integer length,Agentupstudent upstudent);
}
