package com.example.examproject_restapi1.converter.group;

import com.example.examproject_restapi1.DTO.group.GroupResponse;
import com.example.examproject_restapi1.entities.Group;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GroupResponseConverter {
    public GroupResponse viewGroup(Group group){
        if (group==null){
            return null;
        }

        GroupResponse groupResponse = new GroupResponse();

        groupResponse.setId(group.getId());
        groupResponse.setGroupName(group.getGroupName());
        groupResponse.setImage(group.getImage());
        groupResponse.setCount(group.getCount());
        groupResponse.setDateOfStart(group.getDateOfStart());

        return groupResponse;
    }

    public List<GroupResponse> view(List<Group> groups){
        List<GroupResponse> groupResponses = new ArrayList<>();

        for (Group group: groups) {
            groupResponses.add(viewGroup(group));
        }

        return  groupResponses;
    }
}
