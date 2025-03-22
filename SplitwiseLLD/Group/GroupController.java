package SplitwiseLLD.Group;
import java.util.*;

import SplitwiseLLD.User.*;

public class GroupController {
    List<Group> groupList;

    public GroupController() {
        groupList=new ArrayList<>();
    }

    public void createNewGroup(String groupId,String groupName,User createdByUser) {
        Group group=new Group();
        group.groupId=groupId;
        group.groupName=groupName;
        group.groupMembers.add(createdByUser);

        groupList.add(group);
    }

    public Group getGroup(String groupId) {
        for (Group group: groupList)
            if (group.groupId.equals(groupId))
                return group;

        return null;
    }
}
