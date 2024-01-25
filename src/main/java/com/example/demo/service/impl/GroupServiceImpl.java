package com.example.demo.service.impl;

import com.example.demo.repo.GroupRepo;
import com.example.demo.rest.dto.group.GroupInfo;
import com.example.demo.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepo groupRepo;

    @Override
    public List<GroupInfo> getAll() {
        return groupRepo.findAll().stream()
                .map(group -> GroupInfo.builder()
                        .id(group.getId())
                        .name(group.getName())
                        .build())
                .collect(Collectors.toList());
    }
}
