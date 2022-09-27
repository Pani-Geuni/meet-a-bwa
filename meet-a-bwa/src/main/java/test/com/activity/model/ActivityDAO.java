package test.com.activity.model;

import java.util.List;

public interface ActivityDAO {

	public int activity_insert(ActivityVO avo);
	public List<ActivityVO2> selectAll10();
	public List<ActivityVO2> selectCate10(String category);
	
}
